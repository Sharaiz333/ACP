package semesterproject.universitymanagementsystem;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final String FILE_NAME = "server_data.txt";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server started at port 5000...");

            while (true) {
                Socket socket = server.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                String request = br.readLine();

                if (request.equals("LOAD")) {
                    File file = new File(FILE_NAME);
                    if (!file.exists()) {
                        pw.println("NO_DATA");
                    } else {
                        Scanner sc = new Scanner(file);
                        while (sc.hasNextLine()) {
                            pw.println(sc.nextLine());
                        }
                        sc.close();
                    }
                    pw.println("END");
                } else {
                    FileWriter fw = new FileWriter(FILE_NAME, true);
                    fw.write(request + "\n");
                    fw.close();

                    pw.println("SAVED");
                }

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
