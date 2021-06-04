package HotelGuiView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

/**
 * This is the class which outputs the GUI frame for the FAQ section of the 
 * program, including a non-editable text area showing questions and answers
 * based on the hotel.
 * @author Faaris
 */

public class FAQGuiMenu extends JFrame
{
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    
    private JTextArea FAQField;
    private JScrollPane fieldScroller;
    
    private JButton backButton;
    
    private JLabel FAQLabel; 
    
    /**
     * This is the default constructor of the FAQ section, which initializes the
     * panels, buttons, labels, etc for the FAQ Frame. 
     */
    public FAQGuiMenu()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth, frameHeight + 160);
        this.setResizable(true);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        
        this.setTitle("FAQ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        topPanel = new JPanel();
        topPanel.add(Box.createVerticalStrut(120));
        topPanel.setBackground(Color.blue);
        
        FAQLabel = new JLabel("FAQ (Frequently Asked Questions)");
        FAQLabel.setForeground(Color.white);
        FAQLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        FAQField = new JTextArea();
        FAQField.setFont(new Font("Aria", Font.BOLD, 15));
        FAQField.append("  **************************************************************************************************************************************************************************************************\n");
        FAQField.append("   (Q): How can I make a booking for a room/s at the TCM Hotel?\n");
        FAQField.append("   (A): We here at TCM offer various booking options, including our on-site service center. The preferable and easiest\n");
        FAQField.append("          way to make a booking is through the TCM online booking system which is available 24/7.\n");
        FAQField.append("          The online booking-system prompts and requests for your desired hotel branch, number of rooms and\n");
        FAQField.append("          customers staying, room type and any special features.\n");
        
        FAQField.append("  **************************************************************************************************************************************************************************************************");
        FAQField.append("\n   (Q): Do we offer any specials/discount rates for customers?\n");
        FAQField.append("   (A): Yes, for children under the age of 11 pay $10 and any infants under the age of 2 are allowed free entry.\n");
        FAQField.append("          Elderly customers are given a discounted price of $10, and any customers who have a disability pay around $25.\n");
        FAQField.append("          Regular/Adult price is set at $30.\n");
        
        FAQField.append("  **************************************************************************************************************************************************************************************************");
        FAQField.append("\n   (Q): Are there any special features in my room booking that I can include?\n");
        FAQField.append("   (A): When you have confirmed the rooms you want and the number of people that will be accommodating,\n");
        FAQField.append("          you will be prompted to select one of the special features that every TCM hotel branch provides such as the sauna, jacuzzi, spa, tennis-court and gym.\n");

        FAQField.append("  **************************************************************************************************************************************************************************************************");
        FAQField.append("\n   (Q): Am I able to book a multiple rooms of different categories at once?\n");
        FAQField.append("   (A): Yes, the online-booking system will prompt you to enter the amount of rooms you would like to accommodate\n");
        FAQField.append("          and the type for each room. However, there is a limited amount of room types available, which will be indicated on 'Room Availability' tab when booking. \n");
        FAQField.append("  **************************************************************************************************************************************************************************************************");
        
        FAQField.setBounds(15, 15, 855, 400);
        FAQField.setEditable(false);
        
        backButton = new JButton("Return to the Main Menu");
        backButton.setPreferredSize(new Dimension(250, 70));
        backButton.setForeground(Color.black);
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBounds(300, 400, 855, 400);
        
        fieldScroller = new JScrollPane(FAQField, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        fieldScroller.setMinimumSize(new Dimension (855, 400));
        fieldScroller.setPreferredSize(new Dimension (855, 400));     
        
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        bottomPanel.add(Box.createVerticalStrut(100));
        bottomPanel.setBackground(Color.blue);
        
        topPanel.add(FAQLabel);
        middlePanel.add(fieldScroller);
        bottomPanel.add(backButton);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    /**
     * This is a getter JButton method which returns the value of the back button,
     * the same concept applies to the other getter methods.
     * @return 
     */
    public JButton getBackButton()
    {
        return backButton;
    }
    
    /**
     * This sets the hover color of the button for when the user hovers their
     * cursor over the button.
     */
    public void mouseEnterHoverBackButton() 
    {
        getBackButton().setBackground(Color.RED);
    }

    /**
     * This reverts the hover color of the bottom to the default color once the
     * user moves their cursor away from the button.
     */
    public void mouseExitHoverBackButton() 
    {
        getBackButton().setBackground(UIManager.getColor("control"));
    }
    
    /**
     * This sets the visibility of this frame to false so it closes and disposes
     * of it so it can be used later.
     */
    public void returnToMain()
    {
        this.setVisible(false);
        this.dispose();
    }
}
