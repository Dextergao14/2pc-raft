import sys
sys.path.append('./py_out')

import grpc
from py_out import twopc_pb2
from grpc_py_out import twopc_pb2_grpc

from google.protobuf.empty_pb2 import Empty

def collect_votes(transaction_id, participant_addresses):
    """
    In the implementation of 2 Phase Commit,
    the coordinator is the client by definition
    because it sends requests to others and expects response.
    Therefore, participants who receive requests and send responses are the servers.

    This method is for the coordinator to collect all votes from all participants.
    """

    votes = []
    i = 1
    for address in participant_addresses:
        # connect to the add & port of servers(participants)
        channel = grpc.insecure_channel(address) # grpc handles network infra
        stub = twopc_pb2_grpc.TwoPhaseCommitStub(channel)

        # construct a vote request with a transaction id
        request = twopc_pb2.VoteRequest(transaction_id=transaction_id) # call the message type defined in the proto
        
        try:
            response = stub.SendVote(request) # use the client stub to call the method(aka service in proto) of remote server 
            print(f"Phase VOTING PHASE OF Node node_0 sends RPC SendVote(VoteRequest) to Phase VOTING PHASE of Node node_{i}")
            print("got the vote response, transaction id:", response.transaction_id, "vote:", response.vote)
            votes.append(response.vote)
            i += 1
        except Exception as e:
            print(f"Error connecting {address} due to:", e)
        finally:
            channel.close()

    return votes


def coordinate():
    transaction_id = 'dex12345'
    participant_address = [
        'node1:181',
        'node2:182',
        'node3:183',
        'node4:184',
        'node5:185'
    ]

    votes = collect_votes(transaction_id=transaction_id, participant_addresses=participant_address)
    print("phase 1 votes(voted by py servers, collected by py client) are(ps 1 - VOTE_COMMIT, 2 - VOTE_ABORT, 0 - VOTE_UNSPECIFIED):", votes)
    
if __name__=='__main__':
    coordinate()
