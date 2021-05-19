/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import HotelGuiController.WelcomeAppGuiController;
import HotelGuiModel.WelcomeAppGuiModel;
import HotelGuiView.WelcomeAppGuiView;

/**
 *
 * @author faari
 */
public class guiMainClass 
{
    public static void main(String[] args) 
    {
        WelcomeAppGuiModel modelClass = new WelcomeAppGuiModel();
        WelcomeAppGuiView viewClass = new WelcomeAppGuiView();
        WelcomeAppGuiController controllerClass = new WelcomeAppGuiController(viewClass);    
        //Remember to add modelClass as a parameter in the controller Class above
    }
}
