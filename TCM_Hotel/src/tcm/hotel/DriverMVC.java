/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import Controller.AdminController;
import Controller.LoginController;
import Controller.GuestController;
import Model.LoginModel;
import Model.AdminModel;
import Model.GuestModel;
import View.LoginView;
import View.AdminView;
import View.GuestView;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;

/**
 *
 * @author Anuk
 */
public class DriverMVC {
    
    public static void main(String[] args){
        
        HotelProductDB hotelMenuDB = new HotelProductDB();
        DBManager manager = new DBManager();
        hotelMenuDB.createAdminListTable();
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
        AdminModel modelAdmin = new AdminModel();
        AdminView viewAdmin = new AdminView();
        AdminController controllerAdmin = new AdminController(modelAdmin, viewAdmin);
        
        //LoginModel modelLogin = new LoginModel();
        //LoginView viewLogin = new LoginView();
        //LoginController controllerLogin = new LoginController(modelLogin, viewLogin);
        
        //GuestModel modelGuest = new GuestModel();
        //GuestView viewGuest = new GuestView();
        //GuestController controllerGuest = new GuestController(modelGuest, viewGuest);
        
        //viewGuest.setVisible(true);
        viewAdmin.setVisible(true);
        //viewLogin.setVisible(true);
        
    }

}
