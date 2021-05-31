/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/**
 * This is a description of the FileInputOutput Class.
 * This class will handle all of the functionality regarding
 * writing to, reading from and updating java ".txt" files.
 * 
 * @author Anuk/Siddarath/Faaris
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anuk/Siddarath/Faaris
 */
public class FileInputOutput 
{
    
    /**
     * This method is used to write text to the FAQ text 
     * file and read it to the console output
     */
    public void addTextToFAQ()
    {
        try
        { 
           PrintWriter pwFAQ = new PrintWriter(new FileOutputStream("FAQ.txt"));
           
            GraphicsClass graphicsForFAQ = new GraphicsClass(); 
            graphicsForFAQ.enterFAQ();
            graphicsForFAQ.FAQTitle();
            
            //Create a print writer which is used to add text to a text file
            pwFAQ.write("********************************************************************************************************************************************************************\n");
            pwFAQ.write("(Q): How can I make a booking for a room/s at the TCM Hotel?                                                                                                       *"
                    + "\n(A): We here at TCM offer various booking options, including our on-site service center. The preferable and easiest way to make a booking is through the TCM online*"
                    + "\n     booking system which is available 24/7. The online booking-system prompts and requests for your desired hotel branch, number of rooms and customers staying,  *"
                    + "\n     room type and any special features.                                                                                                                           *\n");
            
            pwFAQ.write("********************************************************************************************************************************************************************");
            
            pwFAQ.write("\n(Q): Do we offer any specials/discount rates for customers?                                                                                                        *"
                    + "\n(A): Yes, for children under the age of 11 pay $10 and any infants under the age of 2 are allowed free entry. Elderly customers are given a discounted price of    *"
                    + "\n     $10, and any customers who have a disability pay around $25. Regular/Adult price is set at $30.                                                               *\n");
           
            pwFAQ.write("********************************************************************************************************************************************************************");
            
            pwFAQ.write("\n(Q): Are there any special features in my room booking that I can include?                                                                                         *"
                    + "\n(A): When you have confirmed the rooms you want and the number of people that will be accommodating, you will be prompted to select one of the special features    *"
                    + "\n     that every TCM hotel branch provides such as the sauna, jacuzzi, spa, tennis-court and gym.                                                                   *\n");
            
            pwFAQ.write("********************************************************************************************************************************************************************");
            
            pwFAQ.write("\n(Q): Am I able to book a multiple rooms of different categories at once?                                                                                           *"
                    + "\n(A): Yes, the online-booking system will prompt you to enter the amount of rooms you would like to accommodate and the type for each room. However, there is a     *"
                    + "\n    limited amount of room types available, which will be indicated on 'Room Availability' tab when booking.                                                       *\n");
            
            pwFAQ.write("********************************************************************************************************************************************************************");

            pwFAQ.close();
            
            FileReader textFile = new FileReader("FAQ.txt");
            BufferedReader br = new BufferedReader(textFile);
            
            String line;
            
            while((line = br.readLine()) != null)
            {
                System.out.println(line); //Reads and prints out text from text file to console using buffered reader
            }
                    
            br.close(); //Flushes the buffer
           
            graphicsForFAQ.closingFAQ();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nSorry, there was an error opening up the FAQ file. Please try again later. \nSorry for the Inconvience");
        }
        catch (IOException e)
        {
            System.out.println("\nSorry, there was an error with the FAQ file. Please try again later. \nSorry for the Inconvience");
        }
    }
    
