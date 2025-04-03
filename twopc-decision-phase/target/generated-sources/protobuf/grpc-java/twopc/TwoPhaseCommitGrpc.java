package twopc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: twopc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TwoPhaseCommitGrpc {

  private TwoPhaseCommitGrpc() {}

  public static final String SERVICE_NAME = "twopc.TwoPhaseCommit";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest,
      twopc.Twopc.VoteResponse> getSendVoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendVote",
      requestType = twopc.Twopc.VoteRequest.class,
      responseType = twopc.Twopc.VoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest,
      twopc.Twopc.VoteResponse> getSendVoteMethod() {
    io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest, twopc.Twopc.VoteResponse> getSendVoteMethod;
    if ((getSendVoteMethod = TwoPhaseCommitGrpc.getSendVoteMethod) == null) {
      synchronized (TwoPhaseCommitGrpc.class) {
        if ((getSendVoteMethod = TwoPhaseCommitGrpc.getSendVoteMethod) == null) {
          TwoPhaseCommitGrpc.getSendVoteMethod = getSendVoteMethod =
              io.grpc.MethodDescriptor.<twopc.Twopc.VoteRequest, twopc.Twopc.VoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendVote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.VoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.VoteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TwoPhaseCommitMethodDescriptorSupplier("SendVote"))
              .build();
        }
      }
    }
    return getSendVoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<twopc.Twopc.DecisionRequest,
      twopc.Twopc.DecisionResponse> getSendDecisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDecision",
      requestType = twopc.Twopc.DecisionRequest.class,
      responseType = twopc.Twopc.DecisionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<twopc.Twopc.DecisionRequest,
      twopc.Twopc.DecisionResponse> getSendDecisionMethod() {
    io.grpc.MethodDescriptor<twopc.Twopc.DecisionRequest, twopc.Twopc.DecisionResponse> getSendDecisionMethod;
    if ((getSendDecisionMethod = TwoPhaseCommitGrpc.getSendDecisionMethod) == null) {
      synchronized (TwoPhaseCommitGrpc.class) {
        if ((getSendDecisionMethod = TwoPhaseCommitGrpc.getSendDecisionMethod) == null) {
          TwoPhaseCommitGrpc.getSendDecisionMethod = getSendDecisionMethod =
              io.grpc.MethodDescriptor.<twopc.Twopc.DecisionRequest, twopc.Twopc.DecisionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendDecision"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.DecisionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.DecisionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TwoPhaseCommitMethodDescriptorSupplier("SendDecision"))
              .build();
        }
      }
    }
    return getSendDecisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest,
      twopc.Twopc.VoteResponse> getQueryVoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryVote",
      requestType = twopc.Twopc.VoteRequest.class,
      responseType = twopc.Twopc.VoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest,
      twopc.Twopc.VoteResponse> getQueryVoteMethod() {
    io.grpc.MethodDescriptor<twopc.Twopc.VoteRequest, twopc.Twopc.VoteResponse> getQueryVoteMethod;
    if ((getQueryVoteMethod = TwoPhaseCommitGrpc.getQueryVoteMethod) == null) {
      synchronized (TwoPhaseCommitGrpc.class) {
        if ((getQueryVoteMethod = TwoPhaseCommitGrpc.getQueryVoteMethod) == null) {
          TwoPhaseCommitGrpc.getQueryVoteMethod = getQueryVoteMethod =
              io.grpc.MethodDescriptor.<twopc.Twopc.VoteRequest, twopc.Twopc.VoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryVote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.VoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  twopc.Twopc.VoteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TwoPhaseCommitMethodDescriptorSupplier("QueryVote"))
              .build();
        }
      }
    }
    return getQueryVoteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TwoPhaseCommitStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitStub>() {
        @java.lang.Override
        public TwoPhaseCommitStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TwoPhaseCommitStub(channel, callOptions);
        }
      };
    return TwoPhaseCommitStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TwoPhaseCommitBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitBlockingStub>() {
        @java.lang.Override
        public TwoPhaseCommitBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TwoPhaseCommitBlockingStub(channel, callOptions);
        }
      };
    return TwoPhaseCommitBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TwoPhaseCommitFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TwoPhaseCommitFutureStub>() {
        @java.lang.Override
        public TwoPhaseCommitFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TwoPhaseCommitFutureStub(channel, callOptions);
        }
      };
    return TwoPhaseCommitFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TwoPhaseCommitImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * vote-phase messaging loop - for coordinator use
     * </pre>
     */
    public void sendVote(twopc.Twopc.VoteRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendVoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * decision-phase messaging loop - for coordinator use
     * </pre>
     */
    public void sendDecision(twopc.Twopc.DecisionRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.DecisionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendDecisionMethod(), responseObserver);
    }

    /**
     * <pre>
     * decision-phase info helper - retrieve votes from phase 1 to count and avoid re-voting
     * </pre>
     */
    public void queryVote(twopc.Twopc.VoteRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryVoteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendVoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                twopc.Twopc.VoteRequest,
                twopc.Twopc.VoteResponse>(
                  this, METHODID_SEND_VOTE)))
          .addMethod(
            getSendDecisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                twopc.Twopc.DecisionRequest,
                twopc.Twopc.DecisionResponse>(
                  this, METHODID_SEND_DECISION)))
          .addMethod(
            getQueryVoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                twopc.Twopc.VoteRequest,
                twopc.Twopc.VoteResponse>(
                  this, METHODID_QUERY_VOTE)))
          .build();
    }
  }

  /**
   */
  public static final class TwoPhaseCommitStub extends io.grpc.stub.AbstractAsyncStub<TwoPhaseCommitStub> {
    private TwoPhaseCommitStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TwoPhaseCommitStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TwoPhaseCommitStub(channel, callOptions);
    }

    /**
     * <pre>
     * vote-phase messaging loop - for coordinator use
     * </pre>
     */
    public void sendVote(twopc.Twopc.VoteRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendVoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * decision-phase messaging loop - for coordinator use
     * </pre>
     */
    public void sendDecision(twopc.Twopc.DecisionRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.DecisionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendDecisionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * decision-phase info helper - retrieve votes from phase 1 to count and avoid re-voting
     * </pre>
     */
    public void queryVote(twopc.Twopc.VoteRequest request,
        io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryVoteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TwoPhaseCommitBlockingStub extends io.grpc.stub.AbstractBlockingStub<TwoPhaseCommitBlockingStub> {
    private TwoPhaseCommitBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TwoPhaseCommitBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TwoPhaseCommitBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * vote-phase messaging loop - for coordinator use
     * </pre>
     */
    public twopc.Twopc.VoteResponse sendVote(twopc.Twopc.VoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendVoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * decision-phase messaging loop - for coordinator use
     * </pre>
     */
    public twopc.Twopc.DecisionResponse sendDecision(twopc.Twopc.DecisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendDecisionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * decision-phase info helper - retrieve votes from phase 1 to count and avoid re-voting
     * </pre>
     */
    public twopc.Twopc.VoteResponse queryVote(twopc.Twopc.VoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryVoteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TwoPhaseCommitFutureStub extends io.grpc.stub.AbstractFutureStub<TwoPhaseCommitFutureStub> {
    private TwoPhaseCommitFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TwoPhaseCommitFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TwoPhaseCommitFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * vote-phase messaging loop - for coordinator use
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<twopc.Twopc.VoteResponse> sendVote(
        twopc.Twopc.VoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendVoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * decision-phase messaging loop - for coordinator use
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<twopc.Twopc.DecisionResponse> sendDecision(
        twopc.Twopc.DecisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendDecisionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * decision-phase info helper - retrieve votes from phase 1 to count and avoid re-voting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<twopc.Twopc.VoteResponse> queryVote(
        twopc.Twopc.VoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryVoteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_VOTE = 0;
  private static final int METHODID_SEND_DECISION = 1;
  private static final int METHODID_QUERY_VOTE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TwoPhaseCommitImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TwoPhaseCommitImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_VOTE:
          serviceImpl.sendVote((twopc.Twopc.VoteRequest) request,
              (io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse>) responseObserver);
          break;
        case METHODID_SEND_DECISION:
          serviceImpl.sendDecision((twopc.Twopc.DecisionRequest) request,
              (io.grpc.stub.StreamObserver<twopc.Twopc.DecisionResponse>) responseObserver);
          break;
        case METHODID_QUERY_VOTE:
          serviceImpl.queryVote((twopc.Twopc.VoteRequest) request,
              (io.grpc.stub.StreamObserver<twopc.Twopc.VoteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TwoPhaseCommitBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TwoPhaseCommitBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return twopc.Twopc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TwoPhaseCommit");
    }
  }

  private static final class TwoPhaseCommitFileDescriptorSupplier
      extends TwoPhaseCommitBaseDescriptorSupplier {
    TwoPhaseCommitFileDescriptorSupplier() {}
  }

  private static final class TwoPhaseCommitMethodDescriptorSupplier
      extends TwoPhaseCommitBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TwoPhaseCommitMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TwoPhaseCommitGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TwoPhaseCommitFileDescriptorSupplier())
              .addMethod(getSendVoteMethod())
              .addMethod(getSendDecisionMethod())
              .addMethod(getQueryVoteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
