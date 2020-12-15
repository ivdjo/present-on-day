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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class LoginController implements Initializable {

    private User sessionUser;
    
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private AnchorPane signIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLogin(ActionEvent event) throws Exception {
        UserDAO dao = new UserDAO();
        User temp = dao.getUser(txtUsername.getText(), txtPassword.getText());
        if(temp == null){
                System.out.println("User not found");
            }else{
                this.sessionUser = temp;
                UserSession.getInstace(this.sessionUser);
                if(this.sessionUser.getLevel().equals("admin")){
                    SwitchPane sp = new SwitchPane();
                    sp.switchPane(signIn,"dashAdmin");
                    System.out.println("Login Successs : "+this.sessionUser.getLevel());
                }else{
                    SwitchPane sp = new SwitchPane();
                    sp.switchPane(signIn,"dashDosen");
                }
            }
    }

    @FXML
    private void btnSignUp(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(signIn,"signUp");
    }
    
}
