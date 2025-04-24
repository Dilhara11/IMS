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
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserModel {
    
    public static boolean insertUser(String userId, String name, String password, String type){
        String sql = "Insert Into users(id, name, password, type) values (?, ?, ?, ?)";
        
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, userId);
            stmt.setString(2, name);
            stmt.setString(3, password);
            stmt.setString(4, type);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean authUser(String userName, String password){
        String sql = "Select * from users";
    
        try {
            Connection con = db.connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                String authPassword = rs.getString("password");
          
                
                if ((userName == null ? name == null : userName.equals(name)) && (password == null ? authPassword == null : password.equals(authPassword))) {
                    return true;
                }
            }
            
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
