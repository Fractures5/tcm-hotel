/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminFormModel;
import Model.AdminSysMenuModel;
import Model.LoginModel;
import View.AdminFormView;
import View.AdminSysMenuView;
import View.LoginView;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anuk
 */
public class LoginController {
    
    LoginModel modelLogin;
    LoginView viewLogin;
    AdminFormModel modelAdmin;
    AdminFormView viewAdmin;
    
    public LoginController(LoginModel modelLogin, LoginView viewLogin, AdminFormModel modelAdmin, AdminFormView viewAdmin){
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        
        
        viewLogin.getLogin().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                handleLoginClick();
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
    
    public void handleLoginClick(){
        viewLogin.loginSystemBackend();
        
        if(viewLogin.getShowInvalidPasswordError() == true){
            viewLogin.displayInvalidPasswordError();
        }
        
        if(viewLogin.getShowInvalidPasswordError() == false && viewLogin.getMatchingSystemPassword()== true){
            viewLogin.displayLoginSuccessful();
            modelAdmin.setAdminFirstName(viewAdmin.getAdminFNameField());
            modelAdmin.setAdminLastName(viewAdmin.getAdminLNameField());
            modelAdmin.setAdminJobTitle(viewAdmin.getAdminJobTitleField());
            modelAdmin.setAdminPhoneNumber(viewAdmin.getAdminPhoneNumField());
            modelAdmin.setAdminEmailAddress(viewAdmin.getAdminEmailField());
            System.out.println(modelAdmin.getAdminFirstName());
            HotelProductDB productDB = new HotelProductDB();
            DBManager db = new DBManager();
            productDB.registerAdmin(modelAdmin);
            viewLogin.setVisible(false);
            AdminSysMenuModel modelAdminSystem = new AdminSysMenuModel();
            AdminSysMenuView viewAdminSystem = new AdminSysMenuView();
            AdminSysMenuController controllerAdminSys = new AdminSysMenuController(modelAdminSystem, viewAdminSystem);
            viewAdminSystem.setVisible(true);
            
        }
    }
    
    public void handleClearPasswordClick() {
        viewLogin.clearInputPassword();
    }
    
    public void handleMainMenuClick() {
        viewLogin.returnToMainMenu();
    }
    
    public void handleShowPasswordClick() {
        if(viewLogin.getShowPassword().isSelected()){
            viewLogin.toggleShowPassword();
        }
        else{
            viewLogin.toggleHidePassword();
        }
    }
    
}
