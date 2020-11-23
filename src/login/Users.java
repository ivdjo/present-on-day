/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

public class Users {
    private int id;
    private String username;
    private String password;
    private String nama;
    private String kelamin;

    public Users(int id, String username, String password, String nama, String kelamin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.kelamin = kelamin;
    }

    public String getKelamin() {
        return kelamin;
    }
    
    public Users(int id, String username, String password, String nama) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }
    
}
