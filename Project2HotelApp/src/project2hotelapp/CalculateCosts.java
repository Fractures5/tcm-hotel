/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import hotelControllers.BookDatesInteraction;
import hotelControllers.FeaturesMenuInteraction;
import hotelControllers.GuestsTypeInteraction;
import hotelControllers.LocationMenuInteraction;
import hotelControllers.RoomMenuInteraction;
import java.util.ArrayList;

/**
 *
 * @author Siddarath
 */
public class CalculateCosts 
{
    public CalculateCosts()
    {
        
    }
    
    public double guestsTotalCost()
    {
        ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
        locationBooked = LocationMenuInteraction.guestHotelLocation();
        
        ArrayList<GuestsBookingCart> roomsBooked = new ArrayList<GuestsBookingCart>();
        roomsBooked = RoomMenuInteraction.guestBookedRooms();
        
        ArrayList<GuestsBookingCart> guestsTypesBooked = new ArrayList<GuestsBookingCart>();
        guestsTypesBooked = GuestsTypeInteraction.guestTypesBooked();
        
        ArrayList<GuestsBookingCart> featuresBooked = new ArrayList<GuestsBookingCart>();
        featuresBooked = FeaturesMenuInteraction.guestFeaturesBooked();
        
        double totalPrice = 0.0;
        for(int i = 0; i < roomsBooked.size(); i++)
        {
            totalPrice += roomsBooked.get(i).getPrice();
        }
        
        for(int i = 0; i < guestsTypesBooked.size(); i++)
        {
            totalPrice += guestsTypesBooked.get(i).getPrice();
        }
        
        for(int i = 0; i < featuresBooked.size(); i++)
        {
            totalPrice += featuresBooked.get(i).getPrice();
        }
        
        return totalPrice;
    }
}
