/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.JadwalDAO;
import com.ivana.presensi.model.Jadwal;
import com.ivana.presensi.model.User;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormDosenJadwalController implements Initializable {

    private User sessionUser;
    
    @FXML
    private TableView<Jadwal> tvMatakuliah;
    @FXML
    private TableColumn<Jadwal, String> colKode;
    @FXML
    private TableColumn<Jadwal, String> colMakul;
    @FXML
    private TableColumn<Jadwal, String> colKelas;
    @FXML
    private TableColumn<Jadwal, String> colHari;
    @FXML
    private AnchorPane formDosenJadwal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession session = UserSession.getInstace(this.sessionUser);
        this.sessionUser = session.getUser();
        try {
            showJadwal();
        } catch (SQLException ex) {
            Logger.getLogger(FormDosenJadwalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void showJadwal() throws SQLException{
        JadwalDAO jadwalData = new JadwalDAO();
        ObservableList<Jadwal> list = jadwalData.getDataJadwalList(this.sessionUser.getUserID());
        
        colKelas.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("kelasNama"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulNama"));
        colKode.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulCode"));
        colHari.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("hari"));
        
        tvMatakuliah.setItems(list);
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDosenJadwal,"dashDosen");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    
}
