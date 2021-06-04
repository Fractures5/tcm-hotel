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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * This is a description of the LoginMenu View class. This View class will
 * contain the constructor that when invoked it will initialize and define all
 * the necessary Java GUI components for the Admin System Login frame if the
 * user has successfully entered valid admin details via the Admin Form.
 *
 * @author Anuk
 */
public class LoginMenu extends JFrame{
    
    private String correctSystemPassword;
    private String inputSystemPassword;
    
    private JPanel loginHeader;
    private JPanel centrePanel;
    private JPanel buttonPanel;
    
    private JLabel headerMsg;
    private JLabel loginInstruction;
    private JLabel password;
    
    private int clearPwReply;
    private int returnMenuReply;
    
    private JPasswordField systemPassword;
    
    /**
     * The getSystemPassword method will get the data stored in the field and
     * return it as a String data type.
     *
     * @return new String(this.systemPassword.getPassword()) this is the string
     * which will be returned that will store the data fetched from the
     * JPasswordField object.
     * @author Anuk
     */
    public String getSystemPassword() {
        return new String(this.systemPassword.getPassword());
    }
    
    private JCheckBox showPassword;
    
    private String adminInputPassword;
    
    private JButton login;
    private JButton clearPassword;
    private JButton mainMenu;

    /**
     * The getLogin getter method will return the value stored in the JButton
     * object. The concept of this getter method can be applied to all other
     * getter methods found in this class.
     *
     * @return login stores the value stored in the JButton object.
     * @author Anuk
     */
    public JButton getLogin() {
        return login;
    }

    public JButton getClearPassword() {
        return clearPassword;
    }

    public JButton getMainMenu() {
        return mainMenu;
    }

    public JCheckBox getShowPassword() {
        return showPassword;
    }
    
    private boolean matchingSystemPassword = false;
    private boolean showInvalidPasswordError = false;

    public boolean getMatchingSystemPassword() {
        return matchingSystemPassword;
    }

    public boolean getShowInvalidPasswordError() {
        return showInvalidPasswordError;
    }
    
    /**
     * This is the constructor for the LoginMenu View class. This constructor
     * when invoked, will display the frame of the System Login frame where the
     * user will be prompted to enter the correct system password in the field
     * displayed. This constructor will be invoked once the user has input valid
     * admin details in the admin form The set correct password for the admin
     * system is "tcmHotel".
     *
     * @author Anuk
     */
    public LoginMenu(){
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth-100, frameHeight-50);
        this.setResizable(true);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("System Login");
        
        loginHeader = new JPanel();
        loginHeader.add(Box.createVerticalStrut(100));
        loginHeader.setBackground(Color.blue);
        headerMsg = new JLabel("System Login");
        headerMsg.setForeground(Color.white);
        headerMsg.setFont(new Font("Arial", Font.BOLD, 50));
        loginHeader.add(headerMsg);
        
        centrePanel = new JPanel(null);
        
