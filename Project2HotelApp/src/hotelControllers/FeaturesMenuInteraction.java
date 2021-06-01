/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.BookedHotelFeatures;
import hotelView.BookingCartMenu;
import hotelView.HotelFeaturesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class FeaturesMenuInteraction 
{
    static BookedHotelFeatures featuresModel;
    HotelFeaturesMenu featuresView;
    
    public FeaturesMenuInteraction(BookedHotelFeatures featuresModel, HotelFeaturesMenu featuresView)
    {
        this.featuresModel = featuresModel;
        this.featuresView = featuresView;
        
        featuresView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        featuresView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
        featuresView.confirmSelection();

        if (featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == true) 
        {
            featuresView.displayErrorMessage();
        }
        /*else if(featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            
        }*/
        else if (featuresView.getRepeat() == false) 
        {
            featuresView.addUserFeatureSelection();
            featuresView.setVisible(false);
            featuresModel.setFeaturesBooked(featuresView.getFeaturesBooked());
            
            BookingCartMenu viewBookingCart = new BookingCartMenu();
            BookingCartInteraction cartInteraction = new BookingCartInteraction(viewBookingCart);       
        }
    }
    
    public void mouseEnteredNextHover()
    {
        featuresView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        featuresView.mouseExitNextHover();
    }
    
    public static ArrayList<GuestsBookingCart> guestFeaturesBooked()
    {
        return featuresModel.getFeaturesBooked();
    }
}
