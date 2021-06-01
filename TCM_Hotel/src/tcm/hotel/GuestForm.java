/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/**
 * This is a description of the GuestForm class.
 * In this class, the user will be prompted for valid input
 * where a guest object will be created with the user's input.
 * Only unique guest objects will be created as the class will check
 * for existing bank account numbers and will prompt the user to enter a new
 * account number if existing already.
 * 
 * @author Anuk
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;


/**
 *
 * @author Anuk
 */
public class GuestForm 
{

    public ArrayList<Guest> guestList = new ArrayList<Guest>(); //ArrayList of Guest class is created
    
    public ArrayList<Guest> fetchGuestDetails() throws IOException 
    {
        
        /**
         * The fetchGuestDetails method will prompt the user for input. The input will include
         * their first name, last name, age, a valid contact email and a contact phone number. In addition to these,
         * the guest must input an account number that is not existing already, if not the account number entered
         * is not present in the records, the guest will be prompted to input a bank pin.
         * With all the details provided by the guest, a guest object will be created. After this guest object
         * is created, the guest will be added to a Guest ArrayList and to a hashmap
         * where the key will be the guest account number and the value will be the guest first name.
         * Also, this method will invoke methods in the FileInputOutput class which add guests to the hashmap
         * and writes guest details to a text file.
         */

        Scanner scanner = new Scanner(System.in);
        
        FileWriter fw = new FileWriter("Guests.txt", true);
        PrintWriter pWriter = new PrintWriter(fw);
        FileInputOutput fm = new FileInputOutput();
        
        String fName;
        String lName;
        int age;
        String email = "";
        long phoneNum;
        String accNo = "";
        String accPin;
        
        boolean success = false;
        while(!success)
        { //while the boolean success is not equal to true, repeat the code contained in the try statement
            try
            {
                System.out.println("Please enter your details");
                System.out.println("-----------------------------");
                System.out.print("First Name: ");
                fName = scanner.nextLine();
                System.out.println("-----------------------------");
                while(!fName.matches("[a-zA-Z]+"))
                { //first name must only contain alphabetical characters
                    System.out.print("Please enter a valid first name");
                    fName = scanner.nextLine();
                    System.out.println("-----------------------------");
                }

                System.out.print("Last Name: ");
                lName = scanner.nextLine();
                System.out.println("-----------------------------");
                while (!lName.matches("[a-zA-Z]+")) 
                { //last name must only contain alphabetical characters
                    System.out.print("Please enter a valid last name");
                    lName = scanner.nextLine();
                    System.out.println("-----------------------------");
                }
                
                System.out.print("Age: ");
                age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("-----------------------------");

                System.out.print("Phone Number: ");
                phoneNum = scanner.nextInt();
                System.out.println("-----------------------------");
                
                System.out.println("An Email Address will be used to send you a copy of your receipt");
                
                while (!email.contains("@") || (((!email.contains(".com")) && (!email.contains(".co.nz")) && (!email.contains(".net")) && (!email.contains(".org.nz"))))) 
                {
                    System.out.println("Please enter a valid email address");
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.println("-----------------------------");
                }
                
                HashMap<String, String> guestRecords = readGuestRecords(); //Creates new HashMap object which stores the method call of readGuestRecords();

                System.out.println("--------PAYMENT DETAILS--------");
                System.out.print("What is your Bank Account Number? ");
                do {
                    accNo = scanner.nextLine();
                    if (guestRecords.containsKey(accNo)) 
                    { //checks if the hash map already contains the guest input bank account number
                        System.out.println("Account number exists within our records. Please input a different Bank account number");
                    }
                } 
                while (guestRecords.containsKey(accNo));
                
                System.out.println("-----------------------------");

                System.out.print("What is the Pin to your Bank Account? ");
                accPin = scanner.nextLine();
                System.out.println("-----------------------------");
                Guest guest = new Guest(fName, lName, age, email, phoneNum, accNo, accPin);
                
                guestList.add(guest); //add guest object to ArrayList
                guestRecords.put(accNo, fName);
                FileInputOutput.writeGuestToGuestsFile(guestRecords);
                FileInputOutput.printGuestDetails(guestList);                
                success = true;
            }
            catch (NumberFormatException exception) 
            {
                System.err.println("Error, Please enter a valid Input!");
                scanner.nextLine();
            } 
            catch (InputMismatchException ex) 
            {
                System.err.println("Error, Please enter a valid Integer!");
                scanner.nextLine();
            }
        }
        return guestList;
    }

    public static HashMap<String, String> readGuestRecords() 
    {
        /**
         * The readGuestRecords method creates a LinkedHashMap for storing
         * the bank account number and the first name of the guest where the bank account number
         * will be the key and the first name of the guest will be the value. A buffered reader
         * will be initialized which will be used to read and process the information stored within the Guests.txt file.
         * As long as the guest has provided valid details which include a bank account number which does not exist in the
         * system already, the bank account number and first name will be put into the hash map.
         */
        
        LinkedHashMap<String, String> list = new LinkedHashMap();
        BufferedReader br = null;
        try 
        {
            br = new BufferedReader(new FileReader("Guests.txt")); //the buffered reader is initialised which will read the data stored in the Guests.txt file.
            String line = null;
            while ((line = br.readLine()) != null) 
            {
                String str[] = line.split(" "); //this will split the data in the line keeping a space between the content, for example the key and the value - the bank account number and first name.
                list.put(str[0], str[1]); //put the bank account number and the first name of the guest into the hash map.
            }
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println("error, file not found");
        } 
        catch (IOException e) 
        {
            System.out.println("An Error Occured");
        }
        return list;
    }
    
    public ArrayList<Guest> getArrayList()
    {
        return guestList;
    }
}
