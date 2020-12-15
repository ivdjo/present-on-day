/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.model.Presensi;

/**
 *
 * @author Jordy
 */
public class PresensiSession {
    private static PresensiSession instance;

    private Presensi currentPresensi;
    
    private PresensiSession(Presensi presensiInput) {
        this.currentPresensi = presensiInput;
//        this.privileges = privileges;
    }
    
    public static PresensiSession getInstace(Presensi presensiInput) {
        if(instance == null) {
            instance = new PresensiSession(presensiInput);
        }
        return instance;
    }

    public Presensi getPresensi() {
        return currentPresensi;
    }


    public void cleanPresensiSession() {
        currentPresensi = null;// or null
        instance = null;
    }
    
    public void update(Presensi newPresensi){
        this.currentPresensi = newPresensi;
    }
}
