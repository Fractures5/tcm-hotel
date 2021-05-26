/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import Controller.AdminFormController;
import Controller.AdminSysMenuController;
import Controller.LoginController;
import Controller.GuestController;
import Model.LoginModel;
import Model.AdminFormModel;
import Model.AdminSysMenuModel;
import Model.GuestModel;
import View.LoginView;
import View.AdminFormView;
import View.AdminSysMenuView;
import View.GuestView;
import hotelDB.DBManager;
import hotelDB.HotelProductDB;
import java.awt.CardLayout;
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
public class DriverMVC {
    
    public static void main(String[] args) throws SQLException{
        
        HotelProductDB hotelMenuDB = new HotelProductDB();
        DBManager manager = new DBManager();
        hotelMenuDB.createAdminListTable();
        hotelMenuDB.createGuestListTable();
        hotelMenuDB.createHLocationTable();
        hotelMenuDB.createHRoomsTable();
        hotelMenuDB.createHGuestTypeTable();
        hotelMenuDB.createHFeaturesTable();
        hotelMenuDB.closeConnection();
        
//        AdminFormModel modelAdmin = new AdminFormModel();
//        AdminFormView viewAdmin = new AdminFormView();
//        AdminFormController controllerAdmin = new AdminFormController(modelAdmin, viewAdmin);
        
//        LoginModel modelLogin = new LoginModel();
//        LoginView viewLogin = new LoginView();
//        LoginController controllerLogin = new LoginController(modelLogin, viewLogin);
        
//        GuestModel modelGuest = new GuestModel();
//        GuestView viewGuest = new GuestView();
//        GuestController controllerGuest = new GuestController(modelGuest, viewGuest);
//        
//        viewGuest.setVisible(true);
        //viewAdmin.setVisible(true);
        //viewLogin.setVisible(true);
        
        //AdminSysMenuModel modelAdminSystem = new AdminSysMenuModel();
        //AdminSysMenuView viewAdminSystem = new AdminSysMenuView();
        //AdminSysMenuController controllerAdminSys = new AdminSysMenuController(modelAdminSystem, viewAdminSystem);
        //viewAdminSystem.setVisible(true);
        
        
        //db.readRecordsTest(rs);
        
        
       /* DBManager db = new DBManager();
        ResultSet rs;
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TCMHotelDB", "pdc", "pdc");
            Statement statement = connection.createStatement();
            String sql = "select GUEST_FIRSTNAME from GUEST_LIST";
            rs = db.queryDB(sql);
            ///rs = statement.executeQuery(sql);
            //System.out.println(rs);
            
            while (rs.next()){
                String fName = rs.getString("GUEST_FIRSTNAME");
                System.out.println(fName);
                System.out.println("test");
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        
        
        
        
        
        
        
        /*PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TCMHotelDB", "pdc", "pdc");
            String sql = "select * from GUEST_LIST";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fName = rs.getString("GUEST_FNAME");
                String lName = rs.getString("GUEST_LNAME");
                String age = rs.getString("GUEST_AGE");
                System.out.println(fName + lName + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        //this.add(guestsTable);
              
    }

}
