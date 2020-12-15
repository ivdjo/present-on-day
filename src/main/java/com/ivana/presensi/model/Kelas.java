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
public class Kelas {
    int id;
    String kelasNama;
    String makulID;
    String makulNama;
    String userID;
    String userNama;
    String makulCode;

    public Kelas() {
    }

    public Kelas(int id, String kelasNama, String makulID, String makulNama, String userID, String userNama, String makulCode) {
        this.id = id;
        this.kelasNama = kelasNama;
        this.makulID = makulID;
        this.makulNama = makulNama;
        this.userID = userID;
        this.userNama = userNama;
        this.makulCode = makulCode;
    }

    public int getId() {
        return id;
    }

    public String getKelasNama() {
        return kelasNama;
    }

    public String getMakulID() {
        return makulID;
    }

    public String getMakulNama() {
        return makulNama;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserNama() {
        return userNama;
    }

    public String getMakulCode() {
        return makulCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKelasNama(String kelasNama) {
        this.kelasNama = kelasNama;
    }

    public void setMakulID(String makulID) {
        this.makulID = makulID;
    }

    public void setMakulNama(String makulNama) {
        this.makulNama = makulNama;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserNama(String userNama) {
        this.userNama = userNama;
    }

    public void setMakulCode(String makulCode) {
        this.makulCode = makulCode;
    }
    
    
}
