/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.io.IOException;
import java.text.ParseException;

/*
* This is the interface class which the WelcomApp class implements, which basically
* intializes and contains the methods the WelcomeApp class inherits.
*/

/**
 *
 * @author faaris
 */
public interface WelcomeAppInterface 
{
    public void userSelection(String userInput) throws ParseException, IOException;
    public void confirmBooking() throws IOException;
}
