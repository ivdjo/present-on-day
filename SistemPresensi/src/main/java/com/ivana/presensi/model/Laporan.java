/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.model;

/**
 *
 * @author ANGKY
 */
public class Laporan {
    int id;
    String jadwalID;
    String makulID;
    String makulCode;
    String makulNama;
    String userID;
    String userNama;
    String tanggal;
    String jamMulai;
    String jamBerakhir;
    String pertemuan;

    public Laporan() {
    }

    public Laporan(int id, String jadwalID, String makulID, String makulCode, String makulNama, String userID, String userNama, String tanggal, String jamMulai, String jamBerakhir) {
        this.id = id;
        this.jadwalID = jadwalID;
        this.makulID = makulID;
        this.makulCode = makulCode;
        this.makulNama = makulNama;
        this.userID = userID;
        this.userNama = userNama;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
    }

    public Laporan(int id, String jadwalID, String makulID, String makulCode, String makulNama, String userID, String userNama, String tanggal, String jamMulai, String jamBerakhir, String pertemuan) {
        this.id = id;
        this.jadwalID = jadwalID;
        this.makulID = makulID;
        this.makulCode = makulCode;
        this.makulNama = makulNama;
        this.userID = userID;
        this.userNama = userNama;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
        this.pertemuan = pertemuan;
    }

    public void setPertemuan(String pertemuan) {
        this.pertemuan = pertemuan;
    }

    public String getPertemuan() {
        return pertemuan;
    }

    public int getId() {
        return id;
    }

    public String getJadwalID() {
        return jadwalID;
    }

    public String getMakulID() {
        return makulID;
    }

    public String getMakulCode() {
        return makulCode;
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

    public String getTanggal() {
        return tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public String getJamBerakhir() {
        return jamBerakhir;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJadwalID(String jadwalID) {
        this.jadwalID = jadwalID;
    }

    public void setMakulID(String makulID) {
        this.makulID = makulID;
    }

    public void setMakulCode(String makulCode) {
        this.makulCode = makulCode;
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

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public void setJamBerakhir(String jamBerakhir) {
        this.jamBerakhir = jamBerakhir;
    }
    
    
}
