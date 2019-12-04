package com.example.rooms.service;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;
import com.example.rooms.persistence.AppDatabase;
import com.example.rooms.persistence.dao.PianetaDao;

import java.util.List;

public class PianetaService {

    private String DB_NAME = "pianeti";

    private Context context;

    public PianetaService(){

    }

    public PianetaService(Context context){
        this.context = context;
    }


    /**
     * Trova tutti i pianeti
     *
     * @return
     */
    public List<Pianeta> findAll(){


        // Crea il db
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        // Recupera tutti i pianeti
        db.close();
        return dao.findAll();
    }


    public void insert(Pianeta pianeta){
        // Crea il db
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();

        dao.insert(pianeta);
    }

    public void insert(final List<Pianeta> pianeti){
        /*
        LogUtil.debug("Inizio creazione pianeti nel database");
        // Crea il db
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        dao.insert(pianeti);
        db.close();
        LogUtil.debug("Fine creazione pianeti nel database");
        */


        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                LogUtil.debug("Inizio creazione pianeti nel database");
                // Crea il db
                AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
                // Recupera il DAO
                PianetaDao dao = db.pianetaDao();
                dao.insert(pianeti);
                db.close();
                LogUtil.debug("Fine creazione pianeti nel database");
                return null;
            }
        }.execute();


    }
}
