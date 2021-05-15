/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelFeatures;
import hotelView.HotelFeaturesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Siddarath
 */
public class FeaturesMenuInteraction 
{
    HotelFeatures featuresModel;
    HotelFeaturesMenu featuresView;
    
    public FeaturesMenuInteraction(HotelFeatures featuresModel, HotelFeaturesMenu featuresView)
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
    }
    
    public void handleNextButtonPress()
    {
        featuresView.confirmSelection();

        if (featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == true) 
        {
            featuresView.displayErrorMessage();
        }
        else if(featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == false)
        {
            
        }
        else if (featuresView.getRepeat() == false) 
        {
            featuresView.setVisible(false);
            //featuresModel.setRoomsBooked(roomsView.getRoomsSelected());
            //featuresModel.currentRoomsBookings(roomsView.getRoomsSelected());
           
        }
    }
}
