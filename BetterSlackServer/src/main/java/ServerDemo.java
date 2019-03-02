

import java.io.IOException;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        Server server1 = new Server();

        server1.startServer(51008);
    }
}
