/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.test;

/**
 *
 * @author Achintha
 */
import com.inventory.helpers.OneSale;
import com.inventory.models.SaleModel;
import static com.inventory.models.SaleModel.rs;
import java.util.ArrayList;

public class TestSaleModel {
    public static void main(String[] args) {
        
        String date = "2001-05-30";
        String productKey = "#P001";
        String quantity  = "5";
        
//        ArrayList<OneSale> sales = SaleModel.getMonthSales("04");
//        ArrayList<OneSale> sales = SaleModel.getYearSales("2025");
//        ArrayList<OneSale> sales = SaleModel.getProductSales("#P001");
//        ArrayList<OneSale> sales = SaleModel.getYearMonthSales("2025", "04");
        ArrayList<OneSale> sales = SaleModel.getYearMonthProductSales("#P001", "2001", "05");
        
        
        for(OneSale sale: sales){
            System.out.println(sale.getProductKey() + " " + sale.getProductName() + " " + sale.getQuantity() + " " + sale.getDate());
        }
    }
}
