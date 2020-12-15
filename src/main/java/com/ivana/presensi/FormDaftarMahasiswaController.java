/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.KelasKuotaDAO;
import com.ivana.presensi.dao.MahasiswaDAO;
import com.ivana.presensi.model.Kelas;
import com.ivana.presensi.model.Mahasiswa;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormDaftarMahasiswaController implements Initializable {

    private Kelas kelasSession;
    
    @FXML
    private AnchorPane formDaftarMahasiswa;
    @FXML
    private TableView<Mahasiswa> tvMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, String> colID;
    @FXML
    private TableColumn<Mahasiswa, String> colNim;
    @FXML
    private TableColumn<Mahasiswa, String> colNama;
    @FXML
    private TableColumn<Mahasiswa, String> colGender;
    @FXML
    private TableColumn<Mahasiswa, String> colJurusan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        KelasSession kelas = KelasSession.getInstace(this.kelasSession);
        this.kelasSession = kelas.getKelas();
        
        try {
            showMahasiswa();
        } catch (Exception ex) {
            Logger.getLogger(FormDaftarMahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void insert() throws IOException, Exception{
        String mahasiswaID = Integer.toString(tvMahasiswa.getSelectionModel().getSelectedItem().getId());
        String mahasiswaNim = tvMahasiswa.getSelectionModel().getSelectedItem().getNim();
        String mahasiswaNama = tvMahasiswa.getSelectionModel().getSelectedItem().getName();
        String kelasID = Integer.toString(this.kelasSession.getId());
        String kelasNama = this.kelasSession.getKelasNama();
        String dosenID = this.kelasSession.getUserID();
        String dosenNama = this.kelasSession.getUserNama();
        String makulID = this.kelasSession.getMakulID();
        String makulCode = this.kelasSession.getMakulCode();
        String makulNama = this.kelasSession.getMakulNama();
        
        KelasKuotaDAO kelasKuota = new KelasKuotaDAO();
        kelasKuota.insert(mahasiswaID, mahasiswaNim, mahasiswaNama, kelasID, kelasNama, dosenID, dosenNama, makulID, makulCode, makulNama);
        
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDaftarMahasiswa,"formDaftarKuotaMahasiswa");
    }
    
    public void showMahasiswa() throws Exception{
        MahasiswaDAO mahasiswaData = new MahasiswaDAO();
        ObservableList<Mahasiswa> list = mahasiswaData.getDataMahasiswaList();
        
        colNama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("name"));
        colNim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        colGender.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("gender"));
        colJurusan.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jurusan"));
        
        tvMahasiswa.setItems(list);
    } 

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDaftarMahasiswa,"formDaftarKuotaMahasiswa");
    }

    @FXML
    private void selectKelas(MouseEvent event) {
    }

    @FXML
    private void btnDaftar(ActionEvent event) throws Exception {
        insert();
    }
    
}
