/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiModel.AdminFormDetails;
import HotelGuiView.AdminFormMenu;
import HotelGuiView.AdminSysMenu;
import HotelGuiView.LoginMenu;
import HotelDatabase.DBManager;
import HotelDatabase.HotelProductDB;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anuk
 */
public class LoginInteraction {
    
    LoginMenu menuLogin;
    AdminFormDetails detailsAdminForm;
    AdminFormMenu menuAdminForm;
    
    public LoginInteraction(LoginMenu viewLogin, AdminFormDetails modelAdmin, AdminFormMenu viewAdmin){
        this.menuLogin = viewLogin;
        this.detailsAdminForm = modelAdmin;
        this.menuAdminForm = viewAdmin;
        
        
        viewLogin.getLogin().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    handleLoginClick();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(LoginInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        viewLogin.getClearPassword().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClearPasswordClick();
            }

        });
        
        viewLogin.getMainMenu().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleMainMenuClick();
            }

        });
        
        viewLogin.getShowPassword().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleShowPasswordClick();
            }

        });
    }
    
    public void handleLoginClick() throws SQLException{
        menuLogin.loginSystemBackend();
        
        if(menuLogin.getShowInvalidPasswordError() == true){
            menuLogin.displayInvalidPasswordError();
        }
        
        if(menuLogin.getShowInvalidPasswordError() == false && menuLogin.getMatchingSystemPassword()== true)
        {
            menuAdminForm.dispose();
            menuLogin.displayLoginSuccessful();
            detailsAdminForm.setAdminFirstName(menuAdminForm.getAdminFNameField());
            detailsAdminForm.setAdminLastName(menuAdminForm.getAdminLNameField());
            detailsAdminForm.setAdminJobTitle(menuAdminForm.getJobTitleList().getSelectedItem().toString());
            detailsAdminForm.setAdminPhoneNumber(menuAdminForm.getAdminPhoneNumField());
            detailsAdminForm.setAdminEmailAddress(menuAdminForm.getAdminEmailField());
            System.out.println(detailsAdminForm.getAdminFirstName());
            HotelProductDB productDB = new HotelProductDB();
            DBManager db = new DBManager();
            productDB.registerAdmin(detailsAdminForm);
            menuLogin.setVisible(false);
            AdminSysMenu viewAdminSystem = new AdminSysMenu();
            AdminSysMenuInteraction controllerAdminSys = new AdminSysMenuInteraction(viewAdminSystem);
            viewAdminSystem.setVisible(true);
        }
    }
    
    public void handleClearPasswordClick() {
        menuLogin.clearInputPassword();
    }
    
    public void handleMainMenuClick() 
    {
        WelcomeAppGuiMenu accessMainMenu = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        menuLogin.returnToMainMenu();
    }
    
    public void handleShowPasswordClick() {
        if(menuLogin.getShowPassword().isSelected()){
            menuLogin.toggleShowPassword();
        }
        else{
            menuLogin.toggleHidePassword();
        }
    }
    
}
