/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Pertemuan;
import com.ivana.presensi.model.Presensi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
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
                       result.getString("presensi_makul_code"),
                       result.getString("presensi_makul_nama"),
                       result.getString("presensi_user_id"),
                       result.getString("presensi_user_nama"),
                       result.getString("presensi_kelas_id"),
                       result.getString("presensi_kelas_nama"),
                       result.getString("presensi_mahasiswa_id"),
                       result.getString("presensi_mahasiswa_nama"),
                       result.getString("presensi_tanggal"),
                       result.getString("presensi_jam_mulai"),
                       result.getString("presensi_jam_berakhir"),
                       result.getString("presensi_status"),
                       result.getString("presensi_pertemuan_id")
               );
               presensiList.add(presensi);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return presensiList;
    }
    
    public ObservableList<Presensi> getDataPresensiList(String pertemuanID) throws SQLException{
       ObservableList<Presensi> presensiList = FXCollections.observableArrayList();
       String sql = "SELECT tb_presensi.*, tb_mahasiswa.mahasiswa_nim, tb_mahasiswa.mahasiswa_gender FROM tb_presensi JOIN tb_mahasiswa on tb_presensi.presensi_mahasiswa_id = tb_mahasiswa.mahasiswa_id WHERE presensi_pertemuan_id = ?";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, pertemuanID);
       try{
           Presensi presensi;
           while(result.next()){
               presensi = new Presensi(
                       result.getInt("presensi_id"),
                       result.getString("presensi_jadwal_id"),
                       result.getString("presensi_makul_id"),
                       result.getString("presensi_makul_code"),
                       result.getString("presensi_makul_nama"),
                       result.getString("presensi_user_id"),
                       result.getString("presensi_user_nama"),
                       result.getString("presensi_kelas_id"),
                       result.getString("presensi_kelas_nama"),
                       result.getString("presensi_mahasiswa_id"),
                       result.getString("presensi_mahasiswa_nama"),
                       result.getString("presensi_tanggal"),
                       result.getString("presensi_jam_mulai"),
                       result.getString("presensi_jam_berakhir"),
                       result.getString("presensi_status"),
                       result.getString("presensi_pertemuan_id"),
                       result.getString("mahasiswa_nim"),
                       result.getString("mahasiswa_gender")
               );
               presensiList.add(presensi);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return presensiList;
    }
    
    public ObservableList<Presensi> getDataPresensiList(int id, int pertemuanID) throws SQLException{
       ObservableList<Presensi> presensiList = FXCollections.observableArrayList();
       String sql = "SELECT tb_presensi.*, tb_mahasiswa.mahasiswa_nim, tb_mahasiswa.mahasiswa_gender FROM tb_presensi JOIN tb_mahasiswa on tb_presensi.presensi_mahasiswa_id = tb_mahasiswa.mahasiswa_id WHERE presensi_user_id = ? AND presensi_pertemuan_id = ? ";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, id, pertemuanID);
       try{
           Presensi presensi;
           while(result.next()){
               presensi = new Presensi(
                       result.getInt("presensi_id"),
                       result.getString("presensi_jadwal_id"),
                       result.getString("presensi_makul_id"),
                       result.getString("presensi_makul_code"),
                       result.getString("presensi_makul_nama"),
                       result.getString("presensi_user_id"),
                       result.getString("presensi_user_nama"),
                       result.getString("presensi_kelas_id"),
                       result.getString("presensi_kelas_nama"),
                       result.getString("presensi_mahasiswa_id"),
                       result.getString("presensi_mahasiswa_nama"),
                       result.getString("presensi_tanggal"),
                       result.getString("presensi_jam_mulai"),
                       result.getString("presensi_jam_berakhir"),
                       result.getString("presensi_status"),
                       result.getString("presensi_pertemuan_id"),
                       result.getString("mahasiswa_nim"),
                       result.getString("mahasiswa_gender")
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
    
    public void insertMahasiswa(
            String jadwalID, 
            String makulID, 
            String userID,
            String kelasID,
            String kelasNama,
            String userNama,
            String makulNama,
            String makulCode,
            String jamMulai,
            String jamBerakhir) throws SQLException{
        PertemuanDAO pertemuanData = new PertemuanDAO();
        Pertemuan pertemuanID = new Pertemuan();
        pertemuanID = pertemuanData.getLastPertemuan();
        
        String sql = "SELECT * FROM tb_kelas_kuota WHERE kelas_kuota_kelas_id = ?";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, kelasID);
        try{
            while(result.next()){
                insert(
                        jadwalID, 
                        makulID, 
                        result.getString("kelas_kuota_mahasiswa_id"), 
                        userID,
                        kelasID,
                        kelasNama,
                        userNama,
                        result.getString("kelas_kuota_mahasiswa_nama"),
                        makulNama,
                        pertemuanID.getTanggal(),
                        makulCode,
                        jamMulai,
                        jamBerakhir,
                        Integer.toString(pertemuanID.getId()
                ));
            }
        }catch(Exception ex){
            System.out.println("Error Observable: "+ex.toString()); 
        }
    }
    
    public void insert(
            String jadwalID, 
            String makulID, 
            String mahasiswaID, 
            String userID,
            String kelasID,
            String kelasNama,
            String userNama,
            String mahasiswaNama,
            String makulNama,
            String tanggal,
            String makulCode,
            String jamMulai,
            String jamBerakhir,
            String pertemuanID
            )throws Exception{
        String query = "INSERT INTO tb_presensi ("
                + "presensi_jadwal_id, "
                + "presensi_makul_id, "
                + "presensi_mahasiswa_id,"
                + "presensi_user_id,"
                + "presensi_kelas_id,"
                + "presensi_kelas_nama,"
                + "presensi_user_nama,"
                + "presensi_mahasiswa_nama,"
                + "presensi_makul_nama,"
                + "presensi_tanggal,"
                + "presensi_makul_code,"
                + "presensi_jam_mulai,"
                + "presensi_jam_berakhir,"
                + "presensi_pertemuan_id)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbcUtilities.executeInsert(query, 
                jadwalID, 
                makulID, 
                mahasiswaID, 
                userID,
                kelasID,
                kelasNama,
                userNama,
                mahasiswaNama,
                makulNama,
                tanggal,
                makulCode,
                jamMulai,
                jamBerakhir,
                pertemuanID
                    );
    }
}
