/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import HotelEnums.ExtraFeatureTypes;
import HotelEnums.GuestType;
import HotelEnums.LocationType;
import HotelEnums.RoomType;
import HotelDataFiles.ViewRecords;
import HotelDatabase.HotelProductDB;
import javax.swing.UIManager;

/**
 * This is a description of the AdminSysMenu View class. This View Class will
 * contain the constructor that when invoked it will initialize and define all
 * the necessary Java GUI components for the Admin System back-end Frame after
 * the user has successfully logged in.
 *
 * @author Anuk
 */
public class AdminSysMenu extends JFrame{
    
    private JSplitPane splitPane;
    
    private JPanel buttonList;
    private JPanel displayedData;
    private JPanel guestsDataPanel;
    private JPanel staffDataPanel;
    private JPanel locationsBkdPanel;
    private JPanel roomsBkdPanel;
    private JPanel featuresBkdPanel;
    private JPanel guestTypesBkdPanel;
    private JPanel datesBkdPanel;
    private JPanel headerPanel;
    private JPanel bottomBtnPanel;
    private JLabel systemHeaderMsg;
    
    private JButton viewDatesBooked;
    private JButton viewGuestTypesBooked;
    private JButton viewFeaturesBooked;
    private JButton viewRoomsBooked;
    private JButton viewLocationsBooked;
    private JButton viewGuests;
    private JButton viewStaff;
    private JButton mainMenuReturn;
    
    private CardLayout cardLayout;
    
    private JTable guestsTable;
    private JTable staffTable;
    private JTable locationsBkdTable;
    private JTable roomsBkdTable;
    private JTable featuresBkdTable;
    private JTable guestTypesBkdTable;
    private JTable datesBkdTable;
    
    private static final int NUM_BTNS = 7;
    
    /**
     * The getViewDatesBooked getter method will return the value stored in the
     * JButton object. The concept of this getter method can be applied to all
     * other getter methods found in this class.
     *
     * @return viewDatesBooked stores the value stored in the JButton object.
     * @author Anuk
     */
    public JButton getViewDatesBooked() {
        return viewDatesBooked;
    }

    public JButton getViewGuestTypesBooked() {
        return viewGuestTypesBooked;
    }

    public JButton getViewFeaturesBooked() {
        return viewFeaturesBooked;
    }

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

    public JButton getViewLocationsBooked() {
        return viewLocationsBooked;
    }

    public JButton getViewRoomsBooked() {
        return viewRoomsBooked;
    }
    
    /**
     * This is the constructor for the AdminSysMenu View class. This constructor
     * when invoked, will display the frame of the Admin Back-end System once
     * the user has entered the password successfully to gain access to the
     * system to view the corresponding JTables.
     *
     * @throws SQLException
     * @author Anuk
     */
    public AdminSysMenu() throws SQLException{
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth + 600, frameHeight + 450);
        this.setResizable(false);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator Backend System");
        
        viewGuests = new JButton("View Guests");
        viewStaff = new JButton("View Admins");
        viewLocationsBooked = new JButton("View Locations Booked");
        viewRoomsBooked = new JButton("View Rooms Booked");
        viewFeaturesBooked = new JButton("View Features Booked");
        viewGuestTypesBooked = new JButton("View Guest Types Booked");
        viewDatesBooked = new JButton("View Dates Booked");
        
        GridLayout layout = new GridLayout(NUM_BTNS, 1);
        layout.setVgap(40);
        layout.setHgap(40);
        buttonList = new JPanel();
        buttonList.setLayout(layout);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        buttonList.add(viewGuests);
        buttonList.add(viewStaff);
        buttonList.add(viewLocationsBooked);
        buttonList.add(viewRoomsBooked);
        buttonList.add(viewFeaturesBooked);
        buttonList.add(viewGuestTypesBooked);
        buttonList.add(viewDatesBooked);
        splitPane.add(buttonList);
        
        guestsDataPanel = new JPanel();
        staffDataPanel = new JPanel();
        locationsBkdPanel = new JPanel();
        roomsBkdPanel = new JPanel();
        featuresBkdPanel = new JPanel();
        guestTypesBkdPanel = new JPanel();
        datesBkdPanel = new JPanel();
        
