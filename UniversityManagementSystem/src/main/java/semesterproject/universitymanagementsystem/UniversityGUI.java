package semesterproject.universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniversityGUI extends JFrame {

    private JTextField nameField, locationField;
    private JTextArea outputArea;

    public UniversityGUI() {
        setTitle("University Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        inputPanel.add(new JLabel("University Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        inputPanel.add(locationField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add University");
        JButton viewButton = new JButton("View Universities");
        JButton backButton = new JButton("Back");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String location = locationField.getText();

                outputArea.append("University Added:\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Location: " + location + "\n");
                outputArea.append("--------------------------\n");

                JOptionPane.showMessageDialog(null, "University added successfully!");

                nameField.setText("");
                locationField.setText("");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Displaying all universities (demo only).");
                outputArea.append("Viewing all universities... (In future, fetch from file or list)\n");
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
