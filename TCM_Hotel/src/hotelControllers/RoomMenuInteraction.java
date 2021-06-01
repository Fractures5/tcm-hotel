/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.BookedGuestTypes;
import hotelModel.BookedHotelRooms;
import hotelView.HotelGuestTypesMenu;
import hotelView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import project2hotelapp.CalculateCosts;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class RoomMenuInteraction 
{
    static BookedHotelRooms roomsModel;
    HotelRoomsMenu  roomsView;
    
    public RoomMenuInteraction(BookedHotelRooms roomsModel, HotelRoomsMenu  roomsView)
    {
        this.roomsModel = roomsModel;
        this.roomsView = roomsView;
        
        roomsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        roomsView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
        roomsView.confirmSelection();

        if (roomsView.getRepeat() == true && roomsView.getShowErrorMesssage() == true) 
        {
            roomsView.displayErrorMessage();
        }
        /*else if(roomsView.getRepeat() == true && roomsView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            
        }*/
        else if (roomsView.getRepeat() == false) 
        {
            roomsView.addUserRoomsSelection();
            roomsView.setVisible(false);
            roomsModel.setRoomsBooked(roomsView.getRoomsBooked());
            
            BookedGuestTypes guestsModel = new BookedGuestTypes();
            HotelGuestTypesMenu guestsView = new HotelGuestTypesMenu();
            GuestsTypeInteraction selectGuests = new GuestsTypeInteraction(guestsModel, guestsView);
        }
    }
    
    public void mouseEnteredNextHover()
    {
        roomsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        roomsView.mouseExitNextHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestBookedRooms()
    {
        return roomsModel.getRoomsBooked();
    }
}
