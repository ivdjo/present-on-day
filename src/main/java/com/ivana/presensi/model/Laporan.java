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
public class Laporan {
    String kehadiran;
    String mahasiswaNama;
    String persentase;

    public Laporan() {
    }

    public Laporan(String kehadiran, String mahasiswaNama, String persentase) {
        this.kehadiran = kehadiran;
        this.mahasiswaNama = mahasiswaNama;
        this.persentase = persentase;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public String getMahasiswaNama() {
        return mahasiswaNama;
    }

    public String getPersentase() {
        return persentase;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    public void setMahasiswaNama(String mahasiswaNama) {
        this.mahasiswaNama = mahasiswaNama;
    }

    public void setPersentase(String persentase) {
        this.persentase = persentase;
    }
    
}
