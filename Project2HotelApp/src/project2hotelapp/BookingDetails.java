/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import hotelControllers.LocationMenuInteraction;
import java.util.ArrayList;

/**
 *
 * @author Siddarath
 */
public class BookingDetails 
{
    
    
    public void hello()
    {
        ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
        locationBooked = LocationMenuInteraction.userLocation();
        
        //System.out.println("stuff from my booking details class: " +locationBooked.get(0).getTitle());
    }
}
