/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelModel;

import java.util.ArrayList;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class HotelRooms 
{
    private ArrayList<GuestsBookingCart> roomsSelected = null;
    
    public HotelRooms()
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
    
    public void currentRoomBookings() 
    {
        for (GuestsBookingCart bookingDetails : roomsSelected) 
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle()) + String.format("%-30s", "Room Type: " + bookingDetails.getRoomType()) + String.format("%-25s", "Price: $" + bookingDetails.getPrice()));

        }
    }
}
