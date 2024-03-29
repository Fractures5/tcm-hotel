/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import HotelDataFiles.GuestsBookingCart;

/**
 * The HotelDatesMenu class is a view class which outputs the hotel dates menu
 * GUI to the user where the user can select using combo boxes what check in and
 * check out dates they would like. This class also contains getter methods for
 * accessing variables from other classes methods to deal with error handling
 * and confirm the using selection.
 *
 * @author Siddarath
 */
public class HotelDatesMenu extends JFrame 
{
    
    private JLabel title, instruction;
    private JLabel checkInDayJL, checkOutDayJL, checkInMonthJL, checkOutMonthJL, checkInYearJL, checkOutYearJL;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JButton nextButton;
    private Boolean repeat = false;
    private Boolean validDate = false;
    private Boolean validCheckInDay = false;
    private Boolean validCheckOutDay = false;
    private ArrayList<GuestsBookingCart> datesBooked = new ArrayList<>();
    
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

    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.WHITE, 10));
    
    /**
     * This is the HotelDatesMenu default constructor and it basically
     * initializes the panels,labels, combo boxes, buttons variables, sets the
     * name, size, color, position of the and then adds it to the frame (set to
     * visible) which makes the Booking dates GUI visible to the user, ready for
     * selecting the check in and out dates.
     *
     * @author Siddarath
     */
    public HotelDatesMenu()
    {
        title = new JLabel("Hotel Date Booking Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);

        instruction = new JLabel("Please pick the check in and check out dates!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);

        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700,70));
        headerPanel.add(title);
        
        menuPanel = new JPanel(null);
        menuPanel.setPreferredSize(new Dimension(600,450));
        instruction.setBounds(370, 20, 500, 50);
        menuPanel.add(instruction);

        dayInBox = new JComboBox(dayNo);
        dayInBox.setBounds(410, 100, 60, 50);
        dayInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        dayInBox.setBackground(Color.WHITE);
        dayInBox.setOpaque(true);
        
        monthInBox = new JComboBox(monthNames);
        monthInBox.setBounds(410, 240, 125, 50);
        monthInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        monthInBox.setBackground(Color.WHITE);
        monthInBox.setOpaque(true);
        
        yearInBox = new JComboBox(years);
        yearInBox.setBounds(410, 380, 85, 50);
        yearInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        yearInBox.setBackground(Color.WHITE);
        yearInBox.setOpaque(true);
        
        dayOutBox = new JComboBox(dayNo);
        dayOutBox.setBounds(875, 100, 60, 50);
        dayOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        dayOutBox.setBackground(Color.WHITE);
        dayOutBox.setOpaque(true);
        
        monthOutBox = new JComboBox(monthNames);
        monthOutBox.setBounds(875, 240, 125, 50);
        monthOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        monthOutBox.setBackground(Color.WHITE);
        monthOutBox.setOpaque(true);
        
        yearOutBox = new JComboBox(years);
        yearOutBox.setBounds(875, 380, 85, 50);
        yearOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        yearOutBox.setBackground(Color.WHITE);
        yearOutBox.setOpaque(true);
        
        checkInDayJL = new JLabel("Check in day: ");
        checkInDayJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInDayJL.setBounds(210, 100, 175, 50);
        checkInDayJL.setBackground(Color.WHITE);
        checkInDayJL.setOpaque(true);
        checkInDayJL.setBorder(blackline);
        
        checkInMonthJL = new JLabel("Check in month: ");
        checkInMonthJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInMonthJL.setBounds(210, 240, 185, 50);
        checkInMonthJL.setBackground(Color.WHITE);
        checkInMonthJL.setOpaque(true);
        checkInMonthJL.setBorder(blackline);
        
        checkInYearJL = new JLabel("Check in year: ");
        checkInYearJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInYearJL.setBounds(210, 380, 175, 50);
        checkInYearJL.setBackground(Color.WHITE);
        checkInYearJL.setOpaque(true);
        checkInYearJL.setBorder(blackline);
        
        checkOutDayJL = new JLabel("Check out day: ");
        checkOutDayJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutDayJL.setBounds(640, 100, 200, 50);
        checkOutDayJL.setBackground(Color.WHITE);
        checkOutDayJL.setOpaque(true);
        checkOutDayJL.setBorder(blackline);
        
        checkOutMonthJL = new JLabel("Check out month: ");
        checkOutMonthJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutMonthJL.setBounds(640, 240, 200, 50);
        checkOutMonthJL.setBackground(Color.WHITE);
        checkOutMonthJL.setOpaque(true);
        checkOutMonthJL.setBorder(blackline);
        
        checkOutYearJL = new JLabel("Check out year: ");
        checkOutYearJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutYearJL.setBounds(640, 380, 200, 50);
        checkOutYearJL.setBackground(Color.WHITE);
        checkOutYearJL.setOpaque(true);
        checkOutYearJL.setBorder(blackline);
        
        menuPanel.add(checkInDayJL);
        menuPanel.add(dayInBox);
        menuPanel.add(checkInMonthJL);
        menuPanel.add(monthInBox);  
        menuPanel.add(checkInYearJL);
        menuPanel.add(yearInBox);
        menuPanel.add(checkOutDayJL);
        menuPanel.add(dayOutBox);
        menuPanel.add(checkOutMonthJL);
        menuPanel.add(monthOutBox);  
        menuPanel.add(checkOutYearJL);
        menuPanel.add(yearOutBox);
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.setPreferredSize(new Dimension(730,80));
        bottomPanel.add(nextButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setTitle("Guests booking dates");
        this.setSize(frameWidth +250, frameHeight +170);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
    
    /**
     * This method returns the boolean result from the variable 'repeat' which
     * contains whether the GUI needs to be re displayed, The same concept of
     * getting the specific datatype applies to all the other get methods below.
     *
     * @return repeat the boolean which contains either true or false on whether
     * the GUI needs to be re displayed.
     * @author Siddarath
     */
    public Boolean getRepeat()
    {
        return repeat;
    }
    
    public Boolean getValidCheckInDay()
    {
        return validCheckInDay;
    }
    
    public Boolean getValidCheckOutDay()
    {
        return validCheckOutDay;
    }
    
    public Boolean getValidDate()
    {
        return validDate;
    }

    public JButton getNextButton() 
    {
        return nextButton;
    }

    public ArrayList<GuestsBookingCart> getDatesBooked() 
    {
        return datesBooked;
    }

    /**
     * This method checks if the dates the user selects are valid by making sure
     * the valid check in/out day, month and year are selected before proceeding
     * to the next stage. If the user selects valid dates the booleans for
     * checking validity are set true and the repeat boolean is set false. Once
     * the input is valid the users selected dates are stored in an array list.
     *
     * @throws ParseException
     * @author Siddarath
     */
    public void confirmSelection() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Uses an object of the sdf SimpleDateFormat class to create a date format.
        Date d1 = sdf.parse(String.valueOf(dayInBox.getSelectedItem())+ "/" +String.valueOf(monthInBox.getSelectedIndex() +1) +"/" +String.valueOf(yearInBox.getSelectedItem())); // Uses an object of the Date and SimpleDateFormat class to store the dates.
        Date d2 = sdf.parse(String.valueOf(dayOutBox.getSelectedItem())+ "/" +String.valueOf(monthOutBox.getSelectedIndex() +1) +"/" +String.valueOf(yearOutBox.getSelectedItem()));
        
        if(d1.compareTo(d2) >0) // Checks if the check in date happens after the check out date
        {
            validDate = false;
            repeat = true;
            validCheckInDay = true;
            validCheckOutDay = true;
        }
        else if(d1.compareTo(d2) < 0) // Checks if the check in date happens before the check out date
        {
            if ((monthInBox.getSelectedIndex()+1 == 1 || monthInBox.getSelectedIndex()+1 == 3 || monthInBox.getSelectedIndex()+1 == 5 || monthInBox.getSelectedIndex()+1 == 7 
                || monthInBox.getSelectedIndex()+1 == 8 || monthInBox.getSelectedIndex()+1 == 10 || monthInBox.getSelectedIndex()+1 == 12) && ((Integer)dayInBox.getSelectedItem() <=31 )) // If the user selected a month with 31 days, it checks if the day they selected is within the range. 
            {
                validCheckInDay = true;
            }
            else if (((monthInBox.getSelectedIndex()+1 == 4 || monthInBox.getSelectedIndex()+1 == 6 || monthInBox.getSelectedIndex()+1 == 9 || monthInBox.getSelectedIndex()+1 == 11) && (Integer)dayInBox.getSelectedItem() <= 30)) // If the user selected a month with 30 days, it checks if the day they selected is within the range.
            {
                validCheckInDay = true;
            }
            else if ((monthInBox.getSelectedIndex()+1 == 2 && (Integer)dayInBox.getSelectedItem() <= 28)) // If the user selected a month with 28 days, it checks if the day they selected is within the range.
            {
                validCheckInDay = true;
            }
            else 
            {   
                validCheckInDay = false;
                repeat = true;
                validDate = false;
            }
            
            if (((monthOutBox.getSelectedIndex() +1 == 1 || monthOutBox.getSelectedIndex()+1 == 3 || monthOutBox.getSelectedIndex()+1 == 5 || monthOutBox.getSelectedIndex()+1 == 7 || monthOutBox.getSelectedIndex() +1 == 8 || 
                monthOutBox.getSelectedIndex()+1 == 10 || monthOutBox.getSelectedIndex()+1 == 12 ) && (Integer)dayOutBox.getSelectedItem() <=31 )) // If the user selected a month with 31 days, it checks if the day they selected is within the range. 
            {
                validCheckOutDay = true;
            }
            else if (((monthOutBox.getSelectedIndex()+1 == 4 || monthOutBox.getSelectedIndex()+1 == 6 || monthOutBox.getSelectedIndex()+1 == 9 || monthOutBox.getSelectedIndex()+1 == 11) && (Integer)dayOutBox.getSelectedItem() <= 30)) // If the user selected a month with 30 days, it checks if the day they selected is within the range.
            {
                validCheckOutDay = true;
            }
            else if ((monthOutBox.getSelectedIndex()+1 == 2 && (Integer)dayOutBox.getSelectedItem() <= 28)) // If the user selected a month with 28 days, it checks if the day they selected is within the range.
            {
                validCheckOutDay = true;
            }
            else 
            {
                validCheckOutDay = false;
                repeat = true;
                validDate = false;
            }
            
            if (validCheckOutDay == true && validCheckInDay == true)
            {
                int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");

                if (userConfirmation == JOptionPane.YES_OPTION) 
                {
                    repeat = false;
                    validDate = true;
                    
                    GuestsBookingCart bookingDetails = new GuestsBookingCart( (Integer)dayInBox.getSelectedItem(), (String) monthInBox.getSelectedItem(), (Integer)yearInBox.getSelectedItem()
                            ,(Integer)dayOutBox.getSelectedItem(), (String) monthOutBox.getSelectedItem(), (Integer)yearOutBox.getSelectedItem());
                    datesBooked.add(bookingDetails);
                } 
                else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
                {
                    repeat = true;
                    validDate = true;
                }
            }
            else
            {
               repeat = true;
               validDate = false; 
            }
        }
        else if(d1.compareTo(d2) == 0 ) // Checks if the check in date is equal to the check out date
        {
            validDate = false;
            validCheckInDay = true;
            validCheckOutDay = true;
            repeat = true;
        }
    }
    
    /**
     * This method displays a pop up error message if the user selects check
     * in/out dates that are both the same date or if the check out happens
     * before the check in.
     *
     * @author Siddarath
     */
    public void displayDateErrorMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid selection! Check in date must occur before check out date and both dates cannot be the same!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method displays a pop up error message if the user selects a day for
     * the month that doesn't exist. Such as 'February 31" doesn't exist, so if
     * a user selects this, an error will occur.
     *
     * @author Siddarath
     */
    public void displayIncorrectDayMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid selection! The check in/out day you selected is not valid for that month. Please try again!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method will set the background color of the next button to green
     * once a user hovers over it.
     *
     * @author Siddarath
     */
    public void mouseEnterNextHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    /**
     * This method will set the background color of the next button back to the
     * default color once the user exits hovering over the next button.
     *
     * @author Siddarath
     */
    public void mouseExitNextHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }   
}
