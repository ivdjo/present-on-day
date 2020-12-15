/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Kelas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
 */
public class KelasDAO extends JdbcUtilities{
    public KelasDAO(){
        super();
    }
    
    public ArrayList<String> getKelasList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_nama"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasIDList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_id"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasKodeList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_makul_code"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasMakulIDList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_makul_id"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasMakulList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_makul_nama"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasDosenIDList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_user_id"));
        }
        return list; 
    }
    
    public ArrayList<String> getKelasDosenList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_kelas`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("kelas_user_nama"));
        }
        return list; 
    }
    
    public ObservableList<Kelas> getDataKelasList() throws SQLException{
       ObservableList<Kelas> kelasList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_kelas";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Kelas kelas;
           while(result.next()){
               kelas = new Kelas(
                       result.getInt("kelas_id"), 
                       result.getString("kelas_nama"),
                       result.getString("kelas_makul_id"),
                       result.getString("kelas_makul_nama"),
                       result.getString("kelas_user_id"),
                       result.getString("kelas_user_nama"),
                       result.getString("kelas_makul_code")
               );
               kelasList.add(kelas);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return kelasList;
    }
    
    public Kelas getKelas(int kelasID) throws SQLException{
       String sql = "SELECT * FROM tb_kelas WHERE kelas_id = ?";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, kelasID);
       try{
           while(result.next()){
               Kelas kelas = new Kelas(
                       result.getInt("kelas_id"), 
                       result.getString("kelas_nama"),
                       result.getString("kelas_makul_id"),
                       result.getString("kelas_makul_nama"),
                       result.getString("kelas_user_id"),
                       result.getString("kelas_user_nama"),
                       result.getString("kelas_makul_code")
               );
               return kelas;
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return null;
    }
    
    public void insert(String namaKelas, String makulID, String makulNama, String userID, String userNama, String makulCode)throws Exception{
        String query = "INSERT INTO tb_kelas (kelas_nama, kelas_makul_id, kelas_makul_nama, kelas_user_id, kelas_user_nama, kelas_makul_code)"
                    + "VALUES (?,?,?,?,?,?)";
        this.jdbcUtilities.executeInsert(query, namaKelas, makulID, makulNama, userID, userNama, makulCode);
    }
    
    public void delete(int id) throws SQLException{
        String query = "DELETE FROM tb_kelas WHERE kelas_id = ?";
        this.jdbcUtilities.executeUpdate(query,id);
    }
    
    public void edit(int id, String namaKelas, String makulID, String makulNama, String userID, String userNama, String makulCode) throws SQLException{
        String query = "UPDATE tb_kelas SET kelas_nama = ? , kelas_makul_id = ?, kelas_makul_nama = ? , kelas_user_id = ?, kelas_user_nama = ? , kelas_makul_code = ?"
                + "WHERE kelas_id = ?";
        this.jdbcUtilities.executeUpdate(query, namaKelas, makulID , makulNama, userID, userNama, makulCode);
    }
}