        HotelProductDB db = new HotelProductDB();
        ArrayList<ViewRecords> staffRecords = db.getStaffRecords();
        ArrayList<ViewRecords> guestRecords = db.getGuestRecords();
        ArrayList<ViewRecords> locationsBkdRecords = db.getLocationsBookedRecords();
        ArrayList<ViewRecords> roomsBkdRecords = db.getRoomsBookedRecords();
        ArrayList<ViewRecords> featuresBkdRecords = db.getFeaturesBookedRecords();
        ArrayList<ViewRecords> guestTypesBkdRecords = db.getGuestTypesRecords();
        ArrayList<ViewRecords> datesBkdRecords = db.getDatesBookedRecords();
        
        String guestColumns[] = {"Guest First Name", "Guest Last Name", "Guest Age", "Guest Phone Number", "Guest Email Address", "Guest Account Number", "Guest Total Paid"};
        String staffColumns[] = {"Admin First Name", "Admin Last Name", "Admin Job Title", "Admin Phone Number", "Admin Email Address"};
        String locBkdColumns[] = {"Guest Account Number", "Guest First Name", "Location Title", "Location"};
        String roomsBkdColumns[] = {"Guest Account Number", "Guest First Name", "Room Title", "Room Type"};
        String featuresBkdColumns[] = {"Guest Account Number", "Guest First Name", "Feature Title", "Feature Type"};
        String guestTypesBkdColumns[] = {"Guest Account Number", "Guest First Name", "Guest Title", "Guest Type"};
        String datesBkdColumns[] = {"Guest Account Number", "Guest First Name", "Location", "Check In Day", "Check In Month",
        "Check In Year", "Check Out Day", "Check Out Month", "Check Out Year"};

        DefaultTableModel staffTableModel = new DefaultTableModel(staffColumns, 0);
        DefaultTableModel guestTableModel = new DefaultTableModel(guestColumns, 0);
        DefaultTableModel locBkdModel = new DefaultTableModel(locBkdColumns, 0);
        DefaultTableModel roomsBkdModel = new DefaultTableModel(roomsBkdColumns, 0);
        DefaultTableModel featuresBkdModel = new DefaultTableModel(featuresBkdColumns, 0);
        DefaultTableModel guestTypesBkdModel = new DefaultTableModel(guestTypesBkdColumns, 0);
        DefaultTableModel datesBkdModel = new DefaultTableModel(datesBkdColumns, 0);
        setLocationRelativeTo(null);
        
        guestsTable = new JTable(guestTableModel);
        staffTable = new JTable(staffTableModel);
        locationsBkdTable = new JTable(locBkdModel);
        roomsBkdTable = new JTable(roomsBkdModel);
        featuresBkdTable = new JTable(featuresBkdModel);
        guestTypesBkdTable = new JTable(guestTypesBkdModel);
        datesBkdTable = new JTable(datesBkdModel);
        
