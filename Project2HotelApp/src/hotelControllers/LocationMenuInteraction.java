/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelLocations;
import hotelModel.HotelRooms;
import hotelView.HotelLocationMenu;
import hotelView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project2hotelapp.GuestChooseRoom;

/**
 *
 * @author Siddarath
 */
public class LocationMenuInteraction {
    
    HotelLocations locationsModel;
    HotelLocationMenu locationsView;
   
    
    public LocationMenuInteraction(HotelLocations locationsModel, HotelLocationMenu locationsView)
    {
        this.locationsModel = locationsModel;
        this.locationsView = locationsView;
        
        locationsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                locationNextButtonPress();
            }
        });
    }
 
    public void locationNextButtonPress()
    {
        
        locationsView.confirmSelection();

        if (locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == true) 
        {
            locationsView.displayErrorMessage();
        }
        else if(locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == false)
        {
            
        }
        else if (locationsView.getRepeat() == false) 
        {
            locationsView.setVisible(false);
            locationsModel.setBookingLocation(locationsView.getBookingLocation());
            locationsModel.currentLocationBookings(locationsView.getBookingLocation());
            
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
    
    
    
}
