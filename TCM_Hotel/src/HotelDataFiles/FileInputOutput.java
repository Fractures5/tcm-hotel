/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

/**
 * This is a description of the FileInputOutput Class. This class will handle
 * all of the functionality regarding writing to, reading from and updating java
 * ".txt" files.
 *
 * @author Anuk
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

public class FileInputOutput 
{
    /**
     * The writeGuestToGuestsFile method iterates through all pairs of key-value
     * records which are the bank account number and guest's first name. With
     * every iteration of each pair it will write every pair of the bank account
     * number and the guest's first name to Guests.txt file.
     *
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
                pw.println(entry.getKey() + " " + entry.getValue().toLowerCase());
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
}
