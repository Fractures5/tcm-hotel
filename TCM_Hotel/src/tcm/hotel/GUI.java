/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Anuk
 */
public class GUI {
    
    JFrame formFrame;
    
    JPanel headerPanel;
    JPanel labelPanel;
    JPanel fieldPanel;
    JPanel buttonPanel;
    
    JLabel welcomeLabel;
    JLabel fName;
    JTextField fNameField;
    JLabel lName;
    JTextField lNameField;
    JLabel age;
    JTextField ageField;
    JLabel emailAddress;
    JTextField emailField;
    JLabel phoneNumber;
    JTextField phoneNumField;
    JButton confirmDetails;
    
    public GUI(){
        
        formFrame = new JFrame();
        formFrame.setBounds(800, 200, 500, 600);
        formFrame.setTitle("Guest Form");
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        headerPanel = new JPanel();
        welcomeLabel = new JLabel("Welcome to the Guest Form!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerPanel.add(welcomeLabel);
        
        labelPanel = new JPanel();
        labelPanel.add(Box.createVerticalStrut(10));
        
        fName = new JLabel("Your First Name: ");
        fName.setBounds(1,200, 500, 600);
        lName = new JLabel("Your Last Name: ");
        lName.setBounds(1,2, 500, 600);
        age = new JLabel("Your Age: ");
        labelPanel.add(fName);
        labelPanel.add(lName);
        labelPanel.add(age);
        
        fNameField = new JTextField("", 30);
        lNameField = new JTextField("", 30);
        ageField = new JTextField("", 30);
        
        buttonPanel = new JPanel();
        confirmDetails = new JButton("Confirm Details");
        buttonPanel.add(confirmDetails);
        
        formFrame.add(headerPanel, BorderLayout.NORTH);
        formFrame.add(labelPanel, BorderLayout.WEST);
        formFrame.add(buttonPanel, BorderLayout.SOUTH);
        formFrame.setVisible(true);
        
    }
    public static void main(String[] args) {

        new GUI();

    }

}
