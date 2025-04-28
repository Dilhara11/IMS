/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.controllers;

import com.inventory.helpers.OneSale;
import com.inventory.models.SaleModel;
import com.inventory.views.Landing;
import com.inventory.views.Sales;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Achintha
 */
public class SalesController {
    private final Sales salesView;
    
    public SalesController(Sales salesView){
        this.salesView = salesView;
        closeOperation();
        initController();
        
    }
    
    public void initController(){
        salesView.getFindButton().addActionListener(this::onFindClicked);
    }
    
    private void closeOperation(){
        salesView.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                Landing landingView = new Landing();
                new LandingController(landingView);
                landingView.setVisible(true);
            }
        });
        
    }
    
    private void setProductSales(String key){
        ArrayList<OneSale> sales = SaleModel.getProductSales(key);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setMonthSales(String month){
        ArrayList<OneSale> sales = SaleModel.getMonthSales(month);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setYearSales(String year){
        ArrayList<OneSale> sales = SaleModel.getYearSales(year);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setYearMonthSales(String year, String month){
        ArrayList<OneSale> sales = SaleModel.getYearMonthSales(year, month);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setYearProductSales(String key, String year){
        ArrayList<OneSale> sales = SaleModel.getYearProductSales(key, year);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setMonthProductSales(String key, String month){
        ArrayList<OneSale> sales = SaleModel.getMonthProductSales(key, month);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void setYearMonthProductSales(String key, String year, String month){
        ArrayList<OneSale> sales = SaleModel.getYearMonthProductSales(key, year, month);
        DefaultTableModel model = (DefaultTableModel) salesView.getSalesTable().getModel();
        model.setRowCount(0);
        for(OneSale sale: sales){
            model.addRow(new Object[]{
                sale.getProductKey(),
                sale.getProductName(),
                sale.getQuantity(),
                sale.getDate()
            });
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
            
        }
    }
    
    private void onFindClicked(ActionEvent e){
    String key = salesView.getKeyField().getText().trim();
    String year = salesView.getYearField().getText().trim();
    String month = salesView.getMonthField().getText().trim();
    
    if (!key.isEmpty() && !year.isEmpty() && !month.isEmpty()) {
        setYearMonthProductSales(key, year, month);
    } else if (!key.isEmpty() && !year.isEmpty()) {
        setYearProductSales(key, year);
    } else if (!key.isEmpty() && !month.isEmpty()) {
        setMonthProductSales(key, month);
    } else if (!year.isEmpty() && !month.isEmpty()) {
        setYearMonthSales(year, month);
    } else if (!key.isEmpty()) {
        setProductSales(key);
    } else if (!year.isEmpty()) {
        setYearSales(year);
    } else if (!month.isEmpty()) {
        setMonthSales(month);
    } else {
        JOptionPane.showMessageDialog(null, "At least fill one field!", "Warning", JOptionPane.ERROR_MESSAGE);
    }
}

}
