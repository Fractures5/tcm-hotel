/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelController;

import HotelModel.GuestFormDetails;
import HotelView.GuestFormMenu;
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
import tcm.hotel.CalculateCosts;
import tcm.hotel.FileInputOutput;
import tcm.hotel.Guest;
import tcm.hotel.GuestForm;
import tcm.hotel.GuestGUI;
import tcm.hotel.GuestsBookingCart;



/**
 *
 * @author Anuk
 */
public class GuestFormInteraction{
    
    GuestFormDetails detailsGuestForm;
    GuestFormMenu menuGuestForm;
    
    private GuestForm guestForm = new GuestForm();
    
    public GuestFormInteraction(GuestFormDetails modelGuest, GuestFormMenu viewGuest){
        this.detailsGuestForm = modelGuest;
        this.menuGuestForm = viewGuest;
        
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
        
        viewGuest.getShowAccPin().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                handleShowAccPinClick();
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
        
        menuGuestForm.DetailsConfirmation();
        
        if (menuGuestForm.getShowFNameError() == true){
            menuGuestForm.displayFNameError();
        }
        
        if (menuGuestForm.getShowLNameError() == true){
            menuGuestForm.displayLNameError();
        }
        
        if (menuGuestForm.getShowAgeError() == true){
            menuGuestForm.displayAgeError();
        }
        if (menuGuestForm.getShowPhoneNumberError()== true){
            menuGuestForm.displayPhoneNumberError();
        }
        if (menuGuestForm.getShowEmailAddressError() == true){
            menuGuestForm.displayEmailAddressError();
        }
        if (menuGuestForm.getShowAccNumberError()== true){
            menuGuestForm.displayAccNumError();
        }
        
        if (menuGuestForm.getValidGuest() == true){
            
            menuGuestForm.setVisible(false);
            
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
            
            detailsGuestForm.setGuestFirstName(menuGuestForm.getfNameField());
            detailsGuestForm.setGuestLastName(menuGuestForm.getlNameField());
            detailsGuestForm.setGuestAge(menuGuestForm.getAgeField());
            detailsGuestForm.setGuestPhoneNumber(menuGuestForm.getPhoneNumField());
            detailsGuestForm.setGuestEmail(menuGuestForm.getEmailField());
            detailsGuestForm.setGuestAccountNumber(menuGuestForm.getAccNumField());
            detailsGuestForm.setGuestAccountPin(menuGuestForm.getAccPinField());
            
            HotelProductDB productDB = new HotelProductDB();
            DBManager dbManage = new DBManager();
            CalculateCosts guestCosts = new CalculateCosts();
            productDB.registerGuest(detailsGuestForm, guestCosts);
            productDB.dbAddDatesBooked(detailsGuestForm, locationBooked, datesBooked);
            productDB.dbAddLocationsBooked(detailsGuestForm, locationBooked);
            productDB.dbAddRoomsBooked(detailsGuestForm, roomsBooked);
            productDB.dbAddGuestTypeBooked(detailsGuestForm, guestsTypesBooked);
            productDB.dbAddFeaturesBooked(detailsGuestForm, featuresBooked);
        }
    }

    public void handleResetDetailsClick(){
        
        menuGuestForm.DetailsReset();

    }
    
    public void mouseEnteredConfirmDetails(){
        
        menuGuestForm.mouseEnterConfirmDetails();
        
    }
    
    public void mouseExitedConfirmDetails(){
        
        menuGuestForm.mouseExitConfirmDetails();
        
    }
    
    public void mouseEnteredResetDetails() {

        menuGuestForm.mouseEnterResetDetails();

    }

    public void mouseExitedResetDetails() {
        
        menuGuestForm.mouseExitResetDetails();
    }
    
    public void handleShowAccPinClick(){
        if(menuGuestForm.getShowAccPin().isSelected()){
            menuGuestForm.toggleShowAccPin();
        }
        else{
            menuGuestForm.toggleHideAccPin();
        }
    }
}