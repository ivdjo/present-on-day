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
public class Pertemuan {
    int id;
    String nama;
    String tanggal;
    String jadwalID;
    String jumlahHadir;
    String jumlahAbsen;

    public Pertemuan() {
    }

    public Pertemuan(int id, String nama, String tanggal, String jadwalID) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jadwalID = jadwalID;
    }

    public Pertemuan(int id, String nama, String tanggal, String jadwalID, String jumlahHadir, String jumlahAbsen) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jadwalID = jadwalID;
        this.jumlahHadir = jumlahHadir;
        this.jumlahAbsen = jumlahAbsen;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJadwalID() {
        return jadwalID;
    }

    public String getJumlahHadir() {
        return jumlahHadir;
    }

    public String getJumlahAbsen() {
        return jumlahAbsen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJadwalID(String jadwalID) {
        this.jadwalID = jadwalID;
    }

    public void setJumlahHadir(String jumlahHadir) {
        this.jumlahHadir = jumlahHadir;
    }

    public void setJumlahAbsen(String jumlahAbsen) {
        this.jumlahAbsen = jumlahAbsen;
    }
    
    
}
