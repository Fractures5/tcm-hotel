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
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Siddarath
 */
public class HotelChooseDates extends JFrame {
    
    private JLabel title, instruction;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JButton nextButton;
    
    public HotelChooseDates()
    {
         
         DatePicker d = new DatePicker();
         
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

         menuPanel = new JPanel();
         menuPanel.setBackground(Color.LIGHT_GRAY);
         menuPanel.setPreferredSize(new Dimension(600,450));
         menuPanel.add(instruction);
         menuPanel.add(d);
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
         this.setSize(1200,700);
         this.setLocation(500,150);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
    }
    
    
}
