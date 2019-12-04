package com.example.rooms.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.rooms.model.Pianeta;
import com.example.rooms.persistence.dao.PianetaDao;

@Database(entities = {Pianeta.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PianetaDao pianetaDao();
}
