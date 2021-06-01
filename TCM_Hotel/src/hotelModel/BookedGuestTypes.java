/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelModel;

import java.util.ArrayList;
import project2hotelapp.GuestsBookingCart;

/**
 * This is the model class for the hotel guest types menu and it
 * interacts with the controller which is BookDatesInteraction. 
 * Here the booking dates the user selects is initialized (using setter methods)
 * and stored in the GuessBookingCart array list. This model class also uses 
 * getter methods to retrieve the array list data outside this class.
 * @author Siddarath
 */
public class BookedGuestTypes 
{
    private ArrayList<GuestsBookingCart> guestsSelected = null;
    
    public BookedGuestTypes()
    {
        
    }
    
    public void setGuestsBooked(ArrayList<GuestsBookingCart> guestsSelected)
    {
        this.guestsSelected = guestsSelected;
    }
    
    public ArrayList<GuestsBookingCart> getGuestsBooked()
    {
        return guestsSelected;
    }
}
