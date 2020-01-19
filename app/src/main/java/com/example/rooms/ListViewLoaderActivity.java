package com.example.rooms;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.rooms.common.util.LogUtil;
import com.example.rooms.model.Pianeta;

import java.util.List;

public class ListViewLoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Pianeta>>{

    // L'adapter per un oggetto Pianeta
    // Dobbiamo dichiararlo come attributo della classe perché verrà usato dai metodi di <i>LoaderManager.LoaderCallbacks</i>
    private PianetiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_loader);

        setTitle(getString(R.string.titolo_loader));

        // Crea un Adapter per il Pianeta
        adapter = new PianetiAdapter(this, R.layout.pianeta);

        // Recupera la lista view e assegna l'adapter
        ListView listaPianeti = (ListView) findViewById(R.id.lista_pianeti);
        listaPianeti.setAdapter(adapter);

        // Crea un loadManager e lancia il loaderCallback usando l'Activity (che implementa LoaderManager)
        LoaderManager loader = LoaderManager.getInstance(this);
        loader.initLoader(0, null, this).forceLoad();
    }

    /**
     * Creazione del loader.
     * Creiamo la nostra classe PianetiLoader.
     *
     * @param id
     * @param args
     * @return
     */
    @NonNull
    @Override
    public Loader<List<Pianeta>> onCreateLoader(int id, @Nullable Bundle args) {
        PianetiLoader loader = new PianetiLoader(this);
        return loader;
    }

    /**
     *  Metodo chiamato quando il loader riceve un risultato
     *
     * @param loader
     * @param data
     */
    @Override
    public void onLoadFinished(@NonNull Loader<List<Pianeta>> loader, List<Pianeta> data) {
        LogUtil.debug(" dati ricevuti " + data.size());
        adapter.clear();
        adapter.addAll(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Pianeta>> loader) {
        adapter.clear();
    }
}
