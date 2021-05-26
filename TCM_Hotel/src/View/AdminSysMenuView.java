/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import hotelDB.DBManager;
import hotelDB.HotelProductDB;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tcm.hotel.ViewRecords;

/**
 *
 * @author Anuk
 */
public class AdminSysMenuView extends JFrame{
    
    private JSplitPane splitPane;
    private JPanel buttonList;
    private JPanel displayedData;
    private JPanel guestsRecords;
    private JPanel staffRecords;
    private JButton viewGuests;
    private JButton viewStaff;
    private JLabel testLabel;
    private JLabel testLabel2;
    private CardLayout cardLayout;
    private JTable guestsTable;
    private JTable staffTable;
    //private JScrollPane scroll;

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JPanel getButtonList() {
        return buttonList;
    }

    public JPanel getDisplayedData() {
        return displayedData;
    }

    public JPanel getGuestsRecords() {
        return guestsRecords;
    }

    public JPanel getStaffRecords() {
        return staffRecords;
    }

    public JButton getViewGuests() {
        return viewGuests;
    }

    public JButton getViewStaff() {
        return viewStaff;
    }
    
    
    
    public AdminSysMenuView() throws SQLException{
        
        
        //cardLayout = (CardLayout) (displayedData.getLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth + 300, frameHeight + 300);
        this.setResizable(false);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator Backend System");
        
        viewGuests = new JButton("View Guests");
        viewStaff = new JButton("View Admins");

        staffTable = new JTable();
        
        JScrollPane guestScroll = new JScrollPane(guestsTable);
        JScrollPane staffScroll = new JScrollPane(staffTable);
        
        HotelProductDB db = new HotelProductDB();
        ArrayList<ViewRecords> testStaff = db.getStaffRecords();
        
        System.out.println(testStaff.get(0).getAdminFName());
        //ArrayList<ViewRecords> staffList = new ArrayList<ViewRecords>();
       
        
        //System.out.println("TEST");
//        try{
//            while (rs.next()) {
//                System.out.println("TEST2");
//                String adminFName = rs.getString("ADMIN_FIRSTNAME");
//                String adminLName = rs.getString("ADMIN_LASTNAME");
//                String adminJobTitle = rs.getString("ADMIN_JOBTITLE");
//                String adminPhoneNum = rs.getString("ADMIN_PHONENUMBER");
//                String adminEmail = rs.getString("ADMIN_EMAILADDRESS");
//                System.out.println(adminFName + adminLName + adminJobTitle + adminPhoneNum + adminEmail);
//                ViewRecords staffDetails = new ViewRecords(adminFName, adminLName, adminJobTitle, adminPhoneNum, adminEmail);
//                staffList.add(staffDetails);
//            }
//            return staffList;
//        }
//        catch (SQLException ex){
//            Logger.getLogger(HotelProductDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        /*System.out.println(list.get(0));
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        ResultSetMetaData metaData = rs.getMetaData();
        
        int amountOfColumns = metaData.getColumnCount();
        
        for (int indexOfColumn = 1; indexOfColumn <= amountOfColumns; indexOfColumn++){
            tableModel.addColumn(metaData.getColumnLabel(indexOfColumn));
        }
        
        Object[] tableRow = new Object[amountOfColumns];
        
        while (rs.next()){
            for (int i = 0; i < amountOfColumns; i++){
                tableRow[i] = rs.getObject(i + 1);
            }
            tableModel.addRow(tableRow);
        }
        
        staffTable.setModel(tableModel);*/
        
        this.add(staffTable);
        
        
        
        
        //System.out.println(rs.getString("ADMIN_FIRSTNAME"));
        
//        HotelProductDB db = new HotelProductDB();
//        ResultSet rs = db.getStaffRecords();
        
        /*PreparedStatement ps = null;
        Connection connection = null;
        
        DBManager db = new DBManager();
        
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TCMHotelDB", "pdc", "pdc");
            String sql = "select * from GUEST_LIST";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            db.queryDB(sql);
            while(rs.next()){
                //db.queryDB(sql);
                String fName = rs.getString("GUEST_FIRSTNAME");
                String lName = rs.getString("GUEST_LASTNAME");
                String age = rs.getString("GUEST_AGE");
                System.out.println(fName+ lName + age);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null){
                ps.close();
            }
                if (connection != null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        */
        
        
//        buttonList = new JPanel(new FlowLayout());
//        buttonList.setSize(300, 500);
//        buttonList.setForeground(Color.red);
//        
//        displayedData = new JPanel(new CardLayout());
//        displayedData.setForeground(Color.blue);
//        
//        guestsRecords = new JPanel();
//        testLabel = new JLabel("Here will be the guests records");
//        guestsRecords.add(testLabel);
//        guestsRecords.setVisible(true);
//        
//        staffRecords = new JPanel();
//        testLabel2 = new JLabel("Here will be the Staff records");
//        staffRecords.add(testLabel2);
//        staffRecords.setVisible(true);
//        
//        displayedData.add(guestsRecords);
//        displayedData.add(staffRecords);
//        
//        viewGuests = new JButton("View Guests");
//        viewStaff = new JButton("View Admins");
//        buttonList.add(viewStaff);
//        buttonList.add(viewGuests);
        //splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonList, displayedData);
        //splitPane.setPreferredSize(new Dimension(frameHeight,frameWidth));
        
//        CardLayout cardLayout;
//        cardLayout = (CardLayout) (displayedData.getLayout());
//        cardLayout.show(displayedData, "guestsRecords");
        
        //splitPane.setLeftComponent(leftPanel);
        //splitPane.add(leftPanel);
        
        //this.add(splitPane);
        
    }
    
    public void showGuestRecords() throws ClassNotFoundException{
//        JTable jTabel1 = new JTable();
//        
//        try {
//            
//            
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            
//            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TCMHotelDB", "pdc", "pdc");
//            Statement st = con.createStatement();
//            //this.statement = conn.createStatement();
//            String sql = "select * from GUEST_LIST";
//            ResultSet rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                String fName = String.valueOf(rs.getString("GUEST_FIRSTNAME"));
//                String lName = String.valueOf(rs.getString("GUEST_LASTNAME"));
//                String age = String.valueOf(rs.getInt("GUEST_AGE"));
//
//                String tableData[] = {fName, lName, age};
//                DefaultTableModel tblModel = (DefaultTableModel)jTabel1.getModel();
//                
//                tblModel.addColumn(tableData);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
        //cardLayout = (CardLayout) (displayedData.getLayout());
        //cardLayout.show(displayedData, "guestsRecords");
    }
    
    public void showStaffRecords() {
        
        ///cardLayout = (CardLayout) (displayedData.getLayout());
        //cardLayout.show(displayedData, "staffRecords");
    }
    
}
