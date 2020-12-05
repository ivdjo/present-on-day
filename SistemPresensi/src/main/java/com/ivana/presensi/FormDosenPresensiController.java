/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ANGKY
 */
public class FormDosenPresensiController implements Initializable {

    @FXML
    private AnchorPane formDosenPresensi;
    @FXML
    private TableView<?> tvMatakuliah;
    @FXML
    private TableColumn<?, ?> colKelas;
    @FXML
    private TableColumn<?, ?> colKode;
    @FXML
    private TableColumn<?, ?> colMakul;
    @FXML
    private TableColumn<?, ?> colHari;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDosenPresensi,"dashDosen");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnPIlih(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDosenPresensi,"formDosenInputPresensi");
    }
    
}
