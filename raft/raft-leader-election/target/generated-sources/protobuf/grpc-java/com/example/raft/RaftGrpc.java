package com.example.raft;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: raft.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RaftGrpc {

  private RaftGrpc() {}

  public static final String SERVICE_NAME = "raft.Raft";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.VoteRequest,
      com.example.raft.RaftOuterClass.VoteResponse> getRequestVoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestVote",
      requestType = com.example.raft.RaftOuterClass.VoteRequest.class,
      responseType = com.example.raft.RaftOuterClass.VoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.VoteRequest,
      com.example.raft.RaftOuterClass.VoteResponse> getRequestVoteMethod() {
    io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.VoteRequest, com.example.raft.RaftOuterClass.VoteResponse> getRequestVoteMethod;
    if ((getRequestVoteMethod = RaftGrpc.getRequestVoteMethod) == null) {
      synchronized (RaftGrpc.class) {
        if ((getRequestVoteMethod = RaftGrpc.getRequestVoteMethod) == null) {
          RaftGrpc.getRequestVoteMethod = getRequestVoteMethod =
              io.grpc.MethodDescriptor.<com.example.raft.RaftOuterClass.VoteRequest, com.example.raft.RaftOuterClass.VoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestVote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.VoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.VoteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RaftMethodDescriptorSupplier("RequestVote"))
              .build();
        }
      }
    }
    return getRequestVoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.AppendEntriesRequest,
      com.example.raft.RaftOuterClass.AppendEntriesResponse> getAppendEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AppendEntries",
      requestType = com.example.raft.RaftOuterClass.AppendEntriesRequest.class,
      responseType = com.example.raft.RaftOuterClass.AppendEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.AppendEntriesRequest,
      com.example.raft.RaftOuterClass.AppendEntriesResponse> getAppendEntriesMethod() {
    io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.AppendEntriesRequest, com.example.raft.RaftOuterClass.AppendEntriesResponse> getAppendEntriesMethod;
    if ((getAppendEntriesMethod = RaftGrpc.getAppendEntriesMethod) == null) {
      synchronized (RaftGrpc.class) {
        if ((getAppendEntriesMethod = RaftGrpc.getAppendEntriesMethod) == null) {
          RaftGrpc.getAppendEntriesMethod = getAppendEntriesMethod =
              io.grpc.MethodDescriptor.<com.example.raft.RaftOuterClass.AppendEntriesRequest, com.example.raft.RaftOuterClass.AppendEntriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendEntries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.AppendEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.AppendEntriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RaftMethodDescriptorSupplier("AppendEntries"))
              .build();
        }
      }
    }
    return getAppendEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.StartHeartbeatRequest,
      com.example.raft.RaftOuterClass.HbAck> getStartHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartHeartbeat",
      requestType = com.example.raft.RaftOuterClass.StartHeartbeatRequest.class,
      responseType = com.example.raft.RaftOuterClass.HbAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.StartHeartbeatRequest,
      com.example.raft.RaftOuterClass.HbAck> getStartHeartbeatMethod() {
    io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.StartHeartbeatRequest, com.example.raft.RaftOuterClass.HbAck> getStartHeartbeatMethod;
    if ((getStartHeartbeatMethod = RaftGrpc.getStartHeartbeatMethod) == null) {
      synchronized (RaftGrpc.class) {
        if ((getStartHeartbeatMethod = RaftGrpc.getStartHeartbeatMethod) == null) {
          RaftGrpc.getStartHeartbeatMethod = getStartHeartbeatMethod =
              io.grpc.MethodDescriptor.<com.example.raft.RaftOuterClass.StartHeartbeatRequest, com.example.raft.RaftOuterClass.HbAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartHeartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.StartHeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.HbAck.getDefaultInstance()))
              .setSchemaDescriptor(new RaftMethodDescriptorSupplier("StartHeartbeat"))
              .build();
        }
      }
    }
    return getStartHeartbeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.HeartbeatRequest,
      com.example.raft.RaftOuterClass.HbAck> getReceiveHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveHeartbeat",
      requestType = com.example.raft.RaftOuterClass.HeartbeatRequest.class,
      responseType = com.example.raft.RaftOuterClass.HbAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.HeartbeatRequest,
      com.example.raft.RaftOuterClass.HbAck> getReceiveHeartbeatMethod() {
    io.grpc.MethodDescriptor<com.example.raft.RaftOuterClass.HeartbeatRequest, com.example.raft.RaftOuterClass.HbAck> getReceiveHeartbeatMethod;
    if ((getReceiveHeartbeatMethod = RaftGrpc.getReceiveHeartbeatMethod) == null) {
      synchronized (RaftGrpc.class) {
        if ((getReceiveHeartbeatMethod = RaftGrpc.getReceiveHeartbeatMethod) == null) {
          RaftGrpc.getReceiveHeartbeatMethod = getReceiveHeartbeatMethod =
              io.grpc.MethodDescriptor.<com.example.raft.RaftOuterClass.HeartbeatRequest, com.example.raft.RaftOuterClass.HbAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveHeartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.raft.RaftOuterClass.HbAck.getDefaultInstance()))
              .setSchemaDescriptor(new RaftMethodDescriptorSupplier("receiveHeartbeat"))
              .build();
        }
      }
    }
    return getReceiveHeartbeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RaftStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RaftStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RaftStub>() {
        @java.lang.Override
        public RaftStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RaftStub(channel, callOptions);
        }
      };
    return RaftStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RaftBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RaftBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RaftBlockingStub>() {
        @java.lang.Override
        public RaftBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RaftBlockingStub(channel, callOptions);
        }
      };
    return RaftBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RaftFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RaftFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RaftFutureStub>() {
        @java.lang.Override
        public RaftFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RaftFutureStub(channel, callOptions);
        }
      };
    return RaftFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RaftImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestVote(com.example.raft.RaftOuterClass.VoteRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.VoteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestVoteMethod(), responseObserver);
    }

    /**
     */
    public void appendEntries(com.example.raft.RaftOuterClass.AppendEntriesRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.AppendEntriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendEntriesMethod(), responseObserver);
    }

    /**
     */
    public void startHeartbeat(com.example.raft.RaftOuterClass.StartHeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartHeartbeatMethod(), responseObserver);
    }

    /**
     */
    public void receiveHeartbeat(com.example.raft.RaftOuterClass.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveHeartbeatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestVoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.raft.RaftOuterClass.VoteRequest,
                com.example.raft.RaftOuterClass.VoteResponse>(
                  this, METHODID_REQUEST_VOTE)))
          .addMethod(
            getAppendEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.raft.RaftOuterClass.AppendEntriesRequest,
                com.example.raft.RaftOuterClass.AppendEntriesResponse>(
                  this, METHODID_APPEND_ENTRIES)))
          .addMethod(
            getStartHeartbeatMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.raft.RaftOuterClass.StartHeartbeatRequest,
                com.example.raft.RaftOuterClass.HbAck>(
                  this, METHODID_START_HEARTBEAT)))
          .addMethod(
            getReceiveHeartbeatMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.raft.RaftOuterClass.HeartbeatRequest,
                com.example.raft.RaftOuterClass.HbAck>(
                  this, METHODID_RECEIVE_HEARTBEAT)))
          .build();
    }
  }

  /**
   */
  public static final class RaftStub extends io.grpc.stub.AbstractAsyncStub<RaftStub> {
    private RaftStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RaftStub(channel, callOptions);
    }

    /**
     */
    public void requestVote(com.example.raft.RaftOuterClass.VoteRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.VoteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void appendEntries(com.example.raft.RaftOuterClass.AppendEntriesRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.AppendEntriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startHeartbeat(com.example.raft.RaftOuterClass.StartHeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveHeartbeat(com.example.raft.RaftOuterClass.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceiveHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RaftBlockingStub extends io.grpc.stub.AbstractBlockingStub<RaftBlockingStub> {
    private RaftBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RaftBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.raft.RaftOuterClass.VoteResponse requestVote(com.example.raft.RaftOuterClass.VoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestVoteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.raft.RaftOuterClass.AppendEntriesResponse appendEntries(com.example.raft.RaftOuterClass.AppendEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAppendEntriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.raft.RaftOuterClass.HbAck startHeartbeat(com.example.raft.RaftOuterClass.StartHeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartHeartbeatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.raft.RaftOuterClass.HbAck receiveHeartbeat(com.example.raft.RaftOuterClass.HeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceiveHeartbeatMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RaftFutureStub extends io.grpc.stub.AbstractFutureStub<RaftFutureStub> {
    private RaftFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RaftFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.raft.RaftOuterClass.VoteResponse> requestVote(
        com.example.raft.RaftOuterClass.VoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.raft.RaftOuterClass.AppendEntriesResponse> appendEntries(
        com.example.raft.RaftOuterClass.AppendEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.raft.RaftOuterClass.HbAck> startHeartbeat(
        com.example.raft.RaftOuterClass.StartHeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartHeartbeatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.raft.RaftOuterClass.HbAck> receiveHeartbeat(
        com.example.raft.RaftOuterClass.HeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceiveHeartbeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_VOTE = 0;
  private static final int METHODID_APPEND_ENTRIES = 1;
  private static final int METHODID_START_HEARTBEAT = 2;
  private static final int METHODID_RECEIVE_HEARTBEAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RaftImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RaftImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_VOTE:
          serviceImpl.requestVote((com.example.raft.RaftOuterClass.VoteRequest) request,
              (io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.VoteResponse>) responseObserver);
          break;
        case METHODID_APPEND_ENTRIES:
          serviceImpl.appendEntries((com.example.raft.RaftOuterClass.AppendEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.AppendEntriesResponse>) responseObserver);
          break;
        case METHODID_START_HEARTBEAT:
          serviceImpl.startHeartbeat((com.example.raft.RaftOuterClass.StartHeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck>) responseObserver);
          break;
        case METHODID_RECEIVE_HEARTBEAT:
          serviceImpl.receiveHeartbeat((com.example.raft.RaftOuterClass.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<com.example.raft.RaftOuterClass.HbAck>) responseObserver);
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

  private static abstract class RaftBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RaftBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.raft.RaftOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Raft");
    }
  }

  private static final class RaftFileDescriptorSupplier
      extends RaftBaseDescriptorSupplier {
    RaftFileDescriptorSupplier() {}
  }

  private static final class RaftMethodDescriptorSupplier
      extends RaftBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RaftMethodDescriptorSupplier(String methodName) {
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
      synchronized (RaftGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RaftFileDescriptorSupplier())
              .addMethod(getRequestVoteMethod())
              .addMethod(getAppendEntriesMethod())
              .addMethod(getStartHeartbeatMethod())
              .addMethod(getReceiveHeartbeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
