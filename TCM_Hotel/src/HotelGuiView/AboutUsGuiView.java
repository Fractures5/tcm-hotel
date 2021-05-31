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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

/**
 *
 * @author faari
 */
public class AboutUsGuiView extends JFrame
{
    private JFrame aboutUsFrame;
    
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    
    private JLabel aboutUsLabel;
    
    private JLabel imageLabel1; 
    private JLabel imageLabel2; 
    private JLabel imageLabel3; 
    
    private BufferedImage pic1;
    private BufferedImage pic2;
    private BufferedImage pic3;
    
    private JTextArea AboutUsField;
    private JScrollPane scrollPane;
            
    private JButton returnButton;
    
    public AboutUsGuiView () throws IOException
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;

        this.setSize(frameWidth, frameHeight + 350);
        this.setResizable(false);
        this.setLocation((dim.width / 2 - this.getSize().width / 2), (dim.height / 2 - this.getSize().height / 2));

        aboutUsFrame = new JFrame("About Us");
        aboutUsFrame.setBounds(500, 200, 900, 700);
        aboutUsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutUsFrame.setVisible(true);
        
        topPanel = new JPanel();
        topPanel.add(Box.createVerticalStrut(120));
        topPanel.setBackground(Color.blue);
        aboutUsLabel = new JLabel("About Us - Insight to the TCM Hotel");
        aboutUsLabel.setForeground(Color.white);
        aboutUsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        returnButton = new JButton("Return to the Main Menu");
        returnButton.setForeground(Color.black);
        returnButton.setFont(new Font("Arial", Font.BOLD, 15));
        returnButton.setBounds(300, 400, 855, 400);
        
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        bottomPanel.add(Box.createVerticalStrut(100));
        bottomPanel.setBackground(Color.blue);
        
        pic1 = ImageIO.read(new File("test/1.jpg"));
        Image scaledImage1 = pic1.getScaledInstance(100, 100, 700);
        imageLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imageLabel1.setBounds(1000, 250, 200, 100);
        
        pic2 = ImageIO.read(new File("test/2.png"));
        Image scaledImage2 = pic2.getScaledInstance(100, 100, 700);
        imageLabel2 = new JLabel(new ImageIcon(scaledImage2));
        imageLabel2.setBounds(150, 25, 50, 50);
        
        pic3 = ImageIO.read(new File("test/3.jpg"));
        Image scaledImage3 = pic3.getScaledInstance(100, 100, 700);
        imageLabel3 = new JLabel(new ImageIcon(scaledImage3));
        imageLabel3.setBounds(200, 25, 50, 50); 
        
        AboutUsField = new JTextArea();
        AboutUsField.setFont(new Font("Aria", Font.BOLD, 15));
        AboutUsField.append("****************************************************************Our Vision*****************************************************************\n");
        AboutUsField.append("      We here as part of the management of TCM are a group of young developers looking to give more chances and\n");
        AboutUsField.append("      oppurtunities for people to experiance the culture of the most iconic places in New Zealand. We created our     \n");
        AboutUsField.append("      own hotel brand and set up locations all over NZ from Wellignton to Dunedin and back to Auckland - we aim  \n");
        AboutUsField.append("      to provide cheap places for travellers and tourists alike to immerse themselves into the culture \n");
        AboutUsField.append("      each region of New Zealand... And with Discounts, Special Features and low prices - ALL HERE AT TCM! \n");
        AboutUsField.append("**********************************************************************************************************************************************\n\n");
        AboutUsField.append("*************************************************************Contact Details***************************************************************\n");
        AboutUsField.append("                                    If you have any further issues in regards to our company, feel free to contact us: \n");
        AboutUsField.append("                                              ---------------------------------------------------------------------------------------------\n");
        AboutUsField.append("                                              Email: tdv2188@autuni.ac.nz (Faaris Khan)     - Founding Manager\n");
        AboutUsField.append("                                                       Ph: (07) 2529423             Mob: +64 0217284610\n");
        AboutUsField.append("                                              ---------------------------------------------------------------------------------------------\n");
        AboutUsField.append("                                              Email: xdx4418@autuni.ac.nz (Siddarath Kumar) - Co-Founding Manager\n");
        AboutUsField.append("                                                       Ph: (09) 3218302             Mob: +64 0275209512\n");
        AboutUsField.append("                                              ---------------------------------------------------------------------------------------------\n");
        AboutUsField.append("                                              Email: vwv9667@autuni.ac.nz (Anuk Silva)      - Co-Founding Manager\n");
        AboutUsField.append("                                                       Ph: (08) 2157029             Mob: +64 0237180321\n");
        AboutUsField.append("                                              ---------------------------------------------------------------------------------------------\n");
        AboutUsField.append("**********************************************************************************************************************************************");

        AboutUsField.setBounds(15, 15, 855, 400);
        AboutUsField.setEditable(false);
        
        scrollPane = new JScrollPane(AboutUsField, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setMinimumSize(new Dimension (855, 400));
        scrollPane.setPreferredSize(new Dimension (855, 300));     
        
        //CREATE LABEL WHICH WHEN CLICKED TAKES U TO A LINK
        
        topPanel.add(aboutUsLabel);
        middlePanel.add(imageLabel2);
        middlePanel.add(imageLabel1);
        middlePanel.add(imageLabel3);
        middlePanel.add(scrollPane);
        bottomPanel.add(returnButton);
        
        aboutUsFrame.add(topPanel, BorderLayout.NORTH);
        aboutUsFrame.add(middlePanel, BorderLayout.CENTER);
        aboutUsFrame.add(bottomPanel, BorderLayout.SOUTH);
        aboutUsFrame.setVisible(true);
    }
    
    public JButton getReturnButton() {
        return returnButton;
    }

    public void mouseEnterHoverReturnButton() 
    {
        getReturnButton().setBackground(Color.LIGHT_GRAY);
    }

    public void mouseExitHoverReturnButton() {
        getReturnButton().setBackground(UIManager.getColor("control"));
    }

    public void returnToMainMenu() 
    {
        aboutUsFrame.setVisible(false);
        aboutUsFrame.dispose();
    }
}