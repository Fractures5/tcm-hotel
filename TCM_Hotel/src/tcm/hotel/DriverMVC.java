/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import Controller.GuestController;
import Model.GuestModel;
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
        
        GuestView view = new GuestView();
        GuestModel model = new GuestModel();
        model.setGuestFirstName(model.getGuestFirstName());
        
        GuestController controller = new GuestController(view, model);

        view.setVisible(true);
        
    }

}
