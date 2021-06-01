/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This is the model class for the hotel booking dates and it
 * interacts with the controller which is BookDatesInteraction. 
 * Here the booking dates the user selects is initialized (using setter methods)
 * and stored in the GuessBookingCart array list. This model class also uses 
 * getter methods to retrieve the array list data outside this class.
 * @author Siddarath
 */
public class BookedHotelDates 
{   
    private ArrayList<GuestsBookingCart> bookedDates = null;
    
    /**
     * This is the HotelBookingDates classes default constructor.
     */
    public BookedHotelDates()
    {
        
    }

    /**
     * This setDatesBooked method updates the value of the object named bookedDates 
     * which is an array list object of the GuestBookingCart class.
     * @param bookedDates the parameter represents array list object from the GuestBookingCart class.
     * @author Siddarath
     */
    public void setDatesBooked(ArrayList<GuestsBookingCart> bookedDates)
    {
        this.bookedDates = bookedDates;
    }
    
    /**
     * This getDatesBooked method will return the value of the object named bookedDates 
     * which is an array list object of the class GuestBookingCart.
     * @return bookedDates the array list object.
     * @author Siddarath
     */
    public ArrayList<GuestsBookingCart> getDatesBooked()
    {
        return bookedDates;
    }
    
}
