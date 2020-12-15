/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Matakuliah;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
 */
public class MatakuliahDAO extends JdbcUtilities{
    public MatakuliahDAO(){
        super();
    }
    
    public ArrayList<String> getMakulIDList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_makul`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("makul_id"));
        }
        return list; 
    }
    
    public ArrayList<String> getMakulList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_makul`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("makul_nama"));
        }
        return list; 
    }
    
    public ArrayList<String> getKodeMakulList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_makul`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("makul_kode"));
        }
        return list; 
    }
    
    public ArrayList<String> getDosenIDList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_makul`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("makul_user_id"));
        }
        return list; 
    }
    
    public ArrayList<String> getDosenList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_makul`";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("makul_user_nama"));
        }
        return list; 
    }
    
    public ObservableList<Matakuliah> getDataMatakuliahList() throws SQLException{
       ObservableList<Matakuliah> matakuliahList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_makul";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Matakuliah matakuliah;
           while(result.next()){
               Matakuliah makul = new Matakuliah(
               result.getInt("makul_id"),
               result.getString("makul_kode"),
               result.getString("makul_nama"),
               result.getString("makul_user_id"),
               result.getString("makul_user_nama"));
               matakuliahList.add(makul);
           }
           
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return matakuliahList;
    }
    
    public void insertMakul(String kode, String namaMakul, String id, String userNama)throws Exception{
        String query = "INSERT INTO tb_makul (makul_kode, makul_nama, makul_user_id, makul_user_nama)"
                    + "VALUES (?,?,?,?)";
        this.jdbcUtilities.executeInsert(query, kode, namaMakul, id, userNama);
    }
    
    public void editMakul(int id, String kode, String nama, String userId, String userNama) throws SQLException{
        String query = "UPDATE tb_makul SET makul_kode = ? , makul_nama = ?, makul_user_id = ? , makul_user_nama = ?"
                + "WHERE makul_id = ?";
        this.jdbcUtilities.executeUpdate(query, kode, nama , userId, userNama, id);
    }
    
    public void deleteMakul(int id) throws SQLException{
        String query = "DELETE FROM tb_makul WHERE makul_id = ?";
        this.jdbcUtilities.executeUpdate(query,id);
    }
}
