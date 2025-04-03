from concurrent import futures
import grpc
import time
import sys
import os
sys.path.append('./py_out')

from grpc_py_out import twopc_pb2_grpc
from py_out import twopc_pb2

NODE_ID = os.getenv("NODE_ID", "node_i")
vote_store = {}

class TwoPhaseCommitParticipantsServicer(twopc_pb2_grpc.TwoPhaseCommitServicer):
    """
        XXXServicer is the term grpc uses to annotate the implementation of service
        define in the proto. In this class, the methods are the implementations for the abstract
        services
    """
    def SendVote(self, request, context):
        global vote_store

        print("received a request of vote, transaction id:", request.transaction_id)

        # check if the request is already in the votes dict
        # if so return the vote of this one by transaction id
        if request.transaction_id in vote_store:
            return vote_store[request.transaction_id]
        
        # otherwise construct the vote and send the response
        vote_result = twopc_pb2.VOTE_COMMIT

        response = twopc_pb2.VoteResponse(transaction_id=request.transaction_id, vote=vote_result)
        vote_store[request.transaction_id] = response
        print(f"Phase VOTING PHASE of Node <node_id> sends RPC VoteResponse(returned from SendVote(VoteRequest)) to Phase VOTING PHASE of Node node_0")
        return response

    # the implementation of helper method retrieving info of votes from phase1 to phase2, in order to count votes
    def QueryVote(self, request, context):
        global vote_store
        print(f"Phase DECISION PHASE of Node <node_id> sends RPC QueryVote(VoteRequest) to Phase DECISION PHASE of Node node_0")
        if request.transaction_id in vote_store:
            return vote_store[request.transaction_id]
        else:
            context.set_details("No existing vote result recorded.")
            return twopc_pb2.VoteResponse(transaction_id=request.transaction_id,
                                          vote=twopc_pb2.DECISION_UNSPECIFIED)

    


def serve(vote_port):

    
    server_vote = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    twopc_pb2_grpc.add_TwoPhaseCommitServicer_to_server(TwoPhaseCommitParticipantsServicer(), server_vote)
    server_vote.add_insecure_port(f'[::]:{vote_port}')
    server_vote.start()
    print(f"Vote service of server started on port: {vote_port}")



    try:
        while True:
            time.sleep(86400)

    except KeyboardInterrupt:
        server_vote.stop(1)

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Usage: python phase_1_server_participants.py <vote_port>")
        sys.exit(1)
    vote_port = sys.argv[1]
    
    serve(vote_port)