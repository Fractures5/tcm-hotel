/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import tcm.hotel.GuestsBookingCart;
import tcm.hotel.LocationMenu;

/**
 *
 * @author Siddarath
 */
public class HotelLocations {
    
    private ArrayList<GuestsBookingCart> locationInfo = null;

    public HotelLocations() 
    {
    }
    
    
    public void setBookingLocation(ArrayList<GuestsBookingCart> locationInfo)
    {
        this.locationInfo = locationInfo;
    }
    
    public ArrayList<GuestsBookingCart> getBookingLocation()
    {
        return locationInfo;
    }
    
    // modify this method and add it directly from here!
    public void currentLocationBookings()
    {
        for (GuestsBookingCart bookingDetails : locationInfo)
        {
            System.out.println("Title: " + bookingDetails.getTitle() + "  Location: " +bookingDetails.getRatingType() + "                Rating: " +bookingDetails.getRatingType() + "             Vacancy: " +bookingDetails.getVacancyType());
        }
 
    }
}