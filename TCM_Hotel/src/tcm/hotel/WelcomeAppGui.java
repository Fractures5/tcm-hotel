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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Add A comment

/**
 *
 * @author faari
 */

public class WelcomeAppGui extends JFrame //Making a change for testing purposes
{
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;
    
    JLabel welcomeLabel;
    JLabel subWelcomeLabel;
    
    JButton buttonUpdate;
    
    public WelcomeAppGui()
    {
        //Initialize the Panels
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 500));
        
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
            
        welcomeLabel = new JLabel("Welcome to the TCM Online Booking System!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        
        subWelcomeLabel = new JLabel("Select one of the options below to proceed...");
        subWelcomeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 21));
        
        topPanel.add(welcomeLabel);
        topPanel.add(Box.createVerticalStrut(50));
        topPanel.add(subWelcomeLabel);
        this.add(topPanel, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) 
    {
        JFrame frame = new WelcomeAppGui();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocation(700, 300);
        frame.setVisible(true);
    }
}
