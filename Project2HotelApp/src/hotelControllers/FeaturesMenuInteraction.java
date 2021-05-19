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
        
        featuresView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
    
    public void handleNextButtonPress()
    {
        featuresView.confirmSelection();

        if (featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == true) 
        {
            featuresView.displayErrorMessage();
        }
        else if(featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == false) // take this out maybe not needed
        {
            
        }
        else if (featuresView.getRepeat() == false) 
        {
            featuresView.addUserFeatureSelection();
            featuresView.setVisible(false);
            featuresModel.setFeaturesBooked(featuresView.getFeaturesBooked());
            //System.out.println(featuresModel.getFeaturesBooked().get(0).getTitle() + " " + featuresModel.getFeaturesBooked().get(0).getPrice());
            featuresModel.currentFeatureBookings();
           
        }
    }
    
    public void mouseEnteredHover()
    {
        featuresView.mouseEnterHover();
    }
    
    public void mouseExitedHover()
    {
        featuresView.mouseExitHover();
    }
}
