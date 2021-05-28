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
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import tcm.hotel.ViewRecords;

/**
 *
 * @author Anuk
 */
public class AdminSysMenuView extends JFrame{
    
    private JSplitPane splitPane;
    private JPanel buttonList;
    private JPanel displayedData;
    private JPanel guestsDataPanel;
    private JPanel staffDataPanel;
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

    public JPanel getGuestsDataPanel() {
        return guestsDataPanel;
    }

    public JPanel getstaffDataPanel() {
        return staffDataPanel;
    }

    public JButton getViewGuests() {
        return viewGuests;
    }

    public JButton getViewStaff() {
        return viewStaff;
    }
    
    
    
    public AdminSysMenuView() throws SQLException{
        
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
        JButton test = new JButton("fsdoldsj");
        displayedData = new JPanel();
        buttonList = new JPanel();
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        buttonList.add(viewGuests);
        buttonList.add(viewStaff);
        splitPane.add(buttonList);
        
        displayedData.setLayout(new CardLayout());
        
        guestsDataPanel = new JPanel();
        staffDataPanel = new JPanel();
        
        
        JScrollPane guestScroll = new JScrollPane(guestsTable);
        JScrollPane staffScroll = new JScrollPane(staffTable);
        
        HotelProductDB db = new HotelProductDB();
        ArrayList<ViewRecords> staffRecords = db.getStaffRecords();
        ArrayList<ViewRecords> guestRecords = db.getGuestRecords();
        
        String guestColumns[] = {"Guest First Name", "Guest Last Name", "Guest Age", "Guest Phone Number", "Guest Email Address", "Guest Account Number"};
        String staffColumns[] = {"Admin First Name", "Admin Last Name", "Admin Job Title", "Admin Phone Number", "Admin Email Address"};
        DefaultTableModel staffTableModel = new DefaultTableModel(staffColumns, 0);
        
        DefaultTableModel guestTableModel = new DefaultTableModel(guestColumns, 0);
        guestsTable = new JTable(guestTableModel);
        staffTable = new JTable(staffTableModel);
        
//        guestsTable.add(guestScroll);

        for (int i = 0; i < staffRecords.size(); i++){
            String adminFName = staffRecords.get(i).getAdminFName();
            String adminLName = staffRecords.get(i).getAdminLName();
            String adminJobTitle = staffRecords.get(i).getAdminJobTitle();
            String adminPhoneNum = staffRecords.get(i).getAdminPhoneNum();
            String adminEmail = staffRecords.get(i).getAdminEmail();
            
            Object[] staffData = {adminFName, adminLName, adminJobTitle, adminPhoneNum, adminEmail};
            staffTableModel.addRow(staffData);
        }
        
        for (int i = 0; i < guestRecords.size(); i++) {
            String guestFName = guestRecords.get(i).getGuestFName();
            String guestLName = guestRecords.get(i).getGuestLName();
            String guestAge = guestRecords.get(i).getGuestAge();
            String guestPhoneNum = guestRecords.get(i).getGuestPhoneNum();
            String guestEmail = guestRecords.get(i).getGuestEmailAddress();
            String guestAccNumber = guestRecords.get(i).getGuestAccountNumber();
            
            Object[] guestData = {guestFName, guestLName, guestAge, guestPhoneNum, guestEmail, guestAccNumber};
            guestTableModel.addRow(guestData);
        }
        
        staffTable.setModel(staffTableModel);
        guestsTable.setModel(guestTableModel);
        
//        guestsTable.setMinimumSize(new Dimension(900,900));
//        staffTable.setMinimumSize(new Dimension(900,900));
        
        guestsTable.setPreferredSize(new Dimension(900, 1000));
        staffTable.setPreferredSize(new Dimension(1100, 1100));
        
        Font bigHeader = new Font("sansserif", Font.PLAIN, 16);
        guestsTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer guestsRender = (DefaultTableCellRenderer)guestsTable.getDefaultRenderer(Object.class);
        guestsRender.setHorizontalAlignment(SwingConstants.CENTER);
        guestsTable.setRowHeight(50);
        
        staffTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer staffRender = (DefaultTableCellRenderer) staffTable.getDefaultRenderer(Object.class);
        staffRender.setHorizontalAlignment(SwingConstants.CENTER);
        staffTable.setRowHeight(50);
        
        guestsTable.setPreferredScrollableViewportSize(guestsTable.getPreferredSize());
        guestsTable.setFillsViewportHeight(true);
        guestsTable.setDragEnabled(true);
        guestsTable.setRowMargin(100);
        guestsTable.setGridColor(Color.blue);
        guestsTable.setShowGrid(true);
        
        staffTable.setPreferredScrollableViewportSize(guestsTable.getPreferredSize());
        staffTable.setFillsViewportHeight(true);
        staffTable.setFillsViewportHeight(true);
        staffTable.setDragEnabled(true);
        staffTable.setRowMargin(40);
        staffTable.setGridColor(Color.blue);
        staffTable.setShowGrid(true);
        
        staffDataPanel.add(new JScrollPane(staffTable));
        guestsDataPanel.add(new JScrollPane(guestsTable));
        
        //displayedData.add(guestsDataPanel);
        displayedData.add(staffDataPanel);
        
        splitPane.add(displayedData);
        this.add(splitPane);
    }
    
    public void showGuestRecords() throws ClassNotFoundException{
    }
    
    public void showStaffRecords() {
        
    }
    
}
