package HotelGuiView;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.ImageIcon;
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
    private JPanel topPanel;
    private JPanel middlePanel;

    private JLabel welcomeLabel;
    private JLabel subWelcomeLabel;
    
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    
    private ImageIcon icon1;
    private ImageIcon icon2;
    private ImageIcon icon3;
    private ImageIcon icon4;
    
    private JLabel icon1Label;
    private JLabel icon2Label;
    private JLabel icon3Label;
    private JLabel icon4Label;
    
    private ImageIcon slideshow[];
    private JLabel images;
    private JButton prev, next;
    private int i;
    
    
    public WelcomeAppGuiView()
    {   
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth/2;
        int frameHeight = screenHeight/2;
        
        this.setSize(frameWidth, frameHeight+160);
        this.setResizable(false);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        
        this.setTitle("TCM Hotel Online Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel = new JPanel();
        topPanel.add(Box.createVerticalStrut(120));
        topPanel.setBackground(Color.blue);
        welcomeLabel = new JLabel("TCM Hotel Online Booking System");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        middlePanel = new JPanel(null);
        
        subWelcomeLabel = new JLabel("Please choose one of the options below to continue...");
        subWelcomeLabel.setForeground(Color.black);
        subWelcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        subWelcomeLabel.setBounds(225, 25, 600, 30);
        
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

        prev = new JButton("<<");
        next = new JButton(">>");
        slideshow = new ImageIcon[10];
        slideshow[0] = new ImageIcon("test/hotel1.jpg");
        slideshow[1] = new ImageIcon("test/hotel2.jpg");
        slideshow[2] = new ImageIcon("test/hotel3.jpg");
        slideshow[3] = new ImageIcon("test/hotel4.jpg");
        slideshow[4] = new ImageIcon("test/hotel5.jpg");
        slideshow[5] = new ImageIcon("test/hotel6.jpg");
        slideshow[6] = new ImageIcon("test/hotel7.jpg");
        slideshow[7] = new ImageIcon("test/hotel8.jpg");
        slideshow[8] = new ImageIcon("test/hotel9.jpg");
        slideshow[9] = new ImageIcon("test/hotel10.jpg");

        images = new JLabel("", JLabel.CENTER);
        add(images, BorderLayout.CENTER);
        images.setIcon(slideshow[0]);
        images.setBounds(350, 15, 500, 495);
        prev.setBounds(525, 450, 50, 20);
        next.setBounds(625, 450, 50, 20);

        topPanel.add(welcomeLabel);
        middlePanel.add(subWelcomeLabel);
        middlePanel.add(buttonOne);
        middlePanel.add(buttonTwo);
        middlePanel.add(buttonThree);
        middlePanel.add(buttonFour);
        middlePanel.add(images);
        middlePanel.add(prev);
        middlePanel.add(next);
        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public JButton getPrevButton()
    {
        return prev;
    }
    
    public JButton getNextButton()
    {
        return next;
    }
    
    public void PrevButtonAction()
    {
        if (i == 0) 
        {
            JOptionPane.showMessageDialog(null, "You've reached the start of the slideshow!");
        } 
        else 
        {
            i = i - 1;
            images.setIcon(slideshow[i]);
        }
    }
    
    public void NextButtonAction()
    {
        if (i == slideshow.length - 1) 
        {
            JOptionPane.showMessageDialog(null, "You've reached the end of the slideshow!");
        } 
        else 
        {
            i = i + 1;
            images.setIcon(slideshow[i]);
        }
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
    
    public void enterBookingView()
    {
        //Make call to Booking view class here
    }
    
    public void enterFAQView()
    {
        this.setVisible(false);
        this.dispose();
    }
    
    public void enterAboutUsView()
    {
        this.setVisible(false);
        this.dispose();
    }
    
    public void enterAdminView()
    {
        //Make call to Admin view class here
    }
}
