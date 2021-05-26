/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelDB;

import Model.AdminFormModel;
import Model.GuestModel;
import hotelDB.DBManager;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcm.hotel.ViewRecords;

/**
 *
 * @author Anuk
 */
public class HotelProductDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public HotelProductDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();

    }

    public ArrayList<ViewRecords> getStaffRecords(){
        
        ResultSet rs = null;
        ArrayList<ViewRecords> staffList = new ArrayList<ViewRecords>();
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
                staffList.add(staffDetails);
                //System.out.println(adminFName + adminLName + adminJobTitle + adminPhoneNum + adminEmail);
            }
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staffList;
        
    }
    
    public ResultSet getGuestRecords(){
        
        ResultSet rs = null;
        
        try {
            this.statement = conn.createStatement();
            rs = statement.executeQuery("SELECT GUEST_FIRSTNAME, GUEST_LASTNAME, GUEST_AGE, GUEST_PHONENUMBER, GUEST_EMAILADDRESS, GUEST_ACCOUNTNUMBER FROM GUEST_LIST");
            while (rs.next()) {
                String guestFName = rs.getString("GUEST_FIRSTNAME");
                String guestLName = rs.getString("GUEST_LASTNAME");
                String guestAge = rs.getString("GUEST_AGE");
                String guestPhoneNum = rs.getString("GUEST_PHONENUMBER");
                String guestEmailAddress = rs.getString("GUEST_EMAILADDRESS");
                String guestAccountNumber = rs.getString("GUEST_ACCOUNTNUMBER");
                //System.out.println(guestFName + guestLName + guestAge + guestPhoneNum + guestEmailAddress + guestAccountNumber);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (rs);
        
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

    public void registerGuest(GuestModel guest){
        try{
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO GUEST_LIST (GUEST_FIRSTNAME, GUEST_LASTNAME, GUEST_AGE, GUEST_PHONENUMBER, GUEST_EMAILADDRESS, GUEST_ACCOUNTNUMBER) VALUES('"+ guest.getGuestFirstName()+"', '"+ guest.getGuestLastName()+"', '"+ guest.getGuestAge()+"', '"+ guest.getGuestPhoneNumber()+"', '"+ guest.getGuestEmail()+"', '"+ guest.getGuestAccountNumber()+"')");
            this.statement.executeBatch();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void createAdminListTable() {
        try {
            this.statement = conn.createStatement();
            //this.checkTableExistence("ADMIN_LIST");
            this.statement.addBatch("CREATE TABLE ADMIN_LIST (ADMIN_FIRSTNAME VARCHAR(50), ADMIN_LASTNAME VARCHAR(50), ADMIN_JOBTITLE VARCHAR(50), ADMIN_PHONENUMBER VARCHAR(50), ADMIN_EMAILADDRESS VARCHAR(50))");
            this.statement.executeBatch();
            System.out.println("Table Admin_List has been created");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void createGuestListTable(){
        try{
            this.statement = conn.createStatement();
            //this.checkTableExistence("GUEST_LIST");
            this.statement.addBatch("CREATE TABLE GUEST_LIST (GUEST_FIRSTNAME VARCHAR(50), GUEST_LASTNAME VARCHAR(50), GUEST_AGE VARCHAR(30), GUEST_PHONENUMBER VARCHAR(50), GUEST_EMAILADDRESS VARCHAR(50), GUEST_ACCOUNTNUMBER VARCHAR(50))");
            this.statement.executeBatch();
            System.out.println("Table Guest_List has been created");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void createHLocationTable() {
        try {
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void createHRoomsTable() {
        try {
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void createHGuestTypeTable() {
        try {
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void createHFeaturesTable() {
        try {
            this.statement = conn.createStatement();
            this.checkTableExistence("HOTEL_FEATURES");
            this.statement.addBatch("CREATE  TABLE HOTEL_FEATURES  (FEATURE_TYPE_ID INT,   TITLE   VARCHAR(50),   FEATURE_TYPE VARCHAR(20), PRICE   FLOAT)");
            this.statement.addBatch("INSERT INTO HOTEL_FEATURES VALUES (0, 'Spa pass', 'SPA', 10.00),\n"
                    + "(1, 'Jacuzzi pass', 'JACUZZI', 10.00),\n"
                    + "(2, 'Sauna pass', 'SAUNA', 10.00),\n"
                    + "(3, 'Gym pass', 'GYM', 20.00)");
            this.statement.executeBatch();
            System.out.println("Feature Types table has been created");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }

    public void checkTableExistence(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            if(rs.next()){
                statement.executeUpdate("Drop table " +name);
                System.out.println("Table " +name+ " has been deleted");
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        this.dbManager.closeConnnections();
    }
    
}
