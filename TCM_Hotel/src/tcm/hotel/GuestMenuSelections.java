/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * This is an interface class which is implemented by the GuestMenu class.
 * This interface contains all the methods that the GuestMenu class muse
 * and implement.
 * @author Siddarath
 */
public interface GuestMenuSelections 
{
    public void chooseDates() throws ParseException;
    
    public void chooseLocation();
    
    public void chooseRooms();
    
    public void chooseGuestTypes();
    
    public void chooseHotelFeatures();
    
    public void addBookingToFile(double totalPrice, ArrayList<Guest> guestList);
    
    public void bookingConfirmation(double totalPrice, ArrayList<Guest> guestList) throws IOException;
    
    public double totalBookingCost();
}
