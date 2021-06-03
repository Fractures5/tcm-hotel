/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This is the model class for the hotel rooms menu and it interacts with the
 * controller which is RoomsMenuInteraction. Here the hotel rooms the user
 * selects is initialized (using setter methods) and is stored in the
 * GuessBookingCart array list object. This model class also uses getter methods
 * to retrieve the array list data outside this class.
 *
 * @author Siddarath
 */
public class BookedHotelRooms 
{
    private ArrayList<GuestsBookingCart> roomsSelected = null;
    
    /**
     * This is the BookedHotelRooms classes default constructor.
     */
    public BookedHotelRooms()
    {
    }
    
    /**
     * This setRoomsBooked method updates the value of the object named
     * roomsSelected which is an array list object of the GuestBookingCart
     * class.
     *
     * @param roomsSelected the parameter represents array list object from the
     * GuestBookingCart class.
     * @author Siddarath
     */
    public void setRoomsBooked(ArrayList<GuestsBookingCart> roomsSelected)
    {
        this.roomsSelected = roomsSelected;
    }
    
    /**
     * This getRoomsBooked method will return the value of the object named
     * roomsSelected which is an array list object of the class
     * GuestBookingCart.
     *
     * @return roomsSelected the array list object.
     * @author Siddarath
     */
    public ArrayList<GuestsBookingCart> getRoomsBooked()
    {
        return roomsSelected;
    }
}
