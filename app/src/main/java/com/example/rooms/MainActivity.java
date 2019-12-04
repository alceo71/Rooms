package com.example.rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;
import com.example.rooms.service.PianetaService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // Recupera tutti i pianeti
        PianetaService pianetaService = new PianetaService(this);
        List<Pianeta> pianeti = pianetaService.findAll();

        if(pianeti.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (Pianeta pianeta : pianeti) {
                sb.append(pianeta.getId() + " " + pianeta.getNome() + System.getProperty("line.separator"));
            }
            ((TextView) findViewById(R.id.testo)).setText(sb.toString());
        }
        LogUtil.debug("numero pianeti " + pianeti.size());


        if(pianeti.size() == 0){
            List<Pianeta> result = new ArrayList<Pianeta>();

            result.add(new Pianeta("mercurio", 0.39,88, 1416, 0.06, 0.38,0));
            result.add(new Pianeta("venere", 0.72,225, 5832, 0.82, 0.95,0));
            result.add(new Pianeta("terra", 1,365, 24, 1, 1,1));
            result.add(new Pianeta("marte", 1.52,687, 25, 0.11, 0.53,2));
            result.add(new Pianeta("giove", 5.20,4380, 10, 317.89, 11.19,63));
            result.add(new Pianeta("saturno", 9.54,10585, 10, 95.15, 9.44,61));
            result.add(new Pianeta("urano", 19.2,30660, 18, 14.54, 4.10,27));
            result.add(new Pianeta("nettuno", 30.06,60225, 18, 17.23, 3.88,14));

            LogUtil.debug("Prima di insert");
            pianetaService.insert(result);
            LogUtil.debug("Dopo di insert");

        }


    }
}
