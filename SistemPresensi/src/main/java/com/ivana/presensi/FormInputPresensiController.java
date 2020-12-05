/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.PresensiDAO;
import com.ivana.presensi.model.Presensi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ANGKY
 */
public class FormInputPresensiController implements Initializable {

    @FXML
    private AnchorPane formInputPresensi;
    @FXML
    private TableView<Presensi> tvMatakuliah;
    @FXML
    private TableColumn<Presensi, String> colNama;
    @FXML
    private TableColumn<Presensi, String> colStatus;
    @FXML
    private Label lblNamaKelas;
    @FXML
    private Label lblMakul;
    @FXML
    private Label lblKode;
    @FXML
    private Label lblDosen;
    @FXML
    private DatePicker tglPresensi;
    @FXML
    private TextField txtPertemuan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            showPresensi();
        } catch (Exception ex) {
            Logger.getLogger(FormInputPresensiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void showPresensi() throws Exception{
        PresensiDAO presensiData = new PresensiDAO();
        ObservableList<Presensi> list = presensiData.getDataPresensiList();
        
        colNama.setCellValueFactory(new PropertyValueFactory<Presensi, String>("mahasiswaNama"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Presensi, String>("status"));
        
        tvMatakuliah.setItems(list);
    } 

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formInputPresensi,"formPresensi");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnHadir(ActionEvent event) throws SQLException, Exception {
        PresensiDAO presensi = new PresensiDAO();
        presensi.setHadir(tvMatakuliah.getSelectionModel().getSelectedItem().getId(), "Hadir");
        showPresensi();
    }

    @FXML
    private void btnAbsen(ActionEvent event) throws SQLException, Exception {
        PresensiDAO presensi = new PresensiDAO();
        presensi.setHadir(tvMatakuliah.getSelectionModel().getSelectedItem().getId(), "Absen");
        showPresensi();
    }

    @FXML
    private void btnSimpan(ActionEvent event) {
    }
    
}
