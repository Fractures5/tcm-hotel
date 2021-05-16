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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import project2hotelapp.FeaturesMenu;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Siddarath
 */
public class HotelFeaturesMenu extends JFrame
{
    private JLabel pageTitle, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JCheckBox spaCB, jacuzziCB, saunaCB, gymCB, noneCB;
    private JButton backButton, nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;
    
    public HotelFeaturesMenu()
    {
        ArrayList<FeaturesMenu> featuresMenu = new ArrayList<FeaturesMenu>();
        featuresMenu = FeaturesMenu.showMenu();
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        
        pageTitle = new JLabel("Rooms Menu\n");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setForeground(Color.YELLOW);
        
        instruction = new JLabel("Please tick the boxes of the feature passes you would like!");
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
        
        spaCB = new JCheckBox("Title: " +featuresMenu.get(0).getTitle() + "                                 Guest Type: " +featuresMenu.get(0).getFeatureType()+ "                       Price: $" +featuresMenu.get(0).getPrice());
        spaCB.setFont(new Font("Arial", Font.BOLD, 20));
        //spaCB.setPreferredSize(new Dimension(700, 50));
        spaCB.setBorder(blackline);
        
        jacuzziCB = new JCheckBox("Title: " +featuresMenu.get(1).getTitle() + "                            Guest Type: " +featuresMenu.get(1).getFeatureType()+ "                       Price: $" +featuresMenu.get(1).getPrice());
        jacuzziCB.setFont(new Font("Arial", Font.BOLD, 20));
        jacuzziCB.setBorder(blackline);
        
        saunaCB = new JCheckBox("Title: " +featuresMenu.get(2).getTitle() + "                               Guest Type: " +featuresMenu.get(2).getFeatureType()+ "                        Price: $" +featuresMenu.get(2).getPrice());
        saunaCB.setFont(new Font("Arial", Font.BOLD, 20)); 
        saunaCB.setBorder(blackline);
        
        gymCB = new JCheckBox("Title: " +featuresMenu.get(3).getTitle() + "                               Guest Type: " +featuresMenu.get(3).getFeatureType()+ "                         Price: $" +featuresMenu.get(3).getPrice());
        gymCB.setFont(new Font("Arial", Font.BOLD, 20));
        gymCB.setBorder(blackline);
        
        noneCB = new JCheckBox("No features                                                                                                                 ");
        noneCB.setFont(new Font("Arial", Font.BOLD, 20));
        noneCB.setBorder(blackline);
        
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(spaCB);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(jacuzziCB);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(saunaCB);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(gymCB);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(noneCB);

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
        
        this.setTitle("Guests booking extra hotel features");
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
        if (!spaCB.isSelected() && !jacuzziCB.isSelected() && !saunaCB.isSelected() && !gymCB.isSelected() && !noneCB.isSelected()) 
        {
            showErrorMessage = true;
            repeat = true;
        } 
        else if(!spaCB.isSelected() && !jacuzziCB.isSelected() && !saunaCB.isSelected() && !gymCB.isSelected() && noneCB.isSelected())
        {
            showErrorMessage = false;
            repeat = false;
        }
        else if ((spaCB.isSelected() || jacuzziCB.isSelected() || saunaCB.isSelected() || gymCB.isSelected()) && (noneCB.isSelected()))
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
       JOptionPane.showMessageDialog(new JFrame(), "Please tick upto many features passes or just 'none' by it self before moving to the stage!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE); 
    }
}
