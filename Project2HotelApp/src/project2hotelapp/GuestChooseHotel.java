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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Siddarath
 */
public class GuestChooseHotel extends JFrame {
    
    private static GuestChooseRoom bookRooms;
    private JLabel title, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private ButtonGroup group; 
    private JRadioButton[] locationButtons = new JRadioButton[8];
    private JButton backButton, nextButton;
    
    public GuestChooseHotel()
    {
        ArrayList<LocationMenu> locationsMenu = new ArrayList<LocationMenu>();
        locationsMenu = LocationMenu.showMenu();
        
        title = new JLabel("Hotel Locations Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.YELLOW);
        
        instruction = new JLabel("Please tick the hotel location you would like to book at!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700,70));
        headerPanel.add(title);
        this.add(headerPanel, BorderLayout.NORTH);
        
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setPreferredSize(new Dimension(600,450));
        menuPanel.add(instruction);
        group = new ButtonGroup();
        
        //String hello = "hi"
        /*addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(0).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(0).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(0).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(0).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(1).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(1).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(1).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(1).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(2).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(2).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(2).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(2).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(3).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(3).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(3).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(3).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(4).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(4).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(4).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(4).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(5).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(5).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(5).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(5).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(6).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(6).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(6).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(6).getVacancyType()));
        
        addHotelLocationBtn(String.format("%-40s", "Title: " +locationsMenu.get(7).getTitle())+ String.format("%-30s", "Location: " +locationsMenu.get(7).getLocationType())+
                String.format("%-20s", "Rating: " +locationsMenu.get(7).getRatingType()) + String.format("%-20s", "Vacancy: " +locationsMenu.get(7).getVacancyType()));*/
        
        locationButtons [0] = new JRadioButton("Title: Auckland Hotel - 31 Starcent Ave                          Location: Auckland                       Rating: Five      Vacancy: Yes");
        locationButtons [1] = new JRadioButton("Title: Rotorua Hotel - 17 Geyser Crescent                      Location: Rotorua                        Rating: Three     Vacancy: Yes");
        locationButtons [2] = new JRadioButton("Title: Taupo Hotel - 48 Lake Ave                                       Location: Taupo                           Rating: Four       Vacancy: No");
        locationButtons [3] = new JRadioButton("Title: Palmerston Hotel - 69 Leggy Ave                            Location: Palmerston Hotel        Rating: Four       Vacancy: Yes");
        locationButtons [4] = new JRadioButton("Title: Wellington Hotel - 128 Bee Ave                               Location: Wellington                   Rating: Five        Vacancy: No");
        locationButtons [5] = new JRadioButton("Title: Christchurch Hotel - 27 Meadow Lane                    Location: Christchurch               Rating: Four        Vacancy: Yes");
        locationButtons [6] = new JRadioButton("Title: Dunedin Hotel - 987 Lonely Road                            Location: Dunedin                        Rating: Four        Vacancy: No");
        locationButtons [7] = new JRadioButton("Title: Queenstown Hotel - 52 New South Drive               Location: Queenstown                Rating: Five         Vacancy: Yes");

        locationButtons[2].setEnabled(false);
        locationButtons[4].setEnabled(false);
        locationButtons[6].setEnabled(false);
        
        for(int i = 0; i<8; i++)
        {
            locationButtons[i].setPreferredSize(new Dimension(1100, 50));
            locationButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            group.add(locationButtons[i]);
            menuPanel.add(locationButtons[i]);
        }
        this.add(menuPanel, BorderLayout.CENTER);
        /*ActionListener listener = new ActionListener()
        {
           public void actionPerformed(ActionEvent e) 
           {
              
           } 
        };*/
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.setPreferredSize(new Dimension(730,80));
        
        backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(200,70));
        backButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        nextButton.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if(locationButtons[0].isSelected() || locationButtons[1].isSelected() || locationButtons[3].isSelected() || 
                       locationButtons[5].isSelected() || locationButtons[7].isSelected())
               {
                   int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");
                   
                   if(userConfirmation == JOptionPane.YES_OPTION)
                   {
                       dispose();
                       bookRooms = new GuestChooseRoom();
                       //add code here to add to cart or table etc
                   }
               }
               else
               {
                   JOptionPane.showMessageDialog(new JFrame(), "Please select a hotel location before moving to the next stage", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
               }
               
           }
        });
        
        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking dates");
        this.setSize(1200,700);
        this.setLocation(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
   
    /*public void addHotelLocationBtn(String name)
    {
        addHotelLocationBtn("Title: Auckland Hotel - 31 Starcent Ave                          Location: Auckland                       Rating: Five      Vacancy: Yes");
        addHotelLocationBtn("Title: Rotorua Hotel - 17 Geyser Crescent                      Location: Rotorua                        Rating: Three     Vacancy: Yes");
        addHotelLocationBtn("Title: Taupo Hotel - 48 Lake Ave                                       Location: Taupo                           Rating: Four       Vacancy: No");
        addHotelLocationBtn("Title: Palmerston Hotel - 69 Leggy Ave                            Location: Palmerston Hotel        Rating: Four       Vacancy: Yes");
        addHotelLocationBtn("Title: Wellington Hotel - 128 Bee Ave                               Location: Wellington                   Rating: Five        Vacancy: No");
        addHotelLocationBtn("Title: Christchurch Hotel - 27 Meadow Lane                    Location: Christchurch               Rating: Four        Vacancy: Yes");
        addHotelLocationBtn("Title: Dunedin Hotel - 987 Lonely Road                            Location: Dunedin                        Rating: Four        Vacancy: No");
        addHotelLocationBtn("Title: Queenstown Hotel - 52 New South Drive               Location: Queenstown                Rating: Five         Vacancy: Yes");
    
        JRadioButton locationButton = new JRadioButton(name);
        locationButton.setPreferredSize(new Dimension(1100,50));
        locationButton.setFont(new Font("Arial", Font.BOLD, 18));
        group.add(locationButton);
        menuPanel.add(locationButton);
        
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("Your chose" +event);
                
                if (locaton)
                {
                    System.out.println("invalid choice");
                }
            }
        };
        
    }*/
}
