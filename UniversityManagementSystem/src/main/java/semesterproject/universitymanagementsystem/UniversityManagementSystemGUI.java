package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;

public class UniversityManagementSystemGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenuGUI());
    }
}

class MainMenuGUI extends JFrame {
    public MainMenuGUI() {
        setTitle("University Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("University Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new FlowLayout());
        JButton studentBtn = new JButton("Student Menu");
        JButton universityBtn = new JButton("University Menu");
        JButton exitBtn = new JButton("Exit");

        panel.add(studentBtn);
        panel.add(universityBtn);
        panel.add(exitBtn);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
