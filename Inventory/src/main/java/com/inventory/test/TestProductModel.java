/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.test;

/**
 *
 * @author Achintha
 */
import com.inventory.models.ProductModel;

public class TestProductModel {
    public static void main(String[] args) {
        String productKey = "#P001";
        String productName = "Carrot";
        String category = "Vegitable";
        int quantity = 10;
        float price = (float) 4.50;
        
//        boolean isAdded = ProductModel.addProduct(productKey, productName, category, quantity, price);
//        
//        System.out.println((isAdded? "Successfull!" : "Unsuccessfull"));

//        boolean isDeleted = ProductModel.deleteProduct(productKey);
//        
//        System.out.println((isDeleted? "Successfull!" : "Unsuccessfull!"));
        
//        boolean isFound = ProductModel.findProduct(productKey);
//        System.out.println((isFound? "Successfull" : "Unsuccessfull"));

        boolean isUpdated = ProductModel.editProduct(productKey, productName, category, quantity, price);
        
        System.out.println((isUpdated? "Successfull!" : "Unsuccessfull!"));
       
        
        
    }
}
