/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.LaporanDAO;
import com.ivana.presensi.model.Laporan;
import java.io.IOException;
import java.net.URL;
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
 * @author ANGKY
 */
public class FormLaporanController implements Initializable {

    @FXML
    private AnchorPane formLaporan;
    @FXML
    private TableView<Laporan> tvMatakuliah;
    @FXML
    private TableColumn<Laporan, String> colPertemuan;
    @FXML
    private TableColumn<Laporan, String> colKode;
    @FXML
    private TableColumn<Laporan, String> colMakul;
    @FXML
    private TableColumn<Laporan, String> colTanggal;
    @FXML
    private TextField txtSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            showLaporan();
        } catch (Exception ex) {
            Logger.getLogger(FormLaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLaporan() throws Exception{
        LaporanDAO laporanData = new LaporanDAO();
        ObservableList<Laporan> list = laporanData.getDataLaporanList();
        
        colPertemuan.setCellValueFactory(new PropertyValueFactory<Laporan, String>("pertemuan"));
        colKode.setCellValueFactory(new PropertyValueFactory<Laporan, String>("makulCode"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Laporan, String>("makulNama"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<Laporan, String>("tanggal"));
        
        tvMatakuliah.setItems(list);
    }  
    
    public void showLaporan(String cari) throws Exception{
        LaporanDAO laporanData = new LaporanDAO();
        ObservableList<Laporan> list = laporanData.getDataLaporanList(cari);
        
        colPertemuan.setCellValueFactory(new PropertyValueFactory<Laporan, String>("pertemuan"));
        colKode.setCellValueFactory(new PropertyValueFactory<Laporan, String>("makulCode"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Laporan, String>("makulNama"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<Laporan, String>("tanggal"));
        
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
    private void btnDetail(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formLaporan,"formLaporanDetail");
    }

    @FXML
    private void btnSearch(ActionEvent event) throws Exception {
        showLaporan(txtSearch.getText());
    }
    
}
