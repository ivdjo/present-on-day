/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivana.presensi;

import com.ivana.presensi.model.Pertemuan;

/**
 *
 * @author Jordy
 */
public class TatapMukaSession {
    private static TatapMukaSession instance;

    private Pertemuan currentPertemuan;
    
    private TatapMukaSession(Pertemuan pertemuanInput) {
        this.currentPertemuan = pertemuanInput;
//        this.privileges = privileges;
    }
    
    public static TatapMukaSession getInstace(Pertemuan pertemuanInput) {
        if(instance == null) {
            instance = new TatapMukaSession(pertemuanInput);
        }
        return instance;
    }

    public Pertemuan getPertemuan() {
        return currentPertemuan;
    }


    public void cleanPertemuanSession() {
        currentPertemuan = null;// or null
        instance = null;
    }
    
    public void update(Pertemuan newPertemuan){
        this.currentPertemuan = newPertemuan;
    }
}
