/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

import javafx.scene.control.DatePicker;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Siddarath
 */
public class GuestBookDates extends JFrame{
    
    JLabel title;
    JPanel datePanel;
    
    public GuestBookDates()
    {
        //DatePicker labelDatePicker = new DatePicker();
        title = new JLabel("Dates Booking Menu");
        
        datePanel = new JPanel();
        datePanel.add(title);
       
        this.add(datePanel);
        this.setTitle("Guests booking dates");
        this.setSize(600,700);
        this.setLocation(700,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }    
}
