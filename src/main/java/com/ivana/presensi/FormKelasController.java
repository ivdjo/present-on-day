/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.KelasDAO;
import com.ivana.presensi.dao.MatakuliahDAO;
import com.ivana.presensi.model.Kelas;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormKelasController implements Initializable {

    ArrayList<String> list = null;
    ArrayList<String> listID = null;
    ArrayList<String> listKode = null;
    ArrayList<String> listDosenID = null;
    ArrayList<String> listDosen = null;
    
    @FXML
    private AnchorPane formKelas;
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
    @FXML
    private TextField txtKelas;
    @FXML
    private ComboBox<String> comboMakul;
    @FXML
    private Label lblKode;
    @FXML
    private Label lblDosen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MatakuliahDAO makul = new MatakuliahDAO();
        try {
            list = makul.getMakulList();
            listID = makul.getMakulIDList();
            listKode = makul.getKodeMakulList();
            listDosen = makul.getDosenList();
            listDosenID = makul.getDosenIDList();
        } catch (SQLException ex) {
            Logger.getLogger(FormKelasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboMakul.getItems().addAll(list);
        
        try {
            // TODO
            showKelas();
        } catch (Exception ex) {
            Logger.getLogger(FormKelasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void insert() throws Exception{
        
        if(txtKelas.getText().equals("") || comboMakul.getSelectionModel().getSelectedItem()==null){
            
        }else{
            KelasDAO kelasData = new KelasDAO();
            kelasData.insert(
                    txtKelas.getText(), 
                    listID.get(comboMakul.getSelectionModel().getSelectedIndex()), 
                    comboMakul.getSelectionModel().getSelectedItem(), 
                    listDosenID.get(comboMakul.getSelectionModel().getSelectedIndex()),
                    lblDosen.getText(),
                    lblKode.getText()
            );
            
            showKelas();
        }
        
    }
    
    public void delete() throws SQLException, Exception{
        KelasDAO kelasData = new KelasDAO();
            kelasData.delete(tvKelas.getSelectionModel().getSelectedItem().getId());
            
            showKelas();
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
        sp.switchPane(formKelas,"dashAdmin");
    }


    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        insert();
    }


    @FXML
    private void btnHapus(ActionEvent event) throws Exception {
        delete();
    }

    @FXML
    private void selectMakul(ActionEvent event) {
        lblKode.setText(listKode.get(comboMakul.getSelectionModel().getSelectedIndex()));
        lblDosen.setText(listDosen.get(comboMakul.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void selectKelas(MouseEvent event) {
        Kelas kelas = tvKelas.getSelectionModel().getSelectedItem();
        lblKode.setText(kelas.getMakulCode());
        lblDosen.setText(kelas.getUserNama());
        txtKelas.setText(kelas.getKelasNama());
        comboMakul.setValue(kelas.getMakulNama());
    }
    
}
