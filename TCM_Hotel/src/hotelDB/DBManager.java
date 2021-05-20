/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelDB;

import Model.GuestModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anuk
 */
public class DBManager {
    
    private static final String URL = "jdbc:derby://localhost:1527/TCMHotelDB";
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";

    Connection conn;

    public DBManager() {
        establishConnection();
    }

    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Connection Successful");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public ResultSet queryDB(String sql) {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return resultSet;
    }

    public void updateDB(String sql) {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /*public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
    
    public long insertGuest(GuestModel model){
        
        String SQL = "INSERT INTO GUEST_LIST(GUEST_FNAME, GUEST_LNAME, GUEST_AGE, GUEST_PHONE, GUEST_EMAIL, GUEST_ACCNUM, GUEST_ACCPIN) VALUES(test)";
        long id = 0;
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, model.getGuestFirstName());
            
            int rows = pstmt.executeUpdate();
            
            if (rows > 0){
                try (ResultSet rs = pstmt.getGeneratedKeys()){
                    if (rs.next()){
                        id = rs.getLong(1);
                    }
                }
                catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
            
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return id;
    }*/
}
