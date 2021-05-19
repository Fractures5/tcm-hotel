/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiView;
import HotelGuiModel.WelcomeAppGuiModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author faaris
 */

public class WelcomeAppGuiView extends JFrame
{
    private JFrame welcomeFrame;
    
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel imagePanel;
    
    private JLabel welcomeLabel;
    private JLabel subWelcomeLabel;
    
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    
    private WelcomeAppGuiModel icon1;
    private WelcomeAppGuiModel icon2;
    private WelcomeAppGuiModel icon3;
    private WelcomeAppGuiModel icon4;
    
    public WelcomeAppGuiView()
    {
        icon1 = new WelcomeAppGuiModel();
        icon2= new WelcomeAppGuiModel();
        icon3 = new WelcomeAppGuiModel();
        icon4 = new WelcomeAppGuiModel(); 
       
        welcomeFrame = new JFrame("TCM Hotel Online Booking System");
        welcomeFrame.setBounds(500, 200, 900, 700);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel = new JPanel();
        topPanel.add(Box.createVerticalStrut(120));
        topPanel.setBackground(Color.blue);
        welcomeLabel = new JLabel("Welcome to the TCM Online Booking System!");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        middlePanel = new JPanel(null);
        //middlePanel.add(Box.createVerticalStrut(120));
        
        subWelcomeLabel = new JLabel("Please choose one of the options below to continue...");
        subWelcomeLabel.setForeground(Color.black);
        subWelcomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subWelcomeLabel.setBounds(250, 25, 500, 30);
        
        buttonOne = new JButton("1 - Make a Booking");
        buttonOne.setPreferredSize(new Dimension(250, 70));
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOne.setBorder(new LineBorder(Color.BLACK, 5));
        buttonOne.setBounds(75, 85, 250, 70);
        
        buttonTwo = new JButton("2 - FAQ Section");
        buttonTwo.setPreferredSize(new Dimension(250, 70));
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTwo.setBorder(new LineBorder(Color.BLACK, 5));
        buttonTwo.setBounds(75, 180, 250, 70);
        
        buttonThree = new JButton("3 - About Us");
        buttonThree.setPreferredSize(new Dimension(250, 70));
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        buttonThree.setBorder(new LineBorder(Color.BLACK, 5));
        buttonThree.setBounds(75, 275, 250, 70);
        
        buttonFour = new JButton("4 - Admin");
        buttonFour.setPreferredSize(new Dimension(250, 70));
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFour.setBorder(new LineBorder(Color.BLACK, 5));
        buttonFour.setBounds(75, 370, 250, 70);

        topPanel.add(welcomeLabel);
        
        middlePanel.add(subWelcomeLabel);
        middlePanel.add(buttonOne);
        middlePanel.add(buttonTwo);
        middlePanel.add(buttonThree);
        middlePanel.add(buttonFour);
        
        welcomeFrame.add(topPanel, BorderLayout.NORTH);
        welcomeFrame.add(middlePanel, BorderLayout.CENTER);
        welcomeFrame.setVisible(true);
    }
    
    public JButton getButtonOne()
    {
        return buttonOne;
    }
    
    public void mouseEnterHoverButtonOne()
    {
        getButtonOne().setBackground(Color.LIGHT_GRAY);
    }
    
    public void mouseExitHoverButtonOne()
    {
        getButtonOne().setBackground(UIManager.getColor("control"));
    }
    
    public JButton getButtonTwo() {
        return buttonTwo;
    }

    public void mouseEnterHoverButtonTwo() {
        getButtonTwo().setBackground(Color.LIGHT_GRAY);
    }

    public void mouseExitHoverButtonTwo() {
        getButtonTwo().setBackground(UIManager.getColor("control"));
    }
    
    public JButton getButtonThree() {
        return buttonThree;
    }

    public void mouseEnterHoverButtonThree() {
        getButtonThree().setBackground(Color.LIGHT_GRAY);
    }

    public void mouseExitHoverButtonThree() {
        getButtonThree().setBackground(UIManager.getColor("control"));
    }
    
    public JButton getButtonFour() {
        return buttonFour;
    }

    public void mouseEnterHoverButtonFour() {
        getButtonFour().setBackground(Color.LIGHT_GRAY);
    }

    public void mouseExitHoverButtonFour() {
        getButtonFour().setBackground(UIManager.getColor("control"));
    }    
  
    public void actionPerformed(ActionEvent e)
    {
        //When a button is pushed, open up a new frame it e.g about us...
        //Gonna have to make a call to a new class? Which creates a new frame
    }
}
