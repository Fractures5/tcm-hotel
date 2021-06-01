/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This is the model class for the hotel location menu and it
 * interacts with the controller which is LocationMenuInteraction. 
 * Here the hotel location the user selects is initialized (using setter methods)
 * and stored in the GuessBookingCart array list. This model class also uses 
 * getter methods to retrieve the array list data outside this class.
 * @author Siddarath
 */
public class BookedHotelLocations 
{
    
    /**
     * This is the BookedHotelLocations classes default constructor.
     */
    private ArrayList<GuestsBookingCart> locationInfo = null;

    public BookedHotelLocations() 
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
}
