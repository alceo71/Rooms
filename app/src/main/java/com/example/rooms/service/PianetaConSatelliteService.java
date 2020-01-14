package com.example.rooms.service;

import android.content.Context;

import com.example.rooms.model.PianetaConSatelliti;
import com.example.rooms.persistence.SistemaSolareDatabase;
import com.example.rooms.persistence.dao.PianetaConSatellitiDao;
import com.example.rooms.persistence.dao.PianetaDao;

import java.util.List;

public class PianetaConSatelliteService {

    private static Context context;


    public PianetaConSatelliteService(Context context){
        this.context = context;
    }


    public List<PianetaConSatelliti> findAll(){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaConSatellitiDao dao = db.pianetaConSatellitiDao();
        // Recupera tutti i pianeti
        return dao.findAll();
    }

}
