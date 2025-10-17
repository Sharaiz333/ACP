package semesterproject.universitymanagementsystem;

import java.io.*;
import java.util.*;

public class University {
    private String uniName;
    private String location;

    private static final List<University> universities = new ArrayList<>();
    private static final String FILE_NAME = "universities.txt";

    public University(String uniName, String location) {
        this.uniName = uniName;
        this.location = location;
    }

    public String getUniName() { return uniName; }
    public String getLocation() { return location; }
    public void setUniName(String uniName) { this.uniName = uniName; }
    public void setLocation(String location) { this.location = location; }

    public void displayInfo() {
        System.out.println("\n----------------------------");
        System.out.println("University: " + uniName);
        System.out.println("Location: " + location);
        System.out.println("----------------------------");
    }

    public static void universityMenu() {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n=== UNIVERSITY MENU ===");
            System.out.println("1. Add University");
            System.out.println("2. View All Universities");
            System.out.println("3. Search University");
            System.out.println("4. Delete University");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addUniversity(sc);
                case 2 -> displayAll();
                case 3 -> searchUniversity(sc);
                case 4 -> deleteUniversity(sc); 
                case 5 -> {
                    saveToFile();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addUniversity(Scanner sc) {
        System.out.print("Enter University Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        universities.add(new University(name, location));
        saveToFile();
        System.out.println("University added and saved successfully!");
    }

    private static void displayAll() {
        if (universities.isEmpty()) {
            System.out.println("No universities found!");
            return;
        }
        for (University u : universities)
            u.displayInfo();
    }

    private static void searchUniversity(Scanner sc) {
        System.out.print("Enter University Name: ");
        String name = sc.nextLine();

        for (University u : universities) {
            if (u.getUniName().equalsIgnoreCase(name)) {
                System.out.println("University found:");
                u.displayInfo();
                return;
            }
        }
        System.out.println("University not found!");
    }

    
    private static void deleteUniversity(Scanner sc) {
        System.out.print("Enter University Name to delete: ");
        String name = sc.nextLine();

        University found = null;
        for (University u : universities) {
            if (u.getUniName().equalsIgnoreCase(name)) {
                found = u;
                break;
            }
        }

        if (found == null) {
            System.out.println("University not found!");
            return;
        }

        universities.remove(found);
        saveToFile();
        System.out.println("University deleted successfully!");
    }

    private static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (University u : universities) {
                bw.write(u.uniName + "," + u.location);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fsc = new Scanner(file)) {
            while (fsc.hasNextLine()) {
                String[] data = fsc.nextLine().split(",");
                if (data.length == 2) {
                    universities.add(new University(data[0], data[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
