/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelDB;

import hotelModel.GuestModel;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project2hotelapp.CalculateCosts;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath/anuk
 */
public class HotelProductDB 
{
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public HotelProductDB()
    {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void closeConnection()
    {
        this.dbManager.closeConnnections();
    }
    
    public void checkTableExistence(String name)
    {
        try
        {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types  = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, name, types);
            
            if(rs.next())
            {
                statement.executeUpdate("Drop table " +name);
                System.out.println("Table " +name+ " has been deleted"); 
            }
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean checkTableStatus(String name)
    {
        boolean createTable = true;
        
        try
        {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types  = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, name, types);
            
            if(rs.next())
            {
                System.out.println("Table " +name+ " already exists! Doesnt need to be dropped!"); 
                createTable = false;
            }
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return createTable;
    }
    
    public void createHLocationTable() 
    {
        try
        {
            this.statement = conn.createStatement();
            this.checkTableExistence("HOTEL_LOCATIONS");
            this.statement.addBatch("CREATE  TABLE HOTEL_LOCATIONS  (HOTEL_ID INT,   TITLE   VARCHAR(50),   LOCATION VARCHAR(20),   RATING INT, VACANCY_TYPE VARCHAR(1))");
            this.statement.addBatch("INSERT INTO HOTEL_LOCATIONS VALUES (0, 'Auckland Hotel - 31 Starcent Ave', 'Auckland', 5, 'Y'),\n"
                    + "(1, 'Rotorua Hotel - 17 Geyser Crescent', 'Rotorua', 3, 'Y'),\n"
                    + "(2, 'Taupo Hotel - 48 Lake Street', 'Taupo', 4, 'N'),\n"
                    + "(3, 'Palmerston North Hotel - 69 Leggy Lane', 'Palmerston North', 4, 'Y'),\n"
                    + "(4, 'Wellington Hotel - 128 Bee Ave', 'Wellington', 5, 'N'),\n"
                    + "(5, 'Christchurch Hotel - 27 Meadow Lane', 'Christchurch',4, 'Y'),\n"
                    + "(6, 'Dunedin Hotel - 987 Lonely Road','Dunedin', 4, 'N'),\n"
                    + "(7, 'Queenstown Hotel - 52 New South Drive', 'Queenstown', 5, 'Y')");
            this.statement.executeBatch();
            System.out.println("Locations Table has been created");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void createHRoomsTable()
    {
        try
        { 
            this.statement = conn.createStatement();
            this.checkTableExistence("HOTEL_ROOMS");
            this.statement.addBatch("CREATE  TABLE HOTEL_ROOMS  (ROOM_TYPE_ID INT,   TITLE   VARCHAR(50),   ROOM_TYPE VARCHAR(20), PRICE   FLOAT, ROOM_AVAILABLE VARCHAR(1))");
            this.statement.addBatch("INSERT INTO HOTEL_ROOMS VALUES (0, 'Standard Room (1 Double size bed)', 'STANDARD', 200.00, 'Y'),\n"
                    + "(1, 'Deluxe Room (1 King Size bed)', 'DELUXE', 375.00, 'Y'),\n"
                    + "(2, 'Twin Size Room (2 single bed)', 'TWIN', 250.00, 'Y'),\n"
                    + "(3, 'Queen Size (1 queen sized bed)', 'QUEEN', 225.00, 'Y'),\n"
                    + "(4, 'Family Room (Large room)', 'FAMILY', 300.00, 'Y'),\n"
                    + "(5, 'Couples Room (Custom heart-shaped king size bed)', 'COUPLE', 315.00, 'Y')");
            this.statement.executeBatch();
            System.out.println("Rooms Table has been created");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void createHGuestTypeTable()
    {
        try
        {
            this.statement = conn.createStatement();
            this.checkTableExistence("HOTEL_GUEST_TYPES");
            this.statement.addBatch("CREATE  TABLE HOTEL_GUEST_TYPES  (GUEST_TYPE_ID INT,   TITLE   VARCHAR(50),   GUEST_TYPE VARCHAR(20), PRICE   FLOAT)");
            this.statement.addBatch("INSERT INTO HOTEL_GUEST_TYPES VALUES (0, 'Adult (18-64 yrs)', 'ADULT', 30.00),\n"
                    + "(1, 'Child (4-17 yrs)', 'CHILD', 10.00),\n"
                    + "(2, 'Infant (0-3 yrs)', 'INFANT', 0.00),\n"
                    + "(3, 'Elderly (65+ yrs)', 'ELDERLY', 15.00),\n"
                    + "(4, 'VIP (Famous)', 'VIP', 100.00)");
            this.statement.executeBatch();
            System.out.println("Guest Types table has been created");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void createHFeaturesTable()
    {
        try
        {
            this.statement = conn.createStatement();
            this.checkTableExistence("HOTEL_FEATURES");
            this.statement.addBatch("CREATE  TABLE HOTEL_FEATURES  (FEATURE_TYPE_ID INT,   TITLE   VARCHAR(50),   FEATURE_TYPE VARCHAR(20), PRICE   FLOAT)");
            this.statement.addBatch("INSERT INTO HOTEL_FEATURES VALUES (0, 'Spa pass', 'SPA', 10.00),\n"
                    + "(1, 'Jacuzzi pass', 'JACUZZI', 10.00),\n"
                    + "(2, 'Sauna pass', 'SAUNA', 10.00),\n"
                    + "(3, 'Gym pass', 'GYM', 20.00)");
            this.statement.executeBatch();
            System.out.println("Feature Types table has been created");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void createGuestListTable(){
        try{
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("GUEST_LIST");
            
            if (createTable == true)
            {
                //this.checkTableExistence("GUEST_LIST");
                this.statement.addBatch("CREATE TABLE GUEST_LIST (GUEST_FIRSTNAME VARCHAR(50), GUEST_LASTNAME VARCHAR(50), GUEST_AGE VARCHAR(30), GUEST_PHONENUMBER VARCHAR(50), GUEST_EMAILADDRESS VARCHAR(50), GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_TOTALPAID VARCHAR(50))");
                this.statement.executeBatch();
                System.out.println("Table GUEST_LIST has been created");
            }
            else if (createTable == false)
            {
                System.out.println("GUEST_LIST table has not been droppped or created again!");
            }           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void createAdminListTable() {
        try {
            
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("ADMIN_LIST");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE ADMIN_LIST (ADMIN_FIRSTNAME VARCHAR(50), ADMIN_LASTNAME VARCHAR(50), ADMIN_JOBTITLE VARCHAR(50), ADMIN_PHONENUMBER VARCHAR(50), ADMIN_EMAILADDRESS VARCHAR(50))");
                this.statement.executeBatch();
                System.out.println("Table ADMIN_LIST has been created");
            }
            else if (createTable == false)
            {
                System.out.println("ADMIN_LIST table has not been dropped or created again!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    
    public void createLocationBookedTable()
    {
        try
        {
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("BOOKED_HOTEL_LOCATIONS");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE BOOKED_HOTEL_LOCATIONS (GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_FIRSTNAME VARCHAR(50), LOCATION_TITLE   VARCHAR(50), LOCATION VARCHAR(20))");
                this.statement.executeBatch();
                System.out.println("BOOKED_HOTEL_LOCATIONS table is created");
            }
            else if (createTable == false)
            {
                System.out.println("BOOKED_HOTEL_LOCATIONS table has not been dropped or created again!");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }        
    }
    
    public void createDatesBookedTable()
    {
        try
        {
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("BOOKED_HOTEL_DATES");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE BOOKED_HOTEL_DATES (GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_FIRSTNAME VARCHAR(50), LOCATION VARCHAR(20), CHECK_IN_DAY VARCHAR(50), CHECK_IN_MONTH VARCHAR(15), CHECK_IN_YEAR VARCHAR(10),"
                        + "CHECK_OUT_DAY VARCHAR(50), CHECK_OUT_MONTH VARCHAR(15), CHECK_OUT_YEAR VARCHAR(10))");
                this.statement.executeBatch();
                System.out.println("BOOKED_HOTEL_DATES table is created");
            }
            else if (createTable == false)
            {
                System.out.println("BOOKED_HOTEL_DATES table has not been dropped or created again!");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
        
    }
    
    public void createRoomsBookedTable()
    {
        try
        {
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("BOOKED_HOTEL_DATES");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE BOOKED_HOTEL_ROOMS (GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_FIRSTNAME VARCHAR(50), ROOM_TITLE VARCHAR(50), ROOM_TYPE VARCHAR(30))");
                this.statement.executeBatch();
                System.out.println("BOOKED_HOTEL_ROOMS table is created");
            }
            else if (createTable == false)
            {
                System.out.println("BOOKED_HOTEL_ROOMS table has not been dropped or created again!");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
        
    }
    
    public void createGuestTypeBookedTable()
    {
        try
        {
            this.statement = conn.createStatement();
            boolean createTable = this.checkTableStatus("BOOKED_HOTEL_DATES");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE BOOKED_GUEST_TYPES (GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_FIRSTNAME VARCHAR(50), GUEST_TITLE VARCHAR(20), GUEST_TYPE VARCHAR(10))");
                this.statement.executeBatch();
                System.out.println("BOOKED_GUEST_TYPES table is created");
            }
            else if (createTable == false)
            {
                System.out.println("BOOKED_HOTEL_DATES table has not been dropped or created again!");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
        
    }
    
    public void createFeaturesBookedTable()
    {
        try
        {
            this.statement = conn.createStatement(); 
            boolean createTable = this.checkTableStatus("BOOKED_HOTEL_DATES");
            
            if (createTable == true)
            {
                this.statement.addBatch("CREATE TABLE BOOKED_FEATURES (GUEST_ACCOUNTNUMBER VARCHAR(50), GUEST_FIRSTNAME VARCHAR(50), FEATURE_TITLE VARCHAR(20), FEATURE_TYPE VARCHAR(10))");
                this.statement.executeBatch();
                System.out.println("BOOKED_FEATURES table is created");
            }
            else if (createTable == false)
            {
                System.out.println("BOOKED_FEATURES table has not been dropped or created again!");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
        
    }
    
    public void registerGuest(GuestModel guest, CalculateCosts guestCosts){
        try{
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO GUEST_LIST (GUEST_FIRSTNAME, GUEST_LASTNAME, GUEST_AGE, GUEST_PHONENUMBER, GUEST_EMAILADDRESS, GUEST_ACCOUNTNUMBER, GUEST_TOTALPAID) VALUES('"+ guest.getGuestFirstName()+"', '"+ guest.getGuestLastName()+"', '"+ guest.getGuestAge()+"', '"+ guest.getGuestPhoneNumber()+"', '"+ guest.getGuestEmail()+"', '"+ guest.getGuestAccountNumber()+"', '"+ guestCosts.guestsTotalCost()+"')");
            this.statement.executeBatch();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void registerAdmin(AdminFormModel admin) {
        try {
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO ADMIN_LIST (ADMIN_FIRSTNAME, ADMIN_LASTNAME, ADMIN_JOBTITLE, ADMIN_PHONENUMBER, ADMIN_EMAILADDRESS) VALUES('" + admin.getAdminFirstName() + "', '" + admin.getAdminLastName() + "', '" + admin.getAdminJobTitle()+ "', '" + admin.getAdminPhoneNumber() + "', '" + admin.getAdminEmailAddress() + "')");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void dbAddLocationsBooked(GuestModel guest, ArrayList<GuestsBookingCart> locationBooked)
    {
        try
        {
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO BOOKED_HOTEL_LOCATIONS (GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, LOCATION_TITLE, LOCATION) VALUES "
                    + "('"+ guest.getGuestAccountNumber()+"', '"+ guest.getGuestFirstName()+"', '"+ locationBooked.get(0).getTitle()+"', '" +locationBooked.get(0).getLocationType()+"')");
            this.statement.executeBatch();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }  
    }
    
    public void dbAddDatesBooked(GuestModel guest, ArrayList<GuestsBookingCart> locationBooked, ArrayList<GuestsBookingCart> datesBooked)
    {
        try
        {
            this.statement = conn.createStatement(); 
            this.statement.addBatch("INSERT INTO BOOKED_HOTEL_DATES (GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, LOCATION, CHECK_IN_DAY, CHECK_IN_MONTH, CHECK_IN_YEAR, CHECK_OUT_DAY, CHECK_OUT_MONTH, CHECK_OUT_YEAR) VALUES "
                    + "('"+ guest.getGuestAccountNumber()+"', '"+ guest.getGuestFirstName()+"', '" +locationBooked.get(0).getLocationType()+ "', '" +datesBooked.get(0).getCheckInDay()+"', '" +datesBooked.get(0).getCheckInMonth()+"', '" +datesBooked.get(0).getCheckInYear()
                    +"', '" +datesBooked.get(0).getCheckOutDay()+"', '" +datesBooked.get(0).getCheckOutMonth()+"', '" +datesBooked.get(0).getCheckOutYear()+"' )");
            this.statement.executeBatch();
        }
        catch(SQLException ex)
        {
            ex.getNextException();
            ex.printStackTrace();
        }  
    }
    
    public void dbAddRoomsBooked(GuestModel guest, ArrayList<GuestsBookingCart> roomsDetails)
    {
        try
        {
            for (GuestsBookingCart roomsBooked : roomsDetails) 
            {
                this.statement = conn.createStatement();
                this.statement.addBatch("INSERT INTO BOOKED_HOTEL_ROOMS (GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, ROOM_TITLE, ROOM_TYPE) VALUES "
                    + "('"+ guest.getGuestAccountNumber()+"', '"+ guest.getGuestFirstName()+"', '" +roomsBooked.getTitle()+ "', '" +roomsBooked.getRoomType()+"' )");
                this.statement.executeBatch();
            }   
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }  
    }
    
    public void dbAddGuestTypeBooked(GuestModel guest, ArrayList<GuestsBookingCart> guestTypeDetails)
    {
        try
        {
            for (GuestsBookingCart guestTypeBooked : guestTypeDetails) 
            {
                this.statement = conn.createStatement();
                this.statement.addBatch("INSERT INTO BOOKED_GUEST_TYPES (GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, GUEST_TITLE, GUEST_TYPE) VALUES "
                    + "('"+ guest.getGuestAccountNumber()+"', '"+ guest.getGuestFirstName()+"', '" +guestTypeBooked.getTitle()+ "', '" +guestTypeBooked.getGuestType()+"' )");
                this.statement.executeBatch();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }  
    }
    
    public void dbAddFeaturesBooked(GuestModel guest, ArrayList<GuestsBookingCart> featuresDetails)
    {
        try
        {
            for (GuestsBookingCart featuresBooked : featuresDetails) 
            {
                this.statement = conn.createStatement();
                this.statement.addBatch("INSERT INTO BOOKED_FEATURES (GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, FEATURE_TITLE, FEATURE_TYPE) VALUES "
                    + "('"+ guest.getGuestAccountNumber()+"', '"+ guest.getGuestFirstName()+"', '" +featuresBooked.getTitle()+ "', '" +featuresBooked.getFeatureType()+"' )");
                this.statement.executeBatch();
            }  
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }  
    }
    
    public ArrayList<ViewRecords> getStaffRecords(){
        
        ResultSet rs = null;
        ArrayList<ViewRecords> saveStaffRecords = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT ADMIN_FIRSTNAME, ADMIN_LASTNAME, ADMIN_JOBTITLE, ADMIN_PHONENUMBER, ADMIN_EMAILADDRESS FROM ADMIN_LIST");
            while (rs.next()) {
                String adminFName = rs.getString("ADMIN_FIRSTNAME");
                String adminLName = rs.getString("ADMIN_LASTNAME");
                String adminJobTitle = rs.getString("ADMIN_JOBTITLE");
                String adminPhoneNum = rs.getString("ADMIN_PHONENUMBER");
                String adminEmail = rs.getString("ADMIN_EMAILADDRESS");
                ViewRecords staffDetails = new ViewRecords(adminFName, adminLName, adminJobTitle, adminPhoneNum, adminEmail);
                saveStaffRecords.add(staffDetails);
            }
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return saveStaffRecords;
        
    }
    
    public ArrayList<ViewRecords> getGuestRecords(){
        
        ResultSet rs = null;
        ArrayList<ViewRecords> saveGuestRecords = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_FIRSTNAME, GUEST_LASTNAME, GUEST_AGE, GUEST_PHONENUMBER, GUEST_EMAILADDRESS, GUEST_ACCOUNTNUMBER, GUEST_TOTALPAID FROM GUEST_LIST");
            while (rs.next()) {
                String guestFName = rs.getString("GUEST_FIRSTNAME");
                String guestLName = rs.getString("GUEST_LASTNAME");
                String guestAge = rs.getString("GUEST_AGE");
                String guestPhoneNum = rs.getString("GUEST_PHONENUMBER");
                String guestEmailAddress = rs.getString("GUEST_EMAILADDRESS");
                String guestAccountNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String guestTotalPaid = rs.getString("GUEST_TOTALPAID");
                ViewRecords guestDetails = new ViewRecords(guestFName, guestLName, guestAge, guestPhoneNum, guestEmailAddress, guestAccountNumber, guestTotalPaid);
                saveGuestRecords.add(guestDetails);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saveGuestRecords;
    }
    
     public ArrayList<ViewRecords> getLocationsBookedRecords(){
        
        ResultSet rs = null;
        ArrayList<ViewRecords> saveLocationsBookedRcds = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, LOCATION_TITLE, LOCATION FROM BOOKED_HOTEL_LOCATIONS");
            while (rs.next()) {
                String gAccNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String gFName = rs.getString("GUEST_FIRSTNAME");
                String locTitle = rs.getString("LOCATION_TITLE");
                LocationType location = LocationType.valueOf(rs.getString("LOCATION"));
                ViewRecords locBookedDetails = new ViewRecords(gAccNumber, gFName, locTitle, location);
                saveLocationsBookedRcds.add(locBookedDetails);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saveLocationsBookedRcds;
        
    }
     
    public ArrayList<ViewRecords> getDatesBookedRecords() {

        ResultSet rs = null;
        ArrayList<ViewRecords> saveDatesBookedRecords = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, LOCATION, CHECK_IN_DAY, CHECK_IN_MONTH, CHECK_IN_YEAR, CHECK_OUT_DAY, CHECK_OUT_MONTH, CHECK_OUT_YEAR FROM BOOKED_HOTEL_DATES");
            while (rs.next()) {
                String gAccNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String gFName = rs.getString("GUEST_FIRSTNAME");
                LocationType location = LocationType.valueOf(rs.getString("LOCATION"));
                String checkInDay = rs.getString("CHECK_IN_DAY");
                String checkInMonth = rs.getString("CHECK_IN_MONTH");
                String checkInYear = rs.getString("CHECK_IN_YEAR");
                String checkOutDay = rs.getString("CHECK_OUT_DAY");
                String checkOutMonth = rs.getString("CHECK_OUT_MONTH");
                String checkOutYear = rs.getString("CHECK_OUT_YEAR");
                ViewRecords datesBookedDetails = new ViewRecords(gAccNumber, gFName, location, checkInDay, checkInMonth, checkInYear, checkOutDay, checkOutMonth, checkOutYear);
                saveDatesBookedRecords.add(datesBookedDetails);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saveDatesBookedRecords;

    }
    
     public ArrayList<ViewRecords> getRoomsBookedRecords() {

        ResultSet rs = null;
        ArrayList<ViewRecords> saveRoomsBookedRcds = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, ROOM_TITLE, ROOM_TYPE FROM BOOKED_HOTEL_ROOMS");
            while (rs.next()) {
                String gAccNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String gFName = rs.getString("GUEST_FIRSTNAME");
                String roomTitle = rs.getString("ROOM_TITLE");
                RoomType location = RoomType.valueOf(rs.getString("ROOM_TYPE"));
                ViewRecords roomsBookedDetails = new ViewRecords(gAccNumber, gFName, roomTitle, location);
                saveRoomsBookedRcds.add(roomsBookedDetails);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saveRoomsBookedRcds;

    }
     
    public ArrayList<ViewRecords> getGuestTypesRecords() {

        ResultSet rs = null;
        ArrayList<ViewRecords> saveGuestTypesRecords = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, GUEST_TITLE, GUEST_TITLE, GUEST_TYPE FROM BOOKED_GUEST_TYPES");
            while (rs.next()) {
                String gAccNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String gFName = rs.getString("GUEST_FIRSTNAME");
                String guestTitle = rs.getString("GUEST_TITLE");
                GuestType guestType = GuestType.valueOf(rs.getString("GUEST_TYPE"));
                ViewRecords guestTypesBookedDetails = new ViewRecords(gAccNumber, gFName, guestTitle, guestType);
                saveGuestTypesRecords.add(guestTypesBookedDetails);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saveGuestTypesRecords;

    }
    
    public ArrayList<ViewRecords> getFeaturesBookedRecords(){
        
        ResultSet rs = null;
        ArrayList<ViewRecords> saveFeaturesBookedRcds = new ArrayList<ViewRecords>();
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_ACCOUNTNUMBER, GUEST_FIRSTNAME, FEATURE_TITLE, FEATURE_TYPE FROM BOOKED_FEATURES");
            while (rs.next()) {
                String gAccNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                String gFName = rs.getString("GUEST_FIRSTNAME");
                String featureTitle = rs.getString("FEATURE_TITLE");
                ExtraFeatureTypes featureType = ExtraFeatureTypes.valueOf(rs.getString("FEATURE_TYPE"));
                ViewRecords featuresBookedDetails = new ViewRecords(gAccNumber, gFName, featureTitle, featureType);
                saveFeaturesBookedRcds.add(featuresBookedDetails);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saveFeaturesBookedRcds;
        
    }
}
