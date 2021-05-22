/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Siddarath
 */
public class HotelDatesMenu extends JFrame {
    
    private JLabel title, instruction;
    private JLabel checkInDay, checkOutDay, checkInMonth, checkOutMonth, checkInYear, checkOutYear;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JButton nextButton;
    
    JComboBox <String> monthInBox, monthOutBox;
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
    
    JComboBox <Integer>  yearInBox, yearOutBox;
    Integer[] years = {2021, 2022, 2023};
    
    JComboBox <Integer> dayInBox, dayOutBox;
    Integer[] dayNo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
            , 16, 17 ,18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    public HotelDatesMenu()
    {
        title = new JLabel("Hotel Date Booking Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.YELLOW);

        instruction = new JLabel("Please pick the check in and check out dates!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);

        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700,70));
        headerPanel.add(title);
        this.add(headerPanel, BorderLayout.NORTH);

        menuPanel = new JPanel(null);
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setPreferredSize(new Dimension(600,450));
        instruction.setBounds(370, 20, 500, 50);
        menuPanel.add(instruction);

        dayInBox = new JComboBox(dayNo);
        dayInBox.setBounds(410, 100, 100, 50);
        dayInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        monthInBox = new JComboBox(monthNames);
        monthInBox.setBounds(410, 240, 125, 50);
        monthInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        yearInBox = new JComboBox(years);
        yearInBox.setBounds(410, 380, 85, 50);
        yearInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        dayOutBox = new JComboBox(dayNo);
        dayOutBox.setBounds(875, 100, 100, 50);
        dayOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        monthOutBox = new JComboBox(monthNames);
        monthOutBox.setBounds(875, 240, 125, 50);
        monthOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        yearOutBox = new JComboBox(years);
        yearOutBox.setBounds(875, 380, 85, 50);
        yearOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));

        checkInDay = new JLabel("Check in day: ");
        checkInDay.setFont(new Font("Arial", Font.BOLD, 20));
        checkInDay.setBounds(210, 100, 175, 50);
        checkInDay.setBorder(blackline);
        
        checkInMonth = new JLabel("Check in month: ");
        checkInMonth.setFont(new Font("Arial", Font.BOLD, 20));
        checkInMonth.setBounds(210, 240, 175, 50);
        checkInMonth.setBorder(blackline);
        
        checkInYear = new JLabel("Check in year: ");
        checkInYear.setFont(new Font("Arial", Font.BOLD, 20));
        checkInYear.setBounds(210, 380, 175, 50);
        checkInYear.setBorder(blackline);
        
        checkOutDay = new JLabel("Check out day: ");
        checkOutDay.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutDay.setBounds(640, 100, 200, 50);
        checkOutDay.setBorder(blackline);
        
        checkOutMonth = new JLabel("Check out month: ");
        checkOutMonth.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutMonth.setBounds(640, 240, 200, 50);
        checkOutMonth.setBorder(blackline);
        
        checkOutYear = new JLabel("Check out year: ");
        checkOutYear.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutYear.setBounds(640, 380, 200, 50);
        checkOutYear.setBorder(blackline);
        
        menuPanel.add(checkInDay);
        menuPanel.add(dayInBox);
        menuPanel.add(checkInMonth);
        menuPanel.add(monthInBox);  
        menuPanel.add(checkInYear);
        menuPanel.add(yearInBox);
        menuPanel.add(checkOutDay);
        menuPanel.add(dayOutBox);
        menuPanel.add(checkOutMonth);
        menuPanel.add(monthOutBox);  
        menuPanel.add(checkOutYear);
        menuPanel.add(yearOutBox);
        this.add(menuPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.setPreferredSize(new Dimension(730,80));


        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));

        bottomPanel.add(nextButton);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setTitle("Guests booking dates");
        this.setSize(frameWidth +250, frameHeight +170);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
}
