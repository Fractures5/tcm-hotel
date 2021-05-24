/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelBookingDates;
import hotelModel.HotelLocations;
import hotelView.HotelDatesMenu;
import hotelView.HotelLocationMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Siddarath
 */
public class BookDatesInteraction 
{
    HotelBookingDates datesModel;
    HotelDatesMenu datesView;
    
    public BookDatesInteraction(HotelBookingDates datesModel, HotelDatesMenu datesView)
    {
        this.datesModel = datesModel;
        this.datesView = datesView;
        
        datesView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    handleNextButtonPress();
                } catch (ParseException ex) {
                    Logger.getLogger(BookDatesInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        datesView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseEnteredHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitedHover();
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
            
            /*datesModel.setCheckInDay(datesView.getCheckInDay());
            datesModel.setCheckInMonth(datesView.getCheckInMonth());
            datesModel.setCheckInYear(datesView.getCheckInYear());
            datesModel.setCheckOutDay(datesView.getCheckOutDay());
            datesModel.setCheckOutMonth(datesView.getCheckOutMonth());
            datesModel.setCheckOutYear(datesView.getCheckOutYear());
            
            System.out.println(datesModel.getCheckInDay());
            System.out.println(datesModel.getCheckInMonth());
            System.out.println(datesModel.getCheckInYear());
            System.out.println(datesModel.getCheckOutDay());
            System.out.println(datesModel.getCheckOutMonth());
            System.out.println(datesModel.getCheckOutYear());*/
            datesModel.setDatesBooked(datesView.getDatesBooked());
            
            HotelLocations locationModel = new HotelLocations();
            HotelLocationMenu locationView = new HotelLocationMenu();
            LocationMenuInteraction locationAction = new LocationMenuInteraction(locationModel, locationView);
        }
    }
    
    public void mouseEnteredHover()
    {
        datesView.mouseEnterHover();
    }
    
    public void mouseExitedHover()
    {
        datesView.mouseExitHover();
    }
    
//    public static int bookingDatesData()
//    {
//        return datesModel.getCheckInDay();
//    }
}
