package com.example.twopc;

import java.util.ArrayList;
import java.util.List;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import twopc.TwoPhaseCommitGrpc;
import twopc.Twopc.DecisionRequest;
import twopc.Twopc.DecisionResponse;
import twopc.Twopc.GlobalDecision;
import twopc.Twopc.Vote;
import twopc.Twopc.VoteRequest;
import twopc.Twopc.VoteResponse;

public class GrpcClient {
    public static void main(String[] args) {
        String transaction_id = "dex12345";
        List<String> voteAddresses = List.of("node1:181",
                                            "node2:182",
                                            "node3:183",
                                            "node4:184",
                                            "node5:185"
                                            ); // service ports for VOTE
        
        List<Vote> votes = new ArrayList<>();
        int i = 0;
        for (String addr : voteAddresses) {
            i++;
            String[] parts = addr.split(":");
            String host = parts[0].trim().replaceAll("^/+", "");
            int port = Integer.parseInt(parts[1].trim());
            String target = "dns:///" + addr;
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                                .usePlaintext()
                                .build();

            TwoPhaseCommitGrpc.TwoPhaseCommitBlockingStub stub = TwoPhaseCommitGrpc.newBlockingStub(channel);
            VoteRequest voteReq = VoteRequest.newBuilder()
                                        .setTransactionId(transaction_id)
                                        .build();
            VoteResponse voteResp = stub.queryVote(voteReq);
            System.out.println("Phase DECISION PHASE of Node node_0 sends RPC QueryVote(VoteRequest) to Phase DECISION PHASE of Node node_" + i);
            System.out.println("queried vote from "+ addr + ":" + voteResp.getVote());
            votes.add(voteResp.getVote());
            channel.shutdown();
        }

        // count all votes
        boolean allCommit = votes.stream().allMatch(vote -> vote == Vote.VOTE_COMMIT);
        GlobalDecision gDecision = allCommit ? GlobalDecision.DECISION_COMMIT : GlobalDecision.DECISION_ABORT;
        System.out.println("Coordinator: Final global decision is: " + gDecision);
        
        List<String> decisionAddresses = List.of("node1:191",
                                                    "node2:192",
                                                    "node3:193",
                                                    "node4:194",
                                                    "node5:195"
                                                ); 
        i = 0;
        for (String addr : decisionAddresses) {
            i++;
            String[] parts = addr.split(":");
            String host = parts[0].trim().replaceAll("^/+", "");
            int port = Integer.parseInt(parts[1].trim());
            String target = "dns:///" + addr;
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                                                            .usePlaintext()
                                                            .build();
            TwoPhaseCommitGrpc.TwoPhaseCommitBlockingStub stub = TwoPhaseCommitGrpc.newBlockingStub(channel);
            DecisionRequest decisionReq = DecisionRequest.newBuilder()
                                                        .setTransactionId(transaction_id)
                                                        .setDecision(gDecision)
                                                        .build();
            
            DecisionResponse decisionResp = stub.sendDecision(decisionReq);
            System.out.println("Phase DECISION PHASE of Node node_0 sends RPC SendDecision(DecisionRequest) to Phase DECISION PHASE of Node node_" + i);
            System.out.println("Coordinator: Sent decision to " + addr + ", ack: " + decisionResp.getAck());
            channel.shutdown();
        }                                        
        System.out.println("All participants knows the decision " + gDecision + " coordinator COMMIT!");
    }
}