        JScrollPane guestScroll = new JScrollPane(guestsTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane staffScroll = new JScrollPane(staffTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane locBkdScroll = new JScrollPane(locationsBkdTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane roomsBkdScroll = new JScrollPane(roomsBkdTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane featuresBkdScroll = new JScrollPane(featuresBkdTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane guestTypesBkdScroll = new JScrollPane(guestTypesBkdTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane datesBkdScroll = new JScrollPane(datesBkdTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        guestScroll.setMinimumSize(new Dimension(1300, 650));
        guestScroll.setPreferredSize(new Dimension (1300,650));
        
        staffScroll.setPreferredSize(new Dimension (1300,650));
        staffScroll.setMinimumSize(new Dimension(1300, 650));
        
        locBkdScroll.setPreferredSize(new Dimension (1300,650));
        locBkdScroll.setMinimumSize(new Dimension(1300, 650));
        
        roomsBkdScroll.setPreferredSize(new Dimension (1300,650));
        roomsBkdScroll.setMinimumSize(new Dimension(1300, 650));
        
        featuresBkdScroll.setPreferredSize(new Dimension (1300,650));
        featuresBkdScroll.setMinimumSize(new Dimension(1300, 650));
        
        guestTypesBkdScroll.setPreferredSize(new Dimension (1300,650));
        guestTypesBkdScroll.setMinimumSize(new Dimension(1300, 650));
        
        datesBkdScroll.setPreferredSize(new Dimension (1300,650));
        datesBkdScroll.setMinimumSize(new Dimension(1300, 650));
        
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
            String guestTotalPaid = guestRecords.get(i).getGuestTotalPaid();
            
            Object[] guestData = {guestFName, guestLName, guestAge, guestPhoneNum, guestEmail, guestAccNumber, guestTotalPaid};
            guestTableModel.addRow(guestData);
        }
        
        for (int i = 0; i < locationsBkdRecords.size(); i++) {
            String guestAccNumber = locationsBkdRecords.get(i).getGuestAccountNumber();
            String guestFName = locationsBkdRecords.get(i).getGuestFName();
            String locationTitle = locationsBkdRecords.get(i).getLocationTitle();
            LocationType location= locationsBkdRecords.get(i).getLocation();
            
            Object[] bkdLocRecordsData = {guestAccNumber, guestFName, locationTitle, location};
            locBkdModel.addRow(bkdLocRecordsData);
        }
        
        for (int i = 0; i < roomsBkdRecords.size(); i++){
            String guestAccNumber = roomsBkdRecords.get(i).getGuestAccountNumber();
            String guestFName = roomsBkdRecords.get(i).getGuestFName();
            String roomTitle = roomsBkdRecords.get(i).getRoomTitle();
            RoomType roomType = roomsBkdRecords.get(i).getRoomType();
            
            Object[] bkdRoomsData = {guestAccNumber, guestFName, roomTitle, roomType};
            roomsBkdModel.addRow(bkdRoomsData);
        }
        
        for (int i = 0; i < featuresBkdRecords.size(); i++) {
            String guestAccNumber = featuresBkdRecords.get(i).getGuestAccountNumber();
            String guestFName = featuresBkdRecords.get(i).getGuestFName();
            String featureTitle = featuresBkdRecords.get(i).getFeatureTitle();
            ExtraFeatureTypes featureType = featuresBkdRecords.get(i).getfeatureType();
            
            Object[] featuresBkdData = {guestAccNumber, guestFName, featureTitle, featureType};
            featuresBkdModel.addRow(featuresBkdData);
        }
        
        for (int i = 0; i < guestTypesBkdRecords.size(); i++) {
            String guestAccNumber = guestTypesBkdRecords.get(i).getGuestAccountNumber();
            String guestFName = guestTypesBkdRecords.get(i).getGuestFName();
            String guestTitle = guestTypesBkdRecords.get(i).getGuestTitle();
            GuestType guestType = guestTypesBkdRecords.get(i).getGuestType();
            
            Object[] guestTypesBkdData = {guestAccNumber, guestFName, guestTitle, guestType};
            guestTypesBkdModel.addRow(guestTypesBkdData);
        }
        
        for (int i = 0; i < datesBkdRecords.size(); i++) {
            String guestAccNumber = datesBkdRecords.get(i).getGuestAccountNumber();
            String guestFName = datesBkdRecords.get(i).getGuestFName();
            LocationType location = datesBkdRecords.get(i).getLocation();
            String checkInDay = datesBkdRecords.get(i).getCheckInDay();
            String checkInMonth = datesBkdRecords.get(i).getCheckInMonth();
            String checkInYear = datesBkdRecords.get(i).getCheckInYear();
            String checkOutDay = datesBkdRecords.get(i).getCheckOutDay();
            String checkOutMonth = datesBkdRecords.get(i).getCheckOutMonth();
            String checkOutYear = datesBkdRecords.get(i).getCheckOutYear();
            
            Object[] datesBkdData = {guestAccNumber, guestFName, location, checkInDay, checkInMonth, checkInYear, checkOutDay, checkOutMonth, checkOutYear};
            datesBkdModel.addRow(datesBkdData);
        }
        
        
        guestsTable.setModel(guestTableModel);
        staffTable.setModel(staffTableModel);
        locationsBkdTable.setModel(locBkdModel);
        roomsBkdTable.setModel(roomsBkdModel);
        featuresBkdTable.setModel(featuresBkdModel);
        guestTypesBkdTable.setModel(guestTypesBkdModel);
        datesBkdTable.setModel(datesBkdModel);

        guestsTable.setPreferredSize(new Dimension(1300, 650));
        staffTable.setPreferredSize(new Dimension(1300, 650));
        locationsBkdTable.setPreferredSize(new Dimension(1300, 650));
        roomsBkdTable.setPreferredSize(new Dimension(1300, 650));
        featuresBkdTable.setPreferredSize(new Dimension(1300, 650));
        guestTypesBkdTable.setPreferredSize(new Dimension(1300, 650));
        datesBkdTable.setPreferredSize(new Dimension(1300, 650));
        
        Font bigHeader = new Font("sansserif", Font.BOLD, 15);
        Font smallHeader = new Font("sansserif", Font.BOLD, 12);
        
        guestsTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer guestsRender = (DefaultTableCellRenderer)guestsTable.getDefaultRenderer(Object.class);
        guestsRender.setHorizontalAlignment(SwingConstants.CENTER);
        guestsTable.setRowHeight(50);
        
        staffTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer staffRender = (DefaultTableCellRenderer) staffTable.getDefaultRenderer(Object.class);
        staffRender.setHorizontalAlignment(SwingConstants.CENTER);
        staffTable.setRowHeight(50);
        
        locationsBkdTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer locationsBkdRender = (DefaultTableCellRenderer) locationsBkdTable.getDefaultRenderer(Object.class);
        locationsBkdRender.setHorizontalAlignment(SwingConstants.CENTER);
        locationsBkdTable.setRowHeight(50);
        
        roomsBkdTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer roomsBkdRender = (DefaultTableCellRenderer) roomsBkdTable.getDefaultRenderer(Object.class);
        roomsBkdRender.setHorizontalAlignment(SwingConstants.CENTER);
        roomsBkdTable.setRowHeight(50);
        
        featuresBkdTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer featuresBkdender = (DefaultTableCellRenderer) featuresBkdTable.getDefaultRenderer(Object.class);
        featuresBkdender.setHorizontalAlignment(SwingConstants.CENTER);
        featuresBkdTable.setRowHeight(50);
        
        guestTypesBkdTable.getTableHeader().setFont(bigHeader);
        DefaultTableCellRenderer guestTypesBkdRender = (DefaultTableCellRenderer)guestTypesBkdTable.getDefaultRenderer(Object.class);
        guestTypesBkdRender.setHorizontalAlignment(SwingConstants.CENTER);
        guestTypesBkdTable.setRowHeight(50);
        
        datesBkdTable.getTableHeader().setFont(smallHeader);
        DefaultTableCellRenderer datesBkdRender = (DefaultTableCellRenderer)datesBkdTable.getDefaultRenderer(Object.class);
        datesBkdRender.setHorizontalAlignment(SwingConstants.CENTER);
        datesBkdTable.setRowHeight(50);
        
        
        guestsTable.setPreferredScrollableViewportSize(guestsTable.getPreferredSize());
        guestsTable.setFillsViewportHeight(true);
        guestsTable.setDragEnabled(true);
        
        staffTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        staffTable.setFillsViewportHeight(true);
        staffTable.setDragEnabled(true);
        
        locationsBkdTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        locationsBkdTable.setFillsViewportHeight(true);
        locationsBkdTable.setDragEnabled(true);
        
        roomsBkdTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        roomsBkdTable.setFillsViewportHeight(true);
        roomsBkdTable.setDragEnabled(true);
        
        featuresBkdTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        featuresBkdTable.setFillsViewportHeight(true);
        featuresBkdTable.setDragEnabled(true);
        
        guestTypesBkdTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        guestTypesBkdTable.setFillsViewportHeight(true);
        guestTypesBkdTable.setDragEnabled(true);
        
        datesBkdTable.setPreferredScrollableViewportSize(staffTable.getPreferredSize());
        datesBkdTable.setFillsViewportHeight(true);
        datesBkdTable.setDragEnabled(true);

        guestsDataPanel.add(guestScroll);
        staffDataPanel.add(staffScroll);
        locationsBkdPanel.add(locBkdScroll);
        roomsBkdPanel.add(roomsBkdScroll);
        featuresBkdPanel.add(featuresBkdScroll);
        guestTypesBkdPanel.add(guestTypesBkdScroll);
        datesBkdPanel.add(datesBkdScroll);

        displayedData = new JPanel(new CardLayout());
        displayedData.add(staffDataPanel, "Staff Data");
        displayedData.add(guestsDataPanel, "Guests Data");
        displayedData.add(locationsBkdPanel, "Locations Booked Data");
        displayedData.add(roomsBkdPanel, "Rooms Booked Data");
        displayedData.add(featuresBkdPanel, "Features Booked Data");
        displayedData.add(guestTypesBkdPanel, "Guest Types Booked Data");
        displayedData.add(datesBkdPanel, "Guest Details and Dates Booked Data");
        
        headerPanel = new JPanel();
        headerPanel.add(Box.createVerticalStrut(100));
        headerPanel.setBackground(Color.blue);
        systemHeaderMsg = new JLabel("TCM Hotel System Administration ");
        systemHeaderMsg.setForeground(Color.white);
        systemHeaderMsg.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(systemHeaderMsg);
        
        bottomBtnPanel = new JPanel();
        bottomBtnPanel.setPreferredSize(new Dimension(frameWidth + 600, 100));
        bottomBtnPanel.setBackground(Color.blue);

        mainMenuReturn = new JButton("Return to Main Menu");
        mainMenuReturn.setPreferredSize(new Dimension(300, 80));
        mainMenuReturn.setFont(new Font("Arial", Font.BOLD, 17));
        mainMenuReturn.setBorder(new LineBorder(Color.black, 4));
        mainMenuReturn.setForeground(Color.black);
        
        bottomBtnPanel.add(mainMenuReturn);
        
        splitPane.add(displayedData);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(splitPane, BorderLayout.CENTER);
        this.add(bottomBtnPanel, BorderLayout.SOUTH);
        
    }
    
    /**
     * The showGuestRecords method will be invoked when the view guest records
     * button is pressed. When this method is invoked it will display the panel
     * which contains the JTable for the guest records from the card Layout by
     * using the name of the panel containing the JTable as a reference. The
     * concept of this method can be applied to similar show record methods that
     * follow the card layout procedure which reference the panel's respective
     * name
     *
     * @author Anuk
     */
    public void showGuestRecords(){
        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Guests Data");
        
    }
    
    public void showStaffRecords() {
        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Staff Data");
    }
    
    public void showLocationsBkdRecords(){
        
        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Locations Booked Data");
    }
    
    public void showRoomsBkdRecords() {

        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Rooms Booked Data");
    }
    
    public void showFeaturesBkdRecords() {

        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Features Booked Data");
    }
    
    public void showGuestTypesBkdRecords() {

        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Guest Types Booked Data");
    }
    
    public void showGuestDatesBkdRecords(){

        cardLayout = (CardLayout) displayedData.getLayout();
        cardLayout.show(displayedData, "Guest Details and Dates Booked Data");
    }
    
    public JButton getMainMenuReturnButton() 
    {
        return mainMenuReturn;
    }
    
    /**
     * The mouseEnterHoverMainMenuButton method will change the background
     * colour of the Main Menu button if the mouse has entered the button.
     *
     * @author Anuk
     */
    public void mouseEnterHoverMainMenuButton() 
    {
        getMainMenuReturnButton().setBackground(Color.RED);
    }

    /**
     * The mouseExitHoverMainMenuButton method will change the background colour
     * of the Main Menu button to the default origin colour if the mouse has
     * exited the button.
     *
     * @author Anuk
     */
    public void mouseExitHoverMainMenuButton() 
    {
        getMainMenuReturnButton().setBackground(UIManager.getColor("control"));
    }
    
    public void returnToMain() 
    {
        this.setVisible(false);
        this.dispose();
    }
}