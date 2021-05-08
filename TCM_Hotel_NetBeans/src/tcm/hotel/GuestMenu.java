/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class operates and controls the guests booking and interaction. This class
 * contains methods that will ask the user their check in and out dates, show the 
 * hotel location, rooms available, guest types available and extra features menu. Once
 * the user is shown the menu they will be prompted to enter their choices which is all
 * error handled so the user once entering an invalid input for the particular question
 * will be advised of the error and prompted to enter again.
 * @author Siddarath
 */
public class GuestMenu implements GuestMenuSelections
{
    Scanner scan = new Scanner(System.in);
    ArrayList<GuestsBookingCart> bookingDates = new ArrayList<>(); // Stored each users valid selections into an arraylist for easier accessbility and data control ability. This applies to the array list objects created below.
    ArrayList<GuestsBookingCart> bookingLocation = new ArrayList<>();
    ArrayList<GuestsBookingCart> bookingRoom = new ArrayList<>();
    ArrayList<GuestsBookingCart> bookingGuests = new ArrayList<>();
    ArrayList<GuestsBookingCart> bookingFeatures = new ArrayList<>();
    GuestMenuErrorHandling checkValidity = new GuestMenuErrorHandling(); // An object of guest menus error handling class. This object will be used to help check against the users inputs.
    GuestsBookingCart booking = new GuestsBookingCart();
    
