

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }

    public MainApp() {
        new RegistrationWindow();
    }
}

// Registration Window
class RegistrationWindow extends JFrame {
    private JTextField nameField, emailField;

    public RegistrationWindow() {
        setTitle("IQchecker");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Setting background color and font color
        getContentPane().setBackground(new Color(0x2E3440)); // Dark background

        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setForeground(new Color(0xD8DEE9)); // Light text color
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBackground(new Color(0x4C566A)); // Darker input field background
        nameField.setForeground(Color.WHITE); // White text
        gbc.gridx = 1;
        add(nameField, gbc);

        JLabel emailLabel = new JLabel("Enter Age:");
        emailLabel.setForeground(new Color(0xD8DEE9));
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setBackground(new Color(0x4C566A));
        emailField.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(emailField, gbc);

        // Register Button
        JButton registerButton = new JButton("Start Quiz");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setBackground(new Color(0x5E81AC)); // Soft blue color
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(e -> registerUser());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        registerButton.setPreferredSize(new Dimension(150, 40));
        add(registerButton, gbc);

        setVisible(true);
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            new QuizWindow(name);  // Open the quiz window
            dispose();  // Close the registration window
        }
    }
}
