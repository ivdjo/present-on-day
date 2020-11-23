/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FormUserController implements Initializable {

    @FXML
    private Label lblName;
    
    public String name="";
    Statement st;
    Connection conn;
    ResultSet rs;
    
    @FXML
    private TableView<Users> tvUsers;
    @FXML
    private TableColumn<Users, Integer> colID;
    @FXML
    private TableColumn<Users, String> colUsername;
    @FXML
    private TableColumn<Users, String> colPassword;
    @FXML
    private TableColumn<Users, String> colNama;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtNama;
    @FXML
    private RadioButton rbGirl;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton rbBoy;
    @FXML
    private TableColumn<Users, String> colGender;
    
    public FormUserController(){
        
    }
    
    public void reset(){
        txtUsername.setText("");
        txtPassword.setText("");
        txtNama.setText("");
        
    }
    
    public ObservableList<Users> getUsersList(){
       ObservableList<Users> usersList = FXCollections.observableArrayList();
       String sql = "SELECT * FROM tb_users WHERE id != 1";
       
       try{
           st = conn.createStatement();
           rs = st.executeQuery(sql);
           Users users;
           while(rs.next()){
               users = new Users(rs.getInt("id"),
                       rs.getString("username"),
                       rs.getString("password"),
                       rs.getString("nama"),
                       rs.getString("kelamin"));
               usersList.add(users);
           }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.toString());
       }
       return usersList;
    }
    
    public void showUsers(){
        
        ObservableList<Users> list = getUsersList();
        
        colID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<Users, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
        colNama.setCellValueFactory(new PropertyValueFactory<Users, String>("nama"));
        colGender.setCellValueFactory(new PropertyValueFactory<Users, String>("kelamin"));
        
        tvUsers.setItems(list);
    } 
    
    public void setName(String name){
        this.name = name;
        lblName.setText(name);
    }
    
    public void logoutTipe1(ActionEvent event) throws IOException{
   
        Parent formParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene formScene = new Scene(formParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(formScene);
        window.setTitle("Sistem Presensi");
        window.show();
    }
    
    public void logoutTipe2(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
                
        FXMLDocumentController formController = loader.getController();
               
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
                
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Sistem Presensi");
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rbBoy.setSelected(true);
        conn = javaconnect.ConnectDB();
        showUsers();
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        if (JOptionPane.showConfirmDialog(null, "Anda akan Logout", "LOGOUT",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            logoutTipe2(event);
        }
    }

    @FXML
    private void btnTambahUser(ActionEvent event) {
        
        String kelamin = "";
        if(rbBoy.isSelected()){
            kelamin = rbBoy.getText();
        }else{
            kelamin = rbGirl.getText();
        }
        
        if(txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong");
        }else{
            String query = "INSERT INTO `tb_users` (`id`, `username`, `password`, `nama`, `kelamin`) VALUES "
                    + "(NULL, '"+ txtUsername.getText() +"', '"+txtPassword.getText()+"', '"+txtNama.getText()+"', '"+kelamin+"')";
            executeQuery(query);
            reset();
            showUsers();
        }
        
    }

    @FXML
    private void btnHapusUser(ActionEvent event) {
        
        String query = "DELETE FROM `tb_users` "
                + "WHERE `tb_users`.`id` = "+tvUsers.getSelectionModel().getSelectedItem().getId()+"";
        
        if (JOptionPane.showConfirmDialog(null, "Data akan dihapus permanen", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            executeQuery(query);
            reset();
            showUsers();
        } 
        
    }

    @FXML
    private void btnEditUser(ActionEvent event) {
        String kelamin = "";
        if(rbBoy.isSelected()){
            kelamin = rbBoy.getText();
        }else{
            kelamin = rbGirl.getText();
        }
        
        if(txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong");
        }else{
            String query = "UPDATE `tb_users` SET  "
                + "`username` = '"+txtUsername.getText()+"', "
                + "`password` = '"+txtPassword.getText()+"', "
                + "`nama` = '"+txtNama.getText()+"', "
                + "`kelamin` = '"+kelamin.toString()+"' "
                + "WHERE `tb_users`.`id` = "+tvUsers.getSelectionModel().getSelectedItem().getId()+"";
            executeQuery(query);
            reset();
            showUsers();
        }
        
    }
    
    private void executeQuery(String query) {
        conn = javaconnect.ConnectDB();
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void onClick(MouseEvent event) {
        txtUsername.setText(tvUsers.getSelectionModel().getSelectedItem().getUsername());
        txtPassword.setText(tvUsers.getSelectionModel().getSelectedItem().getPassword());
        txtNama.setText(tvUsers.getSelectionModel().getSelectedItem().getNama());
        if(tvUsers.getSelectionModel().getSelectedItem().getKelamin().equals("Perempuan")){
            rbGirl.setSelected(true);
        }else
            rbBoy.setSelected(true);
        System.out.println(tvUsers.getSelectionModel().getSelectedItem().getId());
    }
    
}
