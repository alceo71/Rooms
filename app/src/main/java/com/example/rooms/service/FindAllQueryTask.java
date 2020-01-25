package com.example.rooms.service;

import android.content.Context;
import android.os.AsyncTask;

import com.example.rooms.model.Pianeta;
import com.example.rooms.persistence.SistemaSolareDatabase;
import com.example.rooms.persistence.dao.PianetaDao;

import java.util.List;

public class FindAllQueryTask  extends AsyncTask<Void, Void, List<Pianeta>> {
    public PianetiCaricatiListener pianetiCaricatiListener;
    public Context context;

    public FindAllQueryTask(PianetiCaricatiListener pianetiCaricatiListener, Context context){
        this.pianetiCaricatiListener = pianetiCaricatiListener;
        this.context = context;
    }

    @Override
    protected List<Pianeta> doInBackground(Void... voids) {
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(this.context);
        PianetaDao dao = db.pianetaDao();
        db.close();
        return dao.findAll();
    }

    @Override
    protected void onPostExecute(List<Pianeta> pianeti) {
        pianetiCaricatiListener.datiRicevuti(pianeti);
    }


    public interface PianetiCaricatiListener{
        public void datiRicevuti(List<Pianeta> pianeti);
    }
}
