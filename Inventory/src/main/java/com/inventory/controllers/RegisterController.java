/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

import com.inventory.models.UserModel;
import com.inventory.views.Landing;
import com.inventory.views.Register;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author Achintha
 */
public class RegisterController {
    private final Register registerView;
    
    public RegisterController(Register registerView){
        this.registerView = registerView;
        closeOperation();
        initController();
    }
    
    private void initController(){
        registerView.getRegisterButton().addActionListener(this::onRegisterClicked);
    }
   
    private void closeOperation(){
        registerView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                Landing landingView = new Landing();
                new LandingController(landingView);
                landingView.setVisible(true);
            }
        });
    }
    
    private void onRegisterClicked(ActionEvent e){
        String userId = registerView.getUserIdField().getText();
        String name = registerView.getUserNameField().getText();
        String password = new String(registerView.getPasswordField().getPassword());
        String type = registerView.getRole().getSelectedItem().toString();
        
        System.out.println(userId + " " + name + " " + password + " " + type);
        boolean isAdded = UserModel.insertUser(userId, name, password, type);

        if(isAdded){
            JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            registerView.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Registration Unsuccessful!", "Success", JOptionPane.ERROR_MESSAGE);
            registerView.getUserIdField().setText("");
            registerView.getUserNameField().setText("");
            registerView.getPasswordField().setText("");
            registerView.getRePasswordField().setText("");
            registerView.getRole().setSelectedIndex(0);
        }
        
    }
}
