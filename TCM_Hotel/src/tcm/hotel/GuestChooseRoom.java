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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Siddarath
 */
public class GuestChooseRoom extends JFrame implements ActionListener{
    
    private JLabel title, instruction, standardTitle, deluxeTitle, twinTitle, queenTitle, familyTitle, couplesTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> standardRoomBox, deluxeRoomBox, twinRoomBox, queenRoomBox, familyRoomBox, couplesRoomBox;
    private JButton backButton, nextButton;
    
    Integer[] roomQuantity = {0,1,2,3,4,5};
    
    
    public GuestChooseRoom()
    {
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        
        title = new JLabel("Rooms Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.YELLOW);
        
        instruction = new JLabel("Please choose the rooms you would like to book!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(title);
        this.add(headerPanel, BorderLayout.NORTH);
        
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        standardRoomBox = new JComboBox(roomQuantity);
        standardRoomBox.setPreferredSize(new Dimension(50, 50));
        standardRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
 
        deluxeRoomBox = new JComboBox(roomQuantity);
        deluxeRoomBox.setPreferredSize(new Dimension(50, 50));
        deluxeRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        twinRoomBox = new JComboBox(roomQuantity);
        twinRoomBox.setPreferredSize(new Dimension(50, 50));
        twinRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        queenRoomBox = new JComboBox(roomQuantity);
        queenRoomBox.setPreferredSize(new Dimension(50, 50));
        queenRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        familyRoomBox = new JComboBox(roomQuantity);
        familyRoomBox.setPreferredSize(new Dimension(50, 50));
        familyRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        couplesRoomBox = new JComboBox(roomQuantity);
        couplesRoomBox.setPreferredSize(new Dimension(50, 50));
        couplesRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        standardTitle = new JLabel("Title: " +roomMenu.get(0).getTitle()+ "                 Room Type: " +roomMenu.get(0).getRoomType()+ "           Price: $" +roomMenu.get(0).getPrice()+ "               Rooms: ");
        standardTitle.setFont(new Font("Arial", Font.BOLD, 20));
        standardTitle.setBorder(blackline);
        deluxeTitle = new JLabel("Title: " +roomMenu.get(1).getTitle()+ "                     Room Type: " +roomMenu.get(1).getRoomType()+ "                     Price: $" +roomMenu.get(1).getPrice()+ "             Rooms: ");
        deluxeTitle.setFont(new Font("Arial", Font.BOLD, 20));
        deluxeTitle.setBorder(blackline);
        twinTitle = new JLabel("Title: " +roomMenu.get(2).getTitle()+ "                       Room Type: " +roomMenu.get(2).getRoomType()+ "                    Price: $" +roomMenu.get(2).getPrice()+ "                  Rooms: ");
        twinTitle.setFont(new Font("Arial", Font.BOLD, 20));
        twinTitle.setBorder(blackline);
        queenTitle = new JLabel("Title: " +roomMenu.get(3).getTitle()+ "                        Room Type: " +roomMenu.get(3).getRoomType()+ "                Price: $" +roomMenu.get(3).getPrice()+ "                Rooms: ");
        queenTitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        queenTitle.setBorder(blackline);
        familyTitle = new JLabel("Title: " +roomMenu.get(4).getTitle()+ "                             Room Type: " +roomMenu.get(4).getRoomType()+ "      Price: $" +roomMenu.get(4).getPrice()+ "                            Rooms: ");
        familyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        familyTitle.setBorder(blackline);
        couplesTitle = new JLabel("Title: " +roomMenu.get(5).getTitle()+ "       Room Type: " +roomMenu.get(5).getRoomType()+ "     Price: $" +roomMenu.get(5).getPrice()+ "         Rooms: ");
        couplesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        couplesTitle.setBorder(blackline);
        
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(standardTitle);
        menuPanel.add(standardRoomBox);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(deluxeTitle);
        menuPanel.add(deluxeRoomBox);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(twinTitle);
        menuPanel.add(twinRoomBox);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(queenTitle);
        menuPanel.add(queenRoomBox);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(familyTitle);
        menuPanel.add(familyRoomBox);
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(couplesTitle);
        menuPanel.add(couplesRoomBox);
        
        this.add(menuPanel, BorderLayout.CENTER);
        
        bottomPanel = new JPanel();
        backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(200,70));
        backButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        nextButton.addActionListener(this);
        
        
        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking rooms");
        this.setSize(1200,700);
        this.setLocation(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
           {
               if(standardRoomBox.getSelectedItem().equals(0) && deluxeRoomBox.getSelectedItem().equals(0) && twinRoomBox.getSelectedItem().equals(0)
                       && queenRoomBox.getSelectedItem().equals(0) && couplesRoomBox.getSelectedItem().equals(0))
               {
                   JOptionPane.showMessageDialog(new JFrame(), "Please select the rooms you would like to book before moving to the next stage", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                   int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");
                   
                   if(userConfirmation == JOptionPane.YES_OPTION)
                   {
                      // add code here to add the selected array list perhaps 
                       //add code here to add to cart or table etc
                   }
                   else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
                   {
                      
                   }
 
               }
               
           }
    
}
