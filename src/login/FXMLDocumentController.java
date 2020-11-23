/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {
    
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    
    public FXMLDocumentController(){
        conn = javaconnect.ConnectDB();
    }
    
    public void loginTipe1(ActionEvent event) throws IOException{
        try {
            String sql = "select * from tb_users where username=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, txtUsername.getText());
            ps.setString(2, new String(txtPass.getText()));
            rs=ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Hallo " + rs.getString("username"));
                
                Parent formParent = FXMLLoader.load(getClass().getResource("Form.fxml"));
                Scene formScene = new Scene(formParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(formScene);
                
                window.show();
                
                rs.close();
                ps.close();
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password tidak ditemukan");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loginTipe2(ActionEvent event) throws IOException{
        try {
            String sql = "select * from tb_users where username=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, txtUsername.getText());
            ps.setString(2, new String(txtPass.getText()));
            rs=ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Hallo " + rs.getString("username"));
                
                if(rs.getString("username").equals("admin")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FormUser.fxml"));
                    Parent root = loader.load();

                    FormUserController formController = loader.getController();
                    formController.setName(rs.getString("nama"));

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.close();

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Form Admin");
                    stage.show();
                }else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FormDosen.fxml"));
                    Parent root = loader.load();

                    FormDosenController formDosenController = loader.getController();
                    formDosenController.setNama(rs.getString("nama"));

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.close();

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Form Dosen");
                    stage.show();
                }
                
                
                rs.close();
                ps.close();
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password tidak ditemukan");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPass;
    
    public void message(){
        JOptionPane.showMessageDialog(null, "Hallo " + txtUsername.getText());
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        loginTipe2(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
