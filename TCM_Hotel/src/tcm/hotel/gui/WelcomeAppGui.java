/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel.gui;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author faari
 */
public class WelcomeAppGui extends JFrame
{
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;
    
    
    public static void main(String[] args) 
    {
        JFrame frame = new WelcomeAppGui();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocation(700, 300);
        frame.setVisible(true);
    }
}
