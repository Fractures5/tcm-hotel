/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

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
            /*this.checkTableExistence("HOTEL_LOCATIONS");
            this.statement.addBatch("CREATE TABLE HOTEL_LOCATIONS  (HOTEL_ID INT,   TITLE VARCHAR(50),   LOCATION VARCHAR(20),   RATING INT,   VACANCY_TYPE VARCHAR(1)");
            this.statement.addBatch("INSERT INTO HOTEL_LOCATIONS VALUES (0, 'Auckland Hotel - 31 Starcent Ave', 'Auckland', 5, 'Y'),\n"
                    + "(1, 'Rotorua Hotel - 17 Geyser Crescent', 'Rotorua', 3, 'Y'),\n" 
                    + "(2, 'Taupo Hotel - 48 Lake Street', 'Taupo', 4, 'N'),\n"
                    + "(3, 'Palmerston North Hotel - 69 Leggy Lane', 'Palmerston North', 4, 'Y'),\n"
                    + "(4, 'Wellington Hotel - 128 Bee Ave', 'Wellington', 5, 'N'),\n"
                    + "(5, 'Christchurch Hotel - 27 Meadow Lane', 'Christchurch', 4, 'Y'),\n"
                    + "(6, 'Dunedin Hotel - 987 Lonely Road', 'Dunedin', 4, 'N'),\n"
                    + "(7, 'Queenstown Hotel - 52 New South Drive', 'Queenstown', 5, 'Y')");*/
            
            this.checkTableExistence("BOOK_K");
            this.statement.addBatch("CREATE  TABLE BOOK_K  (HOTEL_ID INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)");
            this.statement.addBatch("INSERT INTO BOOK_K VALUES (0, 'Auckland Hotel - 31 Starcent Ave', 'Fiction', 19.90),\n"
                    + "(1, 'Rotorua Hotel - 17 Geyser Crescent', 'Fiction', 19.90),\n"
                    + "(2, 'Taupo Hotel - 48 Lake Street', 'Fiction', 28.00),\n"
                    + "(3, 'Palmerston North Hotel - 69 Leggy Lane', 'Fiction', 15.40),\n"
                    + "(4, 'Wellington Hotel - 128 Bee Ave', 'Non-fiction', 55.20),\n"
                    + "(5, 'Christchurch Hotel - 27 Meadow Lane', 'Non-fiction', 24.90),\n"
                    + "(6, 'Dunedin Hotel - 987 Lonely Road','Non-fiction', 33.60),\n"
                    + "(7, 'Queenstown Hotel - 52 New South Drive', 'Textbook', 55.00)");
            this.statement.executeBatch();
            System.out.println("Table has been created");
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
