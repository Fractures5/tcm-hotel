/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Anuk
 */
public class GuestView extends JFrame{
    
    private JPanel headerPanel;
    private JPanel centrePanel;
    private JPanel paymentHeaderPanel;
    private JPanel buttonPanel;
    
    private JLabel welcomeLabel;
    private JLabel fName;
    private JLabel lName;
    private JLabel age;
    private JLabel phoneNumber;
    private JLabel emailAddress;
    private JLabel paymentLabel;
    private JLabel accountNumber;
    private JLabel accountPin;
    
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField ageField;
    private JTextField phoneNumField;
    private JTextField emailField;
    private JTextField accNumField;
    private JPasswordField accPinField;

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getCentrePanel() {
        return centrePanel;
    }

    public JPanel getPaymentHeaderPanel() {
        return paymentHeaderPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public JLabel getfName() {
        return fName;
    }

    public JLabel getlName() {
        return lName;
    }

    public JLabel getAge() {
        return age;
    }

    public JLabel getPhoneNumber() {
        return phoneNumber;
    }

    public JLabel getEmailAddress() {
        return emailAddress;
    }

    public JLabel getPaymentLabel() {
        return paymentLabel;
    }

    public JLabel getAccountNumber() {
        return accountNumber;
    }

    public JLabel getAccountPin() {
        return accountPin;
    }

    public JTextField getfNameField() {
        return fNameField;
    }

    public JTextField getlNameField() {
        return lNameField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getPhoneNumField() {
        return phoneNumField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getAccNumField() {
        return accNumField;
    }

    public JPasswordField getAccPinField() {
        return accPinField;
    }

    public JButton getConfirmDetails() {
        return confirmDetails;
    }

    public JButton getResetDetails() {
        return resetDetails;
    }
    
    
    private JButton confirmDetails;
    private JButton resetDetails;
    
    public GuestView(){
        
        this.setBounds(800, 200, 600, 900);
        this.setTitle("Guest Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        headerPanel = new JPanel();
        headerPanel.add(Box.createVerticalStrut(100));
        headerPanel.setBackground(Color.blue);
        welcomeLabel = new JLabel("Personal Details");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(welcomeLabel);
        
        centrePanel = new JPanel(null);
        
        fName = new JLabel("First Name: ");
        fName.setBounds(200, 25, 150, 30);
        fName.setFont(new Font("Arial", Font.BOLD, 17));
        fNameField = new JTextField("", 30);
        fNameField.setBounds(300, 25, 200, 30);
        
        lName = new JLabel("Last Name: ");
        lName.setBounds(200, 85, 150, 30);
        lName.setFont(new Font("Arial", Font.BOLD, 17));
        lNameField = new JTextField("", 30);
        lNameField.setBounds(300, 85, 200, 30);
        
        age = new JLabel("Age: ");
        age.setBounds(250, 145, 300, 30);
        age.setFont(new Font("Arial", Font.BOLD, 17));
        ageField = new JTextField("", 20);
        ageField.setBounds(300, 145, 100, 30);
        
        phoneNumber = new JLabel("Contact Phone: ");
        phoneNumber.setBounds(160, 205, 300, 30);
        phoneNumber.setFont(new Font("Arial", Font.BOLD, 17));
        phoneNumField = new JTextField("", 30);
        phoneNumField.setBounds(300, 205, 100, 30);
        
        emailAddress = new JLabel("Contact Email: ");
        emailAddress.setBounds(170, 265, 300, 30);
        emailAddress.setFont(new Font("Arial", Font.BOLD, 17));
        emailField = new JTextField("", 30);
        emailField.setBounds(300, 265, 200, 30);
        
        paymentHeaderPanel = new JPanel();
        paymentHeaderPanel.add(Box.createVerticalStrut(100));
        paymentHeaderPanel.setBackground(Color.blue);
        paymentLabel = new JLabel("Payment Details");
        paymentLabel.setForeground(Color.white);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 30));
        paymentHeaderPanel.add(paymentLabel);
        paymentHeaderPanel.setBounds(0, 355, 600, 100);
        
        accountNumber = new JLabel("Bank Account Number: ");
        accountNumber.setBounds(100, 475, 200, 100);
        accountNumber.setFont(new Font("Arial", Font.BOLD, 17));
        accNumField = new JTextField("", 30);
        accNumField.setBounds(300, 515, 200, 30);

        accountPin = new JLabel("Bank Account Pin: ");
        accountPin.setBounds(100, 535, 200, 100);
        accountPin.setFont(new Font("Arial", Font.BOLD, 17));
        accPinField = new JPasswordField("", 30);
        accPinField.setBounds(300, 565, 200, 30);
        
        centrePanel.add(fName);
        centrePanel.add(fNameField);
        centrePanel.add(lName);
        centrePanel.add(lNameField);
        centrePanel.add(age);
        centrePanel.add(ageField);
        centrePanel.add(phoneNumber);
        centrePanel.add(phoneNumField);
        centrePanel.add(emailAddress);
        centrePanel.add(emailField);
        centrePanel.add(paymentHeaderPanel);
        centrePanel.add(accountNumber);
        centrePanel.add(accNumField);
        centrePanel.add(accountPin);
        centrePanel.add(accPinField);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setBounds(0, 275, 600, 700);
        
        confirmDetails = new JButton("Confirm Details " + "\u2192");
        confirmDetails.setPreferredSize(new Dimension(170, 70));
        confirmDetails.setFont(new Font("Arial", Font.BOLD, 17));
        confirmDetails.setBorder(new LineBorder(Color.black, 4));
        confirmDetails.setForeground(Color.black);
        confirmDetails.addActionListener(GuestController controller);
        
        Color DefaultColour = confirmDetails.getBackground();
    }
    
}
