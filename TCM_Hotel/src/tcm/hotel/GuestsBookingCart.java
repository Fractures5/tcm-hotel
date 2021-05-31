/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * This class manages what bookings and purchases the guest makes.
 * This class a child class which inherits properties and behaviors like
 * methods/constructors from its parent class Products. This class contains 
 * the specific constructors for each type of guest sub menu such as the hotel
 * locations, rooms, guest type and rooms menus and it includes the required 
 * instances variables to initialize the GuestsBookingCart. This class also
 * outputs the array lists of each booking product the guest selects along with
 * its banner to make it look legible. Additionally it also calculates the total
 * cost of the hotel booking.
 * @author Siddarath
 */
public class GuestsBookingCart extends Products{    
    
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public GuestsBookingCart()
    {
    }
    
    /**
     * This is a constructor for the GuestsBookingCart class which contains input for specific variables like
     * title, location types, rating types and vacancy types that will be used in this class to initialize the GuestsBookingCart objects
     * and create the array lists which shows the hotel locations menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the GuestsBookingCart objects.
     * @param title the parameter represents the title of selection, in this case it would be the hotel location name.
     * @param locationType the parameter represents the location type of the hotel.
     * @param ratingType the parameter represents the rating type of the hotel.
     * @param vacancyType the parameter represents the vacancy type status of the hotel. 
     * @author Siddarath
     */
    public GuestsBookingCart(String title, LocationType locationType, RatingType ratingType, VacancyType vacancyType)
    {
        super(title, locationType, ratingType, vacancyType);
    }
    
    /**
     * This is a constructor for the GuestsBookingCart class which contains input for specific variables like
     * title, room types, price and availability type amount that will be used in this class to initialize the GuestsBookingCart objects
     * and create the array lists which shows the rooms available menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the GuestsBookingCart objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the room selected.
     * @param roomType the parameter represents the enumerated type RoomType which holds the different types of rooms the guests can book.
     * @param price the parameter in this constructor represents the price of the type of rooms selected by the guest.
     * @param availabilityType the parameter represents the enumerated type AvailabilityType which holds the number of rooms available to the specific room type.
     * @author Siddarath 
     */
    public GuestsBookingCart(String title, RoomType roomType, Double price)
    {
        super(title, roomType, price);
    }
    
    /**
     * This is a constructor for the GuestsBookingCart class which contains input for specific variables like
     * title, guest types and price that will be used in this class to initialize the GuestsBookingCart objects
     * and create the array lists which shows the guests type menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the GuestsBookingCart objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the chosen guest type.
     * @param guestType the parameter represents the enumerated type GuestType which holds the different types of guests that be can booked.
     * @param price the parameter in this constructor represents the price of the type of guest selected to be booked. 
     * @author Siddarath
     */
    public GuestsBookingCart(String title, GuestType guestType, Double price)
    {
        super(title, guestType, price);
    }
    
    /**
     * This is a constructor for the GuestsBookingCart class which contains input for specific variables like
     * title, feature types and price that will be used in this class to initialize the GuestsBookingCart objects
     * and create the array lists which shows the features menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the GuestsBookingCart objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the extra feature selected.
     * @param featureType the parameter represents the enumerated type FeatureType which holds the different types of extra hotel features.
     * @param price the parameter in this constructor represents the price of the selected extra feature pass.
     * @author Siddarath
     */
    public GuestsBookingCart(String title, ExtraFeatureTypes featureType, Double price)
    {
        super(title, featureType, price);
    }
    
    /**
     * This is a constructor for the GuestsBookingCart class which contains input for specific variables 
     * that will only be used for the check in and out in the guest booking cart to initialize the GuestsBookingCart objects.
     * @param checkInDate the parameter represents the check in day of the guest.
     * @param checkInMonth the parameter represents the check out month of the guest.
     * @param checkInYear the parameter represents the check out year of the guest.
     * @param checkOutDate the parameter represents the check out day of the guest.
     * @param checkOutMonth the parameter represents the check out month of the guest.
     * @param checkOutYear the parameter represents the check out year of the guest.
     * @author Siddarath 
     */
    public GuestsBookingCart(int checkInDate, String checkInMonth, int checkInYear, int checkOutDate, String checkOutMonth, int checkOutYear)
    {
        super(checkInDate, checkInMonth, checkInYear, checkOutDate, checkOutMonth, checkOutYear);
    }
    
