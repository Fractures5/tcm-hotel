/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import project2hotelapp.GuestsTypeMenu;

/**
 *
 * @author Siddarath
 */
public class HotelGuestTypesMenu extends JFrame
{
    private JLabel pageTitle, instruction, adultTitle, childTitle, infantTitle, elderlyTitle, vipTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> adultTypeBox, childTypeBox, infantTypeBox, elderlyTypeBox, vipTypeBox;
    private JButton backButton, nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;
    
    Integer[] guestCount = {0,1,2,3,4,5};
    
    public HotelGuestTypesMenu()
    {
        ArrayList<GuestsTypeMenu> guestTypeMenu = new ArrayList<GuestsTypeMenu>();
        guestTypeMenu = GuestsTypeMenu.showMenu();
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        
        pageTitle = new JLabel("Guest Types Menu");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setForeground(Color.YELLOW);
        
        instruction = new JLabel("Please choose the guest type and number of guests you would like to book!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(pageTitle);
        this.add(headerPanel, BorderLayout.NORTH);
        
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        adultTypeBox = new JComboBox(guestCount);
        adultTypeBox.setPreferredSize(new Dimension(50, 50));
        adultTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        childTypeBox = new JComboBox(guestCount);
        childTypeBox.setPreferredSize(new Dimension(50, 50));
        childTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        infantTypeBox = new JComboBox(guestCount);
        infantTypeBox.setPreferredSize(new Dimension(50, 50));
        infantTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));

        elderlyTypeBox = new JComboBox(guestCount);
        elderlyTypeBox.setPreferredSize(new Dimension(50, 50));
        elderlyTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        vipTypeBox = new JComboBox(guestCount);
        vipTypeBox.setPreferredSize(new Dimension(50, 50));
        vipTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        adultTitle = new JLabel("Title: " +guestTypeMenu.get(0).getTitle() + "            Guest Type: " +guestTypeMenu.get(0).getGuestType()+ "           Price: $" +guestTypeMenu.get(0).getPrice());
        adultTitle.setFont(new Font("Arial", Font.BOLD, 20));
        adultTitle.setBorder(blackline);
        childTitle = new JLabel("Title: " +guestTypeMenu.get(1).getTitle() + "            Guest Type: " +guestTypeMenu.get(1).getGuestType()+ "           Price: $" +guestTypeMenu.get(1).getPrice());
        childTitle.setFont(new Font("Arial", Font.BOLD, 20));
        childTitle.setBorder(blackline);
        infantTitle = new JLabel("Title: " +guestTypeMenu.get(2).getTitle() + "            Guest Type: " +guestTypeMenu.get(2).getGuestType()+ "           Price: $" +guestTypeMenu.get(2).getPrice());
        infantTitle.setFont(new Font("Arial", Font.BOLD, 20));
        infantTitle.setBorder(blackline);
        elderlyTitle = new JLabel("Title: " +guestTypeMenu.get(3).getTitle() + "            Guest Type: " +guestTypeMenu.get(3).getGuestType()+ "           Price: $" +guestTypeMenu.get(3).getPrice());
        elderlyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        elderlyTitle.setBorder(blackline);
        vipTitle = new JLabel("Title: " +guestTypeMenu.get(4).getTitle() + "            Guest Type: " +guestTypeMenu.get(4).getGuestType()+ "           Price: $" +guestTypeMenu.get(4).getPrice());
        vipTitle.setFont(new Font("Arial", Font.BOLD, 20));
        vipTitle.setBorder(blackline);
        
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(adultTitle);
        menuPanel.add(adultTypeBox);
        menuPanel.add(Box.createVerticalStrut(85));
        menuPanel.add(childTitle);
        menuPanel.add(childTypeBox);
        menuPanel.add(Box.createVerticalStrut(85));
        menuPanel.add(infantTitle);
        menuPanel.add(infantTypeBox);
        menuPanel.add(Box.createVerticalStrut(85));
        menuPanel.add(elderlyTitle);
        menuPanel.add(elderlyTypeBox);
        menuPanel.add(Box.createVerticalStrut(85));
        menuPanel.add(vipTitle);
        menuPanel.add(vipTypeBox);
        
        this.add(menuPanel, BorderLayout.CENTER);
        
        bottomPanel = new JPanel();
        backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(200,70));
        backButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking guests types");
        this.setSize(1200,700);
        this.setLocation(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public JButton getNextButton()
    {
        return nextButton;
    }
    
    public Boolean getShowErrorMesssage()
    {
        return showErrorMessage;
    }
    
    public Boolean getRepeat()
    {
        return repeat;
    }
    
    public void confirmSelection()
    {
        if (adultTypeBox.getSelectedItem().equals(0) && childTypeBox.getSelectedItem().equals(0) && infantTypeBox.getSelectedItem().equals(0)
                && elderlyTypeBox.getSelectedItem().equals(0) && vipTypeBox.getSelectedItem().equals(0)) 
        {
            showErrorMessage = true;
            repeat = true;
        } 
        else 
        {
            int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");

            if (userConfirmation == JOptionPane.YES_OPTION) 
            {
                showErrorMessage = false;
                repeat = false;
                // add code here to add the selected array list perhaps
                
            }
            else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
            {
                repeat = true;
                showErrorMessage = false;
            }

        }
    }
    
    public void displayErrorMessage()
    {
       JOptionPane.showMessageDialog(new JFrame(), "Please select the number of guests and what type of guests will be staying before moving to the next stage", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE); 
    }
    
    public void mouseEnterHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }
}
