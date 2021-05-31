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
 * specific constructors for initializing data only for rooms types, and it contains the static menu output methods, 
 * toString methods and the special abstract method which all help output the array list in a neat manner 
 * to show the room types available menu which is used in the guest menu class. 
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
     * and create the array lists which shows the rooms available menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the RoomMenu objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the room selected.
     * @param roomType the parameter represents the enumerated type RoomType which holds the different types of rooms the guests can book.
     * @param price the parameter in this constructor represents the price of the type of rooms selected by the guest.
     * @param availabilityType the parameter represents the enumerated type AvailabilityType which holds the number of rooms available to the specific room type.
     * @author Siddarath
     */
    public RoomMenu(String title, RoomType roomType, Double price)
    {
        super(title, roomType, price); // Calls the super class "Products" and inherits the specified characteristics.
    }

    /**
     * This method will essentially output the menu of the rooms available to the user.
     * This static method showMenu will create an object of the RoomMenu class and assign it to values
     * that are details about the available rooms the hotel provides. Then the method adds these assigned objects
     * to the array list and then it outputs the array list that stores the information about the available rooms
     * along with the unique index number which the guest can refer when selecting an option from this menu.
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
        
        /*RoomMenu roomTitle = new RoomMenu();
        roomTitle.menuBanner(); // Calls the abstract method to display this menus specific banner.
        
        for (RoomMenu roomTypes: rooms)
        {
            System.out.println("(" +rooms.indexOf(roomTypes)+ ") - " +roomTypes); // Prints out the room menu formatted with its index number in the front.
        }*/
        
        return rooms;
    }
    
    /**
     * This toString method will return a string representation of the RoomMenu class object.
     * This method utilizes the "strong.format" skill to make the menu look more organized in a column
     * format that is spaced out, legible and appealing.
     * @return a string which outputs all the instances variable values for the RoomMenu class. 
     * @author Siddarath
     */
    public String toString() 
    {
        String output = String.format("%-30s", "Title: " + this.getTitle()); // String.format is used to format the room menu in columns.
        output += String.format("%-30s", "Room Type: " + this.getRoomType());
        output += String.format("%-25s", "Price: $" + this.getPrice());
        
        return output;
    }

     /**
     * This is the abstract method inherited from the Products class. This method will
     * output a special banner graphic to make the menu more appealing.
     * @author Siddarath
     */
    @Override
    public void menuBanner() {
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                                  Rooms availables menu");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
