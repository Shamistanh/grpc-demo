package grpc;

import io.grpc.stub.StreamObserver;


public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        System.out.println("Your full name is " + firstName + " "+ lastName);

        responseObserver.onNext(HelloResponse.newBuilder()
                .setGreeting("Hello " + firstName + " " + lastName + "!!!")
                .build());
        responseObserver.onCompleted();
    }
}
