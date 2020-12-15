/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.UserDAO;
import com.ivana.presensi.model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormUserController implements Initializable {

    private User sessionUser;
    
    @FXML
    private TableView<User> tvUser;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtName;
    @FXML
    private RadioButton rbBoy;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton rbGirl;
    @FXML
    private TableColumn<User, Integer> colID;
    @FXML
    private TableColumn<User, String> colUser;
    @FXML
    private TableColumn<User, String> colName;
    @FXML
    private TableColumn<User, String> colGender;
    @FXML
    private AnchorPane formUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession session = UserSession.getInstace(this.sessionUser);
        this.sessionUser = session.getUser();
        try {
            showUser();
        } catch (Exception ex) {
            Logger.getLogger(FormUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showUser() throws Exception{
        UserDAO userDAO = new UserDAO();
        ObservableList<User> list = userDAO.getDataUserList();
        
        colID.setCellValueFactory(new PropertyValueFactory<User, Integer>("userID"));
        colUser.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colName.setCellValueFactory(new PropertyValueFactory<User, String>("fullName"));
        colGender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        
        tvUser.setItems(list);
    }    

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formUser,"dashAdmin");
    }

    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        String gender = "";
        if(rbBoy.isSelected()){
            gender = rbBoy.getText();
        }
        else{
            gender = rbGirl.getText();
        }
        UserDAO userDAO = new UserDAO();
        userDAO.signUp(txtUsername.getText(), txtPassword.getText(), txtName.getText(), gender, "dosen");
        showUser();
    }

    @FXML
    private void btnEdit(ActionEvent event) {
    }

    @FXML
    private void btnHapus(ActionEvent event) throws Exception {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(tvUser.getSelectionModel().getSelectedItem().getUserID());
        showUser();
    }
    
}
