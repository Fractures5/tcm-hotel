/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anuk
 */
public class AdminView extends JFrame {

    private JPanel adminHeader;
    private JPanel centrePanel;
    private JPanel buttonPanel;

    private JButton proceedToLogin;
    private JButton resetAdminDetails;

    public JButton getProceedToLogin() {
        return proceedToLogin;
    }

    public JButton getResetAdminDetails() {
        return resetAdminDetails;
    }

    private JLabel welcomeLabel;
    private JLabel fName;
    private JLabel lName;
    private JLabel staffTitle;
    private JLabel phoneNumber;
    private JLabel emailAddress;

    private JLabel adminInputPassword;

    private JTextField adminFNameField;
    private JTextField adminLNameField;
    private JTextField adminTitleField;
    private JTextField adminPhoneNumField;
    private JTextField adminEmailField;
    private JTextField adminAccNumField;
    private JPasswordField accPinField;

    public AdminView() {
        this.setBounds(700, 100, 600, 900);
        this.setTitle("Admin Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        adminHeader = new JPanel();
        adminHeader.add(Box.createVerticalStrut(100));
        adminHeader.setBackground(Color.blue);
        welcomeLabel = new JLabel("Administration Staff Form");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        adminHeader.add(welcomeLabel);

        fName = new JLabel("First Name: ");
        fName.setBounds(200, 25, 150, 30);
        fName.setFont(new Font("Arial", Font.BOLD, 17));
        adminFNameField = new JTextField("", 30);
        adminFNameField.setBounds(300, 25, 200, 30);

        centrePanel = new JPanel();
        centrePanel.add(fName);
        centrePanel.add(adminFNameField);

        this.add(centrePanel, BorderLayout.CENTER);
        this.add(adminHeader, BorderLayout.NORTH);
    }
}
