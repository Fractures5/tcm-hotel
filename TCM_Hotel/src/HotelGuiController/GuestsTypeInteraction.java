/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedHotelFeatures;
import HotelGuiModel.BookedGuestTypes;
import HotelGuiView.HotelFeaturesMenu;
import HotelGuiView.HotelGuestTypesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This guest types menu controller class handles the interaction between the
 * guest types menu model and the guest types menu view class. It contains
 * methods which handle a button press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class GuestsTypeInteraction 
{
    static BookedGuestTypes guestsModel;
    HotelGuestTypesMenu guestsView;
    
    /**
     * This constructor initializes the model and view objects for the guest
     * type menu and once a button is pressed in the hotel guest types menu the
     * action listeners and the appropriate actionPerformed method will be
     * executed where it will be directed to another method to perform the
     * required tasks.
     *
     * @param guestsModel represents an object of the class BookedGuestTypes
     * @param guestsView represents an object of the class HotelGuestTypesMenu
     * @author Siddarath
     */
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
    
    /**
     * This method will be invoked when the user presses the next button in the
     * guest types menu. Once the next button is pressed the method will check
     * for a valid user selection by invoking a method in the view. If the
     * selection is invalid it will prompt an error message and the user can
     * choose again. If the selection is valid, the guest types menu frame will
     * close and the hotel extra features menu will open.
     *
     * @author Siddarath
     */
    public void handleNextButtonPress()
    {
        guestsView.confirmSelection();

        if (guestsView.getRepeat() == true && guestsView.getShowErrorMesssage() == true) 
        {
            guestsView.displayErrorMessage();
        }
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
    
    /**
     * This method calls the hover effect in the menu GUI to take in place when
     * the mouse hovers the specified button. This similar concept applies to
     * the ones below.
     *
     * @author Siddarath
     */
    public void mouseEnteredNextHover()
    {
        guestsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        guestsView.mouseExitNextHover();
    }
    
    /**
     * This method returns the array list containing the value of the selected
     * guest types. This will be used for the calculations, booking cart menu
     * and for entering it into the database.
     *
     * @return guestsModel.getGuestsBooked() the array list holding the value of
     * the selected guest types from the user.
     * @author Siddarath
     */
    public static ArrayList<GuestsBookingCart> guestTypesBooked()
    {
        return guestsModel.getGuestsBooked();
    }
}
