/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi.dao;

import com.ivana.presensi.MD5Hash;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ivana.presensi.database.JdbcUtilities;
import com.ivana.presensi.model.User;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jordy
 */
public class UserDAO extends JdbcUtilities{
    
    public UserDAO(){
        super();
    }
    
    //for Login
    public User getUser(String username, String password)throws Exception { 
        String query = "SELECT * from tb_user WHERE user_username = ? AND user_password = ?";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query, username, MD5Hash.hashPassword(password));
        if(result.next()){
            User temp = new User(result.getInt("user_id"), result.getString("user_username"), result.getString("user_password"), result.getString("user_name"), result.getString("user_gender"), result.getString("user_level"));
            return temp;
        }
        return null;
    }
    
    public ArrayList<String> getDosenList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_user` WHERE user_level = 'dosen'";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("user_name"));
        }
        return list; 
    }
    
    public ArrayList<String> getIDDosenList() throws SQLException{
        ArrayList<String> list = new ArrayList<String>();
        String query = "SELECT * from `tb_user` WHERE user_level = 'dosen'";
        ResultSet result = this.jdbcUtilities.selectFromDatabase(query);
        while(result.next()){
            list.add(result.getString("user_id"));
        }
        return list; 
    }
    
    public ObservableList<User> getDataUserList() throws SQLException{
       ObservableList<User> userList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_user WHERE user_level = 'dosen'";
       ResultSet result = this.jdbcUtilities.selectFromDatabase(sql);
       try{
           User user;
           while(result.next()){
               user = new User(result.getInt("user_id"),
                        result.getString("user_username"),
                        result.getString("user_password"),
                        result.getString("user_name"),
                        result.getString("user_gender"),
                        result.getString("user_level"));
               userList.add(user);
               
           }
       }catch(Exception ex){
           System.out.println("Error Observable: "+ex.toString()); 
       }
       return userList;
    }
    
    //for SignUp
    public void signUp(String username, String password, String name, String gender, String level)throws Exception{
        String query = "INSERT INTO tb_user (user_username, user_password, user_name, user_gender, user_level)"
                    + "VALUES (?,?,?,?,?)";
        String md5 = MD5Hash.hashPassword(password);
        this.jdbcUtilities.executeInsert(query, username, md5, name, gender, level);
    }
    
    public void signUp(String username, String password, String name, String gender)throws Exception{
        String query = "INSERT INTO tb_user (user_username, user_password, user_name, user_gender)"
                    + "VALUES (?,?,?,?)";
        String md5 = MD5Hash.hashPassword(password);
        this.jdbcUtilities.executeInsert(query, username, md5, name, gender);
    }
    
    public String updateUsername(int userID, String username) throws SQLException{
        String query = "UPDATE user SET username = ? WHERE user_id = ?";
        this.jdbcUtilities.executeUpdate(query,username, userID);
        return username;
    }
    public String updateName(int userID, String name) throws SQLException{
        String query = "UPDATE tb_user SET user_name = ? WHERE user_id = ?";
        this.jdbcUtilities.executeUpdate(query,name, userID);
        return name;
    }
    public String updatePassword(int userID, String password) throws SQLException{
        String query = "UPDATE user SET password = ? WHERE userID = ?";
        String temp =MD5Hash.hashPassword(password);
        this.jdbcUtilities.executeUpdate(query,temp, userID);
        return temp;
    }
    
    public void deleteUser(int id_user) throws SQLException{
        String query = "DELETE FROM tb_user WHERE user_id = ?";
        this.jdbcUtilities.executeUpdate(query,id_user);
    }
}
