/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This is the model class for the hotel features menu and it
 * interacts with the controller which is FeaturesMenuInteraction. 
 * Here the hotel features the user selects is initialized (using setter methods)
 * and is stored in the GuessBookingCart array list object. This model class also uses 
 * getter methods to retrieve the array list data outside this class.
 * @author Siddarath
 */
public class BookedHotelFeatures 
{
    private ArrayList<GuestsBookingCart> featuresSelected = null;
    
    /**
     * This is the BookedHotelFeatures classes default constructor. 
     */
    public BookedHotelFeatures()
    {
        
    }
    
    /**
     * This setFeaturesBooked method updates the value of the object named featuresSelected 
     * which is an array list object of the GuestBookingCart class. 
     * @param featuresSelected the parameter represents array list object from the GuestBookingCart class.
     * @author Siddarath
     */
    public void setFeaturesBooked(ArrayList<GuestsBookingCart> featuresSelected)
    {
        this.featuresSelected = featuresSelected;
    }
    
    /**
     * This getFeaturesBooked method will return the value of the object named featuresSelected 
     * which is an array list object of the class GuestBookingCart.
     * @return featuresSelected the array list object.
     * @author Siddarath
     */
    public ArrayList<GuestsBookingCart> getFeaturesBooked()
    {
        return featuresSelected;
    }  
}
