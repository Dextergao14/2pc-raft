from concurrent import futures
import grpc
import time
import sys
import os
import subprocess

sys.path.append('./py_out')

from grpc_py_out import raft_pb2_grpc
from py_out import raft_pb2

class RaftServicer(raft_pb2_grpc.RaftServicer):
    def __init__(self):
        self.cur_term = 1
        self.log = []
        self.last_commit_index = 0
        self.role = 'follower'
        self.node_id = os.getenv("NODE_ID")

    def AppendEntries(self, request, context):
        print(f"Initial signal Received from Leader elect {request.leader_id}, Term {request.term}")
        print(f"Node {self.node_id} runs RPC AppendEntries called by Node {request.leader_id}")
        # term check
        if request.term < self.cur_term:
            return raft_pb2.AppendEntriesResponse(
                term=self.cur_term,
                ack=False,
                transaction_id=request.transaction_id
            )
        
        if request.term > self.cur_term:
            self.cur_term = request.term
            self.role = 'follower'
        
        # prevLogIndex check
        if request.prev_log_index >= len(self.log):
            return raft_pb2.AppendEntriesResponse(
                transaction_id=request.transaction_id,
                term=self.cur_term,
                ack=False
            )
        
        # prevLogTerm check
        if request.prev_log_index >= 0:
            if self.log[request.prev_log_index].term != request.prev_log_term:
                return raft_pb2.AppendEntriesResponse(
                    transaction_id=request.transaction_id,
                    term=self.cur_term,
                    ack=False
                )
        
        # copy log
        next_index = request.prev_log_index + 1
        incoming_entries = request.entries

        if incoming_entries:
            for i, entry in enumerate(incoming_entries):
                if next_index + i != len(self.log):
                    # conflict, override old w/ new entries
                    if self.log[next_index + i].term != entry.term:
                        self.log = self.log[:next_index + i]
                        self.log.extend(incoming_entries[i:])
                        break
                else:
                    self.log.extend(incoming_entries[i:])
                    break
        
        # update commit index
        if request.leader_commit_index > self.last_commit_index:
            self.last_commit_index = min(request.leader_commit_index, len(self.log) - 1)


        self.cur_term = request.term
        self.role = 'follower'

        return raft_pb2.AppendEntriesResponse(
            term=self.cur_term,
            ack=True,
            transaction_id=request.transaction_id
        )
    
    def StartHeartbeat(self, request, context):
        subprocess.Popen(["python", "client.py", request.leader_id, str(request.term)])
        print(f"Node {request.leader_id} runs RPC StartHeartbeat called by {request.leader_id}")
        return raft_pb2.HbAck(ack=True)
    
def serve(port, hb_signal_port):
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    raft_pb2_grpc.add_RaftServicer_to_server(RaftServicer(), server)
    server.add_insecure_port(f'[::]:{port}')
    server.add_insecure_port(f'[::]:{hb_signal_port}')
    server.start()
    server.wait_for_termination()


    try:
        while True:
            time.sleep(86400)

    except KeyboardInterrupt:
        server.stop(1)

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print("Usage: server.py <port> <hb_signal_port>")
        sys.exit(1)
    port = sys.argv[1]
    hb_signal_port = sys.argv[2]
    print(f"py server started at log port {port} and hb signal port {hb_signal_port}")
    serve(port, hb_signal_port)
