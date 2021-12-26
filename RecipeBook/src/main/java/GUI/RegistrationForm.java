package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JPanel rootPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton registrationButton;
    private JLabel registrationLable;
    private JLabel loginLable;
    private JLabel passwordLable;

    public RegistrationForm(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(600, 400);

        registrationLable.setText("Register for create a new account");
        loginLable.setText("Please, insert login");
        passwordLable.setText("Please, insert password");
        backButton.setText("Back");
        registrationButton.setText("Registration");
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(parent);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ActionListener backListener = e -> {
            new LoginForm(minDimension, frame);
            frame.setVisible(false);
        };
        backButton.addActionListener(backListener);
    }
}