    /**
     * This class will output the booking dates menu and it will ask the user to 
     * provide an answer to what check in/out day, month and year they want. If the user enters
     * an invalid input it will handle the input and ask the user to enter again. 
     * If the user successfully provides a valid date, the date will be added to the 
     * users booking cart.
     * @author Siddarath
     * @throws ParseException 
     */
    public void chooseDates() throws ParseException
    {
        int checkInDay, checkInMonth, checkInYear;
        int checkOutDay, checkOutMonth, checkOutYear;
        boolean valid = false;
                
        while(!valid) // Repeats proccess until the user selects a valid date.
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                     Booking dates menu        ");
            System.out.println("-------------------------------------------------------------------\n");

            System.out.println("What is your check in month (1-12 (Jan - Dec))? ");
            checkInMonth = checkValidity.checkMonth(); // Calls a method from the GuestMenuErrorHandling class to get input and check if it is valid.

            System.out.println("\nWhat is your check in date (1-31 for the respective month)? ");
            checkInDay = checkValidity.checkDate(checkInMonth);

            System.out.println("\nWhat is your check in year (Between 2021 and 2023)? ");
            checkInYear = checkValidity.checkYear();

            System.out.println("\nWhat is your check out month (1-12 (Jan - Dec))? ");
            checkOutMonth = checkValidity.checkMonth();

            System.out.println("\nWhat is your check out date (1-31 for the respective month)? ");
            checkOutDay = checkValidity.checkDate(checkOutMonth);

            System.out.println("\nWhat is your check out year (Between 2021 and 2023)? ");
            checkOutYear = checkValidity.checkYear();

            valid = checkValidity.compareDates(checkInDay, checkInMonth, checkInYear, checkOutDay, checkOutMonth, checkOutYear); // Checks if the check in and out dates are valid.
            if (valid == true) // If the check in and out dates are valid the program proceeds and adds the details to the booking cart.
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(checkInDay, checkInMonth, checkInYear, checkOutDay, checkOutMonth, checkOutYear);
                bookingDates.add(bookingDetails);
                bookingDetails.currentBookingDates(bookingDates); // Calls the method where it will output the current booked dates by the user.
            }
            else 
            {
                System.out.println("\nUnfortunately the check in date needs to be before the check out date. Please try entering again!\n");
            }
        }    
    }
    
    /**
     * This class shows the available locations menu and asks the user to enter
     * the hotel they would like to book. If the user selects a booked out hotel location
     * they are prompted to enter again, likewise if they enter an option that is not on the menu
     * they are asked to enter again. Once the user selects a valid hotel location it is added to 
     * their booking cart.
     * @author Siddarath
     */
    public void chooseLocation()
    {
        boolean finished = false;
        int chosenLocation = 0;
        
        ArrayList<LocationMenu> locationsMenu = LocationMenu.showMenu(); // Outputs the hotel location menu
        
        while (!finished)
        {
            try // Using try and catch blocks to handle exception errors throughout the class/program.
            {
                System.out.print("\nPlease enter the location number (shown to the left) of the hotel you would like to book/view: ");
                chosenLocation = scan.nextInt();
                
                if (chosenLocation >=0 && chosenLocation <=7)
                {
                    if(locationsMenu.get(chosenLocation).getVacancyType().equals(locationsMenu.get(chosenLocation).getVacancyType().NO))
                    {
                        System.out.println("Sorry the location you choose is fully booked. Please choose another location!");
                    }
                    else
                    {
                        GuestsBookingCart bookingDetails = new GuestsBookingCart(locationsMenu.get(chosenLocation).getTitle(), locationsMenu.get(chosenLocation).getLocationType(),locationsMenu.get(chosenLocation).getRatingType(), locationsMenu.get(chosenLocation).getVacancyType()); // Creates an object and initializes it with the chosen hotel details.
                        bookingLocation.add(bookingDetails); // This adds the selected hotel location to the guest booking cart.
                        finished = true;
                        System.out.println("");
                        bookingDetails.currentBookingDates(bookingDates); // Calls the method where it will output the current booked dates by the user.
                        bookingDetails.currentLocationBookings(bookingLocation); // Calls the method where it will output the current booked hotel location by the user.
                    }   
                }
                else
                {
                    System.err.println("Invalid selection, the location number does not have a hotel! Please try again."); // Shows the error message to the console for the user to see.
                    scan.nextLine(); // Flushes the input buffer.
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again."); // Shows the error message to the console for the user to see.
                scan.nextLine(); // Flushes the input buffer.
            }
        }
    }
    
    /**
     * This method will show the user the rooms available menu and ask 
     * the user to enter the number of rooms they want to book along
     * with the specific room they would like to book. This process is 
     * is backed up with the error handling process so if the guest provides
     * an invalid response they are notified and are prompted to enter again.
     * Once the user enters their valid choices, their rooms are added to their
     * booking cart.
     * @author Siddarath
     */
    public void chooseRooms()
    {
        int addNRooms, roomChoice, count = 0;
        
        ArrayList<RoomMenu> roomsMenu = RoomMenu.showMenu(); // Outputs the rooms available menu
        addNRooms = checkValidity.maxGuestRooms(roomsMenu); // Calls a method from the GuestMenuErrorHandling class to get input of number of rooms to book and check if it is valid.
        
        while(count < addNRooms)
        {
            try
            {
                RoomMenu.showMenu();
                System.out.print("\nPlease enter the corresponding number of the type of room you would like: ");
                roomChoice = scan.nextInt();
                
                if (roomChoice >= 0 && roomChoice <=5)
                {
                    if (roomsMenu.get(roomChoice).getAvailabilityType().getCount() == 0) // If the chosen room has no available rooms left then the user is prompted to choose again.
                    {
                        System.out.println("This specific type of room is unfortunately all booked out. Please choose another room!");    
                    }  
                    else
                    {
                        GuestsBookingCart bookingDetails = new GuestsBookingCart(roomsMenu.get(roomChoice).getTitle(), roomsMenu.get(roomChoice).getRoomType(), roomsMenu.get(roomChoice).getPrice(), roomsMenu.get(roomChoice).getAvailabilityType()); // Creates an object and initializes it with the chosen hotel rooms details.
                        bookingRoom.add(bookingDetails); // This adds the selected hotel room to the guest booking cart.
                        count++;
                        System.out.println("Added to cart! \n");
                        bookingDetails.currentBookingDates(bookingDates);
                        bookingDetails.currentLocationBookings(bookingLocation);
                        bookingDetails.currentRoomBookings(bookingRoom);
                        System.out.println("\nRooms left to add: " +(addNRooms - count)+  "\n");
                        roomsMenu.get(roomChoice).getAvailabilityType().setCount(((roomsMenu.get(roomChoice).getAvailabilityType().getCount())-1)); // Subtracts the current chosen rooms availability by 1.
                    } 
                }
                else
                {
                    System.err.println("Invalid room choice. Does not exist! Please try again.\n");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.\n");
                scan.nextLine();
            }
        }
    }
    
    /**
     * This method will show the user the guest types available to book menu and 
     * ask the user to enter the number of guests they want to book along
     * with the specific guest type they would like to book. This process is 
     * is backed up with the error handling process so if the guest provides
     * an invalid response they are notified and are prompted to enter again.
     * Once the user enters their valid choices, their guest types are added to their
     * booking cart.
     * @author Siddarath 
     */
    public void chooseGuestTypes()
    {
        int addNGuests = 0;
        int guestType = 0;
        int count = 0;
        
        addNGuests = checkValidity.maxGuestsCount(); // Calls a method from the GuestMenuErrorHandling class to get input for the number of guest to book and to check if it is valid.
        
        while(count < addNGuests)
        {
            try
            {
                ArrayList<GuestsTypeMenu> guestTypeMenu = GuestsTypeMenu.showMenu(); // Outputs the guest type menu
                System.out.print("\nEnter the number represented for the guest type that will stay: ");
                guestType = scan.nextInt();
                
                if (guestType >= 0 && guestType <= 4)
                {
                    GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(guestType).getTitle(), guestTypeMenu.get(guestType).getGuestType(), guestTypeMenu.get(guestType).getPrice()); // Creates an object and initializes it with the chosen guest type details.
                    bookingGuests.add(bookingDetails); // This adds the selected guest type to the guest booking cart.
                    count++;
                    System.out.println("\nAdded to cart! \n");
                    bookingDetails.currentBookingDates(bookingDates);
                    bookingDetails.currentLocationBookings(bookingLocation);
                    bookingDetails.currentRoomBookings(bookingRoom);
                    bookingDetails.currentCustomerBookings(bookingGuests);
                    System.out.println("\nGuests left to add: " +(addNGuests - count)+ "\n");
                }
                else
                {
                    System.err.println("Invalid selection. Does not exist! Please try again.");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        } 
    }
    
    /**
     * This method will show the user the hotel features menu and ask 
     * the user to enter the number of features they want to book along
     * with the specific feature they would like to book. This process is 
     * is backed up with the error handling process so if the guest provides
     * an invalid response they are notified and are prompted to enter again.
     * Once the user enters their valid choices, their features are added to their
     * booking cart.
     * @author Siddarath
     */
    public void chooseHotelFeatures()
    {
        ArrayList<FeaturesMenu> featuresMenu = FeaturesMenu.showMenu(); // Outputs the extra features menu
        int addNfeatures, featuresChoice, count = 0;
        addNfeatures = checkValidity.maxGuestFeatures(); // Calls a method from the GuestMenuErrorHandling class to get input on the number of features to add and to check if it is valid.
        
        if (addNfeatures == 10) // When user chooses to have 0 features then do the following which just outputs the current booking details of the user.
        {
            GuestsBookingCart bookingDetails = new GuestsBookingCart();
            System.out.println("");
            bookingDetails.currentBookingDates(bookingDates);
            bookingDetails.currentLocationBookings(bookingLocation);
            bookingDetails.currentRoomBookings(bookingRoom);
            bookingDetails.currentCustomerBookings(bookingGuests);
            bookingDetails.currentFeatureBookings(bookingFeatures);
        }
        else
        {
           while(count < addNfeatures)
            {
                try
                {
                    System.out.print("\nPlease enter the extra feature (represented by the number) you would like: ");
                    featuresChoice = scan.nextInt();

                    if(featuresChoice >= 0 && featuresChoice <= 3)
                    {
                        GuestsBookingCart bookingDetails = new GuestsBookingCart(featuresMenu.get(featuresChoice).getTitle(), featuresMenu.get(featuresChoice).getFeatureType(), featuresMenu.get(featuresChoice).getPrice()); // Creates an object and initializes it with the chosen extra feature details.
                        bookingFeatures.add(bookingDetails); // This adds the selected hotel feature to the guest booking cart.
                        count++;
                        System.out.println("Added to cart!");
                        System.out.println("Features left to add: " +(addNfeatures - count)+ "\n");
                        bookingDetails.currentBookingDates(bookingDates);
                        bookingDetails.currentLocationBookings(bookingLocation);
                        bookingDetails.currentRoomBookings(bookingRoom);
                        bookingDetails.currentCustomerBookings(bookingGuests);
                        bookingDetails.currentFeatureBookings(bookingFeatures);
                    }
                    else
                    {
                        System.err.println("Invalid selection. Does not exist! Please try again.");
                        scan.nextLine();  
                    }
                }
                catch(InputMismatchException message)
                {
                    System.err.println("Invalid input! Please try again.");
                    scan.nextLine();
                }
            } 
        }    
    }
    
    /**
     * This class will use the FileInputOutput class to add the guests
     * booking to a bookings text file.
     * @param totalPrice the parameter represents the total price of the users booking.
     * @param guestList the parameter represents an array list object of the Guest class which contains details of the guest who has booked.
     * @author Siddarath
     */
    public void addBookingToFile(double totalPrice, ArrayList<Guest> guestList) {
        FileInputOutput writeFile = new FileInputOutput();
        writeFile.addGuestBooking(bookingDates, bookingLocation, bookingRoom, bookingGuests, bookingFeatures, totalPrice, guestList);
    }

    /**
     * This class will use the FileInputOutput class to add the guests
     * booking details to the booking confirmation text file which essentially
     * acts like a receipt. Inside this method a method "guestConfirmation" will be
     * called from the FileInputOutput class where it will display the contents from
     * the receipt text file to console for the user to see.
     * @param totalPrice the parameter represents the total price of the users booking.
     * @param guestList the parameter represents an array list object of the Guest class which contains details of the guest who has booked.
     * @author Siddarath
     * @throws IOException 
     */
    public void bookingConfirmation(double totalPrice, ArrayList<Guest> guestList) throws IOException{
        FileInputOutput writeFile = new FileInputOutput();
        writeFile.guestConfirmation(bookingDates, bookingLocation, bookingRoom, bookingGuests, bookingFeatures, totalPrice, guestList);
    }
   
    /**
     * This method will retrieve the calculated total cost of the booking and output
     * it to at the end of the current booking done for the user.
     * @return totalCost the parameter represents the total cost of the guests booking.
     * @author Siddarath
     */
    public double totalBookingCost()
    {
        double totalCost;

        totalCost = booking.totalCost(bookingRoom, bookingGuests, bookingFeatures);
        System.out.println("\nTotal Cost: $" +totalCost);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------\n");
        
        return totalCost;
    }
}
