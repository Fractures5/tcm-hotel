/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/**
 * This is a description of the AdminInterface interface.
 * This interface for the admin is used to group related methods with empty bodies
 * @author Anuk
 */

import java.io.FileNotFoundException;
import java.io.IOException;


public interface AdminInterface 
{
    public void getStaffDetails() throws FileNotFoundException, IOException;
    
}