/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

import com.inventory.helpers.Product;
import com.inventory.helpers.Session;
import com.inventory.models.ProductModel;
import com.inventory.views.Landing;
import com.inventory.views.Products;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Achintha
 */
public class ProductController {
 private final Products productsView;
 private String originalProductKey;

    public ProductController(Products productView) {
        this.productsView = productView;
        closeOperation();
        rowOpertaion();
        initController();
    }
    
    public void initController(){
        productsView.getAddButton().addActionListener(this::onAddClicked);
        productsView.getFindButton().addActionListener(this::onFindClicked);
        productsView.getDeleteButton().addActionListener(this::onDeleteClicked);
        productsView.getUpdateButton().addActionListener(this::onUpdateClicked);
    }
    
    private void closeOperation(){
        productsView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                Landing landingView = new Landing();
                new LandingController(landingView);
                landingView.setVisible(true);
            }
        });
    }
    
    private void getProduct(Product product){
        DefaultTableModel model = (DefaultTableModel) productsView.getProductTable().getModel();
        model.setRowCount(0);
            
        model.addRow(new Object[]{
            product.getProductKey(),
            product.getProductName(),
            product.getProductCategory(),
            product.getQuantity(),
            product.getPrice()
            });
    }
    
    private void rowOpertaion(){
        productsView.getProductTable().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = productsView.getProductTable().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) productsView.getProductTable().getModel();
                
                String key = model.getValueAt(selectedRow, 0).toString();
                String name = model.getValueAt(selectedRow, 1).toString();
                String category = model.getValueAt(selectedRow, 2).toString();
                String quantity = model.getValueAt(selectedRow, 3).toString();
                String price = model.getValueAt(selectedRow, 4).toString();
                
                originalProductKey = key.trim();
                
                productsView.getProductKeyField().setText(key);
                productsView.getProductNameField().setText(name);
                productsView.getCategoryField().setText(category);
                productsView.getQuantityField().setText(quantity);
                productsView.getPriceField().setText(price);
            }
        });
    }
    
    
    
    public void onAddClicked(ActionEvent e){
        if(!"Admin".equals(Session.getPrivilageMode())){
            JOptionPane.showConfirmDialog(null, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String key = productsView.getProductKeyField().getText();
        String name = productsView.getProductNameField().getText();
        String category = productsView.getCategoryField().getText();
        String quantityText = productsView.getQuantityField().getText();
        String priceText = productsView.getPriceField().getText();
        
        int quantity = quantityText.isEmpty() ? 0 : Integer.parseInt(quantityText);
        float price = quantityText.isEmpty() ?  0.0f : Float.parseFloat(priceText);
        
        Product product = ProductModel.findProduct(key);
        if(product != null) {
            JOptionPane.showMessageDialog(null, "Product Already Exist!", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!"".equals(key) && !"".equals(name) && !"".equals(category)) {
            boolean isAdded = ProductModel.addProduct(key, name, category, quantity, price);
            
            if(isAdded){
            JOptionPane.showMessageDialog(null, "Product Add Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
            productsView.getProductKeyField().setText("");
            productsView.getProductNameField().setText("");
            productsView.getCategoryField().setText("");
            productsView.getQuantityField().setText("");
            productsView.getPriceField().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Product Add Unsuccessful!", "Success", JOptionPane.ERROR_MESSAGE);
            productsView.getProductKeyField().setText("");
            productsView.getProductNameField().setText("");
            productsView.getCategoryField().setText("");
            productsView.getQuantityField().setText("");
            productsView.getPriceField().setText("");
        }
        }else {
            JOptionPane.showMessageDialog(null, "Every Field Must Filled", "Falier", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void onUpdateClicked(ActionEvent e){
        if(!"Admin".equals(Session.getPrivilageMode())){
            JOptionPane.showConfirmDialog(null, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int selectedRow = productsView.getProductTable().getSelectedRow();
        
        if(selectedRow != -1){
            String key = productsView.getProductKeyField().getText().trim();
            String name = productsView.getProductNameField().getText();
            String category = productsView.getCategoryField().getText();
            String quantityText = productsView.getQuantityField().getText();
            String priceText = productsView.getPriceField().getText();
        
            int quantity = Integer.parseInt(quantityText); 
            float price = Float.parseFloat(priceText);
        
            if(!originalProductKey.equals(key)){
                JOptionPane.showMessageDialog(null, "You Cannot Change Product Key During Update!", "Warning", JOptionPane.WARNING_MESSAGE);
                productsView.getProductKeyField().setText(originalProductKey);
                productsView.getProductNameField().setText(name);
                productsView.getCategoryField().setText(category);
                productsView.getQuantityField().setText(quantityText);
                productsView.getPriceField().setText(priceText);
                return;
            }
            
            ProductModel.editProduct(key, name, category, quantity, price);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Please Select Row to Update", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void onFindClicked(ActionEvent e){
        String key = productsView.getProductKeyField().getText();
        Product product = ProductModel.findProduct(key);
        
        if(product != null){
            getProduct(product);
        }else{
            JOptionPane.showMessageDialog(null, "Not Found", "falier", JOptionPane.ERROR_MESSAGE);
            
        }

    }
    
    public void onDeleteClicked(ActionEvent e){
        if(!"Admin".equals(Session.getPrivilageMode())){
            JOptionPane.showConfirmDialog(null, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String Key = productsView.getProductKeyField().getText();
        
        boolean isDeleted = ProductModel.deleteProduct(Key);
        
        if(isDeleted){
            JOptionPane.showMessageDialog(null, "Successfully Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Delete Item!", "Falier", JOptionPane.ERROR_MESSAGE);            
        }
    }
 
 
}
