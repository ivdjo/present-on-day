/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.MatakuliahDAO;
import com.ivana.presensi.dao.UserDAO;
import com.ivana.presensi.model.Matakuliah;
import com.ivana.presensi.model.User;
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
public class FormMatakuliahController implements Initializable {

    private User sessionUser;
    ArrayList<String> list = null;
    ArrayList<String> listId = null;
    
    @FXML
    private AnchorPane formMakul;
    @FXML
    private TableView<Matakuliah> tvMatakuliah;
    @FXML
    private TableColumn<Matakuliah, Integer> colID;
    @FXML
    private TableColumn<Matakuliah, Integer> colKodeMakul;
    @FXML
    private TableColumn<Matakuliah, String> colNamaMakul;
    @FXML
    private TableColumn<Matakuliah, String> colDosen;
    @FXML
    private TextField txtKode;
    @FXML
    private TextField txtMakul;
    @FXML
    private ComboBox<String> comboDosen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession session = UserSession.getInstace(this.sessionUser);
        this.sessionUser = session.getUser();
        UserDAO user = new UserDAO();
        
        try {
            list = user.getDosenList();
            listId = user.getIDDosenList();
        } catch (SQLException ex) {
            Logger.getLogger(FormMatakuliahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboDosen.getItems().addAll(list);
        try {
            showMakul();
        } catch (Exception ex) {
            Logger.getLogger(FormMatakuliahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void showMakul() throws Exception{
        MatakuliahDAO makulDAO = new MatakuliahDAO();
        ObservableList<Matakuliah> list = makulDAO.getDataMatakuliahList();
        
        colID.setCellValueFactory(new PropertyValueFactory<Matakuliah, Integer>("id"));
        colKodeMakul.setCellValueFactory(new PropertyValueFactory<Matakuliah, Integer>("kode"));
        colNamaMakul.setCellValueFactory(new PropertyValueFactory<Matakuliah, String>("nama"));
        colDosen.setCellValueFactory(new PropertyValueFactory<Matakuliah, String>("dosen"));
        
        tvMatakuliah.setItems(list);
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formMakul,"dashAdmin");
    }

    @FXML
    private void selectTable(MouseEvent event) {
        Matakuliah matakuliah = tvMatakuliah.getSelectionModel().getSelectedItem();
        txtKode.setText(matakuliah.getKode());
        txtMakul.setText(matakuliah.getNama());
        comboDosen.setValue(matakuliah.getDosen());
    }

    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        MatakuliahDAO makul = new MatakuliahDAO();
        makul.insertMakul(txtKode.getText(), txtMakul.getText(), listId.get(comboDosen.getSelectionModel().getSelectedIndex()), comboDosen.getSelectionModel().getSelectedItem());
        showMakul();
    }

    @FXML
    private void btnEdit(ActionEvent event) throws SQLException, Exception {
        MatakuliahDAO makul = new MatakuliahDAO();
        makul.editMakul(
                tvMatakuliah.getSelectionModel().getSelectedItem().getId(), 
                txtKode.getText(), 
                txtMakul.getText(), 
                listId.get(comboDosen.getSelectionModel().getSelectedIndex()), 
                comboDosen.getSelectionModel().getSelectedItem());
        showMakul();
    }

    @FXML
    private void btnHapus(ActionEvent event) throws SQLException, Exception {
        MatakuliahDAO makul = new MatakuliahDAO();
        makul.deleteMakul(tvMatakuliah.getSelectionModel().getSelectedItem().getId());
        showMakul();
    }

    @FXML
    private void select(ActionEvent event) {
        System.out.println("index :"+comboDosen.getSelectionModel().getSelectedIndex());
        System.out.println("id user: "+listId.get(comboDosen.getSelectionModel().getSelectedIndex()));
    }
    
}
