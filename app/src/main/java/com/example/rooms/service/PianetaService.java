package com.example.rooms.service;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;
import com.example.rooms.persistence.SistemaSolareDatabase;
import com.example.rooms.persistence.dao.PianetaDao;

import java.util.List;

public class PianetaService {

    private static Context context;


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
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        // Recupera tutti i pianeti
        return dao.findAll();
    }


    public void insert(Pianeta pianeta){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        dao.insert(pianeta);
    }

    public void insert(final List<Pianeta> pianeti){
        /*
        LogUtil.debug("Inizio creazione pianeti nel database");
        // Crea il db
        SistemaSolareDatabase db = Room.databaseBuilder(context, SistemaSolareDatabase.class, DB_NAME).allowMainThreadQueries().build();
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
                SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
                // Recupera il DAO
                PianetaDao dao = db.pianetaDao();
                dao.insert(pianeti);
                db.close();
                LogUtil.debug("Fine creazione pianeti nel database");
                return null;
            }
        }.execute();


    }


    private static class FindAllQueryTask extends AsyncTask<Void, Void, List<Pianeta>>{

        @Override
        protected List<Pianeta> doInBackground(Void... voids) {
            // Crea il db
            SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
            // Recupera il DAO
            PianetaDao dao = db.pianetaDao();
            // Recupera tutti i pianeti
            db.close();
            return dao.findAll();
        }

        @Override
        protected void onPostExecute(List<Pianeta> pianetas) {
            super.onPostExecute(pianetas);
        }
    }

}
