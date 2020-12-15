/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.PertemuanDAO;
import com.ivana.presensi.dao.PresensiDAO;
import com.ivana.presensi.model.Jadwal;
import com.ivana.presensi.model.Pertemuan;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
 * @author Jordy
 */
public class FormDosenTatapMukaController implements Initializable {

    private Jadwal jadwalSession;
    private Pertemuan pertemuanSession;
    
    @FXML
    private AnchorPane formDosenTatapMuka;
    @FXML
    private TableView<Pertemuan> tvTatapMuka;
    @FXML
    private TableColumn<Pertemuan, String> colPertemuan;
    @FXML
    private TableColumn<Pertemuan, String> colTanggal;
    @FXML
    private Label lblKelas;
    @FXML
    private Label lblMakul;
    @FXML
    private Label lblKode;
    @FXML
    private TextField txtPertemuan;
    @FXML
    private DatePicker dpTanggal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JadwalSession jadwal = JadwalSession.getInstace(this.jadwalSession);
        this.jadwalSession = jadwal.getJadwal();
        
        TatapMukaSession pertemuan = TatapMukaSession.getInstace(this.pertemuanSession);
        pertemuan.cleanPertemuanSession();
        
        lblKelas.setText(this.jadwalSession.getKelasNama());
        lblMakul.setText(this.jadwalSession.getMakulNama());
        lblKode.setText(this.jadwalSession.getMakulCode());
        
        try {
            showPertemuan();
        } catch (SQLException ex) {
            Logger.getLogger(FormDosenTatapMukaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void showPertemuan() throws SQLException{
        PertemuanDAO pertemuanData = new PertemuanDAO();
        ObservableList<Pertemuan> list = pertemuanData.getDataPertemuanList(this.jadwalSession.getId());
        
        colPertemuan.setCellValueFactory(new PropertyValueFactory<Pertemuan, String>("nama"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<Pertemuan, String>("tanggal"));
        
        tvTatapMuka.setItems(list);
    }
    
    public void insert() throws Exception{
        if(txtPertemuan.getText().equals("") || dpTanggal.getValue()==null){
            
        }else{
            PertemuanDAO pertemuan = new PertemuanDAO();
            pertemuan.insert(txtPertemuan.getText(), dpTanggal.getValue().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")), this.jadwalSession.getId());
            
            PresensiDAO presensi = new PresensiDAO();
            presensi.insertMahasiswa(Integer.toString(this.jadwalSession.getId()), this.jadwalSession.getMakulID(), this.jadwalSession.getUserID(), this.jadwalSession.getKelasID(), this.jadwalSession.getKelasNama(), this.jadwalSession.getUserNama(), this.jadwalSession.getMakulNama(), this.jadwalSession.getMakulCode(), this.jadwalSession.getJamMulai(), this.jadwalSession.getJamBerakhir());
            
            txtPertemuan.setText("");
            dpTanggal.setValue(null);
            showPertemuan();
        }
        
    }
    
    public void delete() throws SQLException{
        PertemuanDAO pertemuan = new PertemuanDAO();
        pertemuan.delete(tvTatapMuka.getSelectionModel().getSelectedItem().getId());
        showPertemuan();
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDosenTatapMuka,"formDosenPresensi");
    }

    @FXML
    private void selectTable(MouseEvent event) {
    }

    @FXML
    private void btnPresensi(ActionEvent event) throws IOException, SQLException {
        PertemuanDAO pertemuanData = new PertemuanDAO();
        Pertemuan temp = pertemuanData.getPertemuan(tvTatapMuka.getSelectionModel().getSelectedItem().getId());
        
        this.pertemuanSession = temp;
        TatapMukaSession.getInstace(this.pertemuanSession);
        
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formDosenTatapMuka,"formDosenInputPresensi");
    }

    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        insert();
    }

    @FXML
    private void btnHapus(ActionEvent event) throws SQLException {
        delete();
    }
    
}
