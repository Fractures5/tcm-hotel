/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This is the model class for the hotel guest types menu and it interacts with
 * the controller which is GuestTypeInteraction. Here the hotel guest types the
 * user selects is initialized (using setter methods) and is stored in the
 * GuessBookingCart array list object. This model class also uses getter methods
 * to retrieve the array list data outside this class.
 *
 * @author Siddarath
 */
public class BookedGuestTypes 
{
    private ArrayList<GuestsBookingCart> guestsSelected = null;
    
    /**
     * This is the BookedGuestTypes classes default constructor.
     */
    public BookedGuestTypes()
    {
        
    }
    
    /**
     * This setGuestsBooked method updates the value of the object named
     * guestsSelected which is an array list object of the GuestBookingCart
     * class.
     *
     * @param guestsSelected the parameter represents array list object from the
     * GuestBookingCart class.
     * @author Siddarath
     */
    public void setGuestsBooked(ArrayList<GuestsBookingCart> guestsSelected)
    {
        this.guestsSelected = guestsSelected;
    }
    
    /**
     * This getGuestsBooked method will return the value of the object named
     * guestsSelected which is an array list object of the class
     * GuestBookingCart.
     *
     * @return guestsSelected the array list object.
     * @author Siddarath
     */
    public ArrayList<GuestsBookingCart> getGuestsBooked()
    {
        return guestsSelected;
    }
}
