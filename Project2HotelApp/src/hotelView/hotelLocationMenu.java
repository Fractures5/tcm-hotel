/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelView;

import hotelControllers.LocationMenuInteraction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import project2hotelapp.GuestChooseRoom;
import project2hotelapp.GuestsBookingCart;
import project2hotelapp.LocationMenu;

/**
 *
 * @author Siddarath
 */
public class HotelLocationMenu extends JFrame{
    
    private static GuestChooseRoom bookRooms;
    private JLabel title, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private ButtonGroup group; 
    private JRadioButton[] locationButtons = new JRadioButton[8];
    private JButton backButton, nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;

    ArrayList<GuestsBookingCart> bookingLocation = new ArrayList<>();
    
    public Boolean getShowErrorMesssage()
    {
        return showErrorMessage;
    }
    
    public Boolean getRepeat()
    {
        return repeat;
    }
    
    public JButton getNextButton()
    {
        return nextButton;
    }
    
    public ArrayList<GuestsBookingCart> getBookingLocation()
    {
        return bookingLocation;
    }
    
    public HotelLocationMenu()
    {
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
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.setPreferredSize(new Dimension(730,80));
        
        backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(200,70));
        backButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking dates");
        this.setSize(1200,700);
        this.setLocation(500,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void confirmSelection()
    {
        ArrayList<LocationMenu> locationsMenu = new ArrayList<LocationMenu>();
        locationsMenu = LocationMenu.showMenu();
        
        if(locationButtons[0].isSelected() || locationButtons[1].isSelected() || locationButtons[3].isSelected() || 
                locationButtons[5].isSelected() || locationButtons[7].isSelected())
        {
            int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");

            if(userConfirmation == JOptionPane.YES_OPTION)
            {
                if (locationButtons[0].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(0).getTitle(), locationsMenu.get(0).getLocationType(), locationsMenu.get(0).getRatingType(), locationsMenu.get(0).getVacancyType());
                    bookingLocation.add(bookingDetails);
                } 
                else if (locationButtons[1].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(1).getTitle(), locationsMenu.get(1).getLocationType(), locationsMenu.get(1).getRatingType(), locationsMenu.get(1).getVacancyType());
                    bookingLocation.add(bookingDetails);
                } 
                else if (locationButtons[3].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(3).getTitle(), locationsMenu.get(3).getLocationType(), locationsMenu.get(3).getRatingType(), locationsMenu.get(3).getVacancyType());
                    bookingLocation.add(bookingDetails);
                } 
                else if (locationButtons[5].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(5).getTitle(), locationsMenu.get(5).getLocationType(), locationsMenu.get(5).getRatingType(), locationsMenu.get(5).getVacancyType());
                    bookingLocation.add(bookingDetails);
                } 
                else if (locationButtons[7].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(7).getTitle(), locationsMenu.get(7).getLocationType(), locationsMenu.get(7).getRatingType(), locationsMenu.get(7).getVacancyType());
                    bookingLocation.add(bookingDetails);
                }
                repeat = false;
                showErrorMessage = false;
            }
            else if(userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION )
            {
                repeat = true;
                showErrorMessage = false;
            }
        }
        else
        {
           showErrorMessage = true;
           repeat = true;
        }
         
    }
    
    public void displayErrorMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Please select a hotel location before moving to the next stage", "Invalid Selection",
             JOptionPane.ERROR_MESSAGE);
    }
    
}
