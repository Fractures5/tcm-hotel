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
