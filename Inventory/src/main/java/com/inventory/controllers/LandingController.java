/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

/**
 *
 * @author Achintha
 */
import com.inventory.helpers.Session;
import com.inventory.views.Alerts;
import com.inventory.views.Landing;
import com.inventory.views.Login;
import com.inventory.views.Products;
import com.inventory.views.Register;
import com.inventory.views.Sales;
import com.inventory.views.Sell;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LandingController {
    
    private final Landing landingView;
    
    public LandingController(Landing landingView){
        this.landingView = landingView;
        initController();
    }
    
    private void initController(){
        landingView.getRegisterButton().addActionListener(this::onRegisterClicked);
        landingView.getLogoutButton().addActionListener(this::onLogoutClicked);
        landingView.getSellButton().addActionListener(this::onSellClicked);
        landingView.getProductButton().addActionListener(this::onProductClicked);
        landingView.getSalesButton().addActionListener(this::onSalesClicked);
        landingView.getAlertsButton().addActionListener(this::onAlertsClicked);
        
    }
    
    private void onRegisterClicked(ActionEvent e){
        if(!"Admin".equals(Session.getPrivilageMode())){
            JOptionPane.showConfirmDialog(null, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        landingView.dispose();
        Register registerView = new Register();
        new RegisterController(registerView);
        registerView.setVisible(true);
    }
    
    private void onLogoutClicked(ActionEvent e){
        landingView.dispose();
        Login loginView = new Login();
        new LoginController(loginView);
        loginView.setVisible(true);
    }
    
    private void onSellClicked(ActionEvent e){
        landingView.dispose();
        Sell sellView = new Sell();
        new SellController(sellView);
        sellView.setVisible(true);
    }
    
    private void onProductClicked(ActionEvent e){
        landingView.dispose();
        Products productsView = new Products();
        new ProductController(productsView);
        productsView.setVisible(true);
    }
    
    private void onSalesClicked(ActionEvent e){
        if(!"Admin".equals(Session.getPrivilageMode())){
            JOptionPane.showConfirmDialog(null, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        landingView.dispose();
        Sales salesView = new Sales();
        new SalesController(salesView);
        salesView.setVisible(true);
    }
    
    private void onAlertsClicked(ActionEvent e){
        landingView.dispose();
        Alerts alertsView = new Alerts();
        new AlertsController(alertsView);
        alertsView.setVisible(true);
    }
    
}
