/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.LaporanDAO;
import com.ivana.presensi.model.Jadwal;
import com.ivana.presensi.model.Laporan;
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
 * @author Jordy
 */
public class FormLaporanDetailController implements Initializable {

    private Jadwal jadwalSession;
    
    @FXML
    private AnchorPane formLaporanDetail;
    @FXML
    private Label lblNamaKelas;
    @FXML
    private Label lblMakul;
    @FXML
    private Label lblKode;
    @FXML
    private Label lblDosen;
    @FXML
    private TableView<Laporan> tvMatakuliah;
    @FXML
    private TableColumn<Laporan, String> colNama;
    @FXML
    private TableColumn<Laporan, String> colKehadiran;
    @FXML
    private TableColumn<Laporan, String> colPersentase;
    @FXML
    private TextField txtSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JadwalSession jadwal = JadwalSession.getInstace(this.jadwalSession);
        this.jadwalSession = jadwal.getJadwal();
        
        lblNamaKelas.setText(this.jadwalSession.getKelasNama());
        lblMakul.setText(this.jadwalSession.getMakulNama());
        lblKode.setText(this.jadwalSession.getMakulCode());
        lblDosen.setText(this.jadwalSession.getUserNama());
        
        try {
            showLaporan();
        } catch (SQLException ex) {
            Logger.getLogger(FormLaporanDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void showLaporan() throws SQLException{
        LaporanDAO laporan = new LaporanDAO();
        ObservableList<Laporan> list = laporan.getDataJadwalList(this.jadwalSession.getId());
        
        colNama.setCellValueFactory(new PropertyValueFactory<Laporan, String>("mahasiswaNama"));
        colKehadiran.setCellValueFactory(new PropertyValueFactory<Laporan, String>("kehadiran"));
        colPersentase.setCellValueFactory(new PropertyValueFactory<Laporan, String>("persentase"));
        
        tvMatakuliah.setItems(list);
    }
    
    public void showLaporan(String search) throws SQLException{
        LaporanDAO laporan = new LaporanDAO();
        ObservableList<Laporan> list = laporan.getDataJadwalList(this.jadwalSession.getId(),search);
        
        colNama.setCellValueFactory(new PropertyValueFactory<Laporan, String>("mahasiswaNama"));
        colKehadiran.setCellValueFactory(new PropertyValueFactory<Laporan, String>("kehadiran"));
        colPersentase.setCellValueFactory(new PropertyValueFactory<Laporan, String>("persentase"));
        
        tvMatakuliah.setItems(list);
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formLaporanDetail,"formLaporan");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnSearch(ActionEvent event) throws SQLException {
        showLaporan(txtSearch.getText());
    }
    
}
