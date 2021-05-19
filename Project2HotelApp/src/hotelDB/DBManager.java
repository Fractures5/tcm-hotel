/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Siddarath
 */
public class DBManager 
{
    
    private static final String URL = "jdbc:derby://localhost:1527/TCMHotelDB";
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    
    Connection conn;
    
    public DBManager()
    {
       establishConnection();
    }
    
    public void establishConnection()
    {
        if(this.conn == null)
        {
            try
            {
               conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
               System.out.println(URL + " Connection Successful");
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public ResultSet queryDB(String sql)
    {
        Connection connection = this.conn;
        Statement statement  = null;
        ResultSet resultSet = null;
        
        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return resultSet;
    }
    
    public void updateDB(String sql)
    {
        Connection connection = this.conn;
        Statement statement  = null;
        ResultSet resultSet = null;
        
        try
        {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeConnnections()
    {
        if(conn!= null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
}
