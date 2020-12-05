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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ANGKY
 */
public class MatakuliahDAO extends JdbcUtilities{
    public MatakuliahDAO(){
        super();
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
               result.getInt("makul_kode"),
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
