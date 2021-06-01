/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import HotelController.AdminFormInteraction;
import HotelController.AdminSysMenuInteraction;
import Controller.BookDatesInteraction;
import HotelController.LoginInteraction;
import HotelController.GuestFormInteraction;
import HotelModel.LoginModel;
import HotelModel.AdminFormDetails;
import HotelModel.AdminSysMenuModel;
import HotelModel.GuestFormDetails;
import HotelModel.HotelBookingDates;
import HotelView.LoginMenu;
import HotelView.AdminFormMenu;
import HotelView.AdminSysMenu;
import HotelView.GuestFormMenu;
import HotelView.HotelDatesMenu;
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
        hotelMenuDB.createDatesBookedTable();
        hotelMenuDB.createFeaturesBookedTable();
        hotelMenuDB.createGuestTypeBookedTable();
        hotelMenuDB.createLocationBookedTable();
        hotelMenuDB.createRoomsBookedTable();
        hotelMenuDB.createAdminListTable();
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
//        AdminFormDetails modelAdmin = new AdminFormDetails();
//        AdminFormMenu viewAdmin = new AdminFormMenu();
//        AdminFormInteraction controllerAdmin = new AdminFormInteraction(modelAdmin, viewAdmin);
            
//        LoginModel modelLogin = new LoginModel();
//        LoginMenu viewLogin = new LoginMenu();
//        LoginInteraction controllerLogin = new LoginInteraction(modelLogin, viewLogin);

//        HotelBookingDates datesModel = new HotelBookingDates();
//        HotelDatesMenu datesView = new HotelDatesMenu();
//        BookDatesInteraction selectDates = new BookDatesInteraction(datesModel, datesView);
        
//        GuestFormDetails modelGuest = new GuestFormDetails();
//        GuestFormMenu viewGuest = new GuestFormMenu();
//        GuestFormInteraction controllerGuest = new GuestFormInteraction(modelGuest, viewGuest);
//        viewGuest.setVisible(true);
//        viewAdmin.setVisible(true);
//        viewLogin.setVisible(true);

        AdminSysMenuModel modelAdminSystem = new AdminSysMenuModel();
        AdminSysMenu viewAdminSystem = new AdminSysMenu();
        AdminSysMenuInteraction controllerAdminSys = new AdminSysMenuInteraction(modelAdminSystem, viewAdminSystem);
        viewAdminSystem.setVisible(true);
    }
}
