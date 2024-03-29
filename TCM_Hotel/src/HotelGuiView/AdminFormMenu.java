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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * This is a description of the AdminFormMenu View class.
 * This View Class will contain the constructor that when invoked it will initialize and define all the
 * necessary Java GUI components for the Admin Form Frame if the user has chosen to access the admin system through
 * the main menu interface.
 * @author Anuk
 */
public class AdminFormMenu extends JFrame {
    
    private JComboBox jobTitleList;

    private JPanel adminHeader;
    private JPanel centrePanel;
    private JPanel buttonPanel;

    private JButton proceedToLogin;
    private JButton resetAdminDetails;

    private JLabel welcomeLabel;
    private JLabel fName;
    private JLabel lName;
    private JLabel staffTitle;
    private JLabel phoneNumber;
    private JLabel emailAddress;

    private JTextField adminFNameField;
    private JTextField adminLNameField;
    private JTextField adminJobTitleField;
    private JTextField adminPhoneNumField;
    private JTextField adminEmailField;
    
    private String inputFirstName;
    private String inputLastName;
    private String inputJobTitle;
    private long inputPhoneNumber;
    private String inputEmail;

    private boolean validAdminFName = false;
    private boolean validAdminLName = false;
    private boolean validAdminJobTitle = false;
    private boolean validAdminPhoneNumber = false;
    private boolean validAdminEmail = false;
    private boolean validAdminDetails = false;

    private boolean showAdminFNameError = false;
    private boolean showAdminLNameError = false;
    private boolean showAdminJobTitleError = false;
    private boolean showAdminPhoneNumberError = false;
    private boolean showAdminEmailAddressError = false;
    private boolean showAdminRegSuccess = false;

    public JComboBox getJobTitleList() {
        return jobTitleList;
    }

    
    public boolean getShowAdminRegSuccess() {
        return showAdminRegSuccess;
    }

    public boolean getValidAdminDetails() {
        return validAdminDetails;
    }

    public boolean getShowAdminFNameError() {
        return showAdminFNameError;
    }

    public boolean getShowAdminLNameError() {
        return showAdminLNameError;
    }

    public boolean getShowAdminJobTitleError() {
        return showAdminJobTitleError;
    }

    public boolean getShowAdminPhoneNumberError() {
        return showAdminPhoneNumberError;
    }

    public boolean getShowAdminEmailAddressError() {
        return showAdminEmailAddressError;
    }
    
    public String getAdminFNameField() {
        return adminFNameField.getText();
    }

    public String getAdminLNameField() {
        return adminLNameField.getText();
    }

    public String getAdminJobTitleField() {
        return adminJobTitleField.getText();
    }

    public long getAdminPhoneNumField() {
        return Long.parseLong(adminPhoneNumField.getText());
    }

    public String getAdminEmailField() {
        return adminEmailField.getText();
    }
    
    /**
     * The getProceedToLogin getter method will return the value stored in the
     * JButton object. The concept of this getter method can be applied to all
     * other getter methods found in this class.
     *
     * @return proceedToLogin stores the value stored in the JButton object.
     * @author Anuk
     */
    public JButton getProceedToLogin() {
        return proceedToLogin;
    }

    public JButton getResetAdminDetails() {
        return resetAdminDetails;
    }
    
    /**
     * This is the constructor for the AdminFormMenu View class. This
     * constructor when invoked, will display the frame of the Admin Form once
     * the user has chosen to access the admin back-end system through the main
     * menu interface.
     *
     * @author Anuk
     */
    public AdminFormMenu() {
        
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth, frameHeight+75);
        this.setResizable(true);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin Form");

        adminHeader = new JPanel();
        adminHeader.add(Box.createVerticalStrut(100));
        adminHeader.setBackground(Color.blue);
        welcomeLabel = new JLabel("Administration Staff Form");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        adminHeader.add(welcomeLabel);
        
        centrePanel = new JPanel(null);

        fName = new JLabel("Administator First Name: ");
        fName.setBounds(300, 25, 300, 30);
        fName.setFont(new Font("Arial", Font.BOLD, 17));
        adminFNameField = new JTextField("", 30);
        adminFNameField.setBounds(500, 25, 200, 30);
        
