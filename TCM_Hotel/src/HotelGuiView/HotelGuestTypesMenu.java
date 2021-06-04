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
import HotelDataFiles.GuestsBookingCart;
import HotelDataFiles.GuestsTypeMenu;

/**
 * The HotelGuestTypesMenu class is a view class outputs the hotel guest types
 * GUI to the user where they can select using combo boxes of the number of
 * guests they would be staying along with their guest type. This class contains
 * all the GUI elements for this menu, getter methods for other classes to
 * access variables from this class safely and methods to deal with error
 * handling and confirming the users selection.
 *
 * @author Siddarath
 */
public class HotelGuestTypesMenu extends JFrame
{
    private JLabel pageTitle, instruction, adultTitle, childTitle, infantTitle, elderlyTitle, vipTitle;
    private JPanel headerPanel, menuPanel, bottomPanel;
    private JComboBox<Integer> adultTypeBox, childTypeBox, infantTypeBox, elderlyTypeBox, vipTypeBox;
    private JButton nextButton;
    private Boolean showErrorMessage = false;
    private Boolean repeat = false;
    Integer[] guestCount = {0,1,2,3,4,5};
    ArrayList<GuestsBookingCart> guestTypesBooked = new ArrayList<>();
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;
    
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createLineBorder(Color.WHITE, 10));
    
    /**
     * This default constructor initializes the panels, labels, combo boxes for
     * the number of guests, next buttons and other variables, sets the name,
     * size, colors, position and then adds it to the frame (set to visible)
     * which makes the Hotel Guest Types Menu GUI visible to the user so they
     * can choose hotel guest types by selecting the desired number of guests
     * and the type.
     */
    public HotelGuestTypesMenu()
    {
        ArrayList<GuestsTypeMenu> guestTypeMenu = new ArrayList<GuestsTypeMenu>();
        guestTypeMenu = GuestsTypeMenu.showMenu();
        
        pageTitle = new JLabel("Guest Types Menu");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setForeground(Color.WHITE);
        
        instruction = new JLabel("Please choose the guest type and number of guests you would like to book!");
        instruction.setFont(new Font("Arial", Font.BOLD, 20));
        instruction.setForeground(Color.BLACK);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.add(pageTitle);
        
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600, 450));
        menuPanel.add(instruction);
        
        adultTypeBox = new JComboBox(guestCount);
        adultTypeBox.setPreferredSize(new Dimension(50, 50));
        adultTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        adultTypeBox.setBackground(Color.WHITE);
        adultTypeBox.setOpaque(true);
        
        childTypeBox = new JComboBox(guestCount);
        childTypeBox.setPreferredSize(new Dimension(50, 50));
        childTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        childTypeBox.setBackground(Color.WHITE);
        childTypeBox.setOpaque(true);
        
        infantTypeBox = new JComboBox(guestCount);
        infantTypeBox.setPreferredSize(new Dimension(50, 50));
        infantTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        infantTypeBox.setBackground(Color.WHITE);
        infantTypeBox.setOpaque(true);

        elderlyTypeBox = new JComboBox(guestCount);
        elderlyTypeBox.setPreferredSize(new Dimension(50, 50));
        elderlyTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        elderlyTypeBox.setBackground(Color.WHITE);
        elderlyTypeBox.setOpaque(true);
        
        vipTypeBox = new JComboBox(guestCount);
        vipTypeBox.setPreferredSize(new Dimension(50, 50));
        vipTypeBox.setFont(new Font("Arial", Font.PLAIN, 20));
        vipTypeBox.setBackground(Color.WHITE);
        vipTypeBox.setOpaque(true);
        
        adultTitle = new JLabel("Title: " +guestTypeMenu.get(0).getTitle() + "            Guest Type: " +guestTypeMenu.get(0).getGuestType()+ "           Price: $" +guestTypeMenu.get(0).getPrice()+ "          Guest Numbers: ");
        adultTitle.setFont(new Font("Arial", Font.BOLD, 20));
        adultTitle.setBorder(blackline);
        adultTitle.setBackground(Color.WHITE);
        adultTitle.setOpaque(true);
        
        childTitle = new JLabel("Title: " +guestTypeMenu.get(1).getTitle() + "            Guest Type: " +guestTypeMenu.get(1).getGuestType()+ "           Price: $" +guestTypeMenu.get(1).getPrice()+ "          Guest Numbers: ");
        childTitle.setFont(new Font("Arial", Font.BOLD, 20));
        childTitle.setBorder(blackline);
        childTitle.setBackground(Color.WHITE);
        childTitle.setOpaque(true);
        
        infantTitle = new JLabel("Title: " +guestTypeMenu.get(2).getTitle() + "            Guest Type: " +guestTypeMenu.get(2).getGuestType()+ "           Price: $" +guestTypeMenu.get(2).getPrice()+ "          Guest Numbers: ");
        infantTitle.setFont(new Font("Arial", Font.BOLD, 20));
        infantTitle.setBorder(blackline);
        infantTitle.setBackground(Color.WHITE);
        infantTitle.setOpaque(true);
        
        elderlyTitle = new JLabel("Title: " +guestTypeMenu.get(3).getTitle() + "            Guest Type: " +guestTypeMenu.get(3).getGuestType()+ "           Price: $" +guestTypeMenu.get(3).getPrice()+ "          Guest Numbers: ");
        elderlyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        elderlyTitle.setBorder(blackline);
        elderlyTitle.setBackground(Color.WHITE);
        elderlyTitle.setOpaque(true);
        
        vipTitle = new JLabel("Title: " +guestTypeMenu.get(4).getTitle() + "            Guest Type: " +guestTypeMenu.get(4).getGuestType()+ "           Price: $" +guestTypeMenu.get(4).getPrice()+ "          Guest Numbers: ");
        vipTitle.setFont(new Font("Arial", Font.BOLD, 20));
        vipTitle.setBorder(blackline);
        vipTitle.setBackground(Color.WHITE);
        vipTitle.setOpaque(true);
        
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(adultTitle);
        menuPanel.add(adultTypeBox);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(childTitle);
        menuPanel.add(childTypeBox);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(infantTitle);
        menuPanel.add(infantTypeBox);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(elderlyTitle);
        menuPanel.add(elderlyTypeBox);
        menuPanel.add(Box.createVerticalStrut(95));
        menuPanel.add(vipTitle);
        menuPanel.add(vipTypeBox);
        menuPanel.add(Box.createVerticalStrut(95));
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200,70));
        nextButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);
        bottomPanel.add(nextButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        this.setTitle("Guests booking guests types");
        this.setSize(frameWidth +350, frameHeight +250);
        this.setLocation((dim.width/2 - this.getSize().width/2), (dim.height/2 - this.getSize().height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
    
    /**
     * This method returns the JButton object from the variable 'nextButton'
     * which contains the next button variable. The same concept of
     * getting/returning the specific datatype applies to all the other get
     * methods below.
     *
     * @return nextButton the JButton variable.
     * @author Siddarath
     */
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
    
    public ArrayList<GuestsBookingCart> getGuestTypesBooked()
    {
        return guestTypesBooked;
    }
    
    /**
     * This method checks if user chooses a guest type and quantity. If the user
     * does not choose a quantity over 0 for any of the guests then it will set
     * a boolean that will let the controller (GuestTypeInteraction) for this
     * menu know to show a error message to the user. If the user selects a
     * valid choice the booleans for repeat and show error message are changed
     * to false indicating the data can be stored in the array and they can move
     * onto the next stage.
     *
     * @author Siddarath
     */
    public void confirmSelection()
    {
        if (adultTypeBox.getSelectedItem().equals(0) && childTypeBox.getSelectedItem().equals(0) && infantTypeBox.getSelectedItem().equals(0)
                && elderlyTypeBox.getSelectedItem().equals(0) && vipTypeBox.getSelectedItem().equals(0)) 
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
    
    /**
     * If the user selects a valid selection of number of guests then this
     * method will successfully store the selected guest types in an array list
     * which is later stored in the BookedGuestTypes model through the
     * GuestsTypeInteraction (controller)
     *
     * @author Siddarath
     */
    public void addGuestTypesSelection()
    {
        int count  = 0;
        
        ArrayList<GuestsTypeMenu> guestTypeMenu = new ArrayList<GuestsTypeMenu>();
        guestTypeMenu = GuestsTypeMenu.showMenu();
        
        int adultsNo = adultTypeBox.getSelectedIndex();
        if (adultsNo > 0)
        {
            while (count < adultsNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(0).getTitle(), guestTypeMenu.get(0).getGuestType(), guestTypeMenu.get(0).getPrice());
                guestTypesBooked.add(bookingDetails);
                count++;
            }
        }
        
        int childNo = childTypeBox.getSelectedIndex();
        if (childNo > 0)
        {
            count = 0;
            while (count < childNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(1).getTitle(), guestTypeMenu.get(1).getGuestType(), guestTypeMenu.get(1).getPrice());
                guestTypesBooked.add(bookingDetails);
                count++;
            }
        }
        
        int infantNo = infantTypeBox.getSelectedIndex();
        if (infantNo > 0)
        {
            count = 0;
            while (count < infantNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(2).getTitle(), guestTypeMenu.get(2).getGuestType(), guestTypeMenu.get(2).getPrice());
                guestTypesBooked.add(bookingDetails);
                count++;
            }
        }
        
        int elderyNo = elderlyTypeBox.getSelectedIndex();
        if (elderyNo > 0)
        {
            count = 0;
            while (count < elderyNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(3).getTitle(), guestTypeMenu.get(3).getGuestType(), guestTypeMenu.get(3).getPrice());
                guestTypesBooked.add(bookingDetails);
                count++;
            }
        }
        
        int vipNo = vipTypeBox.getSelectedIndex();
        if (vipNo > 0)
        {
            count = 0;
            while (count < vipNo) 
            {
                GuestsBookingCart bookingDetails = new GuestsBookingCart(guestTypeMenu.get(4).getTitle(), guestTypeMenu.get(4).getGuestType(), guestTypeMenu.get(4).getPrice());
                guestTypesBooked.add(bookingDetails);
                count++;
            }
        }
    }
    
    /**
     * If a user doesn't select any number of hotel guest types this method will
     * be invoked and it will output an error message to the user, preventing
     * them to move on until they choose one at least.
     *
     * @author Siddarath
     */
    public void displayErrorMessage()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Please select the number of guests and what type of guests will be staying before moving to the next stage", "Invalid Selection",
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
