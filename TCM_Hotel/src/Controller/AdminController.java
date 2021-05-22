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

 /*viewAdmin.getProceedToLogin().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                handleProceedToLoginClick();
            }
        });
        
        viewAdmin.getResetAdminDetails().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleResetAdminDetailsClick();
            }
        });*/

 /*viewAdmin.getProceedToLogin().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredProceedToLogin();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitedProceedToLogin();
            }
        });*/
    }

    public void handleProceedToLoginClick() {
        viewAdmin.adminDetailsConfirmation();
    }

    public void handleResetAdminDetailsClick() {
        
        viewAdmin.adminDetailsReset();

    }

    public void mouseEnteredProceedToLogin() {

    }

    public void mouseExitedProceedToLogin() {

    }

}
