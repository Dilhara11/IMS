/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.test;

/**
 *
 * @author Achintha
 */

import com.inventory.models.UserModel;
public class TestUserModel {
    public static void main(String[] args) {
        String userId = "#U003";
        String name = "Achintha";
        String password = "1245";
        String type = "Admin";
        
        boolean isInsert = UserModel.insertUser(userId, name, password, type);
        
        if(isInsert){
            System.out.println("Successfully Inserted.");
        } else {
            System.out.println("Insertion Failed.");
        }
        
//        boolean isFound = UserModel.authUser(name, password);
//        System.out.println((isFound? "Aunthenticated" : "Invalid user"));
    }
}
