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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;
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
//import static tcm.hotel.GuestForm.readGuestRecords;

/**
 *
 * @author Anuk
 */
public class GuestGUI extends JFrame implements ActionListener{
    
    JFrame formFrame;
    
    JPanel headerPanel;
    JLabel welcomeLabel;
    
    //JPanel formPanel;
    
    //JPanel fNamePanel;
    JLabel fName;
    JTextField fNameField;
    
    //JPanel lNamePanel;
    JLabel lName;
    JTextField lNameField;
    
    //JPanel agePanel;
    JLabel age;
    JTextField ageField;
    
    //JPanel phoneNumPanel;
    JLabel phoneNumber;
    JTextField phoneNumField;
    
    JPanel emailPanel;
    JLabel emailAddress;
    JTextField emailField;
    
    JPanel paymentHeaderPanel;
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
    
    JPanel centrePanel;
    
    private GuestForm guestForm;
    
    public GuestGUI(){
        guestForm = new GuestForm();
        formFrame = new JFrame();
        formFrame.setBounds(800,200,600,900);
        formFrame.setTitle("Guest Form");
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        confirmDetails.addActionListener(this);
        
        Color DefaultColour = confirmDetails.getBackground();
        
        confirmDetails.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent arg0){
                confirmDetails.setBackground(Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent arg0){
                confirmDetails.setBackground(DefaultColour);
        }
        
        });
        
        resetDetails = new JButton("Reset " + "\u2190");
        resetDetails.setPreferredSize(new Dimension(170, 70));
        resetDetails.setFont(new Font("Arial", Font.BOLD, 17));
        resetDetails.setBorder(new LineBorder(Color.black, 4));
        resetDetails.setForeground(Color.black);
        resetDetails.addActionListener(this);
        
        resetDetails.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent arg0){
                resetDetails.setBackground(Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent arg0){
                resetDetails.setBackground(DefaultColour);
        }
        
        });
        
        buttonPanel.add(confirmDetails);
        buttonPanel.add(resetDetails);
        
        formFrame.add(headerPanel, BorderLayout.NORTH);
        formFrame.add(centrePanel, BorderLayout.CENTER);
        formFrame.add(buttonPanel, BorderLayout.SOUTH);
        formFrame.setVisible(true);
        
        /*headerPanel = new JPanel();
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
        formFrame.add(buttonPanel, BorderLayout.SOUTH);*/
        
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
        //guestAge = Integer.parseInt(ageField.getText());
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
            
            HashMap<String, String> guestRecords = GuestForm.readGuestRecords();
            
            if(guestRecords.containsKey(inputAccountNumber)){
                JOptionPane.showMessageDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);
                validAccountNumber = false;
            }
            else if(!guestRecords.containsKey(inputAccountNumber)){
                validAccountNumber = true;
            }
            
            System.out.println(inputFirstName + " " + inputLastName + " "+ guestAge + " " /*inputPhoneNumber*/ + " " + inputEmail + " " + inputAccountNumber + " " + inputAccountPin + " ");
            if(validAge == true && validEmail == true && validAccountNumber == true){
                System.out.println("guest object will be created");
                //Guest guest = new Guest(inputFirstName, inputLastName, guestAge, inputEmail, /*inputPhoneNumber*/ inputAccountNumber, inputAccountPin);
                //ArrayList<Guest> list = guestForm.getArrayList();
                //list.add(guest);
                guestRecords.put(inputAccountNumber, inputFirstName);
                try {
                    FileInputOutput.writeGuestToGuestsFile(guestRecords);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GuestGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                //FileInputOutput.printGuestDetails(list);   
            }
            
            //JOptionPane.showConfirmDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        if (e.getSource() == resetDetails){         
            int reply = JOptionPane.showConfirmDialog(null, "Resetting will clear information you have entered!", "Reset Details!", JOptionPane.ERROR_MESSAGE);
            if (reply == JOptionPane.YES_OPTION){
                String empty = "";
                fNameField.setText(empty);
                lNameField.setText(empty);
                //ageField.setText(empty);
                phoneNumField.setText(empty);
                emailField.setText(empty);
                accNumField.setText(empty);
                accPinField.setText(empty);
            }
            else if(reply == JOptionPane.NO_OPTION){
                fNameField.setText(inputFirstName);
                lNameField.setText(inputLastName);
                //ageField.setText(Integer.toString(guestAge));
                //phoneNumField.setText(inputPhoneNumber);
                emailField.setText(inputEmail);
                accNumField.setText(inputAccountNumber);
                accPinField.setText(inputAccountPin);
            }
            
        }
    }
    
    public static void main(String[] args) throws SQLException{
        
        new GuestGUI();
    }
}
