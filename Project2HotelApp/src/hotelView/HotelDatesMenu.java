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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.DatePicker;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author Siddarath
 */
public class HotelDatesMenu extends JFrame {
    
    private JLabel title, instruction;
    private JLabel checkInDayJL, checkOutDayJL, checkInMonthJL, checkOutMonthJL, checkInYearJL, checkOutYearJL;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JButton nextButton;
    private int checkInDay, checkInYear, checkOutDay, checkOutYear;
    private String checkInMonth, checkOutMonth;
    private Boolean repeat = false;
    private Boolean validDate = false;
    private Boolean validCheckInDay = false;
    private Boolean validCheckOutDay = false;
    
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
        dayInBox.setBounds(410, 100, 60, 50);
        dayInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        monthInBox = new JComboBox(monthNames);
        monthInBox.setBounds(410, 240, 125, 50);
        monthInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        yearInBox = new JComboBox(years);
        yearInBox.setBounds(410, 380, 85, 50);
        yearInBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        dayOutBox = new JComboBox(dayNo);
        dayOutBox.setBounds(875, 100, 60, 50);
        dayOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        monthOutBox = new JComboBox(monthNames);
        monthOutBox.setBounds(875, 240, 125, 50);
        monthOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        yearOutBox = new JComboBox(years);
        yearOutBox.setBounds(875, 380, 85, 50);
        yearOutBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));

        checkInDayJL = new JLabel("Check in day: ");
        checkInDayJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInDayJL.setBounds(210, 100, 175, 50);
        checkInDayJL.setBorder(blackline);
        
        checkInMonthJL = new JLabel("Check in month: ");
        checkInMonthJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInMonthJL.setBounds(210, 240, 185, 50);
        checkInMonthJL.setBorder(blackline);
        
        checkInYearJL = new JLabel("Check in year: ");
        checkInYearJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkInYearJL.setBounds(210, 380, 175, 50);
        checkInYearJL.setBorder(blackline);
        
        checkOutDayJL = new JLabel("Check out day: ");
        checkOutDayJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutDayJL.setBounds(640, 100, 200, 50);
        checkOutDayJL.setBorder(blackline);
        
        checkOutMonthJL = new JLabel("Check out month: ");
        checkOutMonthJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutMonthJL.setBounds(640, 240, 200, 50);
        checkOutMonthJL.setBorder(blackline);
        
        checkOutYearJL = new JLabel("Check out year: ");
        checkOutYearJL.setFont(new Font("Arial", Font.BOLD, 20));
        checkOutYearJL.setBounds(640, 380, 200, 50);
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

    public int getCheckInDay() 
    {
        return checkInDay;
    }

    public String getCheckInMonth() 
    {
        return checkInMonth;
    }

    public int getCheckInYear() 
    {
        return checkInYear;
    }

    public int getCheckOutDay() 
    {
        return checkOutDay;
    }

    public String getCheckOutMonth() 
    {
        return checkOutMonth;
    }

    public int getCheckOutYear() 
    {
        return checkOutYear;
    }
    
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
                    checkInDay = (Integer)dayInBox.getSelectedItem();
                    checkInMonth = (String) monthInBox.getSelectedItem();
                    checkInYear = (Integer)yearInBox.getSelectedItem();
                    checkOutDay = (Integer)dayOutBox.getSelectedItem();
                    checkOutMonth = (String) monthOutBox.getSelectedItem();
                    checkOutYear = (Integer)yearOutBox.getSelectedItem();
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
    
    public void displayDateErrorMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid selection! Check in date must occur before check out date and both dates cannot be the same!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayIncorrectDayMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid selection! The check in/out day you selected is not valid for that month. Please try again!", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    public void mouseEnterHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }
    
}
