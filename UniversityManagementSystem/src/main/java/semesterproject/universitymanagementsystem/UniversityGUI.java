package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;

public class UniversityGUI extends JFrame {
    public UniversityGUI() {
        setTitle("University Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        inputPanel.add(new JLabel("University Name:"));
        inputPanel.add(new JTextField());

        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(new JTextField());

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Add University"));
        buttonPanel.add(new JButton("View Universities"));
        buttonPanel.add(new JButton("Back"));

        add(buttonPanel, BorderLayout.CENTER);

        JTextArea outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        setVisible(true);
    }
}
