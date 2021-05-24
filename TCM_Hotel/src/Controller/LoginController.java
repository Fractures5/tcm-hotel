/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginModel;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        
        viewLogin.getLogin().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                handleLoginClick();
            }
        });
        
        viewLogin.getClearPassword().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClearPasswordClick();
            }

        });
        
        viewLogin.getMainMenu().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleMainMenuClick();
            }

        });
        
        viewLogin.getShowPassword().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleShowPasswordClick();
            }

        });
    }
    
    public void handleLoginClick(){
        viewLogin.loginSystemBackend();
        
        if(viewLogin.getShowInvalidPasswordError() == true){
            viewLogin.displayInvalidPasswordError();
        }
        
        if(viewLogin.getShowInvalidPasswordError() == false && viewLogin.getMatchingSystemPassword()== true){
            viewLogin.displayLoginSuccessful();
        }
    }
    
    public void handleClearPasswordClick() {
        viewLogin.clearInputPassword();
    }
    
    public void handleMainMenuClick() {
        viewLogin.returnToMainMenu();
    }
    
    public void handleShowPasswordClick() {
        if(viewLogin.getShowPassword().isSelected()){
            viewLogin.toggleShowPassword();
        }
        else{
            viewLogin.toggleHidePassword();
        }
    }
    
}
