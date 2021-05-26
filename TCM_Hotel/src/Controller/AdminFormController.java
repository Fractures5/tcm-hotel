/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminFormModel;
import Model.LoginModel;
import View.AdminFormView;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;

/**
 *
 * @author Anuk
 */
public class AdminFormController {

    AdminFormModel modelAdmin;
    AdminFormView viewAdmin;
    LoginView viewLogin;
    LoginController controllerLogin;

    public AdminFormController(AdminFormModel modelAdmin, AdminFormView viewAdmin) {
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

            LoginModel modelLogin = new LoginModel();
            LoginView viewLogin = new LoginView();
            LoginController controllerLogin = new LoginController(modelLogin, viewLogin, modelAdmin, viewAdmin);
            viewLogin.setVisible(true);
            
//            if (viewLogin.getMatchingSystemPassword() == true) {
//                modelAdmin.setAdminFirstName(viewAdmin.getAdminFNameField());
//                modelAdmin.setAdminLastName(viewAdmin.getAdminLNameField());
//                modelAdmin.setAdminJobTitle(viewAdmin.getAdminJobTitleField());
//                modelAdmin.setAdminPhoneNumber(viewAdmin.getAdminPhoneNumField());
//                modelAdmin.setAdminEmailAddress(viewAdmin.getAdminEmailField());
//
//                HotelProductDB productDB = new HotelProductDB();
//                DBManager db = new DBManager();
//                productDB.registerAdmin(modelAdmin);
//            }
//            else{
//                System.out.println("ok");
//            }
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
