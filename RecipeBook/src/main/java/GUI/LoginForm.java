package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm {
    private JButton loginButton;
    private JPanel rootPanel;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JButton registrationButton;
    private JPanel buttonPanel;
    private JLabel welcomeLable;
    private JLabel loginLable;
    private JLabel passwordLable;


    public LoginForm(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(600, 400);

        welcomeLable.setText("Welcome to Recipe Book");
        loginLable.setText("Please, insert login");
        passwordLable.setText("Please, insert password");
        loginButton.setText("Login");
        registrationButton.setText("Registration");
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ActionListener registrationListener = e -> {
            new RegistrationForm(minDimension, frame);
            frame.setVisible(false);
        };
        registrationButton.addActionListener(registrationListener);
    }
}