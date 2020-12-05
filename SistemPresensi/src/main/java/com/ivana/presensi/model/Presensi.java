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
public class Presensi {
    int id;
    String jadwalID;
    String makulID;
    String mahasiswaID;
    String userID;
    String status;
    String kelasID;
    String kelasNama;
    String userNama;
    String mahasiswaNama;
    String makulNama;
    String tanggal;
    String makulCode;
    String jamMulai;
    String jamBerakhir;

    public Presensi() {
    }

    public Presensi(int id, String jadwalID, String makulID, String mahasiswaID, String userID, String status, String kelasID, String kelasNama, String userNama, String mahasiswaNama, String makulNama, String tanggal, String makulCode, String jamMulai, String jamBerakhir) {
        this.id = id;
        this.jadwalID = jadwalID;
        this.makulID = makulID;
        this.mahasiswaID = mahasiswaID;
        this.userID = userID;
        this.status = status;
        this.kelasID = kelasID;
        this.kelasNama = kelasNama;
        this.userNama = userNama;
        this.mahasiswaNama = mahasiswaNama;
        this.makulNama = makulNama;
        this.tanggal = tanggal;
        this.makulCode = makulCode;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
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

    public String getMahasiswaID() {
        return mahasiswaID;
    }

    public String getUserID() {
        return userID;
    }

    public String getStatus() {
        return status;
    }

    public String getKelasID() {
        return kelasID;
    }

    public String getKelasNama() {
        return kelasNama;
    }

    public String getUserNama() {
        return userNama;
    }

    public String getMahasiswaNama() {
        return mahasiswaNama;
    }

    public String getMakulNama() {
        return makulNama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getMakulCode() {
        return makulCode;
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

    public void setMahasiswaID(String mahasiswaID) {
        this.mahasiswaID = mahasiswaID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setKelasID(String kelasID) {
        this.kelasID = kelasID;
    }

    public void setKelasNama(String kelasNama) {
        this.kelasNama = kelasNama;
    }

    public void setUserNama(String userNama) {
        this.userNama = userNama;
    }

    public void setMahasiswaNama(String mahasiswaNama) {
        this.mahasiswaNama = mahasiswaNama;
    }

    public void setMakulNama(String makulNama) {
        this.makulNama = makulNama;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setMakulCode(String makulCode) {
        this.makulCode = makulCode;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public void setJamBerakhir(String jamBerakhir) {
        this.jamBerakhir = jamBerakhir;
    }
     
}