        loginInstruction = new JLabel("To Continue, Please enter the Backend-System Password for the TCM Hotel!");
        loginInstruction.setBounds(100, 30, 700, 30);
        loginInstruction.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 18));
        loginInstruction.setForeground(Color.red);
        
        password = new JLabel("Password: ");
        password.setBounds(250, 110, 200, 30);
        password.setFont(new Font("Arial", Font.BOLD, 30));
        password.setToolTipText("Please Enter the Password to the System Backend");
        
        systemPassword = new JPasswordField("", 300);
        systemPassword.setBounds(450, 110, 200, 30);
        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(525, 140, 200, 50);
        showPassword.setFont(new Font("Arial", Font.BOLD, 13));
        
        
        centrePanel.add(loginInstruction);
        centrePanel.add(password);
        centrePanel.add(showPassword);
        centrePanel.add(systemPassword);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setBounds(0, 275, 600, 700);
        
        login = new JButton("Login" + "\u2192");
        login.setPreferredSize(new Dimension(170, 70));
        login.setFont(new Font("Arial", Font.BOLD, 17));
        login.setBorder(new LineBorder(Color.black, 4));
        login.setForeground(Color.black);
        login.setToolTipText("Login and Proceed to Administrator Privileges");
        
        mainMenu = new JButton("Return To Main Menu" + "\u2190");
        mainMenu.setPreferredSize(new Dimension(210, 70));
        mainMenu.setFont(new Font("Arial", Font.BOLD, 17));
        mainMenu.setBorder(new LineBorder(Color.black, 4));
        mainMenu.setForeground(Color.black);
        mainMenu.setToolTipText("Exit Admin Interface and Return to Main Menu");
        
        clearPassword = new JButton("Clear Password");
        clearPassword.setPreferredSize(new Dimension(200, 70));
        clearPassword.setFont(new Font("Arial", Font.BOLD, 17));
        clearPassword.setBorder(new LineBorder(Color.black, 4));
        clearPassword.setForeground(Color.black);
        clearPassword.setToolTipText("Clear the currently entered password in the field");
        
        buttonPanel.add(mainMenu);
        buttonPanel.add(clearPassword);
        buttonPanel.add(login);
        
        this.add(loginHeader, BorderLayout.NORTH);
        this.add(centrePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    /**
     * The loginSystemBackend method will check if the password entered by the
     * user is correct or not. Based on the validity of the entered password
     * this method will set appropriate true/false values to the boolean
     * variables in the method to determine whether or not an error should be
     * shown. The set correct password for the admin system is "tcmHotel".
     *
     * @author Anuk
     */
    public void loginSystemBackend(){
        inputSystemPassword = (new String(this.systemPassword.getPassword()));
        correctSystemPassword = "tcmHotel";
        System.out.println(inputSystemPassword);
        
        if(inputSystemPassword.equals(correctSystemPassword)){
            System.out.println("input password correct!");
            matchingSystemPassword = true;
            showInvalidPasswordError = false;
        }
        else{
            System.out.println("input password incorrect!");
            matchingSystemPassword = false;
            showInvalidPasswordError = true;
        }
    }
    
    /**
     * The clearInputPassword method will check for the user's reply to the show
     * confirm dialog JOptionPane. If the user has chosen yes, the entered
     * password in the password field will be cleared.
     *
     * @author Anuk
     */
    public void clearInputPassword(){
        inputSystemPassword = (new String(this.systemPassword.getPassword()));
        clearPwReply = JOptionPane.showConfirmDialog(null, "Resetting will clear information you have entered! Are you sure?", "Reset Details!", JOptionPane.OK_CANCEL_OPTION);
        if (clearPwReply == JOptionPane.YES_OPTION) {
            String empty = "";
            systemPassword.setText(empty);
        }
        else if (clearPwReply == JOptionPane.CANCEL_OPTION) {
            systemPassword.setText(inputSystemPassword);
        }
    }
    
    public void returnToMainMenu(){
        JOptionPane.showMessageDialog(null, "Entered Details will be Lost when Returning to the Main Menu before logging in", "Return to Main Menu Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * The toggleShowPassword method, when invoked, will reveal all entered
     * characters in the systemPassword by changing all characters from asteriks
     * to the actual characters pressed from the keyboard.
     *
     * @author Anuk
     */
    public void toggleShowPassword(){
        systemPassword.setEchoChar(showPassword.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.ecoChar"));
    }
    
    /**
     * The toggleHidePassword method, when invoked, will hide all entered
     * characters in the systemPassword by changing all characters from the
     * actual characters pressed from the keyboard to asteriks.
     *
     * @author Anuk
     */
    public void toggleHidePassword() {
        systemPassword.setEchoChar('*');
    }
    
    /**
     * The displayInvalidPasswordError method will display a JOptionPane
     * prompting the user that they have entered incorrect input for the system
     * password field.
     *
     * @author Anuk
     */
    public void displayInvalidPasswordError(){
        JOptionPane.showMessageDialog(null, "Incorrect Password has been entered! Try Again", "System Login Failure", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * The displayLoginSuccessful method will display a JOptionPane prompting
     * the user that they have entered correct input for the system password
     * field.
     *
     * @author Anuk
     */
    public void displayLoginSuccessful(){
        JOptionPane.showMessageDialog(null, "You have Successfully Logged in!", "System Login Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * The mouseEnterHoverLoginButton method will change the background colour
     * of the login button to green if the mouse has entered the button. The
     * concept of this method can be applied to other methods that incorporate
     * the mouse enter button procedure.
     *
     * @author Anuk
     */
    public void mouseEnterHoverLoginButton() {
        getLogin().setBackground(Color.GREEN);
    }
    
    /**
     * The mouseExitHoverLoginButton method will set the background colour of
     * the login button back to the default origin colour if the mouse has
     * exited the button. The concept of this method can be applied to other
     * methods that incorporate the mouse exit button procedure.
     *
     * @author Anuk
     */
    public void mouseExitHoverLoginButton() {
        getLogin().setBackground(UIManager.getColor("control"));
    } 

    public void mouseEnterHoverClearPasswordButton() {
        getClearPassword().setBackground(Color.ORANGE);
    }

    public void mouseExitHoverClearPasswordButton() {
        getClearPassword().setBackground(UIManager.getColor("control"));
    }
    
    public void mouseEnterHoverMainMenuButton() {
        getMainMenu().setBackground(Color.RED);
    }

    public void mouseExitHoverMainMenuButton() {
        getMainMenu().setBackground(UIManager.getColor("control"));
    }
}
