/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import hotelControllers.BookDatesInteraction;
import hotelDB.HotelProductDB;
import hotelControllers.FeaturesMenuInteraction;
import hotelControllers.LocationMenuInteraction;
import hotelControllers.RoomMenuInteraction;
import hotelModel.HotelBookingDates;
import hotelModel.HotelFeatures;
import hotelModel.HotelLocations;
import hotelModel.HotelRooms;
import hotelView.BookingCartMenu;
import hotelView.HotelDatesMenu;
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
    
    
    private static HotelDatesMenu bookDate;
    private static GuestChooseHotel bookLocation;
    private static GuestChooseRoom bookRooms;
    private static BookingCartMenu bookingCart;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //bookDate = new HotelDatesMenu();
        //bookLocation = new GuestChooseHotel();
        //bookRooms = new GuestChooseRoom();
        //bookingCart = new BookingCartMenu();
      
        
        HotelProductDB hotelMenuDB = new HotelProductDB();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createDatesBookedTable();
        hotelMenuDB.createLocationBookedTable();
        hotelMenuDB.createRoomsBookedTable();
        hotelMenuDB.createGuestTypeBookedTable();
        hotelMenuDB.createFeaturesBookedTable();
        hotelMenuDB.closeConnection();
    
        HotelBookingDates datesModel = new HotelBookingDates();
        HotelDatesMenu datesView = new HotelDatesMenu();
        BookDatesInteraction selectDates = new BookDatesInteraction(datesModel, datesView);


    }

}
