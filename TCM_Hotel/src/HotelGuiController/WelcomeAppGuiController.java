/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiController;

import HotelGuiView.AboutUsGuiView;
import HotelGuiView.FAQGuiView;
import HotelGuiView.WelcomeAppGuiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faaris
 */

public class WelcomeAppGuiController 
{
    WelcomeAppGuiView viewClass;
    
    FAQGuiView accessFAQ;
    FAQGuiController faqControl;
    
    AboutUsGuiView accessAboutUs;
    AboutUsGuiController aboutUsControl;

    //Will have a back button on both the FAQ and 
    //About Us page, so will need to make an object of both those
    //View classes and do the same thing of "hovering" and "clicking" 
    //For that back button
    
    public WelcomeAppGuiController(WelcomeAppGuiView viewClass)
    {
        this.viewClass = viewClass;
        
        viewClass.getPrevButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource() == viewClass.getPrevButton()) 
                {
                    ClickPrevButton();
                }
            }
        });
        
        viewClass.getNextButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource() == viewClass.getNextButton()) 
                {
                    ClickNextButton();
                }
            }
        });
        
        viewClass.getButtonOne().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ClickButtonOne();
            }
        });
        
        viewClass.getButtonTwo().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                ClickButtonTwo();
            }
        });
        
        viewClass.getButtonThree().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    ClickButtonThree();
                } catch (IOException ex) {
                    Logger.getLogger(WelcomeAppGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        viewClass.getButtonFour().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                ClickButtonFour();
            }
        });        
        
        viewClass.getButtonOne().addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                EnterMouseHoverButtonOne();
            }

            @Override
            public void mouseExited(MouseEvent evt) 
            {
                ExitMouseHoverButtonOne();
            }
        });
        
        viewClass.getButtonTwo().addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent evt) 
            {
                EnterMouseHoverButtonTwo();
            }

            @Override
            public void mouseExited(MouseEvent evt) 
            {
                ExitMouseHoverButtonTwo();
            }
        });
        
        viewClass.getButtonThree().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent evt) 
            {
                EnterMouseHoverButtonThree();
            }

            @Override
            public void mouseExited(MouseEvent evt) 
            {
                ExitMouseHoverButtonThree();
            }
        });
        
        viewClass.getButtonFour().addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent evt) 
            {
                EnterMouseHoverButtonFour();
            }

            @Override
            public void mouseExited(MouseEvent evt) 
            {
                ExitMouseHoverButtonFour();
            }
        });
        
        
    }
    
    public void EnterMouseHoverButtonOne() 
    {
        viewClass.mouseEnterHoverButtonOne();
    }

    public void ExitMouseHoverButtonOne() 
    {
        viewClass.mouseExitHoverButtonOne();
    }
    
    public void EnterMouseHoverButtonTwo() 
    {
        viewClass.mouseEnterHoverButtonTwo();
    }

    public void ExitMouseHoverButtonTwo() 
    {
        viewClass.mouseExitHoverButtonTwo();
    }
    
    public void EnterMouseHoverButtonThree() 
    {
        viewClass.mouseEnterHoverButtonThree();
    }

    public void ExitMouseHoverButtonThree() 
    {
        viewClass.mouseExitHoverButtonThree();
    }
    
    public void EnterMouseHoverButtonFour()
    {
        viewClass.mouseEnterHoverButtonFour();
    }

    public void ExitMouseHoverButtonFour() 
    {
        viewClass.mouseExitHoverButtonFour();
    }
    
    public void ClickButtonOne()
    {
        viewClass.enterBookingView();
    }
    
    public void ClickButtonTwo()
    {
        accessFAQ = new FAQGuiView();
        faqControl = new FAQGuiController(accessFAQ);
        viewClass.enterFAQView();
    }
    
    public void ClickButtonThree() throws IOException 
    {
        accessAboutUs = new AboutUsGuiView();
        aboutUsControl = new AboutUsGuiController(accessAboutUs);
        viewClass.enterAboutUsView();
    }
    
    public void ClickButtonFour() 
    {
        viewClass.enterAdminView();
    }
    
    public void ClickPrevButton()
    {
        viewClass.PrevButtonAction();
    }
    
    public void ClickNextButton()
    {
        viewClass.NextButtonAction();
    }
}
