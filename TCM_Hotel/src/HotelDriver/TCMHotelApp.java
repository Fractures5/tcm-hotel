package HotelDriver;

import HotelGuiController.WelcomeAppGuiInteraction;
import HotelGuiView.WelcomeAppGuiMenu;
import HotelDatabase.HotelProductDB;

/**
 * This is the driver class from where the program is ran from, 
 * which includes the main method and objects of the welcome class.
 * @author faaris
 */ 
public class TCMHotelApp
{
    public static void main(String[] args) 
    {
        System.out.println("This is the administrator log - showing when connections are made, customers have been added, etc...");
        System.out.println("-----------------------------------------------------------------------------------------------------\n");
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
