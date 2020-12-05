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
public class Matakuliah {
    private int id;
    private int kode;
    private String nama;
    private String dosen_id;
    private String dosen;

    public Matakuliah() {
    }

    public Matakuliah(int id, int kode, String nama, String dosen_id, String dosen) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.dosen_id = dosen_id;
        this.dosen = dosen;
    }

    public int getId() {
        return id;
    }

    public int getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getDosen_id() {
        return dosen_id;
    }

    public String getDosen() {
        return dosen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDosen_id(String dosen_id) {
        this.dosen_id = dosen_id;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }
    
    
}
