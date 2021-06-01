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
 *
 * @author Siddarath
 */
public class BookDatesInteraction 
{
    static BookedHotelDates datesModel;
    HotelDatesMenu datesView;
    
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
    
    public void mouseEnteredNextHover()
    {
        datesView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        datesView.mouseExitNextHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestBookingDates()
    {
        return datesModel.getDatesBooked();
    }
}
