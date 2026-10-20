import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started...");
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String message = input.readLine();
            System.out.println("Client says: " + message);
            output.println("Hello Client");
            socket.close();
            serverSocket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}