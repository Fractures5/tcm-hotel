package HotelDataFiles;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package project2hotelapp;
//
//import HotelGuiController.BookDatesInteraction;
//import hotelDB.HotelProductDB;
//
//import HotelGuiModel.BookedHotelDates;
//import HotelGuiView.HotelDatesMenu;
//import java.sql.SQLException;
//import javax.swing.JFrame;
//
//
///**
// *
// * @author Siddarath
// */
//public class Project2HotelApp extends JFrame{
//  
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws SQLException {
//        // TODO code application logic here
//        //bookDate = new HotelDatesMenu();
//        //bookLocation = new GuestChooseHotel();
//        //bookRooms = new GuestChooseRoom();
//        //bookingCart = new BookingCartMenu();
//      
//        
//        HotelProductDB hotelMenuDB = new HotelProductDB();
//        hotelMenuDB.createHLocationTable();
//        hotelMenuDB.createHRoomsTable();
//        hotelMenuDB.createHGuestTypeTable();
//        hotelMenuDB.createHFeaturesTable();
//        hotelMenuDB.createGuestListTable();
//        hotelMenuDB.createDatesBookedTable();
//        hotelMenuDB.createLocationBookedTable();
//        hotelMenuDB.createRoomsBookedTable();
//        hotelMenuDB.createGuestTypeBookedTable();
//        hotelMenuDB.createFeaturesBookedTable();
//        hotelMenuDB.closeConnection();
//    
//        BookedHotelDates datesModel = new BookedHotelDates();
//        HotelDatesMenu datesView = new HotelDatesMenu();
//        BookDatesInteraction selectDates = new BookDatesInteraction(datesModel, datesView);
//    }
//
//}
