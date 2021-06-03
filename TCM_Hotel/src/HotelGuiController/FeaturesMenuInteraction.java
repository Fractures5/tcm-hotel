/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedHotelFeatures;
import HotelGuiView.BookingCartMenu;
import HotelGuiView.HotelFeaturesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This features menu controller class handles the interaction between the
 * features menu model and the features menu view class. It contains methods
 * which handle a button press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class FeaturesMenuInteraction 
{
    static BookedHotelFeatures featuresModel;
    HotelFeaturesMenu featuresView;
    
    /**
     * This constructor initializes the model and view objects for the features
     * menu and once a button is pressed in the hotel features menu the action
     * listeners and the appropriate actionPerformed method will be executed
     * where it will be directed to another method to perform the required
     * tasks.
     *
     * @param featuresModel represents an object of the class
     * BookedHotelFeatures
     * @param featuresView represents an object of the class HotelFeaturesMenu
     * @author Siddarath
     */
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
    
    /**
     * This method will be invoked when the user presses the next button in the
     * features menu. Once the next button is pressed the method will check for
     * a valid user selection by invoking a method in the view. If the selection
     * is invalid it will prompt an error message and the user can choose again.
     * If the selection is valid, the hotel features menu frame will close and
     * the booking cart menu will open.
     *
     * @author Siddarath
     */
    public void handleNextButtonPress()
    {
        featuresView.confirmSelection();

        if (featuresView.getRepeat() == true && featuresView.getShowErrorMesssage() == true) 
        {
            featuresView.displayErrorMessage();
        }
        else if (featuresView.getRepeat() == false) 
        {
            featuresView.addUserFeatureSelection();
            featuresView.setVisible(false);
            featuresModel.setFeaturesBooked(featuresView.getFeaturesBooked());
            
            BookingCartMenu viewBookingCart = new BookingCartMenu();
            BookingCartInteraction cartInteraction = new BookingCartInteraction(viewBookingCart);       
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
        featuresView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        featuresView.mouseExitNextHover();
    }
    
    /**
     * This method returns the array list containing the value of the selected
     * feature types. This will be used for the calculations, booking cart menu
     * and for entering it into the database.
     *
     * @return featuresModel.getFeaturesBooked() the array list holding the
     * value of the selected feature types from the user.
     * @author Siddarath
     */
    public static ArrayList<GuestsBookingCart> guestFeaturesBooked()
    {
        return featuresModel.getFeaturesBooked();
    }
}
