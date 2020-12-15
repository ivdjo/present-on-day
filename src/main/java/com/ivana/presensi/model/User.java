/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.model;

/**
 *
 * @author Jordy
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private String level;

    public User() {
    }

    public User(int userID, String username, String password, String fullName, String gender, String level) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.level = level;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getLevel() {
        return level;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
}
