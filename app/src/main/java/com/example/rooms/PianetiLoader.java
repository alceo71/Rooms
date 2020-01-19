package com.example.rooms;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;
import com.example.rooms.service.PianetaService;

import java.util.List;


/**
 * https://developer.android.com/reference/android/content/AsyncTaskLoader.html
 *
 * https://developer.android.com/guide/components/loaders
 *
 */
public class PianetiLoader extends AsyncTaskLoader<List<Pianeta>> {

    public PianetiLoader(@NonNull Context context) {
        super(context);
    }

    /**
     * Il codice che esegue il caricamento dei dati, viene lanciato in un thread separato.
     * Quando volta ricevuto il risultato viene passato al thread principale chiamando il metodo onLoadFinished della nostra Activity
     *
     * @return
     */
    @Nullable
    @Override
    public List<Pianeta> loadInBackground() {

        PianetaService service = new PianetaService(getContext());
        List<Pianeta> pianeti = service.findAll();
        LogUtil.debug(" loadInBackground21 " + pianeti.size());
        return pianeti;
    }

}
