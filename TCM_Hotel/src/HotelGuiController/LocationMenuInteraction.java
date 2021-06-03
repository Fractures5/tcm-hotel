/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedHotelLocations;
import HotelGuiModel.BookedHotelRooms;
import HotelGuiView.HotelLocationMenu;
import HotelGuiView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import HotelDataFiles.GuestsBookingCart;

/**
 * This hotel location menu controller class handles the interaction between the
 * hotel location menu model and the hotel location menu view class. It contains
 * methods which handle a button press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class LocationMenuInteraction {
    
    static BookedHotelLocations locationsModel;
    HotelLocationMenu locationsView;
    
    /**
     * This constructor initializes the model and view objects for the location
     * menu and once a button is pressed in the hotel location menu the action
     * listeners and the appropriate actionPerformed method will be executed
     * where it will be directed to another method to perform the required
     * tasks.
     *
     * @param locationsModel represents an object of the class
     * BookedHotelLocations
     * @param locationsView represents an object of the class HotelLocationMenu
     * @author Siddarath
     */
    public LocationMenuInteraction(BookedHotelLocations locationsModel, HotelLocationMenu locationsView)
    {
        this.locationsModel = locationsModel;
        this.locationsView = locationsView;
        
        locationsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        locationsView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
     * hotel location menu. Once the next button is pressed the method will
     * check for a valid user selection by invoking a method in the view. If the
     * selection is invalid it will prompt an error message and the user can
     * choose again. If the selection is valid, the location menu frame will
     * close and the hotel rooms menu will open.
     *
     * @author Siddarath
     */
    public void handleNextButtonPress()
    {
        
        locationsView.confirmSelection();

        if (locationsView.getRepeat() == true && locationsView.getShowErrorMesssage() == true) 
        {
            locationsView.displayErrorMessage();
        }
        else if (locationsView.getRepeat() == false) 
        {
            locationsView.setVisible(false);
            locationsModel.setBookingLocation(locationsView.getBookingLocation());
            
            BookedHotelRooms roomsModel = new BookedHotelRooms();
            HotelRoomsMenu roomsView = new HotelRoomsMenu();
            RoomMenuInteraction roomsAction = new RoomMenuInteraction(roomsModel, roomsView);
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
        locationsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        locationsView.mouseExitNextHover();
    }
    
    /**
     * This method returns the array list containing the value of the selected
     * location. This will be used for the calculations, booking cart menu and
     * for entering it into the database.
     *
     * @return locationsModel.getBookingLocation() the array list holding the
     * value of the selected location from the user.
     * @author Siddarath
     */
    public static ArrayList<GuestsBookingCart> guestHotelLocation()
    {
        return locationsModel.getBookingLocation();
    }
}
