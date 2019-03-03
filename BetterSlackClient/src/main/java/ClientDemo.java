import java.io.IOException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Client client1 = new Client();

        client1.connectToServer("192.168.1.74",55555);
    }
}
