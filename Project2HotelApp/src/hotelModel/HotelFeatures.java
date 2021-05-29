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
public class HotelFeatures 
{
    private ArrayList<GuestsBookingCart> featuresSelected = null;
    
    public HotelFeatures()
    {
    }
    
    public void setFeaturesBooked(ArrayList<GuestsBookingCart> featuresSelected)
    {
        this.featuresSelected = featuresSelected;
    }
    
    public ArrayList<GuestsBookingCart> getFeaturesBooked()
    {
        return featuresSelected;
    }
    
    public void currentFeatureBookings()
    {
        for (GuestsBookingCart bookingDetails : featuresSelected)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle())+ String.format("%-30s", "Feature Type: " + bookingDetails.getFeatureType())+ String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }  
    }
}
