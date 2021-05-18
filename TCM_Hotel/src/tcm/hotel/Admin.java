/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/**
 * This is a description of the Admin Class.
 * The Admin Class asks the user for input details where if
 * the input password matches the system password then a
 * staffMember object will be created with the information
 * provided by the user. Once the staff member object has created
 * and "logged in" they are prompted with options which allow
 * them to choose to view past and present guest details, currently
 * booked guests, view hotel bookings and remove a current guest
 * from the list.
 * 
 * @author Anuk
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin implements AdminInterface //Admin class implements the AdminInterface
{   
    /**
     * The getStaffDetails method will be invoked if the user chooses to access
     * the admin section. This method will prompt the user to enter details such
     * as their staff first name, staff last name, staff title or position and
     * staff contact email. In addition to this the staff member must input the
     * correct system password which is "tcm". If the user enters the incorrect
     * admin system password they will need to go back to the main menu and
     * enter the option to go back to the admin menu. When the user has entered
     * correct and valid staff information where the input password is correct,
     * a staff member object will be created and they have a range of options
     * which they can choose from. These options range from viewing the past
     * guest list, currently booked-in guests, view hotel room bookings and to
     * remove a guest from the list.
     */
    public void getStaffDetails() throws FileNotFoundException, IOException
    {
        Scanner scanner = new Scanner(System.in);
        String sysPassword = "tcm";
        String staffFirstName = "";
        String staffLastName = "";
        String staffTitle = "";
        String staffEmail = "";
        int staffPhone = 0;
        String inputPass = "";
        
        System.out.println("Welcome to TCM Hotel Booking Backend System");
        System.out.println("In order to access, view and make changes to such files please login via the form");
        System.out.println(" ");
        System.out.print("What is your first name?: ");
        staffFirstName = scanner.nextLine();
        System.out.println("-----------------------------");
        System.out.print("What is your last name?: ");
        staffLastName = scanner.nextLine();
        System.out.println("-----------------------------");
        System.out.print("What is your Job Title?: ");
        staffTitle = scanner.nextLine();
        System.out.println("-----------------------------");
        System.out.print("What is your Phone number?: ");
        staffPhone = scanner.nextInt();
        System.out.println("-----------------------------");
        System.out.print("What is your Email address?: ");
        staffEmail = scanner.nextLine();
        System.out.println("-----------------------------");
        while (!staffEmail.contains("@") || (((!staffEmail.contains(".com")) && (!staffEmail.contains(".co.nz")) && (!staffEmail.contains(".net")) && (!staffEmail.contains(".org.nz"))))) 
        {
            System.out.println("Please enter a valid email address");
            System.out.print("Email?: ");
            staffEmail = scanner.nextLine();
            System.out.println("-----------------------------");
        }

        System.out.print("Please enter the system password (password: tcm): ");  
        inputPass = scanner.nextLine();
        
        if (inputPass.equals(sysPassword)) //if the user inputs a correct input which matches with the system password 
        {
            System.out.println("Login Successful!");
            StaffMember staff = new StaffMember(staffFirstName, staffLastName, staffTitle, staffPhone, staffEmail);
            boolean choice = false;

            while (!choice) 
            {
                try 
                {
                    System.out.println("\nWelcome " + staff.getFirstName() + " " + staff.getLastName());
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Press 0. to exit the Admin menu");
                    System.out.println("Press 1. to view the List for past and present Guests");
                    System.out.println("Press 2. to view the List for current Guests only");
                    System.out.println("Press 3. to view the hotel bookings");
                    System.out.println("Press 4. to remove a current guest from the list");
                    System.out.println("------------------------------------------------------ ");
                    System.out.print("\nSelect an Option: ");
                    int staffInputChoice = scanner.nextInt();
                    
                    if (staffInputChoice == 1) 
                    {
                        FileInputOutput.viewGuestsPastAndPresent();
                    } 
                    else if (staffInputChoice == 2) 
                    {
                        System.out.println("Bank-Account-Number | Guest-Name");
                        System.out.println("------------------------");
                        FileInputOutput.viewGuestsHashMap();
                    } 
                    else if (staffInputChoice == 3) 
                    {
                        FileInputOutput.viewGuestBookings();
                    } 
                    else if (staffInputChoice == 4) 
                    {
                        scanner.nextLine();
                        String toRemoveGuest = "";
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.print("Please enter the bank account number of the guest you want to remove:   ");
                        toRemoveGuest = scanner.nextLine();
                        HashMap<String, String> recordsForStaff = GuestForm.readGuestRecords(); //saves the LinkedHashMap returned from the readGuestrecords method into recordsForStaff.
                        if (recordsForStaff.containsKey(toRemoveGuest)) //if the bank account number of the guest the staff member wants to remove already exists execute the following the block inside the if.
                        {
                            recordsForStaff.remove(toRemoveGuest); //remove the guest based on the bank account number key from the hash map.
                            FileInputOutput.writeGuestToGuestsFile(recordsForStaff); //calls method which will iterate through all key-value pairs and print them to the text file
                            System.out.println("---------------------------------------------------------------------------------------------------");
                            System.out.println("The Guest has been successfully removed!");
                            System.out.println("---------------------------------------------------------------------------------------------------");
                        } 
                        else 
                        {
                            System.out.println("---------------------------------------------------------------------------------------------------");
                            System.out.println("Guest has not been removed");
                            System.out.println("---------------------------------------------------------------------------------------------------");
                        }
                    } 
                    else if (staffInputChoice == 0) 
                    {
                        choice = true;
                    } 
                    else if (staffInputChoice < 0 || staffInputChoice > 4) 
                    {
                        System.err.println("Incorrect Value. Please try again.");
                    }
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Invalid Input. Please try again.");
                    scanner.nextLine();
                }
            }
        } 
        else 
        {
            System.err.println("Incorrect Password!");
        }
    }
}