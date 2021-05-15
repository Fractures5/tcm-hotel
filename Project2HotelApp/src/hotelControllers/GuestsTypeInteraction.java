/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.HotelFeatures;
import hotelModel.HotelGuests;
import hotelView.HotelFeaturesMenu;
import hotelView.HotelGuestTypesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Siddarath
 */
public class GuestsTypeInteraction 
{
    HotelGuests guestsModel;
    HotelGuestTypesMenu guestsView;
    
    public GuestsTypeInteraction(HotelGuests guestsModel, HotelGuestTypesMenu guestsView)
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
    }
    
    public void handleNextButtonPress()
    {
        guestsView.confirmSelection();

        if (guestsView.getRepeat() == true && guestsView.getShowErrorMesssage() == true) 
        {
            guestsView.displayErrorMessage();
        }
        else if(guestsView.getRepeat() == true && guestsView.getShowErrorMesssage() == false)
        {
            
        }
        else if (guestsView.getRepeat() == false) 
        {
            guestsView.setVisible(false);
            //roomsModel.setRoomsBooked(roomsView.getRoomsSelected());
            //roomsModel.currentRoomsBookings(roomsView.getRoomsSelected());
            HotelFeatures featuresModel = new HotelFeatures();
            HotelFeaturesMenu featuresView = new HotelFeaturesMenu();
            FeaturesMenuInteraction selectFeatures = new FeaturesMenuInteraction(featuresModel, featuresView);
        }
        
    }
    
}
