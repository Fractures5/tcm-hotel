package tcm.hotel;

import HotelGuiController.WelcomeAppGuiInteraction;
import HotelGuiView.WelcomeAppGuiMenu;

/**
 * This is the driver class from where the program is ran from, 
 * which includes the main method and objects of the welcome class.
 * @author faaris
 */

public class TCMHotelApp
{
    public static void main(String[] args) 
    {
        WelcomeAppGuiMenu viewClass = new WelcomeAppGuiMenu();
        WelcomeAppGuiInteraction controllerClass = new WelcomeAppGuiInteraction(viewClass);
    }
}
