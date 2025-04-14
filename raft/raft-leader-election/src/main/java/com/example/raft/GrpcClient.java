package com.example.raft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.UUID;

import com.example.raft.RaftGrpc;
import com.example.raft.RaftOuterClass.Vote;
import com.example.raft.RaftOuterClass.VoteRequest;
import com.example.raft.RaftOuterClass.VoteResponse;
import com.example.raft.RaftOuterClass.HbAck;
import com.example.raft.RaftOuterClass.LogEntry;
import com.example.raft.RaftOuterClass.StartHeartbeatRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Timer;
import io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;

public class GrpcClient {
    public static void main(String[] args) {
        RaftNode node = new GrpcClient().new RaftNode();
        node.start();
    }

    enum Role {
        FOLLOWER, CANDIDATE, LEADER
    }


    class RaftNode {
        String selfId = System.getenv("NODE_ID");
        
        Role curRole = Role.FOLLOWER;
        List<String> peers = List.of("raft-node1:201", "raft-node2:202", "raft-node3:203", "raft-node4:204", "raft-node5:205");
        int curTerm = 1;
        String votedFor = null;
        int voteCount = 0;
        Timer electionTimer;
        List<LogEntry> log = new ArrayList<>();
        

        public void start() {
            startElectionTimeout();
        }

        private void startElectionTimeout() {
            electionTimer = new Timer();
            electionTimer.schedule(new TimerTask() {
                public void run() {
                    startElection();
                }
            }, randomTimeout());
            
        }

        private int randomTimeout() {
            return ThreadLocalRandom.current().nextInt(1500, 3001);
        }

        private void startElection() {
            curRole = Role.CANDIDATE;
            curTerm++;
            votedFor = selfId;
            voteCount = 1;

            int lastLogIndex = log.size() - 1;
            int lastLogTerm = log.isEmpty() ? 0 : log.get(lastLogIndex).getTerm();

            for (String peer : peers) {
                if (isSelf(peer)) continue;
                VoteResponse resp = sendRequestVote(peer, curTerm, lastLogIndex, lastLogTerm);
                handleVoteResponse(resp);
            }
        }



        public void handleVoteResponse(VoteResponse response) {
            if (response.getVote() == Vote.VOTE_YES) {
                voteCount++;
                System.out.println("node " + selfId + " gets " + voteCount + " votes now");
                if (voteCount > peers.size() / 2) {
                    becomeLeader();
                }
            }
        }

        private boolean isSelf(String peer) {
            String peerId = peer.split(":")[0];
            return peerId.equals(selfId);
        }

        private void becomeLeader() {
            System.out.println("LEADER ELECTED: " + selfId + " in term " + curTerm);
            curRole = Role.LEADER;
            Timer heartbeatTimer = new Timer();
            heartbeatTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    sendHeartbeatStartSignalToPy();
                }
            }, 0, 1000);
            // CONNECT TO PYTHON HERE
        }

        private void sendHeartbeatStartSignalToPy() {
            int reservedPort = 210;
            ManagedChannel channel = ManagedChannelBuilder.forAddress(selfId, reservedPort)
                                                    .usePlaintext()
                                                    .build();
            
            RaftGrpc.RaftBlockingStub stub = RaftGrpc.newBlockingStub(channel);
            StartHeartbeatRequest request = StartHeartbeatRequest.newBuilder()
                                                                .setLeaderId(selfId)
                                                                .setTerm(curTerm)
                                                                .build();

            HbAck response = stub.startHeartbeat(request);
            System.out.println("Node " + selfId +" sends RPC startHeartbeat to Node " + selfId);
        }

        public VoteResponse sendRequestVote(String targetHost, int term, int lastLogIndex, int lastLogTerm) {
            ManagedChannel channel = null;
            VoteRequest request = null;
            System.out.println("Node " + selfId +" sends RPC RequestVote to Node " + targetHost.split(":")[0]);
            try {
                channel = ManagedChannelBuilder.forTarget(targetHost).usePlaintext().build();
                RaftGrpc.RaftBlockingStub stub = RaftGrpc.newBlockingStub(channel);
        
                request = VoteRequest.newBuilder()
                                                .setCandidateId(selfId)
                                                .setTerm(term)
                                                .setLastLogIndex(lastLogIndex)
                                                .setLastLogTerm(lastLogTerm)
                                                .setTransactionId(UUID.randomUUID().toString())
                                                .build();
        
                VoteResponse response = stub.requestVote(request);
                
                return response;
            
            } catch (Exception e) {
                System.err.println("Request to " + targetHost + " failed due to: " + e.getMessage());
                return VoteResponse.newBuilder()
                                    .setTransactionId(request != null ? request.getTransactionId() : "unknown")
                                    .setTerm(term)
                                    .setVote(Vote.VOTE_NO)
                                    .build();
            } finally {
                if (channel != null) channel.shutdown();
            }
        }
    }

    
}
