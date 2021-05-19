/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelDB;

import hotelDB.DBManager;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Siddarath
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
    
    public void createHLocationTable() 
    {
        try
        {
            //Class.forName("jdbc:derby://localhost:1527/TCMHotelDB"); 
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
        
        /*catch(ClassNotFoundException e)
        {
            
        }*/
    }
    
    public void createHRoomsTable()
    {
        try
        {
            //Class.forName("jdbc:derby://localhost:1527/TCMHotelDB"); 
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
    
    public void checkTableExistence(String name)
    {
        try
        {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types  = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);
            
            while(rs.next())
            {
                String table_name = rs.getString("TABLE NAME");
                System.out.println(table_name);
                if(table_name.equalsIgnoreCase(name))
                {
                    statement.executeUpdate("Drop table " +name);
                    System.out.println("Table " +name+ " has been deleted");
                    break;
                }
            }
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeConnection()
    {
        this.dbManager.closeConnnections();
    }
}