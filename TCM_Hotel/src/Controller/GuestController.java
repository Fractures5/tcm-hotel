/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GuestModel;
import View.GuestView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tcm.hotel.FileInputOutput;
import tcm.hotel.Guest;
import tcm.hotel.GuestForm;
import tcm.hotel.GuestGUI;



/**
 *
 * @author Anuk
 */
public class GuestController{
    
    GuestView viewGuest;
    GuestModel modelGuest;
    private GuestForm guestForm = new GuestForm();
    
    public GuestController(GuestView viewGuest, GuestModel modelGuest){
        this.viewGuest = viewGuest;
        this.modelGuest = modelGuest;
        
        viewGuest.getConfirmDetails().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                handleConfirmDetailsClick();
            }
        });
        
        viewGuest.getResetDetails().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                handleResetDetailsClick();
            }
        });
        
        viewGuest.getConfirmDetails().addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseEntered(java.awt.event.MouseEvent evt){
                mouseEnteredConfirmDetails();
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt){
                mouseExitedConfirmDetails();
            }
        });
        
        viewGuest.getResetDetails().addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredResetDetails();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
               mouseExitedResetDetails();
            }
        });
    }
    
    public void handleConfirmDetailsClick() {
        
        viewGuest.DetailsConfirmation();
        
        if (viewGuest.getShowFNameError() == true){
            viewGuest.displayFNameError();
        }
        
        if (viewGuest.getShowLNameError() == true){
            viewGuest.displayLNameError();
        }
        
        if (viewGuest.getShowAgeError() == true){
            viewGuest.displayAgeError();
        }
        if (viewGuest.getShowPhoneNumberError()== true){
            viewGuest.displayPhoneNumberError();
        }
        if (viewGuest.getShowEmailAddressError() == true){
            viewGuest.displayEmailAddressError();
        }
        if (viewGuest.getShowAccNumberError()== true){
            viewGuest.displayAccNumError();
        }
        
        if (viewGuest.getValidGuest() == true){
            viewGuest.insertGuest();
            modelGuest.setGuestFirstName(viewGuest.getfNameField());
            modelGuest.setGuestLastName(viewGuest.getlNameField());
            modelGuest.setGuestAge(viewGuest.getAgeField());
            modelGuest.setGuestPhoneNumber(viewGuest.getPhoneNumField());
            modelGuest.setGuestEmail(viewGuest.getEmailField());
            modelGuest.setGuestAccountNumber(viewGuest.getAccNumField());
            modelGuest.setGuestAccountPin(viewGuest.getAccPinField());
            System.out.println(modelGuest.getGuestFirstName());
            
        }
    }

    public void handleResetDetailsClick(){
        
        viewGuest.DetailsReset();

    }
    
    public void mouseEnteredConfirmDetails(){
        
        viewGuest.mouseEnterConfirmDetails();
        
    }
    
    public void mouseExitedConfirmDetails(){
        
        viewGuest.mouseExitConfirmDetails();
        
    }
    
    public void mouseEnteredResetDetails() {

        viewGuest.mouseEnterResetDetails();

    }

    public void mouseExitedResetDetails() {
        
        viewGuest.mouseExitResetDetails();
    }
}