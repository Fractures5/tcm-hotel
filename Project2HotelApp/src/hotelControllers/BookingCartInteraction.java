/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelControllers;

import hotelModel.GuestModel;
import hotelView.BookingCartMenu;
import hotelView.GuestView;
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
                System.out.println("keffe");
                handleProceedButtonPress();
            }
        });
        
        cartView.getProceedButton().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                mouseExitHomeBtnHover();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                mouseExitHomeBtnHover();
            }
        });
        
        cartView.getHomeButton().addMouseListener(new java.awt.event.MouseAdapter()
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
    }
    
    public void handleProceedButtonPress()
    {
        System.out.println("procceed button is clicked");
        cartView.confirmSelection();
        
        if(cartView.getRepeat() == false)
        {
            cartView.setVisible(false);
            GuestModel modelGuest = new GuestModel();
            GuestView viewGuest = new GuestView();
            GuestController controllerGuest = new GuestController(modelGuest, viewGuest);
        }   
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
