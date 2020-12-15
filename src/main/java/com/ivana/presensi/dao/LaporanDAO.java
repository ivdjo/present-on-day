/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.Laporan;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
 */
public class LaporanDAO extends JdbcUtilities{
    public LaporanDAO(){
        super();
    }
    
    public ObservableList<Laporan> getDataJadwalList(int id) throws SQLException{
       ObservableList<Laporan> laporanList = FXCollections.observableArrayList();
       String sql = "SELECT count(presensi_status) AS 'Total Kehadiran' , presensi_mahasiswa_nama, presensi_jadwal_id  FROM tb_presensi WHERE tb_presensi.presensi_jadwal_id = ? AND tb_presensi.presensi_status = 'Hadir' GROUP BY presensi_mahasiswa_id";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql,id);
       try{
           Laporan laporan;
           double total = getCountPertemuan(id);
           double kehadiran = 0;
           System.out.println("total pertemuan :"+total);
           while(result.next()){
               
               kehadiran = (result.getDouble("Total Kehadiran")/total)*100;
               
               laporan = new Laporan(
                       result.getString("Total Kehadiran"), 
                       result.getString("presensi_mahasiswa_nama"),
                       Double.toString(round(kehadiran,2)) + "%"
               );
               laporanList.add(laporan);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return laporanList;
    }
    
    public ObservableList<Laporan> getDataJadwalList(int id, String search) throws SQLException{
       ObservableList<Laporan> laporanList = FXCollections.observableArrayList();
       String sql = "SELECT count(presensi_status) AS 'Total Kehadiran' , presensi_mahasiswa_nama, presensi_jadwal_id  FROM tb_presensi WHERE tb_presensi.presensi_jadwal_id = ? AND tb_presensi.presensi_status = 'Hadir'  AND presensi_mahasiswa_nama LIKE '%"+search+"%' GROUP BY presensi_mahasiswa_id";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql,id);
       try{
           Laporan laporan;
           double total = getCountPertemuan(id);
           double kehadiran = 0;
           System.out.println("total pertemuan :"+total);
           while(result.next()){
               
               kehadiran = (result.getDouble("Total Kehadiran")/total)*100;
               
               laporan = new Laporan(
                       result.getString("Total Kehadiran"), 
                       result.getString("presensi_mahasiswa_nama"),
                       Double.toString(round(kehadiran,2)) + "%"
               );
               laporanList.add(laporan);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return laporanList;
    }
    
    public double getCountPertemuan(int id) throws SQLException{
       String sql = "SELECT count(pertemuan_id) AS 'total' FROM tb_pertemuan WHERE pertemuan_jadwal_id = ?";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql, id);
       try{
           while(result.next()){
               return result.getDouble("total");
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return 0;
    }
    
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
