package service;
import generated.Empty;
import generated.LoginRequest;
import generated.LoginResponse;
import generated.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        LoginResponse.Builder response = LoginResponse.newBuilder();

        if(username.equals("admin") && password.equals("admin")) {
            response.setResponse("Sucesso").setStatus(200);
        } else {
            response.setResponse("Falha").setStatus(400);
        }
        
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<LoginResponse> responseObserver) {
        super.logout(request, responseObserver);
    }

    
}
