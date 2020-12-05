/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author ANGKY
 */
class SwitchPane {
    protected void switchPane(AnchorPane border, String name)throws IOException{
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource(name+".fxml"));
            border.getChildren().setAll(pane);
        }catch(IOException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(""+ex);
        }
    }
}
