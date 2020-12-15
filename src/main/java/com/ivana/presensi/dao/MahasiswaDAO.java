/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.model.Mahasiswa;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.ivana.presensi.database.JdbcUtilities;

/**
 *
 * @author Jordy
 */
public class MahasiswaDAO extends JdbcUtilities{
    public MahasiswaDAO(){
        super();
    }
    
    public ObservableList<Mahasiswa> getDataMahasiswaList() throws SQLException{
       ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_mahasiswa";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           Mahasiswa mahasiswa;
           while(result.next()){
               mahasiswa = new Mahasiswa(result.getInt("mahasiswa_id"),
                        result.getString("mahasiswa_nama"),
                        result.getString("mahasiswa_nim"),
                        result.getString("mahasiswa_gender"),
                        result.getString("mahasiswa_jurusan"));
               mahasiswaList.add(mahasiswa);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return mahasiswaList;
    }
    
    public void insertMahasiswa(String nim, String nama, String gender, String jurusan)throws Exception{
        String query = "INSERT INTO tb_mahasiswa (mahasiswa_nim, mahasiswa_nama, mahasiswa_gender, mahasiswa_jurusan)"
                    + "VALUES (?,?,?,?)";
        this.jdbcUtilities.executeInsert(query, nim, nama, gender, jurusan);
    }
    
    public void deleteMahasiswa(int id) throws SQLException{
        String query = "DELETE FROM tb_mahasiswa WHERE mahasiswa_id = ?";
        this.jdbcUtilities.executeUpdate(query,id);
    }
    
    public void editMahasiswa(int id, String nim, String nama, String gender, String jurusan) throws SQLException{
        String query = "UPDATE tb_mahasiswa SET mahasiswa_nim = ? , mahasiswa_nama = ?, mahasiswa_gender = ? , mahasiswa_jurusan = ?"
                + "WHERE mahasiswa_id = ?";
        this.jdbcUtilities.executeUpdate(query, nim, nama , gender, jurusan, id);
    }
}
