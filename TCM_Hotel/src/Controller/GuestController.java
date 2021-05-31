/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GuestModel;
import View.GuestView;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;
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
import tcm.hotel.GuestsBookingCart;



/**
 *
 * @author Anuk
 */
public class GuestController{
    
    GuestModel modelGuest;
    GuestView viewGuest;
    
    //HotelProductDB db;
    private GuestForm guestForm = new GuestForm();
    
    public GuestController(GuestModel modelGuest, GuestView viewGuest){
        this.modelGuest = modelGuest;
        this.viewGuest = viewGuest;
        
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
            
            viewGuest.setVisible(false);
            
            ArrayList<GuestsBookingCart> datesBooked = new ArrayList<GuestsBookingCart>();
            datesBooked = BookDatesInteraction.guestBookingDates();

            ArrayList<GuestsBookingCart> locationBooked = new ArrayList<GuestsBookingCart>();
            locationBooked = LocationMenuInteraction.guestHotelLocation();

            ArrayList<GuestsBookingCart> roomsBooked = new ArrayList<GuestsBookingCart>();
            roomsBooked = RoomMenuInteraction.guestBookedRooms();

            ArrayList<GuestsBookingCart> guestsTypesBooked = new ArrayList<GuestsBookingCart>();
            guestsTypesBooked = GuestsTypeInteraction.guestTypesBooked();

            ArrayList<GuestsBookingCart> featuresBooked = new ArrayList<GuestsBookingCart>();
            featuresBooked = FeaturesMenuInteraction.guestFeaturesBooked();
            
            modelGuest.setGuestFirstName(viewGuest.getfNameField());
            modelGuest.setGuestLastName(viewGuest.getlNameField());
            modelGuest.setGuestAge(viewGuest.getAgeField());
            modelGuest.setGuestPhoneNumber(viewGuest.getPhoneNumField());
            modelGuest.setGuestEmail(viewGuest.getEmailField());
            modelGuest.setGuestAccountNumber(viewGuest.getAccNumField());
            modelGuest.setGuestAccountPin(viewGuest.getAccPinField());
            
            HotelProductDB productDB = new HotelProductDB();
            DBManager dbManage = new DBManager();
            productDB.registerGuest(modelGuest);
            productDB.dbAddDatesBooked(modelGuest, locationBooked, datesBooked);
            productDB.dbAddLocationsBooked(modelGuest, locationBooked);
            productDB.dbAddRoomsBooked(modelGuest, roomsBooked);
            productDB.dbAddGuestTypeBooked(modelGuest, guestsTypesBooked);
            productDB.dbAddFeaturesBooked(modelGuest, featuresBooked);
            
            
            
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