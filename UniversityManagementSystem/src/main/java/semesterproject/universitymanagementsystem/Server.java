package semesterproject.universitymanagementsystem;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final String STUDENT_FILE = "students_data.txt";
    private static final String UNIVERSITY_FILE = "university_data.txt";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server started at port 5000...");

            while (true) {
                Socket socket = server.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                String request = br.readLine();
                
                if (request.startsWith("LOAD_STUDENT")) {
                    loadData(STUDENT_FILE, pw);
                } else if (request.startsWith("LOAD_UNIVERSITY")) {
                    loadData(UNIVERSITY_FILE, pw);
                } else if (request.startsWith("SAVE_STUDENT")) {
                    saveData(STUDENT_FILE, request.substring(12), pw);
                } else if (request.startsWith("SAVE_UNIVERSITY")) {
                    saveData(UNIVERSITY_FILE, request.substring(16), pw);
                } else {
                    pw.println("INVALID_REQUEST");
                }

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadData(String fileName, PrintWriter pw) {
        File file = new File(fileName);
        if (!file.exists()) {
            pw.println("NO_DATA");
        } else {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    pw.println(sc.nextLine());
                }
            } catch (IOException e) {
                pw.println("ERROR_READING_FILE");
                e.printStackTrace();
            }
            pw.println("END");
        }
    }

    private static void saveData(String fileName, String data, PrintWriter pw) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(data + "\n");
            pw.println("SAVED");
        } catch (IOException e) {
            pw.println("ERROR_WRITING_FILE");
            e.printStackTrace();
        }
    }
}
