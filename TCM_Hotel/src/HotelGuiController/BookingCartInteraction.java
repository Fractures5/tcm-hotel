/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.GuestFormDetails;
import HotelGuiView.BookingCartMenu;
import HotelGuiView.GuestFormMenu;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This booking cart controller class handles the interaction between the
 * booking cart model and the booking cart menu view class. It contains methods
 * which handle a button press, button hover effects and error handling.
 *
 * @author Siddarath
 */
public class BookingCartInteraction 
{
    BookingCartMenu cartView;
    
    /**
     * This constructor initializes the model and view objects for the booked
     * cart menu and once a button is pressed in the booking cart menu the
     * action listeners and the appropriate actionPerformed method will be
     * executed where it will be directed to another method to perform the
     * required tasks.
     *
     * @param cartView represents an object of the class BookingCartMenu
     * @author Siddarath
     */
    public BookingCartInteraction(BookingCartMenu cartView)
    {
        this.cartView = cartView;
        
        cartView.getProceedButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handleProceedButtonPress();
            }
        });
        
        cartView.getHomeButton().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                handleHomeButtonPress();
            }
        });
        
        cartView.getProceedButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseEnterProceedBtnHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitProceedBtnHover();
            }
        });
        
        cartView.getHomeButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseEnterHomeBtnHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitHomeBtnHover();
            }
        });
    }
    
    /**
     * This method will be invoked when the user presses the proceed button in
     * the booking cart menu. Once the proceed button is pressed the method will
     * prompt the user to continue or not. If they decide to continue, the
     * booking cart menu frame will close and the payment guest form menu will
     * open.
     *
     * @author Siddarath
     */
    public void handleProceedButtonPress()
    {
        cartView.confirmSelection();
        
        if(cartView.getRepeat() == false)
        {
            cartView.setVisible(false);
            GuestFormDetails modelGuest = new GuestFormDetails();
            GuestFormMenu viewGuest = new GuestFormMenu();
            GuestFormInteraction controllerGuest = new GuestFormInteraction(modelGuest, viewGuest);
        }   
    }
    
    /**
     * This method will be invoked when the user presses the home button in the
     * booking cart menu. Once the home button is pressed it will alert the user
     * they are being returned to the main menu and the booking cart menu frame
     * will close and the main menu frame will open.
     *
     * @author Siddarath
     */
    public void handleHomeButtonPress()
    {
        cartView.confirmLeaveBooking();
        cartView.setVisible(false);
        WelcomeAppGuiMenu accessMainMenu = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
    }
    
    /**
     * This method calls the hover effect in the menu GUI to take in place when
     * the mouse hovers the specified button. This similar concept applies to
     * the ones below.
     *
     * @author Siddarath
     */
    public void mouseExitHomeBtnHover()
    {
        cartView.mouseExitHomeHover();
    }
    
    public void mouseEnterHomeBtnHover()
    {
        cartView.mouseEnterHomeHover();
    }
    
    public void mouseExitProceedBtnHover()
    {
        cartView.mouseExitNextHover();
    }
    
    public void mouseEnterProceedBtnHover()
    {
        cartView.mouseEnterNextHover();
    }
    
}
