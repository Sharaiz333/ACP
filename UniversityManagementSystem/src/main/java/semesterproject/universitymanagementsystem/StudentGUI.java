package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {
    public StudentGUI() {
        setTitle("Student Management");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));

        inputPanel.add(new JLabel("University:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("Roll No:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("Semester:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("GPA:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("CGPA:"));
        inputPanel.add(new JTextField());

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Add Student"));
        buttonPanel.add(new JButton("View Students"));
        buttonPanel.add(new JButton("Back"));

        add(buttonPanel, BorderLayout.CENTER);

        JTextArea outputArea = new JTextArea(10, 40);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        setVisible(true);
    }
}
