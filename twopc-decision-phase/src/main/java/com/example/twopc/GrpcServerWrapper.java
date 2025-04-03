package com.example.twopc;
import java.util.ArrayList;
import java.util.List;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import twopc.TwoPhaseCommitGrpc.TwoPhaseCommitImplBase;
import twopc.Twopc.DecisionRequest;
import twopc.Twopc.DecisionResponse;
import twopc.Twopc.GlobalDecision;



public class GrpcServerWrapper {
    public static void main(String[] args) throws Exception {
        ServerRunner.main(args);
    }
}

class TwoPhaseCommitDecisionService extends TwoPhaseCommitImplBase {

    @Override
    public void sendDecision(DecisionRequest request, StreamObserver<DecisionResponse> responseObserver) {

        // print the request of ack'ing the decision
        // java grpc skeleton code has made getter and setter for each message
        // type defined in proto
        GlobalDecision gDecision = request.getDecision();

        System.out.println("received a request of ack'ing a decision, transaction id:" + request.getTransactionId() +
        ", the decision is:" + gDecision);

        // construct a response to ack the decision request
        try {
            DecisionResponse response = DecisionResponse.newBuilder()
                                    .setTransactionId(request.getTransactionId())
                                    .setAck(true)
                                    .build();

            // send the response and complete the invocation
            responseObserver.onNext(response);
            System.out.println("Phase DECISION PHASE of Node " + System.getenv("NODE_ID") + " sends RPC DecisionResponse to Phase DECISION PHASE of Node node_0");
            responseObserver.onCompleted();
        } catch(Exception e) {
            System.out.println("decision response NOT received due to" + e);
        }
    }
}

class ServerRunner {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java -jar <jar-file> <port>");
        }
        int port = Integer.parseInt(args[0]);
        Server server = ServerBuilder.forPort(port)
                        .addService(new TwoPhaseCommitDecisionService())
                        .build()
                        .start();
            
        System.out.println("Server started on port" + port);
        server.awaitTermination();
        
    }
}

