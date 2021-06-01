/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiView.AdminSysMenu;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anuk
 */
public class AdminSysMenuInteraction {
    
    AdminSysMenu viewAdminSystem;
    
    public AdminSysMenuInteraction(AdminSysMenu viewAdminSystem){
        
        this.viewAdminSystem = viewAdminSystem;
        
        viewAdminSystem.getMainMenuReturnButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleMainMenuClick();
            }
        });
        
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
        
        viewAdminSystem.getViewLocationsBooked().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewLocationsBooked();
            }
        });
        
        viewAdminSystem.getViewRoomsBooked().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewRoomsBooked();
            }
        });
        
        viewAdminSystem.getViewFeaturesBooked().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewFeaturesBooked();
            }
        });
        
        viewAdminSystem.getViewGuestTypesBooked().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewGuestTypesBooked();
            }
        });
        
        viewAdminSystem.getViewDatesBooked().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewDatesBooked();
            }
        });
    }
    
    public void handleViewGuests(){
        
        viewAdminSystem.showGuestRecords();
        
    }
    
    public void handleViewStaff() {
        viewAdminSystem.showStaffRecords();
    }
    
    public void handleViewLocationsBooked(){
        viewAdminSystem.showLocationsBkdRecords();
    }
    
    public void handleViewRoomsBooked(){
        viewAdminSystem.showRoomsBkdRecords();
    }
    
    public void handleViewFeaturesBooked(){
        viewAdminSystem.showFeaturesBkdRecords();
    }
    
    public void handleViewGuestTypesBooked(){
        viewAdminSystem.showGuestTypesBkdRecords();
    }
    
    public void handleViewDatesBooked(){
        viewAdminSystem.showGuestDatesBkdRecords();
    }
    
    public void handleMainMenuClick() 
    {
        WelcomeAppGuiMenu accessMainMenu = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        viewAdminSystem.returnToMain();
    }
}
