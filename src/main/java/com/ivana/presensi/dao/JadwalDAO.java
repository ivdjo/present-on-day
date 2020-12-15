/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Jadwal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
 */
public class JadwalDAO extends JdbcUtilities{
    public JadwalDAO(){
        super();
    }
    
    public ObservableList<Jadwal> getDataJadwalList() throws SQLException{
       ObservableList<Jadwal> jadwalList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_jadwal";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Jadwal jadwal;
           while(result.next()){
               jadwal = new Jadwal(
                       result.getInt("jadwal_id"),
                       result.getString("jadwal_kelas_id"),
                       result.getString("jadwal_hari"),
                       result.getString("jadwal_jam_mulai"),
                       result.getString("jadwal_jam_berakhir"),
                       result.getString("jadwal_kelas_nama"),
                       result.getString("jadwal_makul_id"),
                       result.getString("jadwal_makul_nama"),
                       result.getString("jadwal_user_id"),
                       result.getString("jadwal_user_nama"),
                       result.getString("jadwal_makul_code")
               );
               jadwalList.add(jadwal);
           }
           
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return jadwalList;
    }
    
    public Jadwal getJadwal(int id) throws SQLException{
       String sql = "SELECT * FROM tb_jadwal WHERE jadwal_id = ?";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, id);
       try{
           while(result.next()){
               Jadwal jadwal = new Jadwal(
                       result.getInt("jadwal_id"), 
                       result.getString("jadwal_kelas_id"),
                       result.getString("jadwal_hari"),
                       result.getString("jadwal_jam_mulai"),
                       result.getString("jadwal_jam_berakhir"),
                       result.getString("jadwal_kelas_nama"),
                       result.getString("jadwal_makul_id"),
                       result.getString("jadwal_makul_nama"),
                       result.getString("jadwal_user_id"),
                       result.getString("jadwal_user_nama"),
                       result.getString("jadwal_makul_code")
               );
               return jadwal;
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return null;
    }
    
    public ObservableList<Jadwal> getDataJadwalList(String cari) throws SQLException{
       ObservableList<Jadwal> jadwalList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_jadwal WHERE "
               + "jadwal_hari LIKE '%"+cari+"%' OR "
               + "jadwal_kelas_nama LIKE '%"+cari+"%' OR "
               + "jadwal_makul_nama LIKE '%"+cari+"%' OR "
               + "jadwal_makul_code LIKE '%"+cari+"%' OR "
               + "jadwal_user_nama LIKE '%"+cari+"%'";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Jadwal jadwal;
           while(result.next()){
               jadwal = new Jadwal(
                       result.getInt("jadwal_id"), 
                       result.getString("jadwal_kelas_id"),
                       result.getString("jadwal_hari"),
                       result.getString("jadwal_jam_mulai"),
                       result.getString("jadwal_jam_berakhir"),
                       result.getString("jadwal_kelas_nama"),
                       result.getString("jadwal_makul_id"),
                       result.getString("jadwal_makul_nama"),
                       result.getString("jadwal_user_id"),
                       result.getString("jadwal_user_nama"),
                       result.getString("jadwal_makul_code")
               );
               jadwalList.add(jadwal);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return jadwalList;
    }
    
    public ObservableList<Jadwal> getDataJadwalList(int id) throws SQLException{
       ObservableList<Jadwal> jadwalList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_jadwal WHERE jadwal_user_id = ?";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql,id);
       try{
           Jadwal jadwal;
           while(result.next()){
               jadwal = new Jadwal(
                       result.getInt("jadwal_id"), 
                       result.getString("jadwal_kelas_id"),
                       result.getString("jadwal_hari"),
                       result.getString("jadwal_jam_mulai"),
                       result.getString("jadwal_jam_berakhir"),
                       result.getString("jadwal_kelas_nama"),
                       result.getString("jadwal_makul_id"),
                       result.getString("jadwal_makul_nama"),
                       result.getString("jadwal_user_id"),
                       result.getString("jadwal_user_nama"),
                       result.getString("jadwal_makul_code")
               );
               jadwalList.add(jadwal);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return jadwalList;
    }
    
    public ObservableList<Jadwal> getDataJadwalList(int id,String cari) throws SQLException{
       ObservableList<Jadwal> jadwalList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_jadwal WHERE "
               + "jadwal_user_id = ? AND "
               + "(jadwal_hari LIKE '%"+cari+"%' OR "
               + "jadwal_kelas_nama LIKE '%"+cari+"%' OR "
               + "jadwal_makul_nama LIKE '%"+cari+"%' OR "
               + "jadwal_makul_code LIKE '%"+cari+"%' OR "
               + "jadwal_user_nama LIKE '%"+cari+"%')";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql,id);
       try{
           Jadwal jadwal;
           while(result.next()){
               jadwal = new Jadwal(
                       result.getInt("jadwal_id"), 
                       result.getString("jadwal_kelas_id"),
                       result.getString("jadwal_hari"),
                       result.getString("jadwal_jam_mulai"),
                       result.getString("jadwal_jam_berakhir"),
                       result.getString("jadwal_kelas_nama"),
                       result.getString("jadwal_makul_id"),
                       result.getString("jadwal_makul_nama"),
                       result.getString("jadwal_user_id"),
                       result.getString("jadwal_user_nama"),
                       result.getString("jadwal_makul_code")
               );
               jadwalList.add(jadwal);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return jadwalList;
    }
    
    public void insert(String kelasID, String kelasNama, String hari, String jamMulai, String jamBerakhir, String makulID, String makulNama, String userID, String userNama, String makulCode)throws Exception{
        String query = "INSERT INTO tb_jadwal ("
                + "jadwal_kelas_id, "
                + "jadwal_hari, "
                + "jadwal_jam_mulai, "
                + "jadwal_jam_berakhir, "
                + "jadwal_kelas_nama, "
                + "jadwal_makul_id, "
                + "jadwal_makul_nama, "
                + "jadwal_user_id, "
                + "jadwal_user_nama, "
                + "jadwal_makul_code)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.jdbcUtilities.executeInsert(query, kelasID, hari, jamMulai, jamBerakhir, kelasNama, makulID, makulNama, userID, userNama, makulCode);
    }
    
    public void delete(int id) throws SQLException{
        String query = "DELETE FROM tb_jadwal WHERE jadwal_id = ?";
        this.jdbcUtilities.executeUpdate(query,id);
    }
}
