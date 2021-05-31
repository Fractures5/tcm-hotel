/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import tcm.hotel.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class HotelGuests 
{
    private ArrayList<GuestsBookingCart> guestsSelected = null;
    
    public HotelGuests()
    {
    }
    
    public void setGuestsBooked(ArrayList<GuestsBookingCart> guestsSelected)
    {
        this.guestsSelected = guestsSelected;
    }
    
    public ArrayList<GuestsBookingCart> getGuestsBooked()
    {
        return guestsSelected;
    }
    
    public void currentGuestBookings()
    {
        for (GuestsBookingCart bookingDetails : guestsSelected)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle()) + String.format("%-30s", "Guest Type: " + bookingDetails.getGuestType()) + String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }
    }
}