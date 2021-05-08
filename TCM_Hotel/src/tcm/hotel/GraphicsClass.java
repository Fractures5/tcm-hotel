package tcm.hotel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the graphics class, which is used to store methods of different
 * of text/print statements used to enhance different class outputs
 * and provide more context for each menu/section the user goes to, from 
 * welcoming/exiting messages to menus and so on.
 */

/**
 *
 * @author faaris
 */
public class GraphicsClass
{
    public void welcomeMessage() //Method which contains the welcoming message which appaears when the program starts
    {
        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        System.out.println("*   Weclome to the Online TCM Hotel Booking System!    *");
        System.out.println("*                                                      *");
        System.out.println("*  Select one of the displayed options to continue...  *");
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
    }
 
    public void displayOptions() //Method which contains print statements to show the menu options for the user when they enter the program
    {
        System.out.println("\n********************************************************");
        System.out.println("* Press (1) to make a booking                          *");
        System.out.println("* Press (2) to display the FAQ section for the Hotel   *");
        System.out.println("* Press (3) to display the TCM About Us page           *");
        System.out.println("* Press (4) to access the Admin section                *");
        System.out.println("* Press (x) to exit the Program                        *");
        System.out.println("********************************************************");
    }
    
    public void enterFAQ() //Method which shows the section the user choose based on thier input being opended
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("                  Opening the FAQ section...                     ");
        System.out.println("-----------------------------------------------------------------\n");
    }
    
    public void FAQTitle() //Method which contains a small brief of text whch mentions what the section the user has entered is about and contains
    {
        System.out.println("*************************************************************************");
        System.out.println("*    Welcome to the FAQ(Frequently Asked Questions) for the TCM Hotel!  *");
        System.out.println("*      Here are some of the generally asked questions and inqueries     *\n"
                +          "*         you may find useful when browsing the TCM Hotel system:       *");
        System.out.println("*************************************************************************\n");
    }
    
    public void closingFAQ() //Method which is displayed once the user has chosen to exit a specific part of the program
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("     FAQ has been closed. Now returning to the main menu...      ");
        System.out.println("-----------------------------------------------------------------");
    }
    
    public void enterAboutUs()
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("                  Opening the About Us page...                     ");
        System.out.println("-----------------------------------------------------------------\n");
    }
    
    public void aboutUsTitle()
    {
        System.out.println("*************************************************************************");
        System.out.println("*        Welcome to the About Us Page for the TCM Hotel!                *");
        System.out.println("*************************************************************************");
    }
    
    public void closingAboutUs()
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("    About Us has been closed. Now returning to the main menu...  ");
        System.out.println("-----------------------------------------------------------------");
    }
    
    public void exitUserBooking()
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("         Customer booking has been confirmed and paid...           ");
        System.out.println("              Returning to the main menu...                        ");
        System.out.println("-----------------------------------------------------------------");
    }
    
    public void exitAdminPage()
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("     Admin menu has been closed. Now returning to main menu...   ");
        System.out.println("-----------------------------------------------------------------");
    }
}
