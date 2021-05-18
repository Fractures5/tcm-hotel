/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelGuests;
import hotelModel.HotelRooms;
import hotelView.HotelGuestTypesMenu;
import hotelView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Siddarath
 */
public class RoomMenuInteraction 
{
    HotelRooms roomsModel;
    HotelRoomsMenu  roomsView;
    
    public RoomMenuInteraction(HotelRooms roomsModel, HotelRoomsMenu  roomsView)
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
        roomsView.confirmSelection();

        if (roomsView.getRepeat() == true && roomsView.getShowErrorMesssage() == true) 
        {
            roomsView.displayErrorMessage();
        }
        else if(roomsView.getRepeat() == true && roomsView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            
        }
        else if (roomsView.getRepeat() == false) 
        {
            roomsView.addUserRoomsSelection();
            roomsView.setVisible(false);
            roomsModel.setRoomsBooked(roomsView.getRoomsBooked());
            //System.out.println(roomsModel.getRoomsBooked().get(0).getTitle() + " " + roomsModel.getRoomsBooked().get(0).getPrice());
            roomsModel.currentRoomBookings();
            
            
            HotelGuests guestsModel = new HotelGuests();
            HotelGuestTypesMenu guestsView = new HotelGuestTypesMenu();
            GuestsTypeInteraction selectGuests = new GuestsTypeInteraction(guestsModel, guestsView);
        }
    }
    
    public void mouseEnteredHover()
    {
        roomsView.mouseEnterHover();
    }
    
    public void mouseExitedHover()
    {
        roomsView.mouseExitHover();
    }
}
