/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

import HotelGuiController.FeaturesMenuInteraction;
import HotelGuiController.GuestsTypeInteraction;
import HotelGuiController.LocationMenuInteraction;
import HotelGuiController.RoomMenuInteraction;
import java.util.ArrayList; 

/**
 * This class is used to calculate the total costs of the guests
 * booking. It contains a method with performs the required calculations 
 * which is called in the booking cart menu.
 * 
 * @author Siddarath
 */
public class CalculateCosts 
{
    /**
     * This is the default constructor.
     */
    public CalculateCosts()
    {
        
    }
    
    /**
     * This method calculates the total price of the guests booking which includes the room prices, guest type prices
     * and the extra feature prices.
     * @return totalPrice the parameter which represents the total price for the confirmed booking for the guest.
     * @Siddarath
     */
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
