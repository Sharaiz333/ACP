package semesterproject.universitymanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Department {
    private String studentName;
    private int rollNo;
    private int semester;
    private float gpa;
    private float cgpa;

    private static List<Student> studentList = new ArrayList<>();

    public Student(String uniName, String deptName, String studentName, int rollNo) {
        super(uniName, deptName);
        this.studentName = studentName;
        this.rollNo = rollNo;
    }

    // ======== ENCAPSULATION (Getters & Setters) ========
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public float getGpa() { return gpa; }
    public void setGpa(float gpa) { this.gpa = gpa; }

    public float getCgpa() { return cgpa; }
    public void setCgpa(float cgpa) { this.cgpa = cgpa; }

    // ======== POLYMORPHISM (Method Overriding) ========
    @Override
    public void displayInfo() {
        System.out.println("-----------------------------------");
        System.out.println("University Name: " + getUniName());
        System.out.println("Department Name: " + getDeptName());
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Semester: " + semester);
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cgpa);
        System.out.println("-----------------------------------");
    }

    // ================= MAIN MENU =================
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== UNIVERSITY MANAGEMENT SYSTEM ====");
            System.out.println("1. Student Menu");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> studentMenu();
                case 2 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 2);
    }

    // ================= STUDENT MENU =================
    private static void studentMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== STUDENT MENU ====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> updateStudent(sc);
                case 3 -> displayAllStudents();
                case 4 -> searchStudent(sc);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // ================= MENU FUNCTIONS =================
    private static void addStudent(Scanner sc) {
        System.out.print("Enter University Name: ");
        String uniName = sc.nextLine();

        System.out.print("Enter Department Name: ");
        String deptName = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        Student s = new Student(uniName, deptName, name, roll);

        System.out.print("Enter Semester: ");
        s.setSemester(sc.nextInt());
        System.out.print("Enter GPA: ");
        s.setGpa(sc.nextFloat());
        System.out.print("Enter CGPA: ");
        s.setCgpa(sc.nextFloat());

        studentList.add(s);
        System.out.println("✅ Student added successfully!");
    }

    private static void updateStudent(Scanner sc) {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt(); sc.nextLine();
        Student found = findStudent(roll);

        if (found != null) {
            System.out.print("Enter new name: ");
            found.setStudentName(sc.nextLine());
            System.out.print("Enter new semester: ");
            found.setSemester(sc.nextInt());
            System.out.print("Enter new GPA: ");
            found.setGpa(sc.nextFloat());
            System.out.print("Enter new CGPA: ");
            found.setCgpa(sc.nextFloat());
            System.out.println("✅ Student record updated.");
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : studentList) {
            s.displayInfo();
        }
    }

    private static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        Student found = findStudent(roll);
        if (found != null) {
            System.out.println("✅ Student Found:");
            found.displayInfo();
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    private static Student findStudent(int roll) {
        for (Student s : studentList) {
            if (s.getRollNo() == roll)
                return s;
        }
        return null;
    }
}