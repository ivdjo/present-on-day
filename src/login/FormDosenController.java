/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FormDosenController implements Initializable {

    @FXML
    private Label lblNama;
    
    private String nama;
    
    public void setNama(String nama){
        this.nama = nama;
        lblNama.setText(nama);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLogout(ActionEvent event) throws IOException {
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
    
}
