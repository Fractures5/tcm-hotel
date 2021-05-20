/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import tcm.hotel.FileInputOutput;
import tcm.hotel.Guest;
import tcm.hotel.GuestForm;
import tcm.hotel.GuestGUI;

/**
 *
 * @author Anuk
 */
public class GuestView extends JFrame{
    
    private GuestForm form;
    
    private JPanel headerPanel;
    private JPanel centrePanel;
    private JPanel paymentHeaderPanel;
    private JPanel buttonPanel;
    
    private JButton confirmDetails;
    private JButton resetDetails;
    
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
    
    private String inputFirstName;
    private String inputLastName;
    private int inputGuestAge;
    private long inputPhoneNumber;
    private String inputEmail;
    private String inputAccountNumber;
    private String inputAccountPin;
    
    private boolean validFName = false;
    private boolean validLName = false;
    private boolean validAge = false;
    private boolean validPhoneNumber = false;
    private boolean validEmail = false;
    private boolean validAccountNumber = false;
    private boolean validGuest = false;

    private boolean showFNameError = false;
    private boolean showLNameError = false;
    private boolean showAgeError = false;
    private boolean showPhoneNumberError = false;
    private boolean showEmailAddressError = false;
    private boolean showAccNumberError = false;
    
    private int resetReply;
    
    public boolean getValidGuest() {
        return validGuest;
    }

    public boolean getShowFNameError() {
        return showFNameError;
    }

    public boolean getShowLNameError() {
        return showLNameError;
    }

    public boolean getShowAgeError() {
        return showAgeError;
    }

    public boolean getShowPhoneNumberError() {
        return showPhoneNumberError;
    }
    
    public boolean getShowEmailAddressError() {
        return showEmailAddressError;
    }

    public boolean getShowAccNumberError() {
        return showAccNumberError;
    }
    
    public String getInputFirstName() {
        return inputFirstName;
    }

    public String getInputLastName() {
        return inputLastName;
    }

    public int getInputGuestAge() {
        return inputGuestAge;
    }

