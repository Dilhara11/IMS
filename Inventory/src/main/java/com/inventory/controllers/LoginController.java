/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

import com.inventory.views.Login;
import com.inventory.views.Landing;
import com.inventory.controllers.LandingController;
import com.inventory.helpers.Session;
import com.inventory.helpers.User;
import com.inventory.models.UserModel;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Achintha
 */
public class LoginController {
    private final Login loginView;

    public LoginController(Login loginView) {
        this.loginView = loginView;
        initController();
    }
    
    private void initController(){
        loginView.getLoginButton().addActionListener(this::onLoginClicked);

    }
    
    private void onLoginClicked(ActionEvent e){
        String id = loginView.getIDField().getText().trim();
        String password = new String(loginView.getPasswordField().getText());
        
        boolean isFound = UserModel.authUser(id, password);
        
        if(!isFound){
            loginView.getIDField().setText("");
            loginView.getPasswordField().setText("");
            JOptionPane.showMessageDialog(null, "User Not Found!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            loginView.dispose();
            User user = UserModel.getUser(id);
            System.out.println(user.getPrivilageMode());
            Session.newSession(user.getPrivilageMode());
            Landing landingView = new Landing();
            new LandingController(landingView);
            landingView.setVisible(true);
        }
    }
    
}