        lName = new JLabel("Administator Last Name: ");
        lName.setBounds(300, 85, 300, 30);
        lName.setFont(new Font("Arial", Font.BOLD, 17));
        adminLNameField = new JTextField("", 30);
        adminLNameField.setBounds(500, 85, 200, 30);
        
        staffTitle = new JLabel("Your Job Title: ");
        staffTitle.setBounds(375, 145, 300, 30);
        staffTitle.setFont(new Font("Arial", Font.BOLD, 17));
        String[] jobTitleStrings = {"CEO", "Manager", "Desk Staff", "Network Staff", "Clerk", "Supervisor", "Senior Staff"};
        jobTitleList = new JComboBox(jobTitleStrings);
        jobTitleList.setBounds(500, 145, 200, 30);
        
        phoneNumber = new JLabel("Administrator Phone Number: ");
        phoneNumber.setBounds(260, 225, 300, 30);
        phoneNumber.setFont(new Font("Arial", Font.BOLD, 17));
        adminPhoneNumField = new JTextField("", 30);
        adminPhoneNumField.setBounds(500, 225, 200, 30);
        
        emailAddress = new JLabel("Administrator Email Address: ");
        emailAddress.setBounds(260, 305, 300, 30);
        emailAddress.setFont(new Font("Arial", Font.BOLD, 17));
        adminEmailField = new JTextField("", 30);
        adminEmailField.setBounds(500, 305, 200, 30);

        
        centrePanel.add(fName);
        centrePanel.add(adminFNameField);
        centrePanel.add(lName);
        centrePanel.add(adminLNameField);
        centrePanel.add(staffTitle);
        centrePanel.add(jobTitleList);
        centrePanel.add(phoneNumber);
        centrePanel.add(adminPhoneNumField);
        centrePanel.add(emailAddress);
        centrePanel.add(adminEmailField);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setBounds(0, 275, 600, 700);
        
        proceedToLogin = new JButton("Proceed to Login" + "\u2192");
        proceedToLogin.setPreferredSize(new Dimension(170, 70));
        proceedToLogin.setFont(new Font("Arial", Font.BOLD, 17));
        proceedToLogin.setBorder(new LineBorder(Color.black, 4));
        proceedToLogin.setForeground(Color.black);
        
        resetAdminDetails = new JButton("Reset " + "\u2190");
        resetAdminDetails.setPreferredSize(new Dimension(170, 70));
        resetAdminDetails.setFont(new Font("Arial", Font.BOLD, 17));
        resetAdminDetails.setBorder(new LineBorder(Color.black, 4));
        resetAdminDetails.setForeground(Color.black);
        
        
        buttonPanel.add(resetAdminDetails);
        buttonPanel.add(proceedToLogin);

