package semesterproject.universitymanagementsystem;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");

            while (true) {
                try (Socket socket = server.accept(); 
                     BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     FileWriter fw = new FileWriter("server_data.txt", true)) {

                    String data = br.readLine();
                    fw.write(data + "\n");
                    System.out.println("Saved: " + data);

                } catch (IOException e) {
                    System.out.println("Error handling client connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
