/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiView.AboutUsGuiView;
import HotelGuiView.WelcomeAppGuiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author faari
 */
public class AboutUsGuiController 
{
    AboutUsGuiView aboutUsClass;
    
    WelcomeAppGuiView accessMainMenu;
    WelcomeAppGuiController mainMenuControl;
    
    public AboutUsGuiController(AboutUsGuiView aboutUsClass)
    {
        this.aboutUsClass = aboutUsClass;
        
        aboutUsClass.getReturnButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickReturnButton();
            }
        });

        aboutUsClass.getReturnButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                EnterMouseHoverReturnButton();
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                ExitMouseHoverReturnButton();
            }
        });
    }
    
    public void ClickReturnButton() {
        accessMainMenu = new WelcomeAppGuiView();
        mainMenuControl = new WelcomeAppGuiController(accessMainMenu);
        aboutUsClass.returnToMainMenu();
    }

    public void EnterMouseHoverReturnButton() {
        aboutUsClass.mouseEnterHoverReturnButton();
    }

    public void ExitMouseHoverReturnButton() {
        aboutUsClass.mouseExitHoverReturnButton();
    }
}
