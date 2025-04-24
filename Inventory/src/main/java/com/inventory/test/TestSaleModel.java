/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.test;

/**
 *
 * @author Achintha
 */
import com.inventory.models.SaleModel;
import static com.inventory.models.SaleModel.rs;

public class TestSaleModel {
    public static void main(String[] args) {
        
        String date = "2001-05-30";
        String productKey = "#P001";
        String quantity  = "5";
        
//        boolean isAdded = SaleModel.addSale(date, productKey, quantity);
//        
//        System.out.println((isAdded? "Successfull" : "Unsuccessfull"));
        
        boolean isFound = SaleModel.getSales("05");
        
        System.out.println((isFound? "Success" : "Failure"));
     
        
        
        
    }
}
