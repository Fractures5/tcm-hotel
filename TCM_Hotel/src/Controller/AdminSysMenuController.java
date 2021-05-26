/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminSysMenuModel;
import View.AdminSysMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anuk
 */
public class AdminSysMenuController {
    
    AdminSysMenuModel modelAdminSystem;
    AdminSysMenuView viewAdminSystem;
    
    public AdminSysMenuController(AdminSysMenuModel modelAdminSystem, AdminSysMenuView viewAdminSystem){
        
        this.modelAdminSystem = modelAdminSystem;
        this.viewAdminSystem = viewAdminSystem;
        
        viewAdminSystem.getViewGuests().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewGuests();
            }
        });
        
        viewAdminSystem.getViewStaff().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewStaff();
            }
        });
    }
    
    public void handleViewGuests(){
        
        viewAdminSystem.showGuestRecords();
        
    }
    
    public void handleViewStaff() {
        
        viewAdminSystem.showStaffRecords();

    }
    
}
