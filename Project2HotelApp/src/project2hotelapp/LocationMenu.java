/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the menu of the location types available by adding information
 * about the location types into an array list. This class is a child class and inherits
 * certain methods/variables/characteristics from the Parent class Products. This class contains the 
 * specific constructors for initializing data only for location types, and it contains the static menu output methods, 
 * toString methods and the special abstract method which all help output the array list in a neat manner 
 * to show the hotel location menu which is used in the guest menu class. 
 * @author Siddarath
 */
public class LocationMenu extends Products{
    
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public LocationMenu()
    {
    }
    
    /**
     * This is a constructor for the LocationMenu class which contains input for specific variables like
     * title, location types, rating types and vacancy types that will be used in this class to initialize the LocationMenu objects
     * and create the array lists which shows the hotel locations menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the LocationMenu objects.
     * @param title the parameter represents the title of selection, in this case it would be the hotel location name.
     * @param locationType the parameter represents the location type of the hotel.
     * @param ratingType the parameter represents the rating type of the hotel.
     * @param vacancyType the parameter represents the vacancy type status of the hotel.
     * @author Siddarath
     */
    public LocationMenu(String title, LocationType locationType, RatingType ratingType, VacancyType vacancyType)
    {
        super(title, locationType, ratingType, vacancyType); // Calls the super class "Products" and inherits the specified characteristics.
    }
    
    /**
     * This method will essentially output the menu of the hotel locations to the user.
     * This static method showMenu will create an object of the LoctaionMenu class and assign it to values
     * that are details about the locations the hotel is located at. Then the method adds these assigned objects
     * to the array list and then it outputs the array list that stores the information about the hotel locations
     * along with the unique index number which the guest can refer when selecting an option from this menu.
     * @return locations the array list which holds all the information about the hotel locations.
     * @author Siddarath
     */
    public static ArrayList<LocationMenu> showMenu()
    {
        LocationMenu aklHotel = new LocationMenu("Auckland Hotel - 31 Starcent Ave                  ", LocationType.AUCKLAND, RatingType.FIVE, VacancyType.YES);
        LocationMenu rotHotel = new LocationMenu("Rotorua Hotel - 17 Geyser Crescent                ", LocationType.ROTORUA, RatingType.THREE, VacancyType.YES);
        LocationMenu touHotel = new LocationMenu("Taupo Hotel - 48 Lake Street                      ", LocationType.TAUPO, RatingType.FOUR, VacancyType.NO);
        LocationMenu pmrHotel = new LocationMenu("Palmerston North Hotel - 69 Leggy Lane            ", LocationType.PALMERSTONNORTH, RatingType.FOUR, VacancyType.YES);
        LocationMenu wlgHotel = new LocationMenu("Wellington Hotel - 128 Bee Ave                    ", LocationType.WELLINGTON, RatingType.FIVE, VacancyType.NO);
        LocationMenu chcHotel = new LocationMenu("Christchurch Hotel - 27 Meadow Lane               ", LocationType.CHRISTCHURCH, RatingType.FOUR, VacancyType.YES);
        LocationMenu dudHotel = new LocationMenu("Dunedin Hotel - 987 Lonely Road                   ", LocationType.DUNEDIN, RatingType.FOUR, VacancyType.NO);
        LocationMenu queensHotel = new LocationMenu ("Queenstown Hotel - 52 New South Drive             ", LocationType.QUEENSTOWN, RatingType.FIVE, VacancyType.YES);
        
        ArrayList<LocationMenu> locations = new ArrayList<LocationMenu>(); // Creating the array list object.
        locations.add(aklHotel); // Stores details into the array list object.
        locations.add(rotHotel);
        locations.add(touHotel);
        locations.add(pmrHotel);
        locations.add(wlgHotel);
        locations.add(chcHotel);
        locations.add(dudHotel);
        locations.add(queensHotel);
        
        LocationMenu menuTitle = new LocationMenu();
        menuTitle.menuBanner(); // Calls the abstract method to display this menus specific banner.
        
        
        for (LocationMenu locationType: locations)
        {
            System.out.println("(" +locations.indexOf(locationType) +") - " +locationType); // Prints out the hotel location menu formatted with its index number in the front.
        }
        
        return locations;
    }
    
    /**
     * This toString method will return a string representation of the LocationMenu class object.
     * This method utilizes the "strong.format" skill to make the menu look more organized in a column
     * format that is spaced out, legible and appealing.
     * @return a string which outputs all the instances variable values for the LocationMenu class. 
     * @author Siddarath
     */
    public String toString()
    {
        String output = String.format("%-40s", "Title: " +this.getTitle()); // String.format is used to format the location menu in columns.
        output += String.format("%-30s", "Location: " +this.getLocationType());
        output += String.format("%-20s", "Rating: " +this.getRatingType());
        output += String.format("%-20s", "Vacancy: " +this.getVacancyType());
        
        return output;
    }

    /**
     * This is the abstract method inherited from the Products class. This method will
     * output a special banner graphic to make the menu more appealing.
     * @author Siddarath
     */
    @Override
    public void menuBanner() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  Hotel Locations menu");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

}