        this.add(adminHeader, BorderLayout.NORTH);
        this.add(centrePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    /**
     * The adminDetailsConfirmation method will check for the validity of the
     * user input and set values to the defined boolean variables in regards to
     * whether or not the entered data in the field contains an error and
     * whether or not an error message should show.
     *
     * @author Anuk
     */
    public void adminDetailsConfirmation(){
        
        inputFirstName = adminFNameField.getText();
        inputLastName = adminLNameField.getText();
        inputJobTitle = (String) jobTitleList.getSelectedItem();
        inputEmail = adminEmailField.getText();
        
        if (inputFirstName.matches("[A-Za-z]+")) {
            validAdminFName = true;
            showAdminFNameError = false;
        } else if (!inputFirstName.matches("[A-Za-z]+")) {
            validAdminFName = false;
            showAdminFNameError = true;
            adminFNameField.setText("");
        }

        if (inputLastName.matches("[A-Za-z]+")) {
            validAdminLName = true;
            showAdminLNameError = false;
        } else if (!inputLastName.matches("[A-Za-z]+")) {
            validAdminLName = false;
            showAdminLNameError = true;
            adminLNameField.setText("");
        }
        
        try {
            inputPhoneNumber = getAdminPhoneNumField();
            validAdminPhoneNumber = true;
            showAdminPhoneNumberError = false;

        } catch (NumberFormatException o) {
            validAdminPhoneNumber = false;
            showAdminPhoneNumberError = true;
            adminPhoneNumField.setText("");
        }
        if (!inputEmail.contains("@") || (((!inputEmail.contains(".com")) && (!inputEmail.contains(".co.nz")) && (!inputEmail.contains(".net")) && (!inputEmail.contains(".org.nz")) && (!inputEmail.contains(".ac.nz"))))) {
            validAdminEmail = false;
            showAdminEmailAddressError = true;
        } else if (inputEmail.contains("@") || (((inputEmail.contains(".com")) && (inputEmail.contains(".co.nz")) && (inputEmail.contains(".net")) && (inputEmail.contains(".org.nz")) && (!inputEmail.contains(".ac.nz"))))) {
            validAdminEmail = true;
            showAdminEmailAddressError = false;
        }
        if (validAdminFName == true && validAdminLName == true && /*validAdminJobTitle == true &&*/ validAdminPhoneNumber == true && validAdminEmail == true){
            validAdminDetails = true;
            showAdminRegSuccess = true;
        }
    }
    
    /**
     * The adminDetailsReset method will check if the user wants to confirm the
     * resetting of their entered values and if they agree the fields of the
     * form will be cleared or emptied.
     *
     * @author Anuk
     */
    public void adminDetailsReset(){
        
        int resetReply = JOptionPane.showConfirmDialog(null, "Resetting will clear information you have entered!", "Reset Details!", JOptionPane.ERROR_MESSAGE);
        if (resetReply == JOptionPane.YES_OPTION) {
            String empty = "";
            adminFNameField.setText(empty);
            adminLNameField.setText(empty);
            adminPhoneNumField.setText(empty);
            adminEmailField.setText(empty);
        } else if (resetReply == JOptionPane.NO_OPTION) {
            adminFNameField.setText(inputFirstName);
            adminLNameField.setText(inputLastName);
            adminEmailField.setText(inputEmail);
        }
        
    }
    
    /**
     * The mouseEnterProceedToLogin method will change the background colour of
     * the proceed to login button if the mouse has entered the button. The
     * concept of this method can be applied to other methods that incorporate
     * the mouse enter button procedure.
     *
     * @author Anuk
     */
    public void mouseEnterProceedToLogin() {
        getProceedToLogin().setBackground(Color.GREEN);
    }

    /**
     * The mouseExitProceedToLogin method will set the background colour of the
     * proceed to login button back to the default origin colour if the mouse
     * has exited the button. The concept of this method can be applied to other
     * methods that incorporate the mouse exit button procedure.
     *
     * @author Anuk
     */
    public void mouseExitProceedToLogin() {
        getProceedToLogin().setBackground(UIManager.getColor("control"));
    }

    public void mouseEnterResetAdminDetails() {
        getResetAdminDetails().setBackground(Color.RED);
    }

    public void mouseExitResetAdminDetails() {
        getResetAdminDetails().setBackground(UIManager.getColor("control"));
    }
    
    /**
     * The displayAdminFNameError method will display a JOptionPane prompting
     * the user that they have entered incorrect input for the admin first name
     * field. The concept of this method can be applied to other methods which
     * display a JOptionPane to the user.
     *
     * @author Anuk
     */
    public void displayAdminFNameError() {
        JOptionPane.showMessageDialog(null, "Your First Name must only contain letters of the Alphabet!", "Invalid First Name Error!", JOptionPane.ERROR_MESSAGE);
    }

    public void displayAdminLNameError() {
        JOptionPane.showMessageDialog(null, "Your Last Name must only contain letters of the Alphabet!", "Invalid Last Name Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayAdminJobTitleError() {
        JOptionPane.showMessageDialog(null, "Your Job Title must only contain letters of the Alphabet!", "Invalid Job Title Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayAdminPhoneNumberError() {
        JOptionPane.showMessageDialog(null, "Your Phone Number must only contain Numbers", "Invalid Phone Number Error!", JOptionPane.ERROR_MESSAGE);
    }

    public void displayAdminEmailAddressError() {
        JOptionPane.showMessageDialog(null, "You must have a valid Email Address!", "Invalid Email Error!", JOptionPane.ERROR_MESSAGE);
    }
    public void displayAdminRegSuccess() {
        JOptionPane.showMessageDialog(null, "Administrator Registration Successful!", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
