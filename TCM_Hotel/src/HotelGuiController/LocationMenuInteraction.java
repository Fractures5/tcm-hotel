/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedHotelLocations;
import HotelGuiModel.BookedHotelRooms;
import HotelGuiView.HotelLocationMenu;
import HotelGuiView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class LocationMenuInteraction {
    
    static BookedHotelLocations locationsModel;
    HotelLocationMenu locationsView;
    
    public LocationMenuInteraction(BookedHotelLocations locationsModel, HotelLocationMenu locationsView)
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
                mouseEnteredNextHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitedNextHover();
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
        /*else if(locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            // no error is shown
        }*/
        else if (locationsView.getRepeat() == false) 
        {
            locationsView.setVisible(false);
            locationsModel.setBookingLocation(locationsView.getBookingLocation());
            
            BookedHotelRooms roomsModel = new BookedHotelRooms();
            HotelRoomsMenu roomsView = new HotelRoomsMenu();
            RoomMenuInteraction roomsAction = new RoomMenuInteraction(roomsModel, roomsView);
        }
    }
    
    public void mouseEnteredNextHover()
    {
        locationsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        locationsView.mouseExitNextHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestHotelLocation()
    {
        return locationsModel.getBookingLocation();
    }
}
