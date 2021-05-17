/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestControllers;

import guestModel.GuestModel;
import guestView.GuestView;
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
        
    }

    public void handleResetDetailsClick(){

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
    
    /*class DetailsConfirmation implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String inputFirstName;
            String inputLastName;
            int guestAge = 0;
            String inputPhoneNumber;
            String inputEmail;
            String inputAccountNumber;
            String inputAccountPin;
            boolean validAge = false;
            boolean validEmail = false;
            boolean validAccountNumber = false;
            
            try {
                
                inputFirstName = viewGuest.getfNameField();
                inputLastName = viewGuest.getlNameField();
                guestAge = viewGuest.getAgeField();
                inputPhoneNumber = viewGuest.getPhoneNumField();
                inputEmail = viewGuest.getEmailField();
                inputAccountNumber = viewGuest.getAccNumField();
                inputAccountPin = viewGuest.getAccPinField();
                //inputAccountPin = (new String(this.accPinField.getPassword()));
                
                try {
                    guestAge = viewGuest.getAgeField();
                    //guestAge = Integer.parseInt(ageField.getText());
                    validAge = true;

                } catch (NumberFormatException o) {
                    JOptionPane.showMessageDialog(null, "Your Age must only contain Numbers", "Invalid Age Error!", JOptionPane.ERROR_MESSAGE);
                    validAge = false;
                }
                if (!inputEmail.contains("@") || (((!inputEmail.contains(".com")) && (!inputEmail.contains(".co.nz")) && (!inputEmail.contains(".net")) && (!inputEmail.contains(".org.nz"))))) {
                    validEmail = false;
                    JOptionPane.showMessageDialog(null, "You must have a valid email address!", "Invalid Email Error!", JOptionPane.ERROR_MESSAGE);
                } else if (inputEmail.contains("@") || (((inputEmail.contains(".com")) && (inputEmail.contains(".co.nz")) && (inputEmail.contains(".net")) && (inputEmail.contains(".org.nz"))))) {
                    validEmail = true;
                }

                HashMap<String, String> guestRecords = GuestForm.readGuestRecords();

                if (guestRecords.containsKey(inputAccountNumber)) {
                    JOptionPane.showMessageDialog(null, "You must enter your own Bank Account Number!", "Invalid Account Number Error!", JOptionPane.ERROR_MESSAGE);
                    validAccountNumber = false;
                } else if (!guestRecords.containsKey(inputAccountNumber)) {
                    validAccountNumber = true;
                }

                System.out.println(inputFirstName + " " + inputLastName + " " + guestAge + " " + inputPhoneNumber + " " + inputEmail + " " + inputAccountNumber + " " + inputAccountPin + " ");
                if (validAge == true && validEmail == true && validAccountNumber == true) {
                    System.out.println("guest object will be created");
                    Guest guest = new Guest(inputFirstName, inputLastName, guestAge, inputEmail, inputPhoneNumber, inputAccountNumber, inputAccountPin);
                    ArrayList<Guest> list = GuestForm.getArrayList();
                    list.add(guest);
                    guestRecords.put(inputAccountNumber, inputFirstName);
                    try {
                        FileInputOutput.writeGuestToGuestsFile(guestRecords);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GuestGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    FileInputOutput.printGuestDetails(list);
                }
                
            }
        }
        
    }*/
