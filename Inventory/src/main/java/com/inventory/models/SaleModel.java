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
import com.inventory.helpers.OneSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
    
    
    public static ArrayList<OneSale> getMonthSales(String month){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where MONTH(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
                while(rs.next()){
                    OneSale sale  = new OneSale (
                    rs.getString("productKey"),
                    rs.getString("productname"),
                    rs.getInt("quantity"),
                    rs.getString("date"));
                    
                    sales.add(sale);
                }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getYearSales(String year){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where YEAR(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, year);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getYearMonthSales(String year, String month){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where YEAR(date) = ? AND MONTH(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, year);
            stmt.setString(2, month);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getProductSales(String productKey){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where sales.productKey = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productKey);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getMonthProductSales(String productKey, String month){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where sales.productKey = ? AND MONTH(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productKey);
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getYearProductSales(String productKey, String year){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where sales.productKey = ? AND YEAR(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productKey);
            stmt.setString(2, year);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<OneSale> getYearMonthProductSales(String productKey, String year, String month){
        String sql = "select sales.date, sales.quantity, products.productKey, products.ProductName " +
                "FROM sales " +
                "join products on sales.productKey = products.productKey " +
                "where sales.productKey = ? AND YEAR(date) = ? AND MONTH(date) = ?";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productKey);
            stmt.setString(2, year);
            stmt.setString(3, month);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OneSale> sales = new ArrayList<>();
            while(rs.next()){
                OneSale sale = new OneSale (
                rs.getString("productKey"),
                rs.getString("productname"),
                rs.getInt("quantity"),
                rs.getString("date"));
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
