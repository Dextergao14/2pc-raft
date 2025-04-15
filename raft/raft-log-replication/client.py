from collections import defaultdict
from concurrent import futures
import grpc
import time
import sys
import os
import uuid

sys.path.append('./py_out')

from grpc_py_out import raft_pb2_grpc
from py_out import raft_pb2

log = [
    raft_pb2.LogEntry(term=1, index=0, command="sex x = 1"),
    raft_pb2.LogEntry(term=1, index=1, command="sex y = 2"),
    raft_pb2.LogEntry(term=1, index=2, command="sex z = 3")
]

peers = ["raft-node1:211", "raft-node2:212", "raft-node3:213", "raft-node4:214", "raft-node5:215"]
self_id = os.getenv("NODE_ID")
term = 1
commit_index = -1

next_index = defaultdict(lambda: len(log))
match_index = defaultdict(lambda: -1)

def send_append_entries(peer, term, leader_id):
    target_host = peer.split(':')[0]
    port = peer.split(':')[1]
    if target_host == self_id:
        return

    follower_id = peer
    ni = next_index[follower_id]
    prev_log_index = ni - 1
    prev_log_term = log[prev_log_index].term if prev_log_index >= 0 else 0
    entries = log[ni:] if ni < len(log) else []

    try:
        with grpc.insecure_channel(f"{target_host}:{port}") as channel:
            stub = raft_pb2_grpc.RaftStub(channel)

            request = raft_pb2.AppendEntriesRequest(
                term=term,
                leader_id=leader_id,
                prev_log_index=prev_log_index,
                prev_log_term=prev_log_term,
                entries=entries,
                leader_commit_index=commit_index,
                transaction_id=str(uuid.uuid4())
            )

            response = stub.AppendEntries(request)
            if response.ack:
                match_index[follower_id] = ni + len(entries) - 1
                next_index[follower_id] = match_index[follower_id] + 1
            else:
                next_index[follower_id] = max(0, next_index[follower_id] - 1)

    except Exception as e:
        print(f"[AppendEntries] Error sending to {peer}: {e}")

def send_heartbeat(target_host, leader_id, term):
    try:
        with grpc.insecure_channel(f'{target_host}:211') as channel:
            stub = raft_pb2_grpc.RaftStub(channel)
            request = raft_pb2.HeartbeatRequest(leader_id=leader_id, term=term)
            response = stub.receiveHeartbeat(request)
            print("[Heartbeat] ACK from", target_host, ":", response.ack)
    except Exception as e:
        print(f"[Heartbeat] Error sending to {target_host}: {e}")



if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python client.py <leader_id> <term>")
        sys.exit(1)

    self_id = os.getenv("NODE_ID")
    leader_id = sys.argv[1]
    term = int(sys.argv[2])

    while True:
        for peer in peers:
            peer_host = peer.split(':')[0]
            if peer_host == self_id:
                continue
            print(f"[Leader] Node {self_id} sends AppendEntries to {peer_host}")
            send_append_entries(peer, term, leader_id)
            send_heartbeat(peer_host, leader_id, term)
        time.sleep(1)
