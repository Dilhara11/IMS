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

public class ProductModel {
    
    public static boolean addProduct(String key, String name,String category, int quantity, float price){
        String sql = "insert into products(productkey, productName, category, quatity, price) values(?, ?, ?, ?, ?)";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, key);
            stmt.setString(2, name);
            stmt.setString(3, category);
            stmt.setInt(4, quantity);
            stmt.setFloat(5, price);
            
            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean editProduct(String key, String name, String category, int quantity, float price){
        String sql = "update products set productName = ?, category = ?, quatity = ?, price = ? where productKey = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setInt(3, quantity);
            stmt.setFloat(4, price);
            stmt.setString(5, key);
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteProduct(String key){
        String sql = "Delete from products where productKey = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, key);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean findProduct(String key){
        String sql = "Select * from products where productKey = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    
}
