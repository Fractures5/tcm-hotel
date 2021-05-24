/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelView;

import hotelControllers.LocationMenuInteraction;
import hotelModel.HotelBookingDates;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import project2hotelapp.BookingDetails;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class BookingCartMenu extends JFrame
{
    private JLabel pageTitle, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private static JTextArea bookingCartField;
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
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
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        JTextArea bookingCartField = BookingCartMenu.test();
        /*bookingCartField.setPreferredSize(new Dimension(800, 500));
        Font textFieldFont = new Font("Arial", Font.BOLD, 24);
        bookingCartField.setFont(textFieldFont);
        
        ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
        locationBooked = LocationMenuInteraction.userLocation();
        
        bookingCartField.setText(locationBooked.get(0).getTitle());
        
        HotelBookingDates test = new HotelBookingDates();
        System.out.println(test.getCheckInDay());
        System.out.println(test.getCheckInMonth());
        
        bookingCartField.append("chur");*/
        menuPanel.add(Box.createVerticalStrut(75));
        menuPanel.add(bookingCartField);
        
        this.add(menuPanel, BorderLayout.CENTER);
        
        this.setTitle("Guests Booking Cart Confirmation");
        this.setSize(frameWidth +350, frameHeight +250);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static JTextArea test()
    {
        bookingCartField = new JTextArea();
        bookingCartField.setPreferredSize(new Dimension(800, 500));
        Font textFieldFont = new Font("Arial", Font.BOLD, 24);
        bookingCartField.setFont(textFieldFont);
        
        ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
        locationBooked = LocationMenuInteraction.userLocation();
        
        bookingCartField.setText(locationBooked.get(0).getTitle());
        
        HotelBookingDates test = new HotelBookingDates();
        System.out.println(test.getCheckInDay());
        System.out.println(test.getCheckInMonth());
        
        bookingCartField.append("chur");
        
        return bookingCartField;
    }
    
}
