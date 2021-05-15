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
public class HotelGuests 
{
    private ArrayList<GuestsBookingCart> guestsSelected = new ArrayList<>();
    
    public HotelGuests()
    {
        this.guestsSelected = guestsSelected;
    }
    
    public void setGuestsBooked(ArrayList<GuestsBookingCart> guestsSelected)
    {
        this.guestsSelected = guestsSelected;
    }
    
    public ArrayList<GuestsBookingCart> getGuestsBooked()
    {
        return guestsSelected;
    }
    
    public void currentGuestBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle()) + String.format("%-30s", "Guest Type: " + bookingDetails.getGuestType()) + String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }
    }
}
