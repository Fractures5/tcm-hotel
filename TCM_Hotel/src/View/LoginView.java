 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Anuk
 */
public class LoginView extends JFrame{
    
    private JPanel loginHeader;
    private JPanel centrePanel;
    private JPanel buttonPanel;
    
    private JLabel loginPromptMsg;
    private JLabel password;
    
    private JTextField systemPassword;
    
    private String adminInputPassword;
    
    private boolean matchingSystemPassword = false;
    private boolean showIncorrectPasswordError = false;
    
    public LoginView(){
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth, frameHeight);
        this.setResizable(false);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("System Login");
        
        loginHeader = new JPanel();
        loginHeader.add(Box.createVerticalStrut(100));
        loginHeader.setBackground(Color.blue);
        loginPromptMsg = new JLabel("System Login");
        loginPromptMsg.setForeground(Color.white);
        loginPromptMsg.setFont(new Font("Arial", Font.BOLD, 30));
        loginHeader.add(loginPromptMsg);
        
        centrePanel = new JPanel(null);
        
        password = new JLabel("Password: ");
        password.setBounds(300, 25, 300, 30);
        password.setFont(new Font("Arial", Font.BOLD, 17));
        systemPassword = new JTextField("", 30);
        systemPassword.setBounds(500, 25, 200, 30);
        
        centrePanel.add(password);
        centrePanel.add(systemPassword);
       
        
        this.add(loginHeader, BorderLayout.NORTH);
        this.add(centrePanel, BorderLayout.CENTER);
        
    }
    
    
    
}
