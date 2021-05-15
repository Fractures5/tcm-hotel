/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the menu of the guest types available by adding information
 * about the guest types into an array list. This class is a child class and inherits
 * certain methods/variables/characteristics from the Parent class Products. This class contains the 
 * specific constructors for initializing data only for guest types, and it contains the static menu output methods, 
 * toString methods and the special abstract method which all help output the array list in a neat manner 
 * to show the guest types available menu which is used in the guest menu class. 
 * @author Siddarath
 */
public class GuestsTypeMenu extends Products {
    
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public GuestsTypeMenu()
    {
    }
    
    /**
     * This is a constructor for the GuestTypeMenu class which contains input for specific variables like
     * title, guest types and price that will be used in this class to initialize the GuestTypeMenu objects
     * and create the array lists which shows the guests type menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the GuestTypeMenu objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the chosen guest type.
     * @param guestType the parameter represents the enumerated type GuestType which holds the different types of guests that be can booked.
     * @param price the parameter in this constructor represents the price of the type of guest selected to be booked. 
     * @author Siddarath
     */
    public GuestsTypeMenu(String title, GuestType guestType, Double price)
    {
        super(title, guestType, price); // Calls the super class "Products" and inherits the specified characteristics.
    }
    
    /**
     * This method will essentially output the menu of the guest types to the user.
     * This static method showMenu will create an object of the GuestsTypeMenu class and assign it to values
     * that are details about the guest types the hotel provides. Then the method adds these assigned objects
     * to the array list and then it outputs the array list that stores the information about the guest types
     * along with the unique index number which the guest can refer when selecting an option from this menu.
     * @return guests the array list which holds all the information about the guest types.
     * @author Siddarath
     */
    public static ArrayList<GuestsTypeMenu> showMenu()
    {
        GuestsTypeMenu adult = new GuestsTypeMenu("Adult (18-64 yrs)" , GuestType.ADULT , 30.00);
        GuestsTypeMenu child = new GuestsTypeMenu("Child (4-17 yrs)" , GuestType.CHILD , 10.00);
        GuestsTypeMenu infant = new GuestsTypeMenu("Infant (0-3 yrs)" , GuestType.INFANT , 0.00);
        GuestsTypeMenu elderly = new GuestsTypeMenu("Elderly (65+ yrs)" , GuestType.ELDERLY , 15.00);
        GuestsTypeMenu vip = new GuestsTypeMenu("VIP (Famous)" , GuestType.VIP , 100.00);    
        
        ArrayList<GuestsTypeMenu> guests = new ArrayList<GuestsTypeMenu>(); // Creating the array list object.
        guests.add(adult); // Stores details into the array list object.
        guests.add(child);
        guests.add(infant);
        guests.add(elderly);
        guests.add(vip);
        
        GuestsTypeMenu guestTypeTitle = new GuestsTypeMenu();
        guestTypeTitle.menuBanner(); // Calls the abstract method to display this menus specific banner.
        
        for (GuestsTypeMenu guestTypes: guests)
        {
            System.out.println("(" +guests.indexOf(guestTypes)+ ") - " +guestTypes); // Prints out the guest type menu formatted with its index number in the front.
        }
        
        return guests; 
    }
    
    /**
     * This toString method will return a string representation of the GuestsTypeMenu class object.
     * This method utilizes the "strong.format" skill to make the menu look more organized in a column
     * format that is spaced out, legible and appealing.
     * @return a string which outputs all the instances variable values for the GuestsTypeMenu class. 
     * @author Siddarath
     */
    public String toString()
    {
        String output = String.format("%-30s", "Title: " + this.getTitle()); // String.format is used to format the guest type menu in columns.
        output += String.format("%-30s", "Customer Type: " + this.getGuestType());
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
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("                          Customer types menu");
        System.out.println("---------------------------------------------------------------------------------");
    }
}
