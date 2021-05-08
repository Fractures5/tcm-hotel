/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import static tcm.hotel.GuestForm.readGuestRecords;

/**
 *
 * @author Anuk
 */
public class GuestGUI extends JFrame implements ActionListener{
    
    JFrame formFrame;
    
    JPanel headerPanel;
    JLabel welcomeLabel;
    
    JPanel formPanel;
    
    JPanel fNamePanel;
    JLabel fName;
    JTextField fNameField;
    
    JPanel lNamePanel;
    JLabel lName;
    JTextField lNameField;
    
    JPanel agePanel;
    JLabel age;
    JTextField ageField;
    
    JPanel phoneNumPanel;
    JLabel phoneNumber;
    JTextField phoneNumField;
    
    JPanel emailPanel;
    JLabel emailAddress;
    JTextField emailField;
    
    JPanel paymentHeader;
    JLabel paymentLabel;
    
    JPanel accNumPanel;
    JLabel accountNumber;
    JTextField accNumField;
    
    JPanel accPinPanel;
    JLabel accountPin;
    JPasswordField accPinField;
    
    JPanel buttonPanel;
    JButton confirmDetails;
    JButton resetDetails;
    
    private GuestForm guestForm;
    
    public GuestGUI(){
        guestForm = new GuestForm();
        formFrame = new JFrame();
        formFrame.setBounds(800,200,600, 750);
        formFrame.setTitle("Guest Form");
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        headerPanel = new JPanel();
        headerPanel.add(Box.createVerticalStrut(50));
        
        formPanel = new JPanel();
        
        fNamePanel = new JPanel();
        fNamePanel.setBackground(Color.LIGHT_GRAY);
        fNamePanel.add(Box.createVerticalStrut(50));
        
        lNamePanel = new JPanel();
        lNamePanel.setBackground(Color.LIGHT_GRAY);
        lNamePanel.add(Box.createVerticalStrut(50));
        
        agePanel = new JPanel();
        agePanel.setBackground(Color.LIGHT_GRAY);
        agePanel.add(Box.createVerticalStrut(50));
        
        phoneNumPanel = new JPanel();
        phoneNumPanel.setBackground(Color.LIGHT_GRAY);
        phoneNumPanel.add(Box.createVerticalStrut(50));
        
        emailPanel = new JPanel();
        emailPanel.setBackground(Color.LIGHT_GRAY);
        emailPanel.add(Box.createVerticalStrut(50));
        
        paymentHeader = new JPanel();
        paymentHeader.add(Box.createVerticalStrut(50));
        
        accNumPanel = new JPanel();
        accNumPanel.setBackground(Color.LIGHT_GRAY);
        accNumPanel.add(Box.createVerticalStrut(50));
        
        accPinPanel = new JPanel();
        accPinPanel.setBackground(Color.LIGHT_GRAY);
        accPinPanel.add(Box.createVerticalStrut(50));
        
        headerPanel.setBackground(Color.blue);
        welcomeLabel = new JLabel("Personal Details");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        fName = new JLabel("First Name: ");
        fName.setFont(new Font("Arial", Font.BOLD, 17));
        fNameField = new JTextField("", 30);
        
        lName = new JLabel("Last Name: ");
        lName.setFont(new Font("Arial", Font.BOLD, 17));
        lNameField = new JTextField("", 30);
        
        age = new JLabel("Age: ");
        age.setFont(new Font("Arial", Font.BOLD, 17));
        ageField = new JTextField("", 20);
        
        phoneNumber = new JLabel("Contact Phone: ");
        phoneNumber.setFont(new Font("Arial", Font.BOLD, 17));
        phoneNumField = new JTextField("", 30);
        
        emailAddress = new JLabel("Contact Email: ");
        emailAddress.setFont(new Font("Arial", Font.BOLD, 17));
        emailField = new JTextField("", 30);
        
        paymentHeader.setBackground(Color.blue);
        paymentHeader.setPreferredSize(new Dimension(600, 50));
        paymentLabel = new JLabel("Payment Details");
        paymentLabel.setForeground(Color.white);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        accountNumber = new JLabel("Bank Account Number: ");
        accountNumber.setFont(new Font("Arial", Font.BOLD, 17));
        accNumField = new JTextField("", 30);
        
        accountPin = new JLabel("Bank Account Pin: ");
        accountPin.setFont(new Font("Arial", Font.BOLD, 17));
        accPinField = new JPasswordField("", 30);
        
        headerPanel.add(welcomeLabel);
        
        fNamePanel.add(fName);
        fNamePanel.add(fNameField);
        fNamePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        fNamePanel.setBorder(new LineBorder(Color.black, 2));
        
        lNamePanel.add(lName);
        lNamePanel.add(lNameField);
        lNamePanel.add(Box.createRigidArea(new Dimension(0, 0)));
        lNamePanel.setBorder(new LineBorder(Color.black, 2));
        
        agePanel.add(age);
        agePanel.add(ageField);
        agePanel.add(Box.createRigidArea(new Dimension(40, 0)));
        agePanel.setBorder(new LineBorder(Color.black, 2));
        
        phoneNumPanel.add(phoneNumber);
        phoneNumPanel.add(phoneNumField);
        phoneNumPanel.setBorder(new LineBorder(Color.black, 2));
        
        emailPanel.add(emailAddress);
        emailPanel.add(emailField);
        emailPanel.setBorder(new LineBorder(Color.black, 2));
        
        paymentHeader.add(paymentLabel);
        
        accNumPanel.add(accountNumber);
        accNumPanel.add(accNumField);
        accNumPanel.setBorder(new LineBorder(Color.black, 2));
        
        accPinPanel.add(accountPin);
        accPinPanel.add(accPinField);
        accPinPanel.setBorder(new LineBorder(Color.black, 2));
        accPinPanel.setPreferredSize(new Dimension(550, 75));
        
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 75));
        buttonPanel.setBackground(Color.blue);
        
        confirmDetails = new JButton("Confirm Details " + "\u2192");
        confirmDetails.setFont(new Font("Arial", Font.BOLD, 17));
        confirmDetails.setPreferredSize(new Dimension(200, 50));
        confirmDetails.setBorder(new LineBorder(Color.black, 4));
        confirmDetails.setForeground(Color.black);
        confirmDetails.addActionListener(this);
        
        resetDetails = new JButton("Reset " + "\u2190");
        resetDetails.setFont(new Font("Arial", Font.BOLD, 17));
        resetDetails.setPreferredSize(new Dimension(150, 50));
        resetDetails.setBorder(new LineBorder(Color.black, 4));
        resetDetails.setForeground(Color.black);
        resetDetails.addActionListener(this);
        
        buttonPanel.add(confirmDetails);
        buttonPanel.add(resetDetails);
        
        formPanel.add(fNamePanel);
        formPanel.add(lNamePanel);
        formPanel.add(agePanel);
        formPanel.add(phoneNumPanel);
        formPanel.add(emailPanel);
        formPanel.add(paymentHeader);
        formPanel.add(accNumPanel);
        formPanel.add(accPinPanel);

        formFrame.add(headerPanel, BorderLayout.NORTH);
        formFrame.add(formPanel, BorderLayout.CENTER);
        formFrame.add(buttonPanel, BorderLayout.SOUTH);
        formFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        String inputFirstName;
        String inputLastName;
        int guestAge = 0;
        String inputPhoneNumber;
        String inputEmail;
        String inputAccountNumber;
        String inputAccountPin;
        boolean validAge = false;
        boolean validEmail = false;
        boolean validAccountNumber = false;
        
        inputFirstName = fNameField.getText();
        inputLastName = lNameField.getText();
        inputPhoneNumber = phoneNumField.getText();
        inputEmail = emailField.getText();
        inputAccountNumber = accNumField.getText();
        inputAccountPin = (new String(this.accPinField.getPassword()));
        
        if (e.getSource() == confirmDetails){
            try{
                guestAge = Integer.parseInt(ageField.getText());
                validAge = true;
                
            }
            catch (NumberFormatException o){
                JOptionPane.showMessageDialog(null, "Your Age must only contain Numbers", "Invalid Age Error!", JOptionPane.ERROR_MESSAGE);
                validAge = false;
            }
            if (!inputEmail.contains("@") || (((!inputEmail.contains(".com")) && (!inputEmail.contains(".co.nz")) && (!inputEmail.contains(".net")) && (!inputEmail.contains(".org.nz"))))) {
                validEmail = false;
                JOptionPane.showMessageDialog(null, "You must have a valid email address!", "Invalid Email Error!", JOptionPane.ERROR_MESSAGE);
            }
            else if (inputEmail.contains("@") || (((inputEmail.contains(".com")) && (inputEmail.contains(".co.nz")) && (inputEmail.contains(".net")) && (inputEmail.contains(".org.nz"))))) {
                validEmail = true;
            }
            
            HashMap<String, String> guestRecords = readGuestRecords();
            
            if(guestRecords.containsKey(inputAccountNumber)){
                JOptionPane.showMessageDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);
                validAccountNumber = false;
            }
            else if(!guestRecords.containsKey(inputAccountNumber)){
                validAccountNumber = true;
            }
            
            System.out.println(inputFirstName + " " + inputLastName + " "+ guestAge + " " + inputPhoneNumber + " " + inputEmail + " " + inputAccountNumber + " " + inputAccountPin + " ");
            if(validAge == true && validEmail == true && validAccountNumber == true){
                System.out.println("guest object will be created");
                Guest guest = new Guest(inputFirstName, inputLastName, guestAge, inputEmail, inputPhoneNumber, inputAccountNumber, inputAccountPin);
                ArrayList<Guest> list = guestForm.getArrayList();
                list.add(guest);
                guestRecords.put(inputAccountNumber, inputFirstName);
                try {
                    FileInputOutput.writeGuestToGuestsFile(guestRecords);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GuestGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileInputOutput.printGuestDetails(list);   
            }
            
            //JOptionPane.showConfirmDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);

            
        }
        /*if (e.getSource() == confirmDetails){
            String get = emailField.getText().toString();
            char atSymbol = '@';
            String domain1 = ".com";
            String name = "";
            int count = 0;
            for(int i =0; i <get.length(); i++){
                if((get.charAt(i)==atSymbol) || (get.contains(domain1))){
                    count++;
                    name = "this is a valid email";
                    if(count>=2){
                        emailField.setText("");
                        name = "This isnt an email";
                    }
                }
                else{
                    name = "not valid";
                }
            }
            System.out.println(name);
        }*/
        if (e.getSource() == resetDetails){         
            int reply = JOptionPane.showConfirmDialog(null, "Resetting will clear information you have entered!", "Reset Details!", JOptionPane.ERROR_MESSAGE);
            if (reply == JOptionPane.YES_OPTION){
                String empty = "";
                fNameField.setText(empty);
                lNameField.setText(empty);
                ageField.setText(empty);
                phoneNumField.setText(empty);
                emailField.setText(empty);
                accNumField.setText(empty);
                accPinField.setText(empty);
            }
            else if(reply == JOptionPane.NO_OPTION){
                fNameField.setText(inputFirstName);
                lNameField.setText(inputLastName);
                //ageField.setText(empty);
                phoneNumField.setText(inputPhoneNumber);
                emailField.setText(inputEmail);
                accNumField.setText(inputAccountNumber);
                accPinField.setText(inputAccountPin);
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        new GuestGUI();
        
    }
}
