/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.KelasKuotaDAO;
import com.ivana.presensi.model.Kelas;
import com.ivana.presensi.model.KelasKuota;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormDaftarKuotaMahasiswaController implements Initializable {
    
    private Kelas kelasSession;
   
    @FXML
    private TableView<KelasKuota> tvMahasiswa;
    @FXML
    private TableColumn<KelasKuota, String> colID;
    @FXML
    private TableColumn<KelasKuota, String> colNim;
    @FXML
    private TableColumn<KelasKuota, String> colNama;
    @FXML
    private Label lblKelas;
    @FXML
    private Label lblKode;
    @FXML
    private Label lblMakul;
    @FXML
    private Label lblDosen;
    @FXML
    private AnchorPane formDaftarKuota;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        KelasSession kelas = KelasSession.getInstace(this.kelasSession);
        this.kelasSession = kelas.getKelas();
        
        lblKelas.setText(this.kelasSession.getKelasNama());
        lblKode.setText(this.kelasSession.getMakulCode());
        lblMakul.setText(this.kelasSession.getMakulNama());
        lblDosen.setText(this.kelasSession.getUserNama());
        
        try {
            showKelasKuota();
        } catch (SQLException ex) {
            Logger.getLogger(FormDaftarKuotaMahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
    public void showKelasKuota() throws SQLException{
        KelasKuotaDAO kelasKuotaDAO = new KelasKuotaDAO();
        ObservableList<KelasKuota> list = kelasKuotaDAO.getDataKelasKuotaList(this.kelasSession.getId());
        
        colNama.setCellValueFactory(new PropertyValueFactory<KelasKuota, String>("mahasiswaNama"));
        colNim.setCellValueFactory(new PropertyValueFactory<KelasKuota, String>("mahasiswaNim"));
        
        tvMahasiswa.setItems(list);
    }
    
    public void delete() throws SQLException{
        KelasKuotaDAO kelasKuotaData = new KelasKuotaDAO();
        
        kelasKuotaData.delete(tvMahasiswa.getSelectionModel().getSelectedItem().getId());
        showKelasKuota();
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDaftarKuota,"fromKuota");
    }

    @FXML
    private void selectKelas(MouseEvent event) {
    }

    @FXML
    private void btnTambah(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDaftarKuota,"formDaftarMahasiswa");
    }

    @FXML
    private void btnHapus(ActionEvent event) throws SQLException {
        delete();
    }
    
}
