/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import HotelDataFiles.FeaturesMenu;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import HotelDataFiles.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class HotelFeaturesMenu extends JFrame
{
    private JLabel pageTitle, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JCheckBox spaCB, jacuzziCB, saunaCB, gymCB, noneCB;
    private JButton nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;
    private ArrayList<GuestsBookingCart> guestFeaturesBooked = new ArrayList<>();
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.WHITE, 10));
    
    public HotelFeaturesMenu()
    {
        ArrayList<FeaturesMenu> featuresMenu = new ArrayList<FeaturesMenu>();
        featuresMenu = FeaturesMenu.showMenu();
        
        pageTitle = new JLabel("Hotel Features Menu\n");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setForeground(Color.WHITE);
        
        instruction = new JLabel("Please tick the boxes of the feature passes you would like!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(pageTitle);
        
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        spaCB = new JCheckBox("Title: " +featuresMenu.get(0).getTitle() + "                                 Feature Type: " +featuresMenu.get(0).getFeatureType()+ "                              Price: $" +featuresMenu.get(0).getPrice());
        spaCB.setFont(new Font("Arial", Font.BOLD, 20));
        spaCB.setBorderPainted(true);
        spaCB.setBorder(blackline);
        spaCB.setBackground(Color.WHITE);
        spaCB.setOpaque(true);
        
        jacuzziCB = new JCheckBox("Title: " +featuresMenu.get(1).getTitle() + "                            Feature Type: " +featuresMenu.get(1).getFeatureType()+ "                        Price: $" +featuresMenu.get(1).getPrice());
        jacuzziCB.setFont(new Font("Arial", Font.BOLD, 20));
        jacuzziCB.setBorderPainted(true);
        jacuzziCB.setBorder(blackline);
        jacuzziCB.setBackground(Color.WHITE);
        jacuzziCB.setOpaque(true);
        
        saunaCB = new JCheckBox("Title: " +featuresMenu.get(2).getTitle() + "                             Feature Type: " +featuresMenu.get(2).getFeatureType()+ "                           Price: $" +featuresMenu.get(2).getPrice());
        saunaCB.setFont(new Font("Arial", Font.BOLD, 20)); 
        saunaCB.setBorderPainted(true);
        saunaCB.setBorder(blackline);
        saunaCB.setBackground(Color.WHITE);
        saunaCB.setOpaque(true);
        
        gymCB = new JCheckBox("Title: " +featuresMenu.get(3).getTitle() + "                                Feature Type: " +featuresMenu.get(3).getFeatureType()+ "                              Price: $" +featuresMenu.get(3).getPrice());
        gymCB.setFont(new Font("Arial", Font.BOLD, 20));
        gymCB.setBorderPainted(true);
        gymCB.setBorder(blackline);
        gymCB.setBackground(Color.WHITE);
        gymCB.setOpaque(true);
        
        noneCB = new JCheckBox("Title: No features                         Feature Type: NONE                            Price: $0");
        noneCB.setFont(new Font("Arial", Font.BOLD, 20));
        noneCB.setBorderPainted(true);
        noneCB.setBorder(blackline);
        noneCB.setBackground(Color.WHITE);
        noneCB.setOpaque(true);
        
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(spaCB);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(jacuzziCB);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(saunaCB);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(gymCB);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(noneCB);
        menuPanel.add(Box.createVerticalStrut(95)); 
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
       
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.add(nextButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking extra hotel features");
        this.setSize(frameWidth +350, frameHeight +250);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
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
    
    public ArrayList<GuestsBookingCart> getFeaturesBooked()
    {
        return guestFeaturesBooked;
    }
    
    public void confirmSelection()
    {
        if (!spaCB.isSelected() && !jacuzziCB.isSelected() && !saunaCB.isSelected() && !gymCB.isSelected() && !noneCB.isSelected()) // nothing selected
        {
            showErrorMessage = true;
            repeat = true;
        } 
        else if ((spaCB.isSelected() || jacuzziCB.isSelected() || saunaCB.isSelected() || gymCB.isSelected()) && (noneCB.isSelected())) // if a feature is selected the same time as no features
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
            }
            else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
            {
                repeat = true;
                showErrorMessage = false;
            }
        }
    }
    
    public void addUserFeatureSelection()
    {
        ArrayList<FeaturesMenu> featuresMenu = new ArrayList<FeaturesMenu>();
        featuresMenu = FeaturesMenu.showMenu();
        
        if (spaCB.isSelected())
        {
            GuestsBookingCart bookingDetails = new GuestsBookingCart(featuresMenu.get(0).getTitle(), featuresMenu.get(0).getFeatureType(), featuresMenu.get(0).getPrice());
            guestFeaturesBooked.add(bookingDetails);
        }
        
        if(jacuzziCB.isSelected())
        {
            GuestsBookingCart bookingDetails = new GuestsBookingCart(featuresMenu.get(1).getTitle(), featuresMenu.get(1).getFeatureType(), featuresMenu.get(1).getPrice());
            guestFeaturesBooked.add(bookingDetails);
        }
        
        if(saunaCB.isSelected())
        {
            GuestsBookingCart bookingDetails = new GuestsBookingCart(featuresMenu.get(2).getTitle(), featuresMenu.get(2).getFeatureType(), featuresMenu.get(2).getPrice());
            guestFeaturesBooked.add(bookingDetails);
        }
        
        if(gymCB.isSelected())
        {
            GuestsBookingCart bookingDetails = new GuestsBookingCart(featuresMenu.get(3).getTitle(), featuresMenu.get(3).getFeatureType(), featuresMenu.get(3).getPrice());
            guestFeaturesBooked.add(bookingDetails);
        }
    }
    
    public void displayErrorMessage()
    {
       JOptionPane.showMessageDialog(new JFrame(), "Please tick upto many features passes or just 'none' by it self before moving to the stage!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE); 
    }
    
    public void mouseEnterNextHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitNextHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }
}
