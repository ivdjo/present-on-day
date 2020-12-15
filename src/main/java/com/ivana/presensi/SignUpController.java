/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane signUp;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private RadioButton rbBoy;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton rbGril;
    @FXML
    private ComboBox<String> comboLevel;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboLevel.setItems(FXCollections.observableArrayList("admin", "dosen"));
    }    

    @FXML
    private void btnSubmit(ActionEvent event) throws Exception {
        System.out.println(comboLevel.getSelectionModel().getSelectedItem());
        String gender = "";
        if(rbBoy.isSelected()){
            gender = rbBoy.getText();
        }
        else{
            gender = rbGril.getText();
        }
        UserDAO user = new UserDAO();
        user.signUp(txtUsername.getText(), txtPassword.getText(), txtName.getText(), gender,comboLevel.getSelectionModel().getSelectedItem());
        SwitchPane sp = new SwitchPane();
        sp.switchPane(signUp,"login");
        
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(signUp,"login");
    }
    
}
