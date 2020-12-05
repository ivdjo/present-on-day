/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Presensi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ANGKY
 */
public class PresensiDAO extends JdbcUtilities{
    public PresensiDAO(){
        super();
    }
    
    public ObservableList<Presensi> getDataPresensiList() throws SQLException{
       ObservableList<Presensi> presensiList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_presensi";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Presensi presensi;
           while(result.next()){
               presensi = new Presensi(
                       result.getInt("presensi_id"),
                       result.getString("presensi_jadwal_id"),
                       result.getString("presensi_makul_id"),
                       result.getString("presensi_mahasiswa_id"),
                       result.getString("presensi_user_id"),
                       result.getString("presensi_status"),
                       result.getString("presensi_kelas_id"),
                       result.getString("presensi_kelas_nama"),
                       result.getString("presensi_user_nama"),
                       result.getString("presensi_mahasiswa_nama"),
                       result.getString("presensi_makul_nama"),
                       result.getString("presensi_tanggal"),
                       result.getString("presensi_makul_code"),
                       result.getString("presensi_jam_mulai"),
                       result.getString("presensi_jam_berakhir")
               );
               presensiList.add(presensi);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return presensiList;
    }
    
    public ObservableList<Presensi> getDataPresensiList(int id) throws SQLException{
       ObservableList<Presensi> presensiList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_presensi WHERE presensi_user_id = ? ";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, id);
       try{
           Presensi presensi;
           while(result.next()){
               presensi = new Presensi(
                       result.getInt("presensi_id"),
                       result.getString("presensi_jadwal_id"),
                       result.getString("presensi_makul_id"),
                       result.getString("presensi_mahasiswa_id"),
                       result.getString("presensi_user_id"),
                       result.getString("presensi_status"),
                       result.getString("presensi_kelas_id"),
                       result.getString("presensi_kelas_nama"),
                       result.getString("presensi_user_nama"),
                       result.getString("presensi_mahasiswa_nama"),
                       result.getString("presensi_makul_nama"),
                       result.getString("presensi_tanggal"),
                       result.getString("presensi_makul_code"),
                       result.getString("presensi_jam_mulai"),
                       result.getString("presensi_jam_berakhir")
               );
               presensiList.add(presensi);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return presensiList;
    }
    
    public void setHadir(int id, String status) throws SQLException{
        String query = "UPDATE tb_presensi SET presensi_status = ?"
                + "WHERE presensi_id = ?";
        this.jdbcUtilities.executeUpdate(query,status,id);
    }
    
    public void setAbsen(int id, String status) throws SQLException{
        String query = "UPDATE tb_presensi SET presensi_status = ?"
                + "WHERE presensi_id = ?";
        this.jdbcUtilities.executeUpdate(query, status, id);
    }
}
