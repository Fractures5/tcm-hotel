package HotelGuiController;

import HotelGuiModel.AdminFormDetails;
import HotelGuiModel.BookedHotelDates;
import HotelGuiView.AboutUsGuiMenu;
import HotelGuiView.AdminFormMenu;
import HotelGuiView.AdminSysMenu;
import HotelGuiView.FAQGuiMenu;
import HotelGuiView.HotelDatesMenu;
import HotelGuiView.LoginMenu;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the class with controls the button presses, button hovers, and other
 * interactions of the about us section.
 * @author Faaris
 */
public class WelcomeAppGuiInteraction 
{
    WelcomeAppGuiMenu viewClass;
    
    FAQGuiMenu accessFAQ;
    FAQGuiInteraction faqControl;
    
    AboutUsGuiMenu accessAboutUs;
    AboutUsGuiInteraction aboutUsControl;
    
    /**
     * This is the default constructor of the main menu controller, which
     * initializes the model class for the main menu, and uses it in action listener
     * and mouse listener methods to enact the clicking and hovering methods of
     * the buttons used in the main menu view class.
     * @param viewClass Object of the main menu view class
     */
    public WelcomeAppGuiInteraction(WelcomeAppGuiMenu viewClass)
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
                try 
                {
                    ClickButtonThree();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(WelcomeAppGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        viewClass.getButtonFour().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    ClickButtonFour();
                } 
                catch (SQLException ex)
                {
                    Logger.getLogger(WelcomeAppGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    
    /**
     * Calls the method from the about us class which executes entermousehover
     * method
     */
    public void EnterMouseHoverButtonOne() 
    {
        viewClass.mouseEnterHoverButtonOne();
    }

    /**
     * Calls the method from the about us class which executes exitmousehover
     * method
     */
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
        BookedHotelDates datesModel = new BookedHotelDates();
        HotelDatesMenu datesView = new HotelDatesMenu();
        BookDatesInteraction selectDates = new BookDatesInteraction(datesModel, datesView);
        viewClass.enterBookingView();
    }
    
    /**
     * Creates an object of the FAQ view and controller class, and
     * calls the method in the about us view class to dispose of this frame and
     * open up the FAQ frame.
     */
    public void ClickButtonTwo()
    {
        accessFAQ = new FAQGuiMenu();
        faqControl = new FAQGuiInteraction(accessFAQ);
        viewClass.enterFAQView();
    }
    
    public void ClickButtonThree() throws IOException 
    {
        accessAboutUs = new AboutUsGuiMenu();
        aboutUsControl = new AboutUsGuiInteraction(accessAboutUs);
        viewClass.enterAboutUsView();
    }
    
    public void ClickButtonFour() throws SQLException 
    { 
        AdminFormDetails modelAdmin = new AdminFormDetails();
        AdminFormMenu viewAdmin = new AdminFormMenu();
        AdminFormInteraction controllerAdmin = new AdminFormInteraction(modelAdmin, viewAdmin);
        
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
