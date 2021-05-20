/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiView;

import javax.swing.JFrame;

/**
 *
 * @author faari
 */
public class FAQGuiView extends JFrame
{
    private JFrame FAQFrame;
    
    public FAQGuiView()
    {
        FAQFrame = new JFrame("FAQ");
        FAQFrame.setBounds(500, 200, 900, 700);
        FAQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FAQFrame.setVisible(true);
    }
}
