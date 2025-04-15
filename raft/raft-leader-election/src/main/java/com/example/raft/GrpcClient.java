package com.example.raft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Timer;

import com.example.raft.RaftGrpc;
import com.example.raft.RaftOuterClass.Vote;
import com.example.raft.RaftOuterClass.VoteRequest;
import com.example.raft.RaftOuterClass.VoteResponse;
import com.example.raft.RaftOuterClass.HbAck;
import com.example.raft.RaftOuterClass.LogEntry;
import com.example.raft.RaftOuterClass.StartHeartbeatRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.atomic.AtomicInteger;

public class GrpcClient {
    public static void main(String[] args) {
        RaftNode.getInstance().start();
    }

    enum Role {
        FOLLOWER, CANDIDATE, LEADER
    }

    static class RaftNode {
        String selfId = System.getenv("NODE_ID");
        Role curRole = Role.FOLLOWER;
        List<String> peers = List.of("raft-node1:201", "raft-node2:202", "raft-node3:203", "raft-node4:204", "raft-node5:205");
        AtomicInteger curTerm = new AtomicInteger(1);
        String votedFor = null;
        int voteCount = 0;
        private static RaftNode instance;

    public static RaftNode getInstance() {
        if (instance == null) {
            instance = new RaftNode();
        }
        return instance;
    }

        private Timer electionTimer;
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
            return new Random().nextInt(1500) + 1500; // 1500 - 3000 ms
        }

        void resetElectionTimeout() {
            if (electionTimer != null) {
                electionTimer.cancel();
            }
            startElectionTimeout();
        }

        private void startElection() {
            curRole = Role.CANDIDATE;
            int term = curTerm.incrementAndGet();
            votedFor = selfId;
            voteCount = 1;

            int lastLogIndex = log.size() - 1;
            int lastLogTerm = log.isEmpty() ? 0 : log.get(lastLogIndex).getTerm();

            for (String peer : peers) {
                if (isSelf(peer)) continue;
                VoteResponse resp = sendRequestVote(peer, term, lastLogIndex, lastLogTerm);
                handleVoteResponse(resp);
            }
        }

        public void handleVoteResponse(VoteResponse response) {
            synchronized (this) {
                if (response.getTerm() > curTerm.get()) {
                    curTerm.set(response.getTerm());
                    curRole = Role.FOLLOWER;
                    votedFor = null;
                    resetElectionTimeout();
                    return;
                }

                if (response.getVote() == Vote.VOTE_YES) {
                    voteCount++;
                    System.out.println("node " + selfId + " gets " + voteCount + " votes now");
                    if (voteCount > peers.size() / 2 && curRole == Role.CANDIDATE) {
                        becomeLeader();
                    }
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
        }

        private void sendHeartbeatStartSignalToPy() {
            int reservedPort = 210;
            for (String peer : peers) {
                if (isSelf(peer)) continue;
                String peerId = peer.split(":")[0];
                try {
                    System.out.println("Leader sending heartbeat to " + peerId);
                    new ProcessBuilder("python", "client.py", peerId, String.valueOf(curTerm)).start();
                } catch (IOException e) {
                    System.err.println("Failed to send heartbeat to " + peerId + ": " + e.getMessage());
                }
            }
        }


        public VoteResponse sendRequestVote(String targetHost, int term, int lastLogIndex, int lastLogTerm) {
            ManagedChannel channel = null;
            VoteRequest request = null;
            System.out.println("Node " + selfId + " sends RPC RequestVote to Node " + targetHost.split(":")[0]);
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

                return stub.requestVote(request);

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
