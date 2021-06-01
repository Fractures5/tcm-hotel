/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the menu of the rooms types available by adding information
 * about the rooms types into an array list. This class is a child class and inherits
 * certain methods/variables/characteristics from the Parent class Products. This class contains the 
 * specific constructors for initializing data only for rooms types and its array list used
 * to show the room types available menu which is used in the hotelRoomsMenu GUI view and used to add
 * data into the guests booking cart.
 * @author Siddarath
 */
public class RoomMenu extends Products{
    
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public RoomMenu()
    {
    }
    
    /**
     * This is a constructor for the RoomMenu class which contains input for specific variables like
     * title, room types, price and availability type amount that will be used in this class to initialize the RoomMenu objects
     * and create the array lists which will be used in the hotelRoomsMenu GUI view. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the RoomMenu objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the room selected.
     * @param roomType the parameter represents the enumerated type RoomType which holds the different types of rooms the guests can book.
     * @param price the parameter in this constructor represents the price of the type of rooms selected by the guest.
     * @author Siddarath
     */
    public RoomMenu(String title, RoomType roomType, Double price)
    {
        super(title, roomType, price); // Calls the super class "Products" and inherits the specified characteristics.
    }

    /**
     * This static method showMenu will create an object of the RoomMenu class and assign it to values
     * that are details about the available rooms the hotel provides. Then the method adds these assigned objects
     * to the array list and is then used in the hotelRoomsMenu view GUI to output the menu details and used to add
     * the selected rooms to the users booking cart.
     * @return features the array list which holds all the information about the available rooms. 
     * @author Siddarath 
     */
    public static ArrayList<RoomMenu> showMenu()
    {
        RoomMenu standardRoom = new RoomMenu("Standard Room (1 Double size bed)", RoomType.STANDARD, 200.00);
        RoomMenu deluxeRoom = new RoomMenu("Deluxe Room (1 King Size bed)", RoomType.DELUXE, 375.00);
        RoomMenu twinRoom = new RoomMenu("Twin Size Room (2 single bed)", RoomType.TWIN, 250.00);
        RoomMenu queenRoom = new RoomMenu("Queen Size (1 queen sized bed)", RoomType.QUEEN, 225.00);
        RoomMenu familyRoom = new RoomMenu("Family Room (Large room)", RoomType.FAMILY, 300.00);
        RoomMenu couplesRoom = new RoomMenu("Couples Room (Heart-shaped king size bed)", RoomType.COUPLE, 315.00);
        
        ArrayList<RoomMenu> rooms = new ArrayList<RoomMenu>(); // Creating the array list object.
        rooms.add(standardRoom); // Stores details into the array list object.
        rooms.add(deluxeRoom);
        rooms.add(twinRoom);
        rooms.add(queenRoom);
        rooms.add(familyRoom);
        rooms.add(couplesRoom);
        
        return rooms;
    }
}
