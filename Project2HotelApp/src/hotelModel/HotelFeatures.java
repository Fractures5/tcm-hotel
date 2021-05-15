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
    private ArrayList<GuestsBookingCart> featuresSelected = new ArrayList<>();
    
    public HotelFeatures()
    {
        this.featuresSelected = featuresSelected;
    }
    
    public void setFeaturesBook(ArrayList<GuestsBookingCart> featuresSelected)
    {
        this.featuresSelected = featuresSelected;
    }
    
    public ArrayList<GuestsBookingCart> getFeaturesBooked()
    {
        return featuresSelected;
    }
    
    public void currentFeatureBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle())+ String.format("%-30s", "Feature Type: " + bookingDetails.getFeatureType())+ String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }
    }
}
