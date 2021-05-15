/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import guestControllers.GuestController;
import guestModel.GuestModel;
import guestView.GuestView;

/**
 *
 * @author Anuk
 */
public class GuestMVC {
    
    public static void main(String[] args){
        GuestView view = new GuestView();
        GuestModel model = new GuestModel();
        GuestController controller = new GuestController(view, model);

        view.setVisible(true);
        
    }
    
    
    
}
