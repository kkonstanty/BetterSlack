import java.io.IOException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Client client1 = new Client();

        client1.connectToServer("127.0.0.1",51008);
    }
}
