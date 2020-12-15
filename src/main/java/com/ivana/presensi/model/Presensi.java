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
public class Presensi {
    int id;
    String jadwalID;
    String makulID;
    String makulCode;
    String makulNama;
    String dosenID;
    String dosenNama;
    String kelasID;
    String kelasNama;
    String mahasiswaID;
    String mahasiswaNama;
    String tanggal;
    String jamMulai;
    String jamBerakhir;
    String status;
    String pertemuanID;
    String mahasiswaNim;
    String mahasiswaGender;

    public Presensi() {
    }

    public Presensi(int id, String jadwalID, String makulID, String makulCode, String makulNama, String dosenID, String dosenNama, String kelasID, String kelasNama, String mahasiswaID, String mahasiswaNama, String tanggal, String jamMulai, String jamBerakhir, String status, String pertemuanID, String mahasiswaNim, String mahasiswaGender) {
        this.id = id;
        this.jadwalID = jadwalID;
        this.makulID = makulID;
        this.makulCode = makulCode;
        this.makulNama = makulNama;
        this.dosenID = dosenID;
        this.dosenNama = dosenNama;
        this.kelasID = kelasID;
        this.kelasNama = kelasNama;
        this.mahasiswaID = mahasiswaID;
        this.mahasiswaNama = mahasiswaNama;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
        this.status = status;
        this.pertemuanID = pertemuanID;
        this.mahasiswaNim = mahasiswaNim;
        this.mahasiswaGender = mahasiswaGender;
    }

    public Presensi(int id, String jadwalID, String makulID, String makulCode, String makulNama, String dosenID, String dosenNama, String kelasID, String kelasNama, String mahasiswaID, String mahasiswaNama, String tanggal, String jamMulai, String jamBerakhir, String status, String pertemuanID) {
        this.id = id;
        this.jadwalID = jadwalID;
        this.makulID = makulID;
        this.makulCode = makulCode;
        this.makulNama = makulNama;
        this.dosenID = dosenID;
        this.dosenNama = dosenNama;
        this.kelasID = kelasID;
        this.kelasNama = kelasNama;
        this.mahasiswaID = mahasiswaID;
        this.mahasiswaNama = mahasiswaNama;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
        this.status = status;
        this.pertemuanID = pertemuanID;
    }

    public int getId() {
        return id;
    }

    public void setMahasiswaNim(String mahasiswaNim) {
        this.mahasiswaNim = mahasiswaNim;
    }

    public void setMahasiswaGender(String mahasiswaGender) {
        this.mahasiswaGender = mahasiswaGender;
    }

    public String getMahasiswaNim() {
        return mahasiswaNim;
    }

    public String getMahasiswaGender() {
        return mahasiswaGender;
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

    public String getDosenID() {
        return dosenID;
    }

    public String getDosenNama() {
        return dosenNama;
    }

    public String getKelasID() {
        return kelasID;
    }

    public String getKelasNama() {
        return kelasNama;
    }

    public String getMahasiswaID() {
        return mahasiswaID;
    }

    public String getMahasiswaNama() {
        return mahasiswaNama;
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

    public String getStatus() {
        return status;
    }

    public String getPertemuanID() {
        return pertemuanID;
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

    public void setDosenID(String dosenID) {
        this.dosenID = dosenID;
    }

    public void setDosenNama(String dosenNama) {
        this.dosenNama = dosenNama;
    }

    public void setKelasID(String kelasID) {
        this.kelasID = kelasID;
    }

    public void setKelasNama(String kelasNama) {
        this.kelasNama = kelasNama;
    }

    public void setMahasiswaID(String mahasiswaID) {
        this.mahasiswaID = mahasiswaID;
    }

    public void setMahasiswaNama(String mahasiswaNama) {
        this.mahasiswaNama = mahasiswaNama;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPertemuanID(String pertemuanID) {
        this.pertemuanID = pertemuanID;
    }

   
     
}
