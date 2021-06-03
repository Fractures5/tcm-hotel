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
 * This is the class with controls the button presses, button hovers, and other
 * interactions of the about us section.
 * @author Faaris
 */
public class FAQGuiInteraction 
{
    FAQGuiMenu faqClass;
    WelcomeAppGuiMenu accessMainMenu;
    WelcomeAppGuiInteraction mainMenuControl;
    
    /**
     * This is the default constructor of the FAQ controller, which
     * initializes the model class for the FAQ, and uses it in action
     * listener and mouse listener methods to enact the clicking and hovering
     * methods of the buttons used in the FAQ view class.
     * @param faqClass Object of the FAQ view class
     */
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
    
    /**
     * Creates an object of the main menu view and controller class, and calls
     * the method in the about us view class to dispose of this frame and open
     * up the main menu frame.
     */
    public void ClickBackButton()
    {
        accessMainMenu = new WelcomeAppGuiMenu();
        mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        faqClass.returnToMain();
    }
    
    /**
     * Calls the method from the about us class which executes entermousehover
     * method
     */
    public void EnterMouseHoverBackButton() {
        faqClass.mouseEnterHoverBackButton();
    }

    /**
     * Calls the method from the about us class which executes exitmousehover
     * method
     */
    public void ExitMouseHoverBackButton() 
    {
        faqClass.mouseExitHoverBackButton();
    }
}
