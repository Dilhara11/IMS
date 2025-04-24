/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.models;

/**
 *
 * @author Achintha
 */
import com.inventory.config.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SaleModel {
    public static ResultSet rs;
    
    public static boolean addSale(String date, String productKey, String quantity){
        String sql = "insert into sales(date, productKey, quantity) values(?, ?, ?)";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, date);
            stmt.setString(2, productKey);
            stmt.setString(3, quantity);
            
            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static boolean getSales(String month){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where MONTH(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String date = rs.getString("date");
                int quantity = rs.getInt("quantity");
                String productKey = rs.getString("productKey");
                String productName = rs.getString("productName");
                
                System.out.println(productKey + " " + productName + " " + quantity + " " + date);
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
