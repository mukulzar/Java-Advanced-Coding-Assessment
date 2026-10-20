import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello Server");
            String response = input.readLine();
            System.out.println("Server says: " + response);
            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}