/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminModel;
import View.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;

/**
 *
 * @author Anuk
 */
public class AdminController {

    AdminModel modelAdmin;
    AdminView viewAdmin;

    public AdminController(AdminModel modelAdmin, AdminView viewAdmin) {
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;

        viewAdmin.getProceedToLogin().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                handleProceedToLoginClick();
            }
        });
        
        viewAdmin.getResetAdminDetails().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleResetAdminDetailsClick();
            }
        });

        viewAdmin.getProceedToLogin().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredProceedToLogin();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitedProceedToLogin();
            }
        });
        
        viewAdmin.getResetAdminDetails().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredResetAdminDetails();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitedResetAdminDetails();
            }
        });
    }

    public void handleProceedToLoginClick() {
        
        viewAdmin.adminDetailsConfirmation();
        
        if (viewAdmin.getShowAdminFNameError() == true) {
            viewAdmin.displayAdminFNameError();
        }

        if (viewAdmin.getShowAdminLNameError() == true) {
            viewAdmin.displayAdminLNameError();
        }
        
        if (viewAdmin.getShowAdminJobTitleError() == true) {
            viewAdmin.displayAdminJobTitleError();
        }
        
        if (viewAdmin.getShowAdminPhoneNumberError() == true) {
            viewAdmin.displayAdminPhoneNumberError();
        }
        
        if (viewAdmin.getShowAdminEmailAddressError() == true) {
            viewAdmin.displayAdminEmailAddressError();
        }
        
        if (viewAdmin.getShowAdminRegSuccess() == true){
            
            viewAdmin.displayAdminRegSuccess();
        }
        
        if (viewAdmin.getValidAdminDetails() == true) {
            viewAdmin.setVisible(false);
            modelAdmin.setAdminFirstName(viewAdmin.getAdminFNameField());
            modelAdmin.setAdminLastName(viewAdmin.getAdminLNameField());
            modelAdmin.setAdminJobTitle(viewAdmin.getAdminJobTitleField());
            modelAdmin.setAdminPhoneNumber(viewAdmin.getAdminPhoneNumField());
            modelAdmin.setAdminEmailAddress(viewAdmin.getAdminEmailField());
            //HotelProductDB productDB = new HotelProductDB();
            //DBManager db = new DBManager();
            //productDB.registerAdmin(modelAdmin);
            //viewAdmin.showAdminRegistrationSuccess();
        }
    }

    public void handleResetAdminDetailsClick() {
        
        viewAdmin.adminDetailsReset();

    }

    public void mouseEnteredProceedToLogin() {
        
        viewAdmin.mouseEnterProceedToLogin();

    }

    public void mouseExitedProceedToLogin() {
        
        viewAdmin.mouseExitProceedToLogin();

    }
    
    public void mouseEnteredResetAdminDetails() {
        viewAdmin.mouseEnterResetAdminDetails();

    }

    public void mouseExitedResetAdminDetails() {
        
        viewAdmin.mouseExitResetAdminDetails();

    }

}
