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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import project2hotelapp.GuestsBookingCart;
import project2hotelapp.RoomMenu;

/**
 *
 * @author Siddarath
 */
public class HotelRoomsMenu extends JFrame 
{
    private JLabel title, instruction, standardTitle, deluxeTitle, twinTitle, queenTitle, familyTitle, couplesTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> standardRoomBox, deluxeRoomBox, twinRoomBox, queenRoomBox, familyRoomBox, couplesRoomBox;
    private JButton nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;
    Integer[] roomQuantity = {0,1,2,3,4,5};
    
    ArrayList<GuestsBookingCart> roomsBooked = new ArrayList<>();
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.WHITE, 10));
    
    public HotelRoomsMenu()
    {
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();
        
        title = new JLabel("Rooms Menu\n");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        
        instruction = new JLabel("Please choose the rooms you would like to book!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(title);
        
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        standardRoomBox = new JComboBox(roomQuantity);
        standardRoomBox.setPreferredSize(new Dimension(50, 50));
        standardRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        standardRoomBox.setBackground(Color.WHITE);
        standardRoomBox.setOpaque(true);
 
        deluxeRoomBox = new JComboBox(roomQuantity);
        deluxeRoomBox.setPreferredSize(new Dimension(50, 50));
        deluxeRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        deluxeRoomBox.setBackground(Color.WHITE);
        deluxeRoomBox.setOpaque(true);
        
        twinRoomBox = new JComboBox(roomQuantity);
        twinRoomBox.setPreferredSize(new Dimension(50, 50));
        twinRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        twinRoomBox.setBackground(Color.WHITE);
        twinRoomBox.setOpaque(true);
        
        queenRoomBox = new JComboBox(roomQuantity);
        queenRoomBox.setPreferredSize(new Dimension(50, 50));
        queenRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        queenRoomBox.setBackground(Color.WHITE);
        queenRoomBox.setOpaque(true);
        
        familyRoomBox = new JComboBox(roomQuantity);
        familyRoomBox.setPreferredSize(new Dimension(50, 50));
        familyRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        familyRoomBox.setBackground(Color.WHITE);
        familyRoomBox.setOpaque(true);
        
        couplesRoomBox = new JComboBox(roomQuantity);
        couplesRoomBox.setPreferredSize(new Dimension(50, 50));
        couplesRoomBox.setFont(new Font("Arial", Font.PLAIN, 20));
        couplesRoomBox.setBackground(Color.WHITE);
        couplesRoomBox.setOpaque(true);
        
        standardTitle = new JLabel("Title: " +roomMenu.get(0).getTitle()+ "                 Room Type: " +roomMenu.get(0).getRoomType()+ "           Price: $" +roomMenu.get(0).getPrice()+ "               Rooms: ");
        standardTitle.setFont(new Font("Arial", Font.BOLD, 20));
        standardTitle.setBorder(blackline);
        standardTitle.setBackground(Color.WHITE);
        standardTitle.setOpaque(true);
        
        deluxeTitle = new JLabel("Title: " +roomMenu.get(1).getTitle()+ "                        Room Type: " +roomMenu.get(1).getRoomType()+ "                Price: $" +roomMenu.get(1).getPrice()+ "               Rooms: ");
        deluxeTitle.setFont(new Font("Arial", Font.BOLD, 20));
        deluxeTitle.setBorder(blackline);
        deluxeTitle.setBackground(Color.WHITE);
        deluxeTitle.setOpaque(true);
        
        twinTitle = new JLabel("Title: " +roomMenu.get(2).getTitle()+ "                         Room Type: " +roomMenu.get(2).getRoomType()+ "                     Price: $" +roomMenu.get(2).getPrice()+ "               Rooms: ");
        twinTitle.setFont(new Font("Arial", Font.BOLD, 20));
        twinTitle.setBorder(blackline);
        twinTitle.setBackground(Color.WHITE);
        twinTitle.setOpaque(true);
        
        queenTitle = new JLabel("Title: " +roomMenu.get(3).getTitle()+ "                       Room Type: " +roomMenu.get(3).getRoomType()+ "                  Price: $" +roomMenu.get(3).getPrice()+ "               Rooms: ");
        queenTitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        queenTitle.setBorder(blackline);
        queenTitle.setBackground(Color.WHITE);
        queenTitle.setOpaque(true);
        
        familyTitle = new JLabel("Title: " +roomMenu.get(4).getTitle()+ "                               Room Type: " +roomMenu.get(4).getRoomType()+ "                  Price: $" +roomMenu.get(4).getPrice()+ "               Rooms: ");
        familyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        familyTitle.setBorder(blackline);
        familyTitle.setBackground(Color.WHITE);
        familyTitle.setOpaque(true);
        
        couplesTitle = new JLabel("Title: " +roomMenu.get(5).getTitle()+ "   Room Type: " +roomMenu.get(5).getRoomType()+ "                 Price: $" +roomMenu.get(5).getPrice()+ "              Rooms: ");
        couplesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        couplesTitle.setBorder(blackline);
        couplesTitle.setBackground(Color.WHITE);
        couplesTitle.setOpaque(true);
        
        menuPanel.add(Box.createVerticalStrut(40));
        menuPanel.add(standardTitle);
        menuPanel.add(standardRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        menuPanel.add(deluxeTitle);
        menuPanel.add(deluxeRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        menuPanel.add(twinTitle);
        menuPanel.add(twinRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        menuPanel.add(queenTitle);
        menuPanel.add(queenRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        menuPanel.add(familyTitle);
        menuPanel.add(familyRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        menuPanel.add(couplesTitle);
        menuPanel.add(couplesRoomBox);
        menuPanel.add(Box.createVerticalStrut(83));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.add(nextButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking rooms");
        this.setSize(frameWidth +350, frameHeight +250);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public JButton getNextButton()
    {
        return nextButton;
    }
    
    public Boolean getShowErrorMesssage()
    {
        return showErrorMessage;
    }
    
    public Boolean getRepeat()
    {
        return repeat;
    }
    
    public ArrayList<GuestsBookingCart> getRoomsBooked()
    {
        return roomsBooked;
    }
    public void confirmSelection()
    {
        if (standardRoomBox.getSelectedItem().equals(0) && deluxeRoomBox.getSelectedItem().equals(0) && twinRoomBox.getSelectedItem().equals(0)
                && familyRoomBox.getSelectedItem().equals(0) && queenRoomBox.getSelectedItem().equals(0) && couplesRoomBox.getSelectedItem().equals(0)) 
        {
            showErrorMessage = true;
            repeat = true;
        } 
        else 
        {
            int userConfirmation = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to continue?");

            if (userConfirmation == JOptionPane.YES_OPTION) 
            {
                showErrorMessage = false;
                repeat = false;

            }
            else if (userConfirmation == JOptionPane.NO_OPTION || userConfirmation == JOptionPane.CANCEL_OPTION || userConfirmation == JOptionPane.CLOSED_OPTION) 
            {
                repeat = true;
                showErrorMessage = false;
            }

        }
    }
    
    public void addUserRoomsSelection()
    {
        int count  = 0;
        
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();
        
        int standardNo = standardRoomBox.getSelectedIndex();
        if (standardNo > 0)
        {
            while (count < standardNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(0).getTitle(), roomMenu.get(0).getRoomType(), roomMenu.get(0).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
        
        int deluxeNo = deluxeRoomBox.getSelectedIndex();
        if (deluxeNo > 0)
        {
            count = 0;
            while (count < deluxeNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(1).getTitle(), roomMenu.get(1).getRoomType(), roomMenu.get(1).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
        
        int twinNo = twinRoomBox.getSelectedIndex();
        if (twinNo > 0)
        {
            count = 0;
            while (count < twinNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(2).getTitle(), roomMenu.get(2).getRoomType(), roomMenu.get(2).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
        
        int queenNo = queenRoomBox.getSelectedIndex();
        if (queenNo > 0)
        {
            count = 0;
            while (count < queenNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(3).getTitle(), roomMenu.get(3).getRoomType(), roomMenu.get(3).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
        
        int familyRNo = familyRoomBox.getSelectedIndex();
        if (familyRNo > 0)
        {
            count = 0;
            while (count < familyRNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(4).getTitle(), roomMenu.get(4).getRoomType(), roomMenu.get(4).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
        
        int couplesNo = couplesRoomBox.getSelectedIndex();
        if (couplesNo > 0)
        {
            count = 0;
            while (count < couplesNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(roomMenu.get(5).getTitle(), roomMenu.get(5).getRoomType(), roomMenu.get(5).getPrice());
                roomsBooked.add(bookingDetails);
                count++;
            }
        }
    }
    
    public void displayErrorMessage()
    {
       JOptionPane.showMessageDialog(new JFrame(), "Please select the rooms you would like to book before moving to the next stage", "Invalid Selection",
                    JOptionPane.ERROR_MESSAGE); 
    }
    
    public void mouseEnterNextHover()
    {
        getNextButton().setBackground(Color.GREEN);
    }
    
    public void mouseExitNextHover()
    {
        getNextButton().setBackground(UIManager.getColor("control"));
    }
}
