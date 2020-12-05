/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.model.User;

/**
 *
 * @author ANGKY
 */
public class UserSession {
    private static UserSession instance;

    private User currentUser;
    
    private UserSession(User userInput) {
        this.currentUser = userInput;
//        this.privileges = privileges;
    }
    
    public static UserSession getInstace(User userInput) {
        if(instance == null) {
            instance = new UserSession(userInput);
        }
        return instance;
    }

    public User getUser() {
        return currentUser;
    }


    public void cleanUserSession() {
        currentUser = null;// or null
        instance = null;
    }
    
    public void update(User newUser){
        this.currentUser = newUser;
    }
}
