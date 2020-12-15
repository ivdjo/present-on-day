/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.JadwalDAO;
import com.ivana.presensi.model.Jadwal;
import com.ivana.presensi.model.Laporan;
import com.ivana.presensi.model.Pertemuan;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormLaporanController implements Initializable {

    private Jadwal jadwalSession;
    
    @FXML
    private AnchorPane formLaporan;
    @FXML
    private TableView<Jadwal> tvMatakuliah;
    private TableColumn<Jadwal, String> colPertemuan;
    @FXML
    private TableColumn<Jadwal, String> colKode;
    @FXML
    private TableColumn<Jadwal, String> colMakul;
    private TableColumn<Jadwal, String> colTanggal;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableColumn<Jadwal, String> colKelas;
    @FXML
    private TableColumn<Jadwal, String> colDosen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JadwalSession jadwal = JadwalSession.getInstace(this.jadwalSession);
        jadwal.cleanJadwalSession();
        
        try {
            showJadwal();
        } catch (SQLException ex) {
            Logger.getLogger(FormLaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showJadwal() throws SQLException{
        JadwalDAO jadwalData = new JadwalDAO();
        ObservableList<Jadwal> list = jadwalData.getDataJadwalList();
        
        colKelas.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("kelasNama"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulNama"));
        colKode.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulCode"));
        colDosen.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("userNama"));
        
        tvMatakuliah.setItems(list);
    }
    
    public void showJadwal(String cari) throws SQLException{
        JadwalDAO jadwalData = new JadwalDAO();
        ObservableList<Jadwal> list = jadwalData.getDataJadwalList(cari);
        
        colKelas.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("kelasNama"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulNama"));
        colKode.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulCode"));
        colDosen.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("userNama"));
        
        tvMatakuliah.setItems(list);
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formLaporan,"dashAdmin");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnDetail(ActionEvent event) throws IOException, SQLException {
        JadwalDAO jadwal = new JadwalDAO();
        Jadwal temp = jadwal.getJadwal(tvMatakuliah.getSelectionModel().getSelectedItem().getId());
        
        this.jadwalSession = temp;
        JadwalSession.getInstace(this.jadwalSession);
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formLaporan,"formLaporanDetail");
    }

    @FXML
    private void btnSearch(ActionEvent event) throws Exception {
        showJadwal(txtSearch.getText());
    }
    
}
