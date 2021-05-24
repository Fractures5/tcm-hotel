/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginModel;
import View.LoginView;

/**
 *
 * @author Anuk
 */
public class LoginController {
    
    LoginModel modelLogin;
    LoginView viewLogin;
    
    public LoginController(LoginModel modelLogin, LoginView viewLogin){
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
    }
    
}
