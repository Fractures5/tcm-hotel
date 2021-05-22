/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import Controller.AdminController;
import Controller.GuestController;
import Model.AdminModel;
import Model.GuestModel;
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
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
        AdminModel mAdmin = new AdminModel();
        AdminView vAdmin = new AdminView();
        AdminController cAdmin = new AdminController(mAdmin, vAdmin);
        
        //GuestModel model = new GuestModel();
        //GuestView view = new GuestView();
        //GuestController controller = new GuestController(model, view);
        
        //view.setVisible(true);
        vAdmin.setVisible(true);
        
    }

}
