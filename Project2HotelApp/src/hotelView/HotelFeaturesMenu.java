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
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import project2hotelapp.GuestsBookingCart;

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
    private ArrayList<GuestsBookingCart> guestFeaturesBooked = new ArrayList<>();
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
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
        
        spaCB = new JCheckBox("Title: " +featuresMenu.get(0).getTitle() + "                                 Feature Type: " +featuresMenu.get(0).getFeatureType()+ "                       Price: $" +featuresMenu.get(0).getPrice());
        spaCB.setFont(new Font("Arial", Font.BOLD, 20));
        //spaCB.setPreferredSize(new Dimension(700, 50));
        spaCB.setBorder(blackline);
        
        jacuzziCB = new JCheckBox("Title: " +featuresMenu.get(1).getTitle() + "                            Feature Type: " +featuresMenu.get(1).getFeatureType()+ "                       Price: $" +featuresMenu.get(1).getPrice());
        jacuzziCB.setFont(new Font("Arial", Font.BOLD, 20));
        jacuzziCB.setBorder(blackline);
        
        saunaCB = new JCheckBox("Title: " +featuresMenu.get(2).getTitle() + "                             Feature Type: " +featuresMenu.get(2).getFeatureType()+ "                        Price: $" +featuresMenu.get(2).getPrice());
        saunaCB.setFont(new Font("Arial", Font.BOLD, 20)); 
        saunaCB.setBorder(blackline);
        
        gymCB = new JCheckBox("Title: " +featuresMenu.get(3).getTitle() + "                               Feature Type: " +featuresMenu.get(3).getFeatureType()+ "                         Price: $" +featuresMenu.get(3).getPrice());
        gymCB.setFont(new Font("Arial", Font.BOLD, 20));
        gymCB.setBorder(blackline);
        
        noneCB = new JCheckBox("Title: No features                                Feature Type: NONE                                  Price: $0");
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
        this.setSize(frameWidth +350, frameHeight +250);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
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
    
    public ArrayList<GuestsBookingCart> getFeaturesBooked()
    {
        return guestFeaturesBooked;
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
    
    public void mouseEnterHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
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
}
