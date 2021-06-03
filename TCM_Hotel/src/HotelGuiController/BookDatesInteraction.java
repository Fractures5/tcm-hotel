/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedHotelDates;
import HotelGuiModel.BookedHotelLocations;
import HotelGuiView.HotelDatesMenu;
import HotelGuiView.HotelLocationMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import HotelDataFiles.GuestsBookingCart;


/**
 * This booking dates controller class handles the interaction between the
 * booking dates model and view class. It contains methods which handle a button
 * press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class BookDatesInteraction 
{
    static BookedHotelDates datesModel;
    HotelDatesMenu datesView;
    
    /**
     * This constructor initializes the model and view objects for the booked
     * dates and once a button is pressed in the hotel dates menu the action
     * listeners and the appropriate actionPerformed method will be executed
     * where it will be directed to another method to perform the required
     * tasks.
     *
     * @param datesModel represents an object of the class BookedHotelDates
     * @param datesView represents an object of the class HotelDatesMenu
     * @author Siddarath
     */
    public BookDatesInteraction(BookedHotelDates datesModel, HotelDatesMenu datesView)
    {
        this.datesModel = datesModel;
        this.datesView = datesView;
        
        datesView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    handleNextButtonPress();
                } 
                catch (ParseException ex) 
                {
                    Logger.getLogger(BookDatesInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        datesView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseEnteredNextHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitedNextHover();
            }
        });
    }
    
    /**
     * This method will be invoked when the user presses the next button in the
     * booking dates menu. Once the next button is pressed the method will check
     * for a valid user selection by invoking a method in the view. If the
     * selection is invalid it will prompt an error message and the user can
     * choose again. If the selection is valid, the date menu frame will close
     * and the hotel location menu will open.
     *
     * @throws ParseException
     * @author Siddarath
     */
    public void handleNextButtonPress() throws ParseException
    {
        datesView.confirmSelection();
        
        if ((datesView.getValidCheckInDay() == false || datesView.getValidCheckOutDay() == false))
        {
            datesView.displayIncorrectDayMessage();
        }
        else if((datesView.getValidCheckInDay() == true && datesView.getValidCheckInDay() == true ) && datesView.getRepeat() == true && datesView.getValidDate() == false)
        {
            datesView.displayDateErrorMessage();
        }
        else if (datesView.getRepeat() == false)
        {
            datesView.setVisible(false);
            datesModel.setDatesBooked(datesView.getDatesBooked());
            
            BookedHotelLocations locationModel = new BookedHotelLocations();
            HotelLocationMenu locationView = new HotelLocationMenu();
            LocationMenuInteraction locationAction = new LocationMenuInteraction(locationModel, locationView);
        }
    }
    
    /**
     * This method calls the hover effect in the menu GUI to take in place when
     * the mouse hovers the specified button. This similar concept applies to
     * the ones below.
     *
     * @author Siddarath
     */
    public void mouseEnteredNextHover()
    {
        datesView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        datesView.mouseExitNextHover();
    }
    
    /**
     * This method returns the array list containing the value of the selected
     * booking dates. This will be used for the calculations, booking cart menu
     * and for entering it into the database.
     *
     * @return datesModel.getDatesBooked() the array list holding the value of
     * the selected booking dates from the user.
     * @author Siddarath
     */
    public static ArrayList<GuestsBookingCart> guestBookingDates()
    {
        return datesModel.getDatesBooked();
    }
}
