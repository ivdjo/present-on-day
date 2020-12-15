/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.dao.MahasiswaDAO;
import com.ivana.presensi.model.Mahasiswa;
import com.ivana.presensi.model.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jordy
 */
public class FormMahasiswaController implements Initializable {

    private User sessionUser;
    
    @FXML
    private TableView<Mahasiswa> tvMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, Integer> colID;
    @FXML
    private TableColumn<Mahasiswa, String> colName;
    @FXML
    private TableColumn<Mahasiswa, String> colGender;
    @FXML
    private TextField txtName;
    @FXML
    private RadioButton rbBoy;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton rbGirl;
    @FXML
    private AnchorPane formMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, String> colNim;
    @FXML
    private TableColumn<Mahasiswa, String> colJurusan;
    @FXML
    private TextField txtNim;
    @FXML
    private ComboBox<String> comboJurusan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession session = UserSession.getInstace(this.sessionUser);
        this.sessionUser = session.getUser();
        comboJurusan.setItems(FXCollections.observableArrayList(
                "Informatika", 
                "Management",
                "Biotek",
                "Sistem Informasi",
                "Akutansi"));
        try {
            showMahasiswa();
        } catch (Exception ex) {
            Logger.getLogger(FormMahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void showMahasiswa() throws Exception{
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        ObservableList<Mahasiswa> list = mahasiswaDAO.getDataMahasiswaList();
        
        colID.setCellValueFactory(new PropertyValueFactory<Mahasiswa, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("name"));
        colNim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        colGender.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("gender"));
        colJurusan.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jurusan"));
        
        tvMahasiswa.setItems(list);
    }  

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        SwitchPane sp = new SwitchPane();
        sp.switchPane(formMahasiswa,"dashAdmin");
    }

    @FXML
    private void btnTambah(ActionEvent event) throws Exception {
        String gender = "";
        if(rbBoy.isSelected()){
            gender = rbBoy.getText();
        }
        else{
            gender = rbGirl.getText();
        }
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        mahasiswaDAO.insertMahasiswa(txtNim.getText(), txtName.getText(), gender, comboJurusan.getSelectionModel().getSelectedItem());
        showMahasiswa();
    }

    @FXML
    private void btnEdit(ActionEvent event) throws SQLException, Exception {
        String gender = "";
        if(rbBoy.isSelected()){
            gender = rbBoy.getText();
        }
        else{
            gender = rbGirl.getText();
        }
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        mahasiswaDAO.editMahasiswa(
                tvMahasiswa.getSelectionModel().getSelectedItem().getId(), 
                txtNim.getText(), 
                txtName.getText(), 
                gender, 
                comboJurusan.getSelectionModel().getSelectedItem());
        showMahasiswa();
    }

    @FXML
    private void btnHapus(ActionEvent event) throws SQLException, Exception {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        mahasiswaDAO.deleteMahasiswa(tvMahasiswa.getSelectionModel().getSelectedItem().getId());
        showMahasiswa();
    }

    @FXML
    private void selectTable(MouseEvent event) {
        Mahasiswa mahasiswa = tvMahasiswa.getSelectionModel().getSelectedItem();
        txtNim.setText(mahasiswa.getNim());
        txtName.setText(mahasiswa.getName());
        if(mahasiswa.getGender().equals("Perempuan")){
            rbGirl.setSelected(true);
        }else{
            rbBoy.setSelected(true);
        }
        comboJurusan.setValue(mahasiswa.getJurusan());
        
    }

    @FXML
    private void select(ActionEvent event) {
        System.out.println(comboJurusan.getSelectionModel().getSelectedIndex());
    }
    
}