    public long getInputPhoneNumber() {
        return inputPhoneNumber;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public String getInputAccountNum() {
        return inputAccountNumber;
    }

    public String getInputAccountPin() {
        return inputAccountPin;
    }

    public String getfNameField() {
        return fNameField.getText();
    }

    public String getlNameField() {
        return lNameField.getText();
    }

    public int getAgeField() {
        return Integer.parseInt(ageField.getText());
    }

    public long getPhoneNumField() {
        return Long.parseLong(phoneNumField.getText());
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getAccNumField() {
        return accNumField.getText();
    }

    public String getAccPinField() {
        //String accountPin;
        //accountPin = (new String(this.accPinField.getPassword()));
        //return accountPin;
        return new String(this.accPinField.getPassword());
    }

    public JButton getConfirmDetails() {
        return confirmDetails;
    }

    public JButton getResetDetails() {
        return resetDetails;
    }
    
    public GuestView(){
        
        this.setBounds(700, 100, 600, 900);
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
        phoneNumField = new JTextField("", 50);
        phoneNumField.setBounds(300, 205, 150, 30);
        
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
        
        resetDetails = new JButton("Reset " + "\u2190");
        resetDetails.setPreferredSize(new Dimension(170, 70));
        resetDetails.setFont(new Font("Arial", Font.BOLD, 17));
        resetDetails.setBorder(new LineBorder(Color.black, 4));
        resetDetails.setForeground(Color.black);

        buttonPanel.add(confirmDetails);
        buttonPanel.add(resetDetails);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(centrePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void DetailsConfirmation(){
        
        inputFirstName = fNameField.getText();
        inputLastName = lNameField.getText();
        inputEmail = emailField.getText();
        inputAccountNumber = accNumField.getText();
        inputAccountPin = (new String(this.accPinField.getPassword()));
        
        if(inputFirstName.matches("[A-Za-z]+")){
            validFName = true;
            showFNameError = false;
        }
        else if(!inputFirstName.matches("[A-Za-z]+")){
            validFName = false;
            showFNameError = true;
            fNameField.setText("");
        }
        
        if(inputLastName.matches("[A-Za-z]+")){
            validLName = true;
            showLNameError = false;
        }
        else if(!inputLastName.matches("[A-Za-z]+")){
            validLName = false;
            showLNameError = true;
            lNameField.setText("");
        }
        
        try {
            inputGuestAge = getAgeField();
            validAge = true;
            showAgeError = false;

        } catch (NumberFormatException o) {
            validAge = false;
            showAgeError = true;
            ageField.setText("");
        }
        try {
            inputPhoneNumber = getPhoneNumField();
            validPhoneNumber = true;
            showPhoneNumberError = false;

        } catch (NumberFormatException o) {
            validPhoneNumber = false;
            showPhoneNumberError = true;
            phoneNumField.setText("");
        }
        if (!inputEmail.contains("@") || (((!inputEmail.contains(".com")) && (!inputEmail.contains(".co.nz")) && (!inputEmail.contains(".net")) && (!inputEmail.contains(".org.nz"))))) {
            validEmail = false;
            showEmailAddressError = true;
        } else if (inputEmail.contains("@") || (((inputEmail.contains(".com")) && (inputEmail.contains(".co.nz")) && (inputEmail.contains(".net")) && (inputEmail.contains(".org.nz"))))) {
            validEmail = true;
            showEmailAddressError = false;
        }

        HashMap<String, String> guestRecords = GuestForm.readGuestRecords();

        if (guestRecords.containsKey(inputAccountNumber)) {
            validAccountNumber = false;
            showAccNumberError = true;
            accNumField.setText("");
        } else if (!guestRecords.containsKey(inputAccountNumber)) {
            validAccountNumber = true;
            showAccNumberError = false;
        }

        System.out.println(inputFirstName + " " + inputLastName + " " + inputGuestAge + " " + inputPhoneNumber + " " + inputEmail + " " + inputAccountNumber + " " + inputAccountPin + " ");
        
        if (validFName == true && validLName == true && validAge == true && validPhoneNumber == true && validEmail == true && validAccountNumber == true) {
            validGuest = true;
            System.out.println("Guest object will be created");
            
            //Guest guest = new Guest(inputFirstName, inputLastName, inputGuestAge, inputEmail, inputPhoneNumber, inputAccountNumber, inputAccountPin);
            //ArrayList<Guest> list = form.getArrayList();
            //list.add(guest);
            guestRecords.put(inputAccountNumber, inputFirstName);
            try {
                FileInputOutput.writeGuestToGuestsFile(guestRecords);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GuestView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(validFName == false || validLName == false || validAge == false || validPhoneNumber == false || validEmail == false || validAccountNumber == false ){
            validGuest = false;
            System.out.println("***Guest Object will NOT be created***");
        }
        
        
    }      
    
    public void insertGuest(){
        
        String insertQuery = "INSERT INTO 'GUEST_LIST'('GUEST_FNAME', 'GUEST_LNAME', 'GUEST_AGE', 'GUEST_PHONE', 'GUEST_EMAIL', 'GUEST_ACCNUM', 'GUEST_ACCPIN')"+" VALUES(?,?,?,?,?,?,?)";
        
        //Class.forName(JDBC_DRIVER);
    }
    
    public void DetailsReset(){
        
        int resetReply = JOptionPane.showConfirmDialog(null, "Resetting will clear information you have entered!", "Reset Details!", JOptionPane.ERROR_MESSAGE);
        if (resetReply == JOptionPane.YES_OPTION) {
            String empty = "";
            fNameField.setText(empty);
            lNameField.setText(empty);
            ageField.setText(empty);
            phoneNumField.setText(empty);
            emailField.setText(empty);
            accNumField.setText(empty);
            accPinField.setText(empty);
        } else if (resetReply == JOptionPane.NO_OPTION) {
            fNameField.setText(inputFirstName);
            lNameField.setText(inputLastName);
            //ageField.setText(Integer.toString());
            //phoneNumField.setText(inputPhoneNumber);
            emailField.setText(inputEmail);
            accNumField.setText(inputAccountNumber);
            accPinField.setText(inputAccountPin);
        }
    }
    
    public void mouseEnterConfirmDetails(){
        getConfirmDetails().setBackground(Color.LIGHT_GRAY);
    }
    
    public void mouseExitConfirmDetails(){
        getConfirmDetails().setBackground(UIManager.getColor("control"));
    }
    
    public void mouseEnterResetDetails() {
        getResetDetails().setBackground(Color.LIGHT_GRAY);
    }

    public void mouseExitResetDetails() {
        getResetDetails().setBackground(UIManager.getColor("control"));
    }
    
    public void displayFNameError(){
        JOptionPane.showMessageDialog(null, "Your First Name must only contain letters of the Alphabet!", "Invalid First Name Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayLNameError(){
        JOptionPane.showMessageDialog(null, "Your Last Name must only contain letters of the Alphabet!", "Invalid Last Name Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayAgeError(){
        JOptionPane.showMessageDialog(null, "Your Age must only contain Numbers", "Invalid Age Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayPhoneNumberError(){
        JOptionPane.showMessageDialog(null, "Your Phone Number must only contain Numbers", "Invalid Phone Number Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayEmailAddressError(){
        JOptionPane.showMessageDialog(null, "You must have a valid email address!", "Invalid Email Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayAccNumError(){
        JOptionPane.showMessageDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);
    }
}