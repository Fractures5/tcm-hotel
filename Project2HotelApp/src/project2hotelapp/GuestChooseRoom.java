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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Siddarath
 */
public class GuestChooseRoom extends JFrame{
    
    private JLabel title, instruction, standardTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> standardRoom, deluxeRoom, twinRoom, queenRoom, familyRoom, couplesRoom;
    
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
        
        standardRoom = new JComboBox(roomQuantity);
        standardRoom.setPreferredSize(new Dimension(1100, 50));
        deluxeRoom = new JComboBox(roomQuantity);
        twinRoom = new JComboBox(roomQuantity);
        queenRoom = new JComboBox(roomQuantity);
        familyRoom = new JComboBox(roomQuantity);
        couplesRoom = new JComboBox(roomQuantity);
        
        standardTitle = new JLabel("Standard Room");
        menuPanel.add(standardTitle);
        menuPanel.add(standardRoom);
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
