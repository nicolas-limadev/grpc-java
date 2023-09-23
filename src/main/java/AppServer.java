import io.grpc.ServerBuilder;
import service.UserService;
import io.grpc.BindableService;
import io.grpc.Server;

import java.io.IOException;
import java.util.logging.Logger;

public class AppServer {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Server server = ServerBuilder.forPort(50000).addService((BindableService) new UserService()).build();

        server.start();

        logger.info("Server started at port: " + server.getPort());

        server.awaitTermination();
    }
}
