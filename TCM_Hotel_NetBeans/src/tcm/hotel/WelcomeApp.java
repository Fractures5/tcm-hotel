package tcm.hotel;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the WelcomeApp class, which is the main class
 * from where the system will run and the main method is included.
 * When run, the class displays a welcoming message and the menu options
 * of the booking system to the user, then asking for an input of which 
 * section the user would like to go to. Whichever option the user chooses,
 * the code specific to that section in the if-else loop we have will operate
 * and run, and take the user to the section they want and provide them the information
 * they need to advance. The class, depending on the user input, will direct and output
 * the guest booking page, the FAQ and About us section or the Admin class, and for those
 * instances, objects of the classes are created to access their methods and run the functionality
 * of that class as intended (i.e Select rooms and options for guest booking page, etc).
 */

/**
 *
 * @author faaris
 */
public class WelcomeApp implements WelcomeAppInterface
{
    Scanner scan = new Scanner(System.in);
    
    /*Crete an object of the classes needed to access thier methods*/
    static GraphicsClass graphics = new GraphicsClass(); 
    static WelcomeApp guest = new WelcomeApp();
    FileInputOutput fileManager = new FileInputOutput();
    StaffMember staffMessage = new StaffMember();
    Guest guestMessage = new Guest();
    GuestMenu app = new GuestMenu();
    
    
    public void userSelection(String userInput) throws ParseException, IOException
    {
        double userOption = 0.0;
        boolean loop = false;
         
        while(!loop) //Use a While to keep program running until the correct input is used to access another section or the user prompts to exit the loop and leave the program
        {
            try
            {
                System.out.print("\nWhere would you like to go?: ");
                userInput = scan.nextLine();
                
                if(userInput.equals("x")) //Matches to see if the user input is equal to the character "x"
                {
                    System.out.println("\nWe hope to see you soon. Thank you and Goodbye.");
                    loop = true; //Make the value which is running the loop true, which will exit the loop and end the program
                }
                else
                {
                    userOption = Double.parseDouble(userInput); //Convert and Parse the string variable input to a Double if the input is not a letter or "x"
                    
                    if(userOption == 1)
                    {
                        //Using the created class objects to access the methods of the class
                        guestMessage.personalizedMessage();
                        app.chooseDates();
                        app.chooseLocation();
                        app.chooseRooms();
                        app.chooseGuestTypes();
                        app.chooseHotelFeatures();
                        double totalPrice = app.totalBookingCost();
                        
                        guest.confirmBooking();
                        
                        GuestForm form = new GuestForm();
                        ArrayList<Guest> guestList = form.fetchGuestDetails();
                        app.addBookingToFile(totalPrice, guestList);
                        app.bookingConfirmation(totalPrice, guestList);
                        graphics.exitUserBooking();
                        graphics.displayOptions();
                    }
                    else if(userOption == 2)
                    {
                        fileManager.addTextToFAQ();
                        graphics.displayOptions();
                    }
                    else if(userOption == 3)
                    {
                        fileManager.aboutUsSection();
                        graphics.displayOptions();
                    }
                    else if(userOption == 4)
                    {
                        staffMessage.personalizedMessage();
                        Admin admin = new Admin();
                        admin.getStaffDetails();
                        graphics.exitAdminPage();
                        graphics.displayOptions();
                    }
                    else if (userOption < 1 || userOption > 4)
                    {
                        System.err.println("This is not an applicable input."); //Displays an error message if the input is not within the boundaries of input the program provides
                        graphics.displayOptions(); //Call the object of the graphics class to display the method to show the menu options again
                    }
                }
            }
            catch (NumberFormatException e)
            {
                System.err.println("This is an invalid input.");
                graphics.displayOptions();
            } 
        }
    }

    public void confirmBooking() throws IOException
    {
        char userExit = '?';
        boolean loop = false;

        while(!loop)
        {
            System.out.println("Do you want to confirm your booking (y) or exit the program (x)? ");
            userExit = scan.next().charAt(0); //Store the user input of the next character they enter into the console 

            if (userExit == 'y' || userExit == 'Y') { 
                loop = true; //If the user enters one of these correct values in the expression, the loop will end.
            } else if (userExit == 'x' || userExit == 'X') { //If the user enter one of these correct values, the program will end.
                System.out.println("Thank you and Goodbye.");
                System.exit(0); //End program run time
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
    
    public static void main(String[] args) throws ParseException, IOException 
    {
        String userChoice = "";
        boolean systemRun = false;

        graphics.welcomeMessage(); //Calls the object of the graphics class, and uses the dot operator to access the welcome message and menu options
        graphics.displayOptions();
        
        while(!systemRun)
        {
            WelcomeApp storeOptions = new WelcomeApp();
            storeOptions.userSelection(userChoice); //Object of this class is created, and uses the dot operator to access the user selection method, while passing the String variable as a parameter
            systemRun = true;
        }
    }
}
