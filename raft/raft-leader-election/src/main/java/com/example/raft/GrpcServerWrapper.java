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
import com.example.raft.RaftGrpc.RaftImplBase;;

public class GrpcServerWrapper {
    public static void main(String[] args) throws Exception {
        ServerRunner.main(args);
    }
}

class RaftLeaderElectionService extends RaftGrpc.RaftImplBase {

    private int curTerm = 1;
    private int curLastLogIndex = -1;
    private int curLastLogTerm = 0;
    private String votedFor = null;

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
                                                .setTerm(curTerm)
                                                .setVote(Vote.VOTE_NO)
                                                .build();
            
            

            if (votedFor != null && !votedFor.equals(candidateId)) {
                System.out.println("Vote NO due to at-most one candi");
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return;
            }

            if (candidateTerm < curTerm) {
                System.out.println("Vote NO due to candi older term");
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return; 
            } else if (candidateTerm > curTerm) {
                curTerm = candidateTerm;
                votedFor = null;
                // downgradeToFollower();
            } 

            if (lastLogTerm >= curLastLogTerm && lastLogIndex >= curLastLogIndex) {
                    votedFor = candidateId;
            } else {
                System.out.println("Vote NO due to older log");
                responseObserver.onNext(responseNo);
                responseObserver.onCompleted();
                return;
            }
            
            
            VoteResponse responseYes = VoteResponse.newBuilder()
                                                .setTransactionId(request.getTransactionId())
                                                .setTerm(curTerm)
                                                .setVote(Vote.VOTE_YES)
                                                .build();
            
            
            responseObserver.onNext(responseYes);
            System.out.println("Vote YES");
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            System.out.println("vote response NOT received due to" + e);
            votedFor = null;
            responseObserver.onError(e);
        }
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
            
        System.out.println("Server started on port" + port);
        server.awaitTermination();
        
    }
}
