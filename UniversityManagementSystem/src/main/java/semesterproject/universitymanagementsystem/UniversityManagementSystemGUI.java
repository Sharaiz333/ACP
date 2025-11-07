package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniversityManagementSystemGUI extends JFrame {

    public UniversityManagementSystemGUI() {
        setTitle("University Management System");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("University Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton studentMenuButton = new JButton("Student Menu");
        JButton universityMenuButton = new JButton("University Menu");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(studentMenuButton);
        buttonPanel.add(universityMenuButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.CENTER);

        studentMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opening Student Menu...");
                new StudentGUI();
            }
        });

        universityMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opening University Menu...");
                new UniversityGUI();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UniversityManagementSystemGUI();
    }
}
