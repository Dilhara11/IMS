/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

import com.inventory.helpers.Product;
import com.inventory.models.ProductModel;
import com.inventory.views.Alerts;
import com.inventory.views.Landing;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Achintha
 */
public class AlertsController {
    private final Alerts alertsView;
    private final String lowStock = "10";
    
    public AlertsController(Alerts alertsView){
        this.alertsView = alertsView;
        closeOperation();
        showLowStocks(lowStock);
    }
    
    public void initController(){
    
    }
    
    private void closeOperation(){
        alertsView.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosed(WindowEvent e){
            Landing landingView = new Landing();
            new LandingController(landingView);
            landingView.setVisible(true);
        }
        
        });
        
    }
    
    public void showLowStocks(String stock){
        DefaultTableModel model = (DefaultTableModel) alertsView.getAlerTable().getModel();
        ArrayList<Product> products = ProductModel.findLowStocks(stock);
        model.setRowCount(0);
        
        if(products != null && !products.isEmpty()){
            for(Product product: products){
                model.addRow(new Object[]{
                    product.getProductKey(),
                    product.getProductName(),
                    product.getQuantity()
                });
            }
        }else {
            JOptionPane.showMessageDialog(null, "No Low Stocks!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