    /**
     * This method is used to write text to the About Us text file
     * and read it out to the console output
     */
     public void aboutUsSection()
    {
        try
        {
            PrintWriter pwAboutUs = new PrintWriter(new FileOutputStream("About Us.txt"));
            GraphicsClass graphicsForAboutUs = new GraphicsClass();
            
            graphicsForAboutUs.enterAboutUs();
            graphicsForAboutUs.aboutUsTitle();
            
            pwAboutUs.write("                                          ----------                                                     \n");
            pwAboutUs.write("                                          Our Vision                                                     \n");
            pwAboutUs.write("                                          ----------                                                       ");
            pwAboutUs.write("\n*********************************************************************************************************");
            pwAboutUs.write("\n* We here as part of the management of TCM are a group of young developers looking to give more chances *"
                    +       "\n* and oppurtunities for people to experiance the culture of the most iconic places in New Zealand.      *"
                    +       "\n* We created our own hotel brand and set up locations all over New Zealand, from Wellignton             *"
                    +       "\n* to Dunedin and back to Auckland - we aim to provide cheap places for travellers and tourists alike to *"
                    +       "\n* immerse themselves into the culture each region of New Zealand offers  various hotel branch           *"
                    +       "\n* arms. Discounts, Special Features and all at cheap price - what more could you ask for at TCM!        *");
            pwAboutUs.write("\n*********************************************************************************************************");
            
            pwAboutUs.write("\n\n                                       ----------------                                                     \n");
            pwAboutUs.write("                                       Contact Details                                                     \n");
            pwAboutUs.write("                                       ----------------                                                       ");
            pwAboutUs.write("\n**************************************************************************************************************************************");
            pwAboutUs.write("\n* If you have any further issues in regards to our company, the management or the online booking system, feel free to contact us on: *"
                    +       "\n*--------------------------------------------------------------------------------------------------------------------------------------*"
                    +       "\n*                    Email: tdv2188@autuni.ac.nz (Faaris Khan)     - Founding Manager                                                *"
                    +       "\n*                    Ph: (07) 2529423             Mob: +64 0217284610                                                                *"
                    +       "\n*--------------------------------------------------------------------------------------------------------------------------------------*"
                    +       "\n*                    Email: xdx4418@autuni.ac.nz (Siddarath Kumar) - Founding Manager                                             *"
                    +       "\n*                    Ph: (09) 3218302             Mob: +64 0275209512                                                                *"
                    +       "\n*--------------------------------------------------------------------------------------------------------------------------------------*"
                    +       "\n*                    Email: vwv9667@autuni.ac.nz (Anuk Silva)      - Founding Manager                                             *"
                    +       "\n*                    Ph: (08) 2157029             Mob: +64 0237180321                                                                *"
                    +       "\n*--------------------------------------------------------------------------------------------------------------------------------------*");
            pwAboutUs.write("\n**************************************************************************************************************************************");
            
            pwAboutUs.close();
            
            FileReader textFile = new FileReader("About Us.txt");
            BufferedReader br = new BufferedReader(textFile);
            
            String line;
            
            while((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
                    
            br.close();
           
            graphicsForAboutUs.closingAboutUs();
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nSorry, there was an error opening up the FAQ file. Please try again later. \nSorry for the Inconvience");
        }
        catch (IOException e)
        {
            System.out.println("\nSorry, there was an error with the FAQ file. Please try again later. \nSorry for the Inconvience");
        }
    }
    
     /**
      * This method appends all guests who booked(past and current) a room at the TCM hotel to a text file
      * @param bookingDates Holds the details for the check in/check out dates
      * @param bookingLocation Holds location details for the selected guest hotel
      * @param bookingRoom Holds the room-booked details selected by the guest
      * @param bookingGuests Holds the number of guests who will be staying
      * @param bookingFeatures Holds the features details of what the guest wants
      * @param totalPrice Holds the total price of the guest's booking
      * @param guestList Holds current details of the guest's who have booked at the hotel
      */
    public void addGuestBooking(ArrayList<GuestsBookingCart> bookingDates, ArrayList<GuestsBookingCart> bookingLocation, ArrayList<GuestsBookingCart> bookingRoom, ArrayList<GuestsBookingCart> bookingGuests, ArrayList<GuestsBookingCart> bookingFeatures, double totalPrice, ArrayList<Guest> guestList)
    {
        try
        {
            ArrayList<GuestsBookingCart> booking = new ArrayList<>();
            PrintWriter pw = new PrintWriter(new FileOutputStream("guestBookings.txt", true));
            
            pw.write("\n====================================================================================================================================");
            pw.write("\n                                                      " +guestList.get(0).getFirstName()+ "'s booking!                               ");
            pw.write("\n                                                      Booking ID: " +guestList.get(0).getBankAccountPin()+"                             ");
            pw.write("\n====================================================================================================================================\n");
            
            pw.write("Check in date: " +bookingDates.get(0).getCheckInDay()+ "/" +bookingDates.get(0).getCheckInMonth()+ "/" + bookingDates.get(0).getCheckInYear() + "\n");
            pw.write("Check out date: " +bookingDates.get(0).getCheckOutDay()+ "/" +bookingDates.get(0).getCheckOutMonth()+ "/" +bookingDates.get(0).getCheckOutYear() + "\n");
            pw.write("\n");
            
            pw.write(String.format("%-30s", "Title: " + bookingLocation.get(0).getTitle()) + String.format("%-30s", "  Location: " +bookingLocation.get(0).getLocationType()) + String.format("%-25s", " Rating: " +bookingLocation.get(0).getRatingType()) 
                    + String.format("%-25s", " Vacancy: " +bookingLocation.get(0).getVacancyType()) + "\n");
           
            for (int i = 0; i < bookingRoom.size(); i++)
            {
                pw.write((String.format("%-30s", "Title: " + bookingRoom.get(i).getTitle())+ String.format("%-30s", "Room Type: " + bookingRoom.get(i).getRoomType()) + 
                        String.format("%-25s", "Price: $" + bookingRoom.get(i).getPrice()) + "\n"));
                
            }
            
            for (int i = 0; i < bookingGuests.size(); i++)
            {
                pw.write(String.format("%-59s", "Title: " + bookingGuests.get(i).getTitle()) + String.format("%-30s", "Guest Type: " + bookingGuests.get(i).getGuestType()) + String.format("%-25s", "Price: $" + bookingGuests.get(i).getPrice())+ "\n");
            }
            
            for (int i = 0; i < bookingFeatures.size(); i++)
            {
                pw.write(String.format("%-59s", "Title: " + bookingFeatures.get(i).getTitle())+ String.format("%-30s", "Feature Type: " + bookingFeatures.get(i).getFeatureType())+ String.format("%-25s", "Price: $" + bookingFeatures.get(i).getPrice())+ "\n");
            }
            
            pw.write("\nTotal cost of the booking: $" +totalPrice);
            
            pw.write("\n------------------------------------------------------------------------------------------------------------------------------------\n\n");
            pw.close();  
        }
        catch(FileNotFoundException message)
        {
            System.out.println("File not found!");
        }
        catch (IOException message) 
        {
            System.out.println("Error with the file!");
        }
    }
    
     /**
      * This method holds the receipt for the current guest who's making the booking, and is showed to the guest once they confirm the booking
      * @param bookingDates Holds the details for the check in/check out dates
      * @param bookingLocation Holds location details for the selected guest hotel
      * @param bookingRoom Holds the room-booked details selected by the guest
      * @param bookingGuests Holds the number of guests who will be staying
      * @param bookingFeatures Holds the features details of what the guest wants
      * @param totalPrice Holds the total price of the guest's booking
      * @param guestList Holds current details of the guest's who have booked at the hotel
      */
    
    public void guestConfirmation(ArrayList<GuestsBookingCart> bookingDates, ArrayList<GuestsBookingCart> bookingLocation, ArrayList<GuestsBookingCart> bookingRoom, ArrayList<GuestsBookingCart> bookingGuests, ArrayList<GuestsBookingCart> bookingFeatures, double totalPrice, ArrayList<Guest> guestList) throws IOException
    {
        try
        {
            ArrayList<GuestsBookingCart> booking = new ArrayList<>();
            PrintWriter pw = new PrintWriter(new FileOutputStream("guestConfirmation.txt"));
           
            pw.write("The following is the confirmation of your booking .....\n\n");
            pw.write("\n====================================================================================================================================");
            pw.write("\n                                                  Your Booking Confirmation                                                       ");
            pw.write("\n====================================================================================================================================\n");
            pw.write(String.format("%-20s %-20s %-20s %-20s %-20s", "Guest Name", "Guest Age", "Account Number", "Phone", "Email"));
            for (Guest g : guestList) {
                pw.write(String.format("\n%-20s %-20s %-20s %-20s %-20s", guestList.get(0).getFirstName() + " " + guestList.get(0).getLastName(), guestList.get(0).getPersonAge(), guestList.get(0).getBankAccountNo(), guestList.get(0).getPersonNumber(), guestList.get(0).getPersonEmail()));
                pw.write("\n____________________________________________________________________________________________________________________________________");
            } 
            
            pw.write("\n\n====================================================================================================================================");
            pw.write("\n                                                     Your Current booking!                                                       ");
            pw.write("\n====================================================================================================================================\n");
            
            pw.write("Check in date: " +bookingDates.get(0).getCheckInDay()+ "/" +bookingDates.get(0).getCheckInMonth()+ "/" + bookingDates.get(0).getCheckInYear() + "\n");
            pw.write("Check out date: " +bookingDates.get(0).getCheckOutDay()+ "/" +bookingDates.get(0).getCheckOutMonth()+ "/" +bookingDates.get(0).getCheckOutYear() + "\n");
            pw.write("\n");
            
            pw.write(String.format("%-30s", "Title: " + bookingLocation.get(0).getTitle()) + String.format("%-30s", "  Location: " +bookingLocation.get(0).getLocationType()) + String.format("%-25s", " Rating: " +bookingLocation.get(0).getRatingType()) 
                    + String.format("%-25s", " Vacancy: " +bookingLocation.get(0).getVacancyType()) + "\n");
           
            for (int i = 0; i < bookingRoom.size(); i++)
            {
                pw.write((String.format("%-30s", "Title: " + bookingRoom.get(i).getTitle())+ String.format("%-30s", "Room Type: " + bookingRoom.get(i).getRoomType()) + 
                        String.format("%-25s", "Price: $" + bookingRoom.get(i).getPrice()) + "\n"));
                
            }
            
            for (int i = 0; i < bookingGuests.size(); i++)
            {
                pw.write(String.format("%-59s", "Title: " + bookingGuests.get(i).getTitle()) + String.format("%-30s", "Guest Type: " + bookingGuests.get(i).getGuestType()) + String.format("%-25s", "Price: $" + bookingGuests.get(i).getPrice())+ "\n");
            }
            
            for (int i = 0; i < bookingFeatures.size(); i++)
            {
                pw.write(String.format("%-59s", "Title: " + bookingFeatures.get(i).getTitle())+ String.format("%-30s", "Feature Type: " + bookingFeatures.get(i).getFeatureType())+ String.format("%-25s", "Price: $" + bookingFeatures.get(i).getPrice())+ "\n");
            }
            
            pw.write("\nPaid: Yes");
            pw.write("\nTotal cost of the booking: $" +totalPrice);
            
            pw.write("\n------------------------------------------------------------------------------------------------------------------------------------\n");
            pw.write("====================================================================================================================================\n");
            pw.close();
            
            
            FileReader reader = new FileReader("guestConfirmation.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            
        }
        catch(FileNotFoundException message)
        {
            System.out.println("File not found!");
        }
        catch (IOException message) 
        {
            System.out.println("Error with the file!");
        }
    }
    
    /**
     * The writeGuestToGuestsFile method iterates through all pairs of key-value
     * records which are the bank account number and guest's first name. With
     * every iteration of each pair it will write every pair of the bank account
     * number and the guest's first name to Guests.txt file.
     * @param guestRecords Holds the details of the guests in the system
     * @throws FileNotFoundException 
     */
    public static void writeGuestToGuestsFile(HashMap<String, String> guestRecords) throws FileNotFoundException 
    {
        PrintWriter pw = null;
        try 
        {
            pw = new PrintWriter("Guests.txt");
            for (Map.Entry<String, String> entry : guestRecords.entrySet()) 
            {
                pw.println(entry.getKey() + " " + entry.getValue());
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("file not found");
        } 
        finally 
        {
            if (pw != null) 
            {
                pw.close();
            }
        }
    }
    
    /**
     * The printGuestDetails method will print all guest objects found in the
     * ArrayList to the Guest_Details.txt file through the use of PrintWriter
     * and FileOutputStream which will work in conjunction with an enhanced for
     * loop to iterate through each object and print the data of each object to
     * the text file with an appropriate format.
     */
    public static void printGuestDetails(ArrayList<Guest> guestList)
    {
        PrintWriter pw = null;
        try 
        {
            pw = new PrintWriter(new FileOutputStream("Guest_Details.txt", true));
            pw.println(String.format("%-20s %-20s %-20s %-20s %-20s", "Guest Name", "Guest Age", "Account Number", "Phone", "Email")); //the spacing and formatting for how content will be printed into the Guest_Details txt file.
            pw.println("------------------------------------------------------------------------------------------------------");
            for (Guest g : guestList) 
            {
                pw.println(String.format("%-20s %-20s %-20s %-20s %-20s", guestList.get(0).getFirstName() + " " + guestList.get(0).getLastName(), guestList.get(0).getPersonAge(), guestList.get(0).getBankAccountNo(), guestList.get(0).getPersonNumber(), guestList.get(0).getPersonEmail()));
                pw.println("______________________________________________________________________________________________________");
            }   
            pw.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(FileInputOutput.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally 
        {
            pw.close();
        }
    }
    
    /**
     * The viewGuestsPastAndPresent will initialize a BufferedReader which will
     * read the contents of the Guest_Details.txt file which will then use a
     * while loop to print the contents of each line to the console as long as
     * it is not equal to null
     */
    public static void viewGuestsPastAndPresent() throws FileNotFoundException, IOException
    {
        
        BufferedReader in = new BufferedReader(new FileReader("Guest_Details.txt"));
        String line;
        try 
        {
            while ((line = in.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        in.close();
    }
    
    /**
     * The viewGuestsHashMap will initialize a BufferedReader which will read
     * the contents of the Guests.txt file which will then use a while loop to
     * print the contents of each line to the console as long as it is not equal
     * to null
     */
    public static void viewGuestsHashMap() throws FileNotFoundException, IOException
    {
  
        BufferedReader in = new BufferedReader(new FileReader("Guests.txt"));
        String line;
        try 
        {
            while ((line = in.readLine()) != null) 
            {
                System.out.println(line);
                System.out.println("------------------------");
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        in.close();     
    }
    
    /**
     * This method reads and views the guests booking file which has been made to the console output
     * @throws IOException 
     */
    public static void viewGuestBookings() throws IOException
    {
        try
        {
            FileReader reader = new FileReader("guestBookings.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
        catch(FileNotFoundException message)
        {
            System.err.println("Cannot read the file!");
        }
    }
}
