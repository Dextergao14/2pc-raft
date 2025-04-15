package com.example.raft;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;

import com.example.*;
import com.example.raft.RaftGrpc.RaftImplBase;
import com.example.raft.RaftOuterClass.AppendEntriesRequest;
import com.example.raft.RaftOuterClass.AppendEntriesResponse;
import com.example.raft.RaftOuterClass.Vote;
import com.example.raft.RaftOuterClass.VoteRequest;
import com.example.raft.RaftOuterClass.VoteResponse;
import com.example.raft.RaftOuterClass.LogEntry;
import com.example.raft.RaftOuterClass.HbAck;
import com.example.raft.RaftOuterClass.HeartbeatRequest;
import com.example.raft.RaftGrpc.RaftImplBase;;

public class GrpcServerWrapper {
    public static void main(String[] args) throws Exception {
        ServerRunner.main(args);
    }
}

class NodeState {
    public static int curTerm = 1;
    public static int curLastLogIndex = -1;
    public static int curLastLogTerm = 0;
    public static String votedFor = null;
}

class RaftLeaderElectionService extends RaftGrpc.RaftImplBase {
    @Override
    public void requestVote(VoteRequest request, StreamObserver<VoteResponse> responseObserver) {
        System.out.println("Node " + System.getenv("NODE_ID") + " runs RPC RequestVote called by " + request.getCandidateId());
        try {
            int candidateTerm = request.getTerm();
            String candidateId = request.getCandidateId();
            int lastLogIndex = request.getLastLogIndex();
            int lastLogTerm = request.getLastLogTerm();

            VoteResponse responseNo = VoteResponse.newBuilder()
                                            .setTransactionId(request.getTransactionId())
                                            .setTerm(NodeState.curTerm)
                                            .setVote(Vote.VOTE_NO)
                                            .build();

            if (candidateTerm < NodeState.curTerm) {
                System.out.println("Vote NO due to candidate's older term");
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return;
            }

            if (candidateTerm > NodeState.curTerm) {
                NodeState.curTerm = candidateTerm;
                NodeState.votedFor = null;
            }

            if (NodeState.votedFor != null && !NodeState.votedFor.equals(candidateId)) {
                System.out.println("Vote NO due to already voted for " + NodeState.votedFor);
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return;
            }

            if (lastLogTerm < NodeState.curLastLogTerm ||
                (lastLogTerm == NodeState.curLastLogTerm && lastLogIndex < NodeState.curLastLogIndex)) {
                System.out.println("Vote NO due to log being less up-to-date");
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return;
            }

            NodeState.votedFor = candidateId;
            VoteResponse responseYes = VoteResponse.newBuilder()
                                            .setTransactionId(request.getTransactionId())
                                            .setTerm(NodeState.curTerm)
                                            .setVote(Vote.VOTE_YES)
                                            .build();
            responseObserver.onNext(responseYes);
            System.out.println("Vote YES for " + candidateId);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.out.println("Vote failed due to: " + e);
            responseObserver.onError(e);
        }
    }

    @Override
    public void receiveHeartbeat(HeartbeatRequest request, StreamObserver<HbAck> responseObserver) {
        System.out.println("Node " + System.getenv("NODE_ID") + " received heartbeat from Leader " + request.getLeaderId());
    
        // reset ele timeout
        GrpcClient.RaftNode.getInstance().resetElectionTimeout();

        HbAck ack = HbAck.newBuilder().setAck(true).build();
        responseObserver.onNext(ack);
        responseObserver.onCompleted();
    }
}

class ServerRunner {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java -jar <jar-file> <port>");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        Server server = ServerBuilder.forPort(port)
                        .addService(new RaftLeaderElectionService())
                        .build()
                        .start();

        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }
}
