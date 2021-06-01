package tcm.hotel;

import HotelGuiController.WelcomeAppGuiController;
import HotelGuiView.WelcomeAppGuiView;

/**
 * This is the driver class from where the program is ran from, 
 * which includes the main method
 * @author faaris
 */

public class GuiMainClass
{
    //Main method, which includes creates an object of the main menu view and controller class
    public static void main(String[] args) 
    {
        WelcomeAppGuiView viewClass = new WelcomeAppGuiView();
        WelcomeAppGuiController controllerClass = new WelcomeAppGuiController(viewClass);
    }
}
