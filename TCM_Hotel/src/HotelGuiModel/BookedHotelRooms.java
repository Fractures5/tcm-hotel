/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class BookedHotelRooms 
{
    private ArrayList<GuestsBookingCart> roomsSelected = null;
    
    public BookedHotelRooms()
    {
    }
    
    public void setRoomsBooked(ArrayList<GuestsBookingCart> roomsSelected)
    {
        this.roomsSelected = roomsSelected;
    }
    
    public ArrayList<GuestsBookingCart> getRoomsBooked()
    {
        return roomsSelected;
    }
}
