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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author faaris
 */

public class WelcomeAppGui extends JFrame implements ActionListener //Making a change for testing purposes
{
    private JFrame welcomeFrame;
    
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    
    private JLabel welcomeLabel;
    private JLabel subWelcomeLabel;
    
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    
    public WelcomeAppGui()
    {
        //Create the Frame
        welcomeFrame = new JFrame("TCM Hotel Online Booking System");
        welcomeFrame.setBounds(500, 500, 1200, 900);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Initialize the Panels
        topPanel = new JPanel();
        topPanel.add(Box.createVerticalStrut(120));
        topPanel.setBackground(Color.blue);
        
        middlePanel = new JPanel();
        middlePanel.add(Box.createVerticalStrut(120));
        //middlePanel.setBackground(Color.GRAY);

        //Create labels
        welcomeLabel = new JLabel("Welcome to the TCM Online Booking System!");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setBounds(450, 450, 300, 300);
        
        subWelcomeLabel = new JLabel("Please choose one of the options below to continue through the system...");
        subWelcomeLabel.setForeground(Color.white);
        subWelcomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subWelcomeLabel.setBounds(500, 500, 900, 950);
        
        //Create Buttons
        buttonOne = new JButton("1 - Make a Booking");
        buttonOne.setPreferredSize(new Dimension(250, 70));
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOne.setBorder(new LineBorder(Color.BLACK, 5));
        
        buttonTwo = new JButton("2 - FAQ Section");
        buttonTwo.setPreferredSize(new Dimension(250, 70));
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTwo.setBorder(new LineBorder(Color.BLACK, 5));
        
        buttonThree = new JButton("3 - About Us");
        buttonThree.setPreferredSize(new Dimension(250, 70));
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        buttonThree.setBorder(new LineBorder(Color.BLACK, 5));
        
        buttonFour = new JButton("4 - Admin");
        buttonFour.setPreferredSize(new Dimension(250, 70));
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFour.setBorder(new LineBorder(Color.BLACK, 5));
        
        //Add content to Panels and display on Frame
        topPanel.add(welcomeLabel);
        topPanel.add(subWelcomeLabel);
        
        middlePanel.add(buttonOne);
        middlePanel.add(buttonTwo);
        middlePanel.add(buttonThree);
        middlePanel.add(buttonFour);
        
        welcomeFrame.add(topPanel, BorderLayout.NORTH);
        welcomeFrame.add(middlePanel, BorderLayout.CENTER);
        welcomeFrame.setVisible(true);      
    }
    
    public static void main(String[] args) 
    {
       new WelcomeAppGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
