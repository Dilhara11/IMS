/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.helpers;

/**
 *
 * @author Achintha
 */
public class OneSale {
    private String productKey;
    private String productName;
    private int quantity;
    private String date;

    public OneSale(String productKey, String productName, int quantity, String date) {
        this.productKey = productKey;
        this.productName = productName;
        this.quantity = quantity;
        this.date = date;
    }

    public String getProductKey() {
        return productKey;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }
    
    
}
