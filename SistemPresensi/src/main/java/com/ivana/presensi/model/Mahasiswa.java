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
public class Mahasiswa {
    private int id;
    private String name;
    private String nim;
    private String gender;
    private String jurusan;

    public Mahasiswa() {
    }

    public Mahasiswa(int id, String name, String nim, String gender, String jurusan) {
        this.id = id;
        this.name = name;
        this.nim = nim;
        this.gender = gender;
        this.jurusan = jurusan;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getGender() {
        return gender;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
}
