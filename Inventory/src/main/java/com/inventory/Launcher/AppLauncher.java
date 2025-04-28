/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.Launcher;

import com.inventory.views.Login;
import com.inventory.controllers.LoginController;
/**
 *
 * @author Achintha
 */
public class AppLauncher {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Login loginView = new Login();
            new LoginController(loginView);
            loginView.setVisible(true);
        });
    }
}
