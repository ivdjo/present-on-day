/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.JadwalDAO;
import com.ivana.presensi.dao.KelasDAO;
import com.ivana.presensi.model.Jadwal;
import com.ivana.presensi.model.Kelas;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class FormJadwalController implements Initializable {
    
    ArrayList<String> listID = null;
    ArrayList<String> listKelas = null;
    ArrayList<String> listKode = null;
    ArrayList<String> listMakul = null;
    ArrayList<String> listMakulID = null;
    ArrayList<String> listDosen = null;
    ArrayList<String> listDosenID = null;
    
    @FXML
    private TableColumn<Jadwal, String> colKelas;
    @FXML
    private TableColumn<Jadwal, String> colKode;
    @FXML
    private TableColumn<Jadwal, String> colMakul;
    @FXML
    private TableColumn<Jadwal, String> colHari;
    @FXML
    private ComboBox<String> comboKelas;
    @FXML
    private Label lblKode;
    @FXML
    private Label lblMakul;
    @FXML
    private Label lblDosen;
    @FXML
    private ComboBox<String> comboHari;
    @FXML
    private ComboBox<String> comboMulai;
    @FXML
    private ComboBox<String> comboAkhir;
    @FXML
    private AnchorPane formJadwal;
    @FXML
    private TableView<Jadwal> tvJadwal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        KelasDAO kelas = new KelasDAO();
        try {
            listID = kelas.getKelasIDList();
            listKelas = kelas.getKelasList();
            listMakulID = kelas.getKelasMakulIDList();
            listKode = kelas.getKelasKodeList();
            listMakul = kelas.getKelasMakulList();
            listDosenID = kelas.getKelasDosenIDList();
            listDosen = kelas.getKelasDosenList();
        } catch (SQLException ex) {
            Logger.getLogger(FormJadwalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboKelas.getItems().addAll(listKelas);
        
        comboHari.setItems(FXCollections.observableArrayList(
                "Senin", 
                "Selasa",
                "Rabu",
                "Kamis",
                "Jumat"
        ));
        comboMulai.setItems(FXCollections.observableArrayList(
                "7.30",
                "10.30",
                "12.30",
                "14.30",
                "16.30"
        ));
        comboAkhir.setItems(FXCollections.observableArrayList(
                "10.20",
                "12.20",
                "14.20",
                "16.20"
        ));
        
        try {
            showJadwal();
        } catch (SQLException ex) {
            Logger.getLogger(FormJadwalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void showJadwal() throws SQLException{
        JadwalDAO jadwalData = new JadwalDAO();
        ObservableList<Jadwal> list = jadwalData.getDataJadwalList();
        
        colKelas.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("kelasNama"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulNama"));
        colKode.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("makulCode"));
        colHari.setCellValueFactory(new PropertyValueFactory<Jadwal, String>("hari"));
        
        tvJadwal.setItems(list);
    }
    
    public void insert() throws Exception{
        JadwalDAO jadwalData = new JadwalDAO();
        jadwalData.insert(
                listID.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                listKelas.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                comboHari.getSelectionModel().getSelectedItem(), 
                comboMulai.getSelectionModel().getSelectedItem(), 
                comboAkhir.getSelectionModel().getSelectedItem(), 
                listMakulID.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                listMakul.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                listDosenID.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                listDosen.get(comboKelas.getSelectionModel().getSelectedIndex()), 
                listKode.get(comboKelas.getSelectionModel().getSelectedIndex())
        );
        
        showJadwal();
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formJadwal,"dashAdmin");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        if(comboKelas.getSelectionModel().getSelectedItem()==null||
                comboHari.getSelectionModel().getSelectedItem()==null||
                comboMulai.getSelectionModel().getSelectedItem()==null||
                comboAkhir.getSelectionModel().getSelectedItem()==null
                )
        {
            System.out.println("Combo select is null");
        }else{
            insert();
        }
    }

    @FXML
    private void btnEdit(ActionEvent event) {
    }

    @FXML
    private void btnHapus(ActionEvent event) {
    }

    @FXML
    private void selectKelas(ActionEvent event) {
        lblKode.setText(listKode.get(comboKelas.getSelectionModel().getSelectedIndex()));
        lblMakul.setText(listMakul.get(comboKelas.getSelectionModel().getSelectedIndex()));
        lblDosen.setText(listDosen.get(comboKelas.getSelectionModel().getSelectedIndex()));
    }
    
}
