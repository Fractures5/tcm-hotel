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
        
        if (datesView.getRepeat() == true && datesView.getValidDate() == false)
        {
            datesView.displayErrorMessage();
        }
        else if (datesView.getRepeat() == false)
        {
            datesView.setVisible(false);
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
}
