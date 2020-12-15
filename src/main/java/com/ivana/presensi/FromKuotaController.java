/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.KelasDAO;
import com.ivana.presensi.model.Kelas;
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
public class FromKuotaController implements Initializable {

    private Kelas kelasSession;
    
    @FXML
    private AnchorPane formKuota;
    @FXML
    private TableView<Kelas> tvKelas;
    @FXML
    private TableColumn<Kelas, Integer> colID;
    @FXML
    private TableColumn<Kelas, String> colNama;
    @FXML
    private TableColumn<Kelas, String> colKode;
    @FXML
    private TableColumn<Kelas, String> colMakul;
    @FXML
    private TableColumn<Kelas, String> colDosen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        KelasSession kelas = KelasSession.getInstace(this.kelasSession);
        kelas.cleanKelasSession();
        
        try {
            // TODO
            showKelas();
        } catch (Exception ex) {
            Logger.getLogger(FromKuotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void showKelas() throws Exception{
        KelasDAO kelasDAO = new KelasDAO();
        ObservableList<Kelas> list = kelasDAO.getDataKelasList();
        
        colNama.setCellValueFactory(new PropertyValueFactory<Kelas, String>("kelasNama"));
        colMakul.setCellValueFactory(new PropertyValueFactory<Kelas, String>("makulNama"));
        colKode.setCellValueFactory(new PropertyValueFactory<Kelas, String>("makulCode"));
        colDosen.setCellValueFactory(new PropertyValueFactory<Kelas, String>("userNama"));
        
        tvKelas.setItems(list);
    } 

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formKuota,"dashAdmin");
    }

    @FXML
    private void selectKelas(MouseEvent event) {
    }

    @FXML
    private void btnDaftar(ActionEvent event) throws IOException, SQLException {
        KelasDAO kelas = new KelasDAO();
        Kelas temp = kelas.getKelas(tvKelas.getSelectionModel().getSelectedItem().getId());
        
        this.kelasSession = temp;
        KelasSession.getInstace(this.kelasSession);
        
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formKuota,"formDaftarKuotaMahasiswa");
    }
    
}
