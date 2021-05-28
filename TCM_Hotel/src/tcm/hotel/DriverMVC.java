/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import Controller.AdminFormController;
import Controller.AdminSysMenuController;
import Controller.LoginController;
import Controller.GuestController;
import Model.LoginModel;
import Model.AdminFormModel;
import Model.AdminSysMenuModel;
import Model.GuestModel;
import View.LoginView;
import View.AdminFormView;
import View.AdminSysMenuView;
import View.GuestView;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anuk
 */
public class DriverMVC {
    
    public static void main(String[] args) throws SQLException{
        
        HotelProductDB hotelMenuDB = new HotelProductDB();
        DBManager manager = new DBManager();
        hotelMenuDB.createAdminListTable();
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
//        AdminFormModel modelAdmin = new AdminFormModel();
//        AdminFormView viewAdmin = new AdminFormView();
//        AdminFormController controllerAdmin = new AdminFormController(modelAdmin, viewAdmin);
        
//        LoginModel modelLogin = new LoginModel();
//        LoginView viewLogin = new LoginView();
//        LoginController controllerLogin = new LoginController(modelLogin, viewLogin);
        
//        GuestModel modelGuest = new GuestModel();
//        GuestView viewGuest = new GuestView();
//        GuestController controllerGuest = new GuestController(modelGuest, viewGuest);
////        
//        viewGuest.setVisible(true);
//        viewAdmin.setVisible(true);
//        viewLogin.setVisible(true);
        
        AdminSysMenuModel modelAdminSystem = new AdminSysMenuModel();
        AdminSysMenuView viewAdminSystem = new AdminSysMenuView();
        AdminSysMenuController controllerAdminSys = new AdminSysMenuController(modelAdminSystem, viewAdminSystem);
        viewAdminSystem.setVisible(true);

    }

}
