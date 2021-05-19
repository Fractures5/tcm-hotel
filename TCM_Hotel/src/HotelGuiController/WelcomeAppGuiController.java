/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiView.WelcomeAppGuiView;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author faari
 */
public class WelcomeAppGuiController 
{
    //Calls the methods, stuff like action listeners, etc...
    
    WelcomeAppGuiView viewClass;
    
    public WelcomeAppGuiController(WelcomeAppGuiView viewClass)
    {
        this.viewClass = viewClass;
        
        viewClass.getButtonOne().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnterMouseHoverButtonOne();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseHoverButtonOne();
            }
        });
        
        viewClass.getButtonTwo().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnterMouseHoverButtonTwo();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseHoverButtonTwo();
            }
        });
        
        viewClass.getButtonThree().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnterMouseHoverButtonThree();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseHoverButtonThree();
            }
        });
        
        viewClass.getButtonFour().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnterMouseHoverButtonFour();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseHoverButtonFour();
            }
        });
    }
    
    public void EnterMouseHoverButtonOne() {
        viewClass.mouseEnterHoverButtonOne();
    }

    public void ExitMouseHoverButtonOne() {
        viewClass.mouseExitHoverButtonOne();
    }
    
    public void EnterMouseHoverButtonTwo() {
        viewClass.mouseEnterHoverButtonTwo();
    }

    public void ExitMouseHoverButtonTwo() {
        viewClass.mouseExitHoverButtonTwo();
    }
    
    public void EnterMouseHoverButtonThree() {
        viewClass.mouseEnterHoverButtonThree();
    }

    public void ExitMouseHoverButtonThree() {
        viewClass.mouseExitHoverButtonThree();
    }
    
    public void EnterMouseHoverButtonFour() {
        viewClass.mouseEnterHoverButtonFour();
    }

    public void ExitMouseHoverButtonFour() {
        viewClass.mouseExitHoverButtonFour();
    }
}
