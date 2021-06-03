/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.BookedGuestTypes;
import HotelGuiModel.BookedHotelRooms;
import HotelGuiView.HotelGuestTypesMenu;
import HotelGuiView.HotelRoomsMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import HotelDataFiles.CalculateCosts;
import HotelDataFiles.GuestsBookingCart;

/**
 * This hotel room menu controller class handles the interaction between the
 * hotel room menu model and the hotel room menu view class. It contains methods
 * which handle a button press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class RoomMenuInteraction 
{
    static BookedHotelRooms roomsModel;
    HotelRoomsMenu  roomsView;
    
    /**
     * This constructor initializes the model and view objects for the rooms
     * menu and once a button is pressed in the hotel rooms menu the action
     * listeners and the appropriate actionPerformed method will be executed
     * where it will be directed to another method to perform the required
     * tasks.
     *
     * @param roomsModel represents an object of the class BookedHotelRooms
     * @param roomsView represents an object of the class HotelRoomsMenu
     * @author Siddarath
     */
    public RoomMenuInteraction(BookedHotelRooms roomsModel, HotelRoomsMenu  roomsView)
    {
        this.roomsModel = roomsModel;
        this.roomsView = roomsView;
        
        roomsView.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleNextButtonPress();
            }
        });
        
        roomsView.getNextButton().addMouseListener(new java.awt.event.MouseAdapter()
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
     * hotel rooms menu. Once the next button is pressed the method will check
     * for a valid user selection by invoking a method in the view. If the
     * selection is invalid it will prompt an error message and the user can
     * choose again. If the selection is valid, the rooms menu frame will close
     * and the hotel guest types menu will open.
     *
     * @author Siddarath
     */
    public void handleNextButtonPress()
    {
        roomsView.confirmSelection();

        if (roomsView.getRepeat() == true && roomsView.getShowErrorMesssage() == true) 
        {
            roomsView.displayErrorMessage();
        }
        else if (roomsView.getRepeat() == false) 
        {
            roomsView.addUserRoomsSelection();
            roomsView.setVisible(false);
            roomsModel.setRoomsBooked(roomsView.getRoomsBooked());
            
            BookedGuestTypes guestsModel = new BookedGuestTypes();
            HotelGuestTypesMenu guestsView = new HotelGuestTypesMenu();
            GuestsTypeInteraction selectGuests = new GuestsTypeInteraction(guestsModel, guestsView);
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
        roomsView.mouseEnterNextHover();
    }
    
    public void mouseExitedNextHover()
    {
        roomsView.mouseExitNextHover();
    }
    
    /**
     * This method returns the array list containing the value of the selected
     * rooms. This will be used for the calculations, booking cart menu and for
     * entering it into the database.
     *
     * @return roomsModel.getRoomsBooked() the array list holding the value of
     * the selected rooms from the user.
     * @author Siddarath
     */
    public static ArrayList<GuestsBookingCart> guestBookedRooms()
    {
        return roomsModel.getRoomsBooked();
    }
}
