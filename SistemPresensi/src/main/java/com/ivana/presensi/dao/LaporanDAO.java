/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Laporan;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ANGKY
 */
public class LaporanDAO extends JdbcUtilities{
    public LaporanDAO(){
        super();
    }
    
    public ObservableList<Laporan> getDataLaporanList() throws SQLException{
       ObservableList<Laporan> laporanList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_laporan";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Laporan laporan;
           while(result.next()){
               laporan = new Laporan(
                       result.getInt("laporan_id"),
                       result.getString("laporan_jadwal_id"),
                       result.getString("laporan_makul_id"),
                       result.getString("laporan_makul_code"),
                       result.getString("laporan_makul_nama"),
                       result.getString("laporan_user_id"),
                       result.getString("laporan_user_nama"),
                       result.getString("laporan_presensi_tanggal"),
                       result.getString("laporan_jam_mulai"),
                       result.getString("laporan_jam_berakhir"),
                       result.getString("laporan_pertemuan")
               );
               laporanList.add(laporan);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return laporanList;
    }
    
    public ObservableList<Laporan> getDataLaporanList(String cari) throws SQLException{
       ObservableList<Laporan> laporanList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_laporan WHERE laporan_makul_code LIKE '%"+cari+"%' OR laporan_makul_nama LIKE '%"+cari+"%' OR laporan_pertemuan LIKE '%"+cari+"%' OR laporan_presensi_tanggal LIKE '%"+cari+"%'";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Laporan laporan;
           while(result.next()){
               laporan = new Laporan(
                       result.getInt("laporan_id"),
                       result.getString("laporan_jadwal_id"),
                       result.getString("laporan_makul_id"),
                       result.getString("laporan_makul_code"),
                       result.getString("laporan_makul_nama"),
                       result.getString("laporan_user_id"),
                       result.getString("laporan_user_nama"),
                       result.getString("laporan_presensi_tanggal"),
                       result.getString("laporan_jam_mulai"),
                       result.getString("laporan_jam_berakhir"),
                       result.getString("laporan_pertemuan")
               );
               laporanList.add(laporan);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return laporanList;
    }
}
