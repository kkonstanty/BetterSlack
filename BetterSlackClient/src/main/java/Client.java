import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    private static final String EXIT_KEYWORD = "exit";

    public void connectToServer (String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        System.out.println(input.readLine());

        Scanner scanner = new Scanner(System.in);

        while (true){
            String userInput = scanner.next();

            if(userInput.toLowerCase().equals(EXIT_KEYWORD)){
                break;
            }
            output.println(userInput);
        }
    }
}
