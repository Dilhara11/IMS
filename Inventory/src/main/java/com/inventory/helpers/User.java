/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.helpers;

/**
 *
 * @author Achintha
 */
public class User {
    private String userName;
    private String PrivilageMode;
    private String id;

    public User(String userName, String id, String PrivilageMode) {
        this.userName = userName;
        this.PrivilageMode = PrivilageMode;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPrivilageMode() {
        return PrivilageMode;
    }

    public String getId() {
        return id;
    }
    
    
}
