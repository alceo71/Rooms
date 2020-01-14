package com.example.rooms.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rooms.model.Pianeta;
import com.example.rooms.model.Satellite;
import com.example.rooms.persistence.dao.PianetaConSatellitiDao;
import com.example.rooms.persistence.dao.PianetaDao;
import com.example.rooms.persistence.dao.SatelliteDao;

@Database(entities = {Pianeta.class, Satellite.class}, version = 1)
public abstract class SistemaSolareDatabase extends RoomDatabase {

    public abstract PianetaDao pianetaDao();

    public abstract SatelliteDao satelliteDao();

    public abstract PianetaConSatellitiDao pianetaConSatellitiDao();

    private static SistemaSolareDatabase instance;

    private static String DB_NAME = "sistema_solare";

    public static SistemaSolareDatabase getDatabase(final Context context){
        if(instance == null){
            synchronized (SistemaSolareDatabase.class){
                if(instance == null){
                    // .allowMainThreadQueries() da non usare in produzione
                    instance = Room.databaseBuilder(context.getApplicationContext(),SistemaSolareDatabase.class, DB_NAME).allowMainThreadQueries().build();
                }
            }
        }

        return instance;
    }

}
