/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestControllers;

import guestModel.GuestModel;
import guestView.GuestView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 *
 * @author Anuk
 */
public class GuestController implements ActionListener{
    
    GuestView viewGuest;
    GuestModel modelGuest;
    
    public GuestController(GuestView viewGuest, GuestModel modelGuest){
        this.viewGuest = viewGuest;
        this.modelGuest = modelGuest;
        
        this.viewGuest.addGuestModel(new GuestView());

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
