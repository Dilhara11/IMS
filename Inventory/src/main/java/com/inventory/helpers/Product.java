/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.helpers;

/**
 *
 * @author Achintha
 */
public class Product {
    private String productKey;
    private String productName; 
    private String productCategory;
    private int quantity;
    private float price;

    public Product(String productKey, String productName, String productCategory, int quantity, float price) {
        this.productKey = productKey;
        this.productName = productName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductKey() {
        return productKey;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
   
    
}