    /**
     * This method will output the current check in and check out dates.
     * @param products the parameter that represents an array list of the GuestsBookingCart class. It will be used to extract and display information about the booked check in/out dates.
     * @author Siddarath
     */
    public void currentBookingDates(ArrayList<GuestsBookingCart> products)
    {
        GuestsBookingCart cartTitle = new GuestsBookingCart();
        cartTitle.menuBanner();
        
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println("Check in date: " +bookingDetails.getCheckInDay()+ "/" +bookingDetails.getCheckInMonth()+ "/" +bookingDetails.getCheckInYear());
            System.out.println("Check out date: " +bookingDetails.getCheckOutDay()+ "/" +bookingDetails.getCheckOutMonth()+ "/" +bookingDetails.getCheckOutYear() + "\n");
        }
        
    }
    
    /**
     * This method will output the current location of the hotel that the user booked.
     * @param products the parameter that represents an array list of the GuestsBookingCart class. It will be used to extract and display information about the booked hotel location.
     * @author Siddarath
     */
    public void currentLocationBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println("Title: " + bookingDetails.getTitle() + "  Location: " +bookingDetails.getLocationType()+ "                Rating: " +bookingDetails.getRatingType() + "             Vacancy: " +bookingDetails.getVacancyType());
        }
    }
    
    /**
     * This method will output the current rooms the guest has booked at the particular hotel location.
     * @param products the parameter that represents an array list of the GuestsBookingCart class. It will be used to extract and display information about the booked rooms.
     * @author Siddarath
     */
    public void currentRoomBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println(String.format("%-30s", "Title: " + bookingDetails.getTitle())+ String.format("%-30s", "Room Type: " + bookingDetails.getRoomType()) + String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
            
        }
    }
    
    /**
     * This method will output the current booking for the type of guest that will be staying at the hotel.
     * @param products the parameter that represents an array list of the GuestsBookingCart class. It will be used to extract and display information about the booked guest types.
     * @author Siddarath
     */
    public void currentCustomerBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle()) + String.format("%-30s", "Guest Type: " + bookingDetails.getGuestType()) + String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }
    }
    
    /**
     * This method will output the current booking for the type of extra features the guest has selected.
     * @param products the parameter that represents an array list of the GuestsBookingCart class. It will be used to extract and display information about the booked features.
     * @author Siddarath
     */
    public void currentFeatureBookings(ArrayList<GuestsBookingCart> products)
    {
        for (GuestsBookingCart bookingDetails : products)
        {
            System.out.println(String.format("%-59s", "Title: " + bookingDetails.getTitle())+ String.format("%-30s", "Feature Type: " + bookingDetails.getFeatureType())+ String.format("%-25s", "Price: $" + bookingDetails.getPrice()));
        }
    }
    
    /**
     * This method uses the parameters to calculate the total cost of the guests hotel booking. 
     * The total price is comprised of the total cost of the rooms booked, types of guests selected
     * and the extra features selected if any. The method returns the total price to the guestMenu class
     * where it is then used to be added to the current cart booking output and the file input output files
     * for the receipt once the user has paid.
     * @param rooms products the parameter that represents an array list of the GuestsBookingCart class. It will be used to get the prices of booked rooms.
     * @param guestType products the parameter that represents an array list of the GuestsBookingCart class. It will be used to get the prices of the selected guest types.
     * @param features products the parameter that represents an array list of the GuestsBookingCart class. It will be used to get the prices of the features selected.
     * @return totalPrice the parameter which represents the total price for the confirmed booking for the guest.
     * @author Siddarath
     */
    public double totalCost(ArrayList<GuestsBookingCart> rooms, ArrayList<GuestsBookingCart> guestType,  ArrayList<GuestsBookingCart> features)
    {
        double totalPrice = 0.0;
        for(int i = 0; i < rooms.size(); i++)
        {
            totalPrice += rooms.get(i).getPrice();
        }
        
        for(int i = 0; i < guestType.size(); i++)
        {
            totalPrice += guestType.get(i).getPrice();
        }
        
        for(int i = 0; i < features.size(); i++)
        {
            totalPrice += features.get(i).getPrice();
        }
        
        return totalPrice;
    }

    /**
     * This is the abstract method inherited from the Products class. This method will
     * output a special banner graphic to make the current bookings heading more appealing.
     * @author Siddarath
     */
    @Override
    public void menuBanner() {
        System.out.println("====================================================================================================================================");
        System.out.println("                                                     Your Current booking!                                                       ");
        System.out.println("====================================================================================================================================");
    }
}