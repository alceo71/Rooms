package com.example.rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;
import com.example.rooms.model.PianetaConSatelliti;
import com.example.rooms.model.Satellite;
import com.example.rooms.persistence.SistemaSolareDatabase;
import com.example.rooms.persistence.dao.PianetaDao;
import com.example.rooms.service.FindAllQueryTask;
import com.example.rooms.service.PianetaConSatelliteService;
import com.example.rooms.service.PianetaService;
import com.example.rooms.service.SatelliteService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FindAllQueryTask.PianetiCaricatiListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inizializzaPianeti();


/*
        PianetaService service = new PianetaService(this);
        Pianeta pianeta = service.getPerNome("terra");
        LogUtil.debug("TERRA " + pianeta.getId());

        // inizializzaPianeti();

        // datiPianeti();
        // inserisciLuna(3);


        PianetaConSatelliteService service = new PianetaConSatelliteService(this);

        List<PianetaConSatelliti> pianeti = service.findAll();

        if(pianeti.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (PianetaConSatelliti pianeta : pianeti) {
                sb.append(pianeta.pianeta.getId() + " " + pianeta.pianeta.getNome() + System.getProperty("line.separator"));

                if(pianeta.sateliti != null){
                    for(Satellite satellite:pianeta.sateliti){
                        sb.append(  "---" + satellite.getId() + " " + satellite.getNome() +  System.getProperty("line.separator"));
                    }
                }

            }
            ((TextView) findViewById(R.id.testo)).setText(sb.toString());
        }
        LogUtil.debug("numero pianeti " + pianeti.size());
*/


        // Recupera tutti i pianeti


        /*
        PianetaService pianetaService = new PianetaService(this);

        Pianeta pianeta = new Pianeta();
        pianeta.setNome("Qualcosa");

        pianetaService.insert(pianeta);
        */

        /*

        */

    }


    public void mostraPianeti(){
        FindAllQueryTask task = new FindAllQueryTask(this, this);
        task.execute();
    }


    public void inizializzaPianeti(){

        // Eseguiamo in un thread separato e aspettiamo la risposta

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                PianetaService pianetaService = new PianetaService(getApplicationContext());
                List<Pianeta> pianeti = datiPianeti();
                LogUtil.debug("Prima di insert");
                pianetaService.insert(pianeti);
                LogUtil.debug("Dopo di insert");
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Dati caricati", Toast.LENGTH_LONG).show();
                mostraPianeti();
            }
        }.execute();



    }


    public List<Pianeta> datiPianeti(){
        List<Pianeta> result = new ArrayList<Pianeta>();
        result.add(new Pianeta("mercurio", 0.39,88, 1416, 0.06, 0.38,0));
        result.add(new Pianeta("venere", 0.72,225, 5832, 0.82, 0.95,0));
        result.add(new Pianeta("terra", 1,365, 24, 1, 1,1));
        result.add(new Pianeta("marte", 1.52,687, 25, 0.11, 0.53,2));
        result.add(new Pianeta("giove", 5.20,4380, 10, 317.89, 11.19,63));
        result.add(new Pianeta("saturno", 9.54,10585, 10, 95.15, 9.44,61));
        result.add(new Pianeta("urano", 19.2,30660, 18, 14.54, 4.10,27));
        result.add(new Pianeta("nettuno", 30.06,60225, 18, 17.23, 3.88,14));
        return result;
    }


    public void inserisciLuna(int idTerra){
        Satellite satellite = new Satellite();
        satellite.setIdPianeta(idTerra);
        satellite.setMassa(0.12);
        satellite.setNome("Luna");
        SatelliteService satelliteService = new SatelliteService(this);
        satelliteService.insert(satellite);
    }

    @Override
    public void datiRicevuti(List<Pianeta> pianeti) {
        if(pianeti.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (Pianeta pianeta : pianeti) {
                sb.append(pianeta.getId() + " " + pianeta.getNome() + System.getProperty("line.separator"));
            }
            ((TextView) findViewById(R.id.testo)).setText(sb.toString());
        }
        LogUtil.debug("numero pianeti " + pianeti.size());
    }
}
