/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import hotelDB.HotelProductDB;
import hotelControllers.FeaturesMenuInteraction;
import hotelControllers.LocationMenuInteraction;
import hotelModel.HotelFeatures;
import hotelModel.HotelLocations;
import hotelModel.HotelRooms;
import hotelView.HotelChooseDates;
import hotelView.HotelFeaturesMenu;
import hotelView.HotelLocationMenu;
import hotelView.HotelRoomsMenu;
import java.sql.SQLException;
import javafx.scene.control.DatePicker;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Siddarath
 */
public class Project2HotelApp extends JFrame{
    
    
    private static HotelChooseDates bookDate;
    private static GuestChooseHotel bookLocation;
    private static GuestChooseRoom bookRooms;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //bookDate = new HotelChooseDates();
        //bookLocation = new GuestChooseHotel();
        //bookRooms = new GuestChooseRoom();
      
        HotelProductDB hotelMenuDB = new HotelProductDB();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
        HotelLocations locationModel = new HotelLocations();
        HotelLocationMenu locationView = new HotelLocationMenu();
        LocationMenuInteraction locationAction = new LocationMenuInteraction(locationModel, locationView);
        
        
        //locationModel.currentLocationBookings(locationView.getBookingLocation());
    }

}
