/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.BookedHotelFeatures;
import hotelModel.BookedGuestTypes;
import hotelView.HotelFeaturesMenu;
import hotelView.HotelGuestTypesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class GuestsTypeInteraction 
{
    static BookedGuestTypes guestsModel;
    HotelGuestTypesMenu guestsView;
    
    public GuestsTypeInteraction(BookedGuestTypes guestsModel, HotelGuestTypesMenu guestsView)
    {
        this.guestsModel = guestsModel;
        this.guestsView = guestsView;
        
        guestsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        guestsView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
    
    public void handleNextButtonPress()
    {
        guestsView.confirmSelection();

        if (guestsView.getRepeat() == true && guestsView.getShowErrorMesssage() == true) 
        {
            guestsView.displayErrorMessage();
        }
        /*else if(guestsView.getRepeat() == true && guestsView.getShowErrorMesssage() == false)// take this out maybe not needed
        {
            
        }*/
        else if (guestsView.getRepeat() == false) 
        {
            guestsView.addGuestTypesSelection();
            guestsView.setVisible(false);
            guestsModel.setGuestsBooked(guestsView.getGuestTypesBooked());
            
            BookedHotelFeatures featuresModel = new BookedHotelFeatures();
            HotelFeaturesMenu featuresView = new HotelFeaturesMenu();
            FeaturesMenuInteraction selectFeatures = new FeaturesMenuInteraction(featuresModel, featuresView);
        }   
    }
    
    public void mouseEnteredNextHover()
    {
        guestsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        guestsView.mouseExitNextHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestTypesBooked()
    {
        return guestsModel.getGuestsBooked();
    }
}
