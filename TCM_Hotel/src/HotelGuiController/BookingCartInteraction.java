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
 *
 * @author Siddarath
 */
public class BookingCartInteraction 
{
    BookingCartMenu cartView;
    
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
    
    public void handleHomeButtonPress()
    {
        cartView.confirmLeaveBooking();
        cartView.setVisible(false);
        WelcomeAppGuiMenu accessMainMenu = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
    }
    
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
