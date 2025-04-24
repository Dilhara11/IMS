/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.config;

/**
 *
 * @author Achintha
 */
import com.sun.source.tree.TryTree;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    private static final String URL = "jdbc:mysql://localhost:3306/Inventory";
    private static final String USER = "root";
    private static final String PASSWORD = "#Dilhara22530";
    
    public static Connection connect(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
