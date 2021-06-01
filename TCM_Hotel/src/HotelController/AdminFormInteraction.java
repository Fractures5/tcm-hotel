/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelController;

import HotelModel.AdminFormDetails;
import HotelView.AdminFormMenu;
import HotelView.LoginMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;

/**
 *
 * @author Anuk
 */
public class AdminFormInteraction {

    AdminFormDetails detailsAdminForm;
    AdminFormMenu menuAdminForm;
    LoginMenu menuLogin;
    LoginInteraction interactionLogin;

    public AdminFormInteraction(AdminFormDetails modelAdmin, AdminFormMenu viewAdmin) {
        this.detailsAdminForm = modelAdmin;
        this.menuAdminForm = viewAdmin;

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
        
        menuAdminForm.adminDetailsConfirmation();
        
        if (menuAdminForm.getShowAdminFNameError() == true) {
            menuAdminForm.displayAdminFNameError();
        }

        if (menuAdminForm.getShowAdminLNameError() == true) {
            menuAdminForm.displayAdminLNameError();
        }
        
        if (menuAdminForm.getShowAdminJobTitleError() == true) {
            menuAdminForm.displayAdminJobTitleError();
        }
        
        if (menuAdminForm.getShowAdminPhoneNumberError() == true) {
            menuAdminForm.displayAdminPhoneNumberError();
        }
        
        if (menuAdminForm.getShowAdminEmailAddressError() == true) {
            menuAdminForm.displayAdminEmailAddressError();
        }
        
        if (menuAdminForm.getShowAdminRegSuccess() == true){
            
            menuAdminForm.displayAdminRegSuccess();
        }
        
        if (menuAdminForm.getValidAdminDetails() == true) {
            menuAdminForm.setVisible(false);

            LoginMenu menuLogin = new LoginMenu();
            LoginInteraction interactionLogin = new LoginInteraction(menuLogin, detailsAdminForm, menuAdminForm);
            menuLogin.setVisible(true);

        }
    }

    public void handleResetAdminDetailsClick() {
        
        menuAdminForm.adminDetailsReset();

    }

    public void mouseEnteredProceedToLogin() {
        
        menuAdminForm.mouseEnterProceedToLogin();

    }

    public void mouseExitedProceedToLogin() {
        
        menuAdminForm.mouseExitProceedToLogin();

    }
    
    public void mouseEnteredResetAdminDetails() {
        menuAdminForm.mouseEnterResetAdminDetails();

    }

    public void mouseExitedResetAdminDetails() {
        
        menuAdminForm.mouseExitResetAdminDetails();

    }

}
