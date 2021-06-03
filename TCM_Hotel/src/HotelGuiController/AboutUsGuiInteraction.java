package HotelGuiController;

import HotelGuiView.AboutUsGuiMenu;
import HotelGuiView.WelcomeAppGuiMenu;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the class with controls the button presses, button hovers, and other
 * interactions of the about us section.
 * @author Faaris
 */
public class AboutUsGuiInteraction 
{
    AboutUsGuiMenu aboutUsClass;
    
    WelcomeAppGuiMenu accessMainMenu;
    WelcomeAppGuiInteraction mainMenuControl;
    
    /**
     * This is the default constructor of the about us controller, which
     * initializes the model class for the about us, and uses it in action 
     * listener and mouse listener methods to enact the clicking and hovering 
     * methods of the buttons used in the about us view class.
     * @param aboutUsClass 
     */
    public AboutUsGuiInteraction(AboutUsGuiMenu aboutUsClass)
    {
        this.aboutUsClass = aboutUsClass;
        
        aboutUsClass.getReturnButton().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                ClickReturnButton();
            }
        });

        aboutUsClass.getReturnButton().addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent evt) 
            {
                EnterMouseHoverReturnButton();
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                ExitMouseHoverReturnButton();
            }
        });
        
        aboutUsClass.getLabel1().addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("mailto:tdv2188@autuni.ac.nz"));
                } 
                catch (URISyntaxException ex) 
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        aboutUsClass.getLabel2().addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("mailto:xdx4418@autuni.ac.nz"));
                } 
                catch (URISyntaxException ex)
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        aboutUsClass.getLabel3().addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
            {
                try
                {
                    Desktop.getDesktop().browse(new URI("mailto:vwv9667@autuni.ac.nz"));
                } 
                catch (URISyntaxException ex)
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex)
                {
                    Logger.getLogger(AboutUsGuiInteraction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /**
     * Creates an object of the main menu view and controller class,
     * and calls the method in the about us view class to dispose of this frame
     * and open up the main menu frame.
     */
    public void ClickReturnButton() 
    {
        accessMainMenu = new WelcomeAppGuiMenu();
        mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        aboutUsClass.returnToMainMenu();
    }

    /**
     * Calls the method from the about us class which executes entermousehover
     * method
     */
    public void EnterMouseHoverReturnButton() 
    {
        aboutUsClass.mouseEnterHoverReturnButton();
    }

    /**
     * Calls the method from the about us class which executes exitmousehover 
     * method
     */
    public void ExitMouseHoverReturnButton() 
    {
        aboutUsClass.mouseExitHoverReturnButton();
    }
}