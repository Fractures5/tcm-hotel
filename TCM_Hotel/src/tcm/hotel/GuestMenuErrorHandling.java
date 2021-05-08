/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used by the guest menu class in methods to 
 * provide error handling to user input, in order to make sure
 * the user provides a valid answer to the question. This class
 * contains methods which handle specific errors.
 * @author Siddarath
 */
public class GuestMenuErrorHandling 
{
    
    Scanner scan = new Scanner(System.in);
    
    /**
     * This method asks the user the number of rooms they would like to
     * book and using that inputs decides if the users input is valid or not.
     * If the user inputs a symbol/letters, numbers over 10 and below 1, and if
     * the number of rooms they want is unavailable then they will be prompted
     * and error message and asked to enter another input.
     * @param roomsMenu the parameter represent the array list contains the rooms available menu.
     * @return addNRooms the integer which contains a valid number of rooms the user can book.
     * @author Siddarath
     */
    public int maxGuestRooms(ArrayList<RoomMenu> roomsMenu)
    {
        boolean finished = false;
        int roomsAvail, addNRooms = 0;
        while (!finished)
        {
            try
            {
                System.out.print("\nPlease enter the number of rooms you want to book: ");
                addNRooms = scan.nextInt();
                if (addNRooms >0 && addNRooms < 11)
                {
                    // roomsAvail contains total number of rooms available to book at that hotel.
                    roomsAvail = roomsMenu.get(0).getAvailabilityType().getCount() + roomsMenu.get(1).getAvailabilityType().getCount()+roomsMenu.get(2).getAvailabilityType().getCount()
                            +roomsMenu.get(3).getAvailabilityType().getCount() + roomsMenu.get(4).getAvailabilityType().getCount() + roomsMenu.get(5).getAvailabilityType().getCount();
                    
                    if(addNRooms <= roomsAvail) // If the number of rooms the user wants to book is less than the available rooms then the users input is valid.
                    {
                        finished = true;
                    }
                    else // If the number of rooms the user wants to book is more than the available rooms then the users input is invalid. The user will be prompted again for a valid response.
                    {
                        System.out.println("Sorry the number of rooms you want is unavailable. Please choose a lower number of rooms to enter!");
                    }  
                }
                else
                {
                    System.err.println("Invalid selection, a user only can book upto 10 rooms at a time.");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return addNRooms;
    }
    
    /**
     * This method asks the user how much people will be staying
     * at the hotel. Based on the users response, if they enter an invalid
     * input such as letters/symbols, numbers below 1 and over 20 then
     * they will be shown an error message and prompted to enter again.
     * @return guestCount the integer which contains a valid number of guests that will be booked.
     * @author Siddarath
     */
    public int maxGuestsCount()
    {
        boolean finished = false;
        int guestCount = 0;
        while (!finished)
        {
            try
            {
                System.out.print("How much people will be staying at the hotel? ");
                guestCount = scan.nextInt();
                
                if (guestCount >0 && guestCount < 21)
                {
                    finished = true;
                }
                else
                {
                    System.err.println("Invalid selection, a user only can book upto 20 guests at a time.");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return guestCount;
    }
    
    /**
     * This method asks the user the number of features they would like and
     * based on the users responses determine if its valid or not. If the user 
     * inputs a letter/symbol or number below 0 and over 3 then they will be 
     * shown an error message and prompted to choose again.
     * @return addNfeatures the integer which contains a valid number of features a user can book.
     * @author Siddarath
     */
    public int maxGuestFeatures()
    {
        boolean finished = false;
        int addNFeatures = 0;
        while (!finished)
        {
            try
            {
                System.out.print("\nHow many features will you like? "); 
                addNFeatures = scan.nextInt();
                
                if (addNFeatures >=1 && addNFeatures <=3)
                {
                    finished = true;
                }
                else if(addNFeatures == 0)
                {
                    finished = true;
                    addNFeatures = 10;
                }
                else
                {
                    System.err.println("Invalid selection, a user only can book upto 3 feature passes at a time.");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return addNFeatures;
    }
    
    /**
     * This method will check if the user enters a valid month.
     * If the user doesn't they will be shown an error message and
     * prompted to enter again.
     * @return checkInOutMonth the integer which holds valid month the user wants to check in/out.
     * @author Siddarath
     */
    public int checkMonth()
    {
        boolean finished = false;
        int checkInOutMonth = 0;
        while (!finished)
        {
            try
            {
                System.out.print("Enter choice here: ");
                checkInOutMonth = scan.nextInt();
                
                if (checkInOutMonth >=1 && checkInOutMonth <=12)
                {
                    finished = true;
                }
                else
                {
                    System.err.println("Month does not exist. Date must be within 1 to 12. Please try again.");
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return checkInOutMonth;
    }
    
    /**
     * This method will check if the user enters a correct check 
     * in/ check out date. If the users an invalid input such as letters,
     * invalid date in the month, symbols etc, then the user will be shown an
     * error message and prompted to enter again.
     * @param monthSelected the integer which holds the month the guest wants to check in/out. It is used to determine if a user selects a valid date in that month.
     * @return checkInOutDate the integer which hold the users valid input of the check in/check out date.
     * @author Siddarath
     */
    public int checkDate(int monthSelected)
    {
        boolean finished = false;
        int checkInOutDate = 0;
        while (!finished)
        {
            try
            {
                System.out.print("Enter choice here: ");
                checkInOutDate = scan.nextInt();
                
                if (checkInOutDate >=1 && checkInOutDate <=31) //Checks if the user enters a valid day
                { 
                    if ((monthSelected == 1 || monthSelected == 3 || monthSelected == 5 || monthSelected == 7 
                            || monthSelected == 8 || monthSelected == 10 || monthSelected == 12) && checkInOutDate <= 31) // If the user selected a month with 31 days, it checks if the day they selected is within the range. 
                    {
                        finished = true;
                    }
                    else if ((monthSelected == 4 || monthSelected == 6 || monthSelected == 9 || monthSelected == 11) && checkInOutDate <= 30) // If the user selected a month with 30 days, it checks if the day they selected is within the range.
                    {
                        finished = true;
                    }
                    else if (monthSelected == 2 && checkInOutDate <= 28) // If the user selected a month with 28 days, it checks if the day they selected is within the range.
                    {
                        finished = true;
                    }
                    else 
                    {
                        System.err.println("The day you selected is not valid for that month. Please try again!");
                    }
                    
                }
                else
                {
                    System.err.println("Date does not exist. Date must be within 1 to 31.");
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return checkInOutDate;
    }
    
    /**
     * This method will check if the user enter a valid check in/check out
     * year. If the user selects an invalid year range, letters and symbols then
     * the user will be shown an error message and be prompted to enter again.
     * @return checkInOutYear the integer will hold a valid check in and out year.
     * @author Siddarath
     */
    public int checkYear()
    {
        boolean finished = false;
        int checkInOutYear = 0;
        while (!finished)
        {
            try
            {
                System.out.print("Enter choice here: ");
                checkInOutYear = scan.nextInt();
                
                if (checkInOutYear >= 2021 && checkInOutYear <= 2023)
                {
                    finished = true;
                }
                else
                {
                    System.err.println("Invalid year selection. Year must between 2021 - 2023.");
                    scan.nextLine();
                }
            }
            catch(InputMismatchException message)
            {
                System.err.println("Invalid input! Please try again.");
                scan.nextLine();
            }
        }
        return checkInOutYear;
    }
    
    /**
     * This method will be used to compare the check in dates with the check out dates
     * to make sure its valid. It will be valid when the check in dates occur before the
     * check out dates. Depending if it is valid or not a true or false result will returned to 
     * the guest menu where it will decide the user has to renter their check in dates or
     * if they will proceed to booking a hotel location.
     * @param checkInDay the parameter represents the check in day of the guest.
     * @param checkInMonth the parameter represents the check out month of the guest.
     * @param checkInYear the parameter represents the check out year of the guest.
     * @param checkOutDay the parameter represents the check out day of the guest.
     * @param checkOutMonth the parameter represents the check out month of the guest.
     * @param checkOutYear the parameter represents the check out year of the guest.
     * @return valid a boolean holding either true of false to determine the next step of the program.
     * @author Siddarath
     * @throws ParseException 
     */
    public boolean compareDates(int checkInDay, int checkInMonth, int checkInYear, int checkOutDay, int checkOutMonth, int checkOutYear) throws ParseException
    {
        boolean valid = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Uses an object of the sdf SimpleDateFormat class to create a date format.
        Date d1 = sdf.parse(String.valueOf(checkInDay)+ "/" +String.valueOf(checkInMonth) +"/" +String.valueOf(checkInYear)); // Uses an object of the Date and SimpleDateFormat class to store the dates.
        Date d2 = sdf.parse(String.valueOf(checkOutDay)+ "/" +String.valueOf(checkOutMonth) +"/" +String.valueOf(checkOutYear));
        System.out.println("\nCheck IN: " +sdf.format(d1));
        System.out.println("Check OUT: " +sdf.format(d2));
        if(d1.compareTo(d2) >0) // Checks if the check in date happens after the check out date
        {
            System.out.println("Check in occurs after check out");
            valid = false;
        }
        else if(d1.compareTo(d2) < 0) // Checks if the check in date happens before the check out date
        {
            System.out.println("Check in occurs before check out");
            valid = true;
        }
        else if(d1.compareTo(d2) == 0 ) // Checks if the check in date is equal to the check out date
        {
            System.out.println("Both dates are equal");
            valid = false;
        }
        
        return valid;
    }
}

