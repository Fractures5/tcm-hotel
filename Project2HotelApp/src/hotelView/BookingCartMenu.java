/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelView;

import hotelControllers.BookDatesInteraction;
import hotelControllers.FeaturesMenuInteraction;
import hotelControllers.GuestsTypeInteraction;
import hotelControllers.LocationMenuInteraction;
import hotelControllers.RoomMenuInteraction;
import hotelModel.HotelBookingDates;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import project2hotelapp.CalculateCosts;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class BookingCartMenu extends JFrame
{
    private JLabel pageTitle, instruction, emptySpace;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JButton homeButton, proceedButton;
    private static JTextArea bookingCartField;
    private static JTextArea costsField;
    private JScrollPane scroll;
    private Boolean repeat = false;
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    Border blackline = BorderFactory.createLineBorder(Color.black, 2);
    
    public BookingCartMenu()
    {
        pageTitle = new JLabel("Booking Cart Menu\n");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setForeground(Color.YELLOW);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(pageTitle);
        this.add(headerPanel, BorderLayout.NORTH);
        
        instruction = new JLabel("The following is what you booked along with the total cost!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);

        menuPanel = new JPanel();
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setPreferredSize(new Dimension(1100, 850));
        menuPanel.add(instruction);
        
        JTextArea bookingCartField = BookingCartMenu.addBookingDetails();
        bookingCartField.setFont(new Font("Arial", Font.BOLD, 16));
        bookingCartField.setBorder(blackline);
        bookingCartField.setEditable(false);
        
        scroll = new JScrollPane(bookingCartField, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setValue(0);
        scroll.setMinimumSize(new Dimension (950, 450));
        scroll.setPreferredSize(new Dimension (950, 450));
        
        emptySpace = new JLabel("");
        emptySpace.setPreferredSize(new Dimension (900, 10));
        
        CalculateCosts guestCosts = new CalculateCosts();
        double totalCosts = guestCosts.guestsTotalCost();
        costsField = new JTextArea();
        costsField.setFont(new Font("Arial", Font.BOLD, 20));
        costsField.setBorder(blackline);
        costsField.setPreferredSize(new Dimension (950, 40));
        costsField.setText("                                                       Total cost to pay: $" +totalCosts);
        costsField.setEditable(false);
        
        menuPanel.add(Box.createVerticalStrut(65));
        menuPanel.add(scroll);
        menuPanel.add(emptySpace);
        menuPanel.add(costsField);
        this.add(menuPanel, BorderLayout.CENTER);
        
        bottomPanel = new JPanel();
        homeButton = new JButton("Return to Home");
        homeButton.setPreferredSize(new Dimension(300,70));
        homeButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        proceedButton = new JButton("Proceed to Checkout");
        proceedButton.setPreferredSize(new Dimension(300,70));
        proceedButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel.add(homeButton);
        bottomPanel.add(proceedButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        
        this.setTitle("Guests Booking Cart Confirmation");
        this.setSize(frameWidth +350, frameHeight +300);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static JTextArea addBookingDetails()
    {
        ArrayList<GuestsBookingCart> datesBooked = new ArrayList<GuestsBookingCart>();
        datesBooked = BookDatesInteraction.guestBookingDates();
        
        ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
        locationBooked = LocationMenuInteraction.guestHotelLocation();
        
        ArrayList<GuestsBookingCart> roomsBooked = new ArrayList<GuestsBookingCart>();
        roomsBooked = RoomMenuInteraction.guestBookedRooms();
        
        ArrayList<GuestsBookingCart> guestsTypesBooked = new ArrayList<GuestsBookingCart>();
        guestsTypesBooked = GuestsTypeInteraction.guestTypesBooked();
        
        ArrayList<GuestsBookingCart> featuresBooked = new ArrayList<GuestsBookingCart>();
        featuresBooked = FeaturesMenuInteraction.guestFeaturesBooked();
        
        bookingCartField = new JTextArea();
        //bookingCartField.setPreferredSize(new Dimension(950, 100));
        
        bookingCartField.setText("===============================================================================================================\n");
        bookingCartField.append("\n------------------------------------------------------------------------------ Booked dates ---------------------------------------------------------------------------------------------------\n\n");
        bookingCartField.append("Check in date: " +datesBooked.get(0).getCheckInDay()+ " / " +datesBooked.get(0).getCheckInMonth()+ " / " +datesBooked.get(0).getCheckInYear() +"\n");
        bookingCartField.append("Check out date: " +datesBooked.get(0).getCheckOutDay()+ " / " +datesBooked.get(0).getCheckOutMonth()+ " / " +datesBooked.get(0).getCheckOutYear() +"\n");
        //bookingCartField.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        bookingCartField.append("\n--------------------------------------------------------------------------- Location Booked -------------------------------------------------------------------------------------------------\n\n");
        bookingCartField.append("Title: " + locationBooked.get(0).getTitle() + "Location: " +locationBooked.get(0).getLocationType()+ "             Rating: " +locationBooked.get(0).getRatingType() + "             Vacancy: " +locationBooked.get(0).getVacancyType() + "\n");
        //bookingCartField.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        bookingCartField.append("\n----------------------------------------------------------------------------- Rooms Booked -------------------------------------------------------------------------------------------------\n\n");
        for (GuestsBookingCart bookingDetails : roomsBooked)
        {
            bookingCartField.append("Title: " + bookingDetails.getTitle() + "                    Room Type: " + bookingDetails.getRoomType() + "                 Price: $" + bookingDetails.getPrice() + "\n");
        }
        //bookingCartField.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        bookingCartField.append("\n-------------------------------------------------------------------------- Guest types Booked ---------------------------------------------------------------------------------------------\n\n");
        for (GuestsBookingCart bookingDetails : guestsTypesBooked)
        {
            bookingCartField.append("Title: " + bookingDetails.getTitle() + "                   Guest Type: " + bookingDetails.getGuestType() + "                 Price: $" + bookingDetails.getPrice() + "\n");
        }
       // bookingCartField.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        bookingCartField.append("\n--------------------------------------------------------------------------- Features Booked -------------------------------------------------------------------------------------------------\n\n");
        for (GuestsBookingCart bookingDetails : featuresBooked)
        {
            bookingCartField.append("Title: " + bookingDetails.getTitle()+ "                 Feature Type: " + bookingDetails.getFeatureType()+ "               Price: $" + bookingDetails.getPrice() + "\n");
        }
        bookingCartField.append("\n===============================================================================================================\n");
        return bookingCartField;
    }

    public void confirmSelection()
    {
        int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");

        if (userConfirmation == JOptionPane.YES_OPTION) 
        {
            repeat = false;
        } 
        else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
        {
            repeat = true;
        }
    }
    public JButton getHomeButton() 
    {
        return homeButton;
    }

    public JButton getProceedButton() 
    {
        return proceedButton;
    }

    public Boolean getRepeat() 
    {
        return repeat;
    }
    
    public void mouseEnterHomeHover()
    {
        getHomeButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitHomeHover()
    {
        getHomeButton().setBackground(UIManager.getColor("control"));
    }
    
    public void mouseEnterNextHover()
    {
        getProceedButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitNextHover()
    {
        getProceedButton().setBackground(UIManager.getColor("control"));
    }
}
