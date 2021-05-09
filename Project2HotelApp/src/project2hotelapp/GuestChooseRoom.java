/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Siddarath
 */
public class GuestChooseRoom extends JFrame{
    
    private JLabel title, instruction, standardTitle, deluxeTitle, twinTitle, queenTitle, familyTitle, couplesTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> standardRoomBox, deluxeRoomBox, twinRoomBox, queenRoomBox, familyRoomBox, couplesRoomBox;
    
    Integer[] roomQuantity = {0,1,2,3,4,5};
    
    
    public GuestChooseRoom()
    {
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));*/
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1); 
        
        title = new JLabel("Hotel Locations Menu\n");
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
        twinTitle = new JLabel("Title: " +roomMenu.get(2).getTitle()+ "                       Room Type: " +roomMenu.get(2).getRoomType()+ "                    Price: $" +roomMenu.get(2).getPrice()+ "                  Rooms: ");
        twinTitle.setFont(new Font("Arial", Font.BOLD, 20));
        queenTitle = new JLabel("Title: " +roomMenu.get(3).getTitle()+ "                        Room Type: " +roomMenu.get(3).getRoomType()+ "                Price: $" +roomMenu.get(3).getPrice()+ "                Rooms: ");
        queenTitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        familyTitle = new JLabel("Title: " +roomMenu.get(4).getTitle()+ "                             Room Type: " +roomMenu.get(4).getRoomType()+ "      Price: $" +roomMenu.get(4).getPrice()+ "                            Rooms: ");
        familyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        couplesTitle = new JLabel("Title: " +roomMenu.get(5).getTitle()+ "       Room Type: " +roomMenu.get(5).getRoomType()+ "     Price: $" +roomMenu.get(5).getPrice()+ "         Rooms: ");
        couplesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        
        menuPanel.add(standardTitle);
        menuPanel.add(standardRoomBox);
        menuPanel.add(deluxeTitle);
        menuPanel.add(deluxeRoomBox);
        menuPanel.add(twinTitle);
        menuPanel.add(twinRoomBox);
        menuPanel.add(queenTitle);
        menuPanel.add(queenRoomBox);
        menuPanel.add(familyTitle);
        menuPanel.add(familyRoomBox);
        menuPanel.add(couplesTitle);
        menuPanel.add(couplesRoomBox);
        
        this.add(menuPanel, BorderLayout.CENTER);
        
        bottomPanel = new JPanel();
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking rooms");
        this.setSize(1200,700);
        this.setLocation(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
