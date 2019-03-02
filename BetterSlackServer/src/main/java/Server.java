import com.sun.security.ntlm.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private static final String EXIT_KEYWORD = "exit";

    public void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("before accept");
        socket = server.accept();
        System.out.println("Client has been connected");

        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        output.println("Hello from server");

        while (!socket.isClosed()){
            String receivedMessage = "";

            try{
                receivedMessage = input.readLine();
            }catch (SocketException ex){
                System.out.println("Client has been disconnected");
                break;
            }

            if(receivedMessage.toLowerCase().equals(EXIT_KEYWORD)){
                break;
            }
            System.out.println(receivedMessage);
        }

//        while (clientSocket.isClosed()&& !clientSocket.isInputShutdown()) {
//        }
//        System.out.println("Client has been disconnected");
//    }

    }
}
