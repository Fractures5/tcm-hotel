/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiView.FAQGuiMenu;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
/**
 *
 * @author faari
 */
public class FAQGuiInteraction 
{
    FAQGuiMenu faqClass;
    WelcomeAppGuiMenu accessMainMenu;
    WelcomeAppGuiInteraction mainMenuControl;
    
    public FAQGuiInteraction(FAQGuiMenu faqClass)
    {
        this.faqClass = faqClass;
        
        faqClass.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                ClickBackButton();
            }
        });
        
        faqClass.getBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                EnterMouseHoverBackButton();
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                ExitMouseHoverBackButton();
            }
        });
    }
    
    public void ClickBackButton()
    {
        accessMainMenu = new WelcomeAppGuiMenu();
        mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        faqClass.returnToMain();
    }
    
    public void EnterMouseHoverBackButton() {
        faqClass.mouseEnterHoverBackButton();
    }

    public void ExitMouseHoverBackButton() 
    {
        faqClass.mouseExitHoverBackButton();
    }
}