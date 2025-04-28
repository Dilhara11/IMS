/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.test;

/**
 *
 * @author Achintha
 */
import com.inventory.config.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
        
public class Dbtest {
    
    public static boolean insertUser(){
        String sql = "Insert Into users(id, name, password, type) values (?, ?, ?, ?)";
        try {
            Connection conn = db.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, "#U001");
            stmt.setString(2, "Achintha");
            stmt.setString(3, "12345");
            stmt.setString(4, "food");
            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        boolean parse = Dbtest.insertUser();
        System.out.println(parse);
    }
    
}
