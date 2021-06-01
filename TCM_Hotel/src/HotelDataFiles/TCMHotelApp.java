package HotelDataFiles;

import HotelGuiController.WelcomeAppGuiInteraction;
import HotelGuiView.WelcomeAppGuiMenu;
import HotelDatabase.HotelProductDB;

/**
 * This is the driver class from where the program is ran from, 
 * which includes the main method and objects of the welcome class.
 * @author faaris
 */ 
//comment 1

public class TCMHotelApp
{
    public static void main(String[] args) 
    {
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
        hotelMenuDB.createAdminListTable();
        hotelMenuDB.closeConnection();
        
        WelcomeAppGuiMenu viewClass = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction controllerClass = new WelcomeAppGuiInteraction(viewClass);
    }
}
