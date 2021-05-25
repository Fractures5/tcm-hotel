/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelLocations;
import hotelModel.HotelRooms;
import hotelView.BookingCartMenu;
import hotelView.HotelLocationMenu;
import hotelView.HotelRoomsMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import project2hotelapp.CalculateCosts;
import project2hotelapp.GuestChooseRoom;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class LocationMenuInteraction {
    
    static HotelLocations locationsModel;
    HotelLocationMenu locationsView;
    
    public LocationMenuInteraction(HotelLocations locationsModel, HotelLocationMenu locationsView)
    {
        this.locationsModel = locationsModel;
        this.locationsView = locationsView;
        
        locationsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        locationsView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseEnteredHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitedHover();
            }
        });
    }
 
    public void handleNextButtonPress()
    {
        
        locationsView.confirmSelection();

        if (locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == true) 
        {
            locationsView.displayErrorMessage();
        }
        else if(locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            // no error is shown
        }
        else if (locationsView.getRepeat() == false) 
        {
            locationsView.setVisible(false);
            locationsModel.setBookingLocation(locationsView.getBookingLocation());
            locationsModel.currentLocationBookings();
            
            HotelRooms roomsModel = new HotelRooms();
            HotelRoomsMenu roomsView = new HotelRoomsMenu();
            RoomMenuInteraction roomsAction = new RoomMenuInteraction(roomsModel, roomsView);
        }
        
        
        
        /*if (locationsView.confirmSelection() == false)
        {
            locationsView.displayErrorMessage();
        }
        else
        {
            locationsView.setVisible(false);
            locationsModel.setBookingLocation(locationsView.getBookingLocation());
            // add code here to add studet to the model data array or something
        }*/
    }
    
    public void mouseEnteredHover()
    {
        locationsView.mouseEnterHover();
    }
    
    public void mouseExitedHover()
    {
        locationsView.mouseExitHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestHotelLocation()
    {
        return locationsModel.getBookingLocation();
    }
}
