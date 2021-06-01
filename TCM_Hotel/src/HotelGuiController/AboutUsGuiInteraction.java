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
 *
 * @author faari
 */
public class AboutUsGuiInteraction 
{
    AboutUsGuiMenu aboutUsClass;
    
    WelcomeAppGuiMenu accessMainMenu;
    WelcomeAppGuiInteraction mainMenuControl;
    
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
    
    public void ClickReturnButton() 
    {
        accessMainMenu = new WelcomeAppGuiMenu();
        mainMenuControl = new WelcomeAppGuiInteraction(accessMainMenu);
        aboutUsClass.returnToMainMenu();
    }

    public void EnterMouseHoverReturnButton() 
    {
        aboutUsClass.mouseEnterHoverReturnButton();
    }

    public void ExitMouseHoverReturnButton() 
    {
        aboutUsClass.mouseExitHoverReturnButton();
    }
}