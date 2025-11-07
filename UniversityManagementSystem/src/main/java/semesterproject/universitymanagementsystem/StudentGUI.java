package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI extends JFrame {

    private JTextField universityField, departmentField, nameField, rollField, semesterField, gpaField, cgpaField;
    private JTextArea outputArea;

    public StudentGUI() {
        setTitle("Student Management");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));

        inputPanel.add(new JLabel("University:"));
        universityField = new JTextField();
        inputPanel.add(universityField);

        inputPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        inputPanel.add(departmentField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Roll No:"));
        rollField = new JTextField();
        inputPanel.add(rollField);

        inputPanel.add(new JLabel("Semester:"));
        semesterField = new JTextField();
        inputPanel.add(semesterField);

        inputPanel.add(new JLabel("GPA:"));
        gpaField = new JTextField();
        inputPanel.add(gpaField);

        inputPanel.add(new JLabel("CGPA:"));
        cgpaField = new JTextField();
        inputPanel.add(cgpaField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton backButton = new JButton("Back");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(10, 40);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                String university = universityField.getText();
                String department = departmentField.getText();
                String name = nameField.getText();
                String roll = rollField.getText();
                String semester = semesterField.getText();
                String gpa = gpaField.getText();
                String cgpa = cgpaField.getText();

                outputArea.append("Student Added:\n");
                outputArea.append("University: " + university + "\n");
                outputArea.append("Department: " + department + "\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Roll No: " + roll + "\n");
                outputArea.append("Semester: " + semester + "\n");
                outputArea.append("GPA: " + gpa + " | CGPA: " + cgpa + "\n");
                outputArea.append("--------------------------------------\n");

                JOptionPane.showMessageDialog(null, "Student added successfully!");

                universityField.setText("");
                departmentField.setText("");
                nameField.setText("");
                rollField.setText("");
                semesterField.setText("");
                gpaField.setText("");
                cgpaField.setText("");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Displaying all students (demo only).");
                outputArea.append("Viewing all students... (In future, fetch from file or list)\n");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
