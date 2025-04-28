/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;
import com.inventory.helpers.Product;
import com.inventory.models.ProductModel;
import com.inventory.models.SaleModel;
import com.inventory.utils.Date;
import com.inventory.views.Landing;
import com.inventory.views.Sell;
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
public class SellController {
    private final Sell sellView;
    private String originalProductKey = null;

    public SellController(Sell sellView) {
        this.sellView = sellView;
        closeOperation();
        initController();
    }
    
    private void initController(){
        rowOperation();
        sellView.getAddButton().addActionListener(this::onAddClicked);
        sellView.getProceedButton().addActionListener(this::onProceedClicked);
        sellView.getUpdateButton().addActionListener(this::onUpdateClicked);
        sellView.getClearButton().addActionListener(this::onClearClicked);
        sellView.getDeleteButton().addActionListener(this::onDeleteClicked);
    }
    
    private void closeOperation(){
        sellView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                Landing landingView = new Landing();
                new LandingController(landingView);
                landingView.setVisible(true);
            }
        });
    }
    
    private void rowOperation(){
        sellView.getSellTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int selectedRow = sellView.getSellTable().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) sellView.getSellTable().getModel();
                
                String key = model.getValueAt(selectedRow, 0).toString();
                String quantity = model.getValueAt(selectedRow, 2).toString();
                originalProductKey = key;
                
                sellView.getKeyField().setText(key);
                sellView.getQuantity().setText(quantity);
            }
        });        
    }
    
    private void getsellingProduct(Product product, int quantity){
        DefaultTableModel model = (DefaultTableModel) sellView.getSellTable().getModel();
        model.addRow(new Object[]{
            product.getProductKey(),
            product.getProductName(),
            quantity,
            product.getPrice() * quantity
        });
    }
    
    
    private void getCartData(){
        DefaultTableModel model = (DefaultTableModel) sellView.getSellTable().getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        
        if(rowCount == 0) {
            JOptionPane.showMessageDialog(null, "Nothing in the Cart!", "warning", JOptionPane.WARNING_MESSAGE);
        }
        
        for(int i = 0; i < rowCount; i++){
            String date = Date.getDate().toString();
            String key = model.getValueAt(i, 0).toString();
            String quantity = model.getValueAt(i, 2).toString();
            
            boolean isAdded = SaleModel.addSale(date, key, quantity);
            Product product = ProductModel.findProduct(key);
            if(isAdded){
                ProductModel.editProduct(key, product.getProductName(), product.getProductCategory(), product.getQuantity() - Integer.parseInt(quantity), product.getPrice());
            }else{
                JOptionPane.showMessageDialog(null, "Can't Find Item!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        model.setRowCount(0);
        
    }
    
    private float calculateGrandTotal(){
        float grandTotal = 0.0f;
        
        for(int i = 0; i < sellView.getSellTable().getRowCount(); i++){
            Object value  = sellView.getSellTable().getValueAt(i, 3);
            if(value != null){
                grandTotal += Float.parseFloat(value.toString());
            }
        }
        return grandTotal;
    }
    
    private void onAddClicked(ActionEvent e){
        String key = sellView.getKeyField().getText();
        String quantityText = sellView.getQuantity().getText();
        int quantity = Integer.parseInt(quantityText);
        
        Product product = ProductModel.findProduct(key);
        
        if(product != null){
            getsellingProduct(product, quantity);
            float total = calculateGrandTotal();
            sellView.getTotalLabel().setText(String.valueOf(total));
        }else{
            JOptionPane.showMessageDialog(null, "No such Product!", "not found", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void onProceedClicked(ActionEvent e){
        getCartData();
        float total = calculateGrandTotal();
        sellView.getTotalLabel().setText(String.valueOf(total));        
    }
    
    private void onUpdateClicked(ActionEvent e){
        int selectedRow = sellView.getSellTable().getSelectedRow();
        
        if(selectedRow != -1){
            String key = sellView.getKeyField().getText();
            if(!key.equals(originalProductKey)){
                JOptionPane.showMessageDialog(null, "You Cannot Change Product Key During Update!", "Warning", JOptionPane.WARNING_MESSAGE);
                sellView.getKeyField().setText(originalProductKey);
                return;
            }
            Product product = ProductModel.findProduct(key);
            String quantity = sellView.getQuantity().getText();
            float price = product.getPrice() * Integer.parseInt(quantity);
            
            sellView.getSellTable().setValueAt(quantity, selectedRow, 2);
            sellView.getSellTable().setValueAt(price, selectedRow, 3);
            
            float total = calculateGrandTotal();
            sellView.getTotalLabel().setText(String.valueOf(total));
        }else {
            JOptionPane.showMessageDialog(null, "Please Select Row to Update", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void onClearClicked(ActionEvent e){
        int choice = JOptionPane.showConfirmDialog(null, "Want to clear all Item", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            DefaultTableModel model = (DefaultTableModel) sellView.getSellTable().getModel();
            model.setRowCount(0);
            float total = calculateGrandTotal();
            sellView.getTotalLabel().setText(String.valueOf(total));
            sellView.getKeyField().setText("");
            sellView.getQuantity().setText("");
        }
        
    }
    
    private void onDeleteClicked(ActionEvent e){
        int selectedRow = sellView.getSellTable().getSelectedRow();
        
        if(selectedRow != -1){
            DefaultTableModel model = (DefaultTableModel) sellView.getSellTable().getModel();
            
            int choice = JOptionPane.showConfirmDialog(null, "Want to delete This Item", "Confirmation", JOptionPane.YES_NO_OPTION);
            
            if(choice == JOptionPane.YES_OPTION){
                model.removeRow(selectedRow);
                float total = calculateGrandTotal();
                sellView.getTotalLabel().setText(String.valueOf(total));
            }
        }
    }
    
}
