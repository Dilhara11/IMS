/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.helpers;

/**
 *
 * @author Achintha
 */
public class Session {
    private static String privilageMode;

 
    public static void newSession(String mode){
        privilageMode = mode;
    }
    
    public static String getPrivilageMode() {
        return privilageMode;
    }

    
    
}
