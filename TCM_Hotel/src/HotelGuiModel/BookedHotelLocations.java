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

    /**
     * This setBookingLocation method updates the value of the object named
     * locationInfo which is an array list object of the GuestBookingCart class.
     *
     * @param locationInfo the parameter represents array list object from the
     * GuestBookingCart class.
     * @author Siddarath
     */
    public void setBookingLocation(ArrayList<GuestsBookingCart> locationInfo)
    {
        this.locationInfo = locationInfo;
    }
    
    /**
     * This getBookingLocation method will return the value of the object named
     * locationInfo which is an array list object of the class GuestBookingCart.
     *
     * @return locationInfo the array list object.
     * @author Siddarath
     */
    public ArrayList<GuestsBookingCart> getBookingLocation()
    {
        return locationInfo;
    }
}
