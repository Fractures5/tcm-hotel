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
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import HotelDataFiles.GuestsBookingCart;
import HotelDataFiles.LocationMenu;

/**
 * The HotelLocationMenu class is a view class outputs the hotel location menu
 * GUI to the user where they can select a radio button of what hotel they would
 * like to book at. This class contains all the GUI elements for this menu,
 * getter methods for other classes to access variables from this class safely
 * and methods to deal with error handling and confirming the users selection.
 *
 * @author Siddarath
 */
public class HotelLocationMenu extends JFrame{
    
    private JLabel title, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private ButtonGroup group; 
    private JRadioButton[] locationButtons = new JRadioButton[8];
    private JButton nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;

    ArrayList<GuestsBookingCart> locationBooked = new ArrayList<>();
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.WHITE, 10));
    
    /**
     * This default constructor initializes the panels, labels, radio buttons,
     * buttons and other variables, sets the name, size, colors, location and
     * then adds it to the frame (set to visible) which makes the Hotel Location
     * Menu GUI visible to the user so they can choose a hotel location.
     *
     * @author Siddarath
     */
    public HotelLocationMenu()
    {
        title = new JLabel("Hotel Locations Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        
        instruction = new JLabel("Please tick the hotel location you would like to book at!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700,70));
        headerPanel.add(title);
        
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600,450));
        menuPanel.add(instruction);
        menuPanel.add(Box.createVerticalStrut(75));
        
        locationButtons [0] = new JRadioButton("Title: Auckland Hotel - 31 Starcent Ave                          Location: Auckland                       Rating: Five      Vacancy: Yes");
        locationButtons [1] = new JRadioButton("Title: Rotorua Hotel - 17 Geyser Crescent                      Location: Rotorua                        Rating: Three     Vacancy: Yes");
        locationButtons [2] = new JRadioButton("Title: Taupo Hotel - 48 Lake Ave                                       Location: Taupo                           Rating: Four       Vacancy: No");
        locationButtons [3] = new JRadioButton("Title: Palmerston Hotel - 69 Leggy Lane                            Location: Palmerston North        Rating: Four       Vacancy: Yes");
        locationButtons [4] = new JRadioButton("Title: Wellington Hotel - 128 Bee Ave                               Location: Wellington                   Rating: Five        Vacancy: No");
        locationButtons [5] = new JRadioButton("Title: Christchurch Hotel - 27 Meadow Lane                    Location: Christchurch               Rating: Four        Vacancy: Yes");
        locationButtons [6] = new JRadioButton("Title: Dunedin Hotel - 987 Lonely Road                            Location: Dunedin                        Rating: Four        Vacancy: No");
        locationButtons [7] = new JRadioButton("Title: Queenstown Hotel - 52 New South Drive               Location: Queenstown                Rating: Five         Vacancy: Yes");

        locationButtons[2].setEnabled(false);
        locationButtons[4].setEnabled(false);
        locationButtons[6].setEnabled(false);
        group = new ButtonGroup();
        
        for(int i = 0; i<8; i++)
        {
            locationButtons[i].setPreferredSize(new Dimension(1100, 50));
            locationButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            locationButtons[i].setBackground(Color.WHITE);
            locationButtons[i].setOpaque(true);
            locationButtons[i].setBorderPainted(true);
            locationButtons[i].setBorder(blackline);
            group.add(locationButtons[i]);
            menuPanel.add(locationButtons[i]);
            menuPanel.add(Box.createVerticalStrut(60));
        }
          
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.setPreferredSize(new Dimension(730,80));
        bottomPanel.add(nextButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking hotel location");
        this.setSize(frameWidth +350, frameHeight +300);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
    
    /**
     * This method returns the boolean result from the variable
     * 'showErrorMessage' which contains whether the error message needs to be
     * displayed, The same concept of getting/returning the specific datatype
     * applies to all the other get methods below.
     *
     * @return showErrorMessage the boolean which contains either true or false
     * on whether the error message needs to be displayed.
     * @author Siddarath
     */
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
        return locationBooked;
    }
    
    /**
     * This method checks if the user has selected a valid hotel location. If
     * the user gives a invalid response then it will set a boolean that will
     * let the controller for this menu know to show a error message to the
     * user. If the user successfully chooses a hotel location, the selected
     * hotel location is stored in an array list which is later stored in the
     * bookedHotelLocation model through using the LocationMenuInteraction
     * (controller).
     *
     * @author Siddarath
     */
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
                    locationBooked.add(bookingDetails);
                } 
                else if (locationButtons[1].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(1).getTitle(), locationsMenu.get(1).getLocationType(), locationsMenu.get(1).getRatingType(), locationsMenu.get(1).getVacancyType());
                    locationBooked.add(bookingDetails);
                } 
                else if (locationButtons[3].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(3).getTitle(), locationsMenu.get(3).getLocationType(), locationsMenu.get(3).getRatingType(), locationsMenu.get(3).getVacancyType());
                    locationBooked.add(bookingDetails);
                } 
                else if (locationButtons[5].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(5).getTitle(), locationsMenu.get(5).getLocationType(), locationsMenu.get(5).getRatingType(), locationsMenu.get(5).getVacancyType());
                    locationBooked.add(bookingDetails);
                } 
                else if (locationButtons[7].isSelected()) 
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(7).getTitle(), locationsMenu.get(7).getLocationType(), locationsMenu.get(7).getRatingType(), locationsMenu.get(7).getVacancyType());
                    locationBooked.add(bookingDetails);
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
    
    /**
     * If a user doesn't select a hotel location this method will be invoked and
     * it will output an error message to the user, preventing them to move on,
     * until they choose one.
     *
     * @author Siddarath
     */
    public void displayErrorMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Please select a hotel location before moving to the next stage", "Invalid Selection",
             JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method will set the background color of the next button to green
     * once a user hovers over it.
     *
     * @author Siddarath
     */
    public void mouseEnterNextHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    /**
     * This method will set the background color of the next button back to the
     * default color once the user exits hovering over the next button.
     *
     * @author Siddarath
     */
    public void mouseExitNextHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }
}
