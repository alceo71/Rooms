package com.example.rooms.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rooms.model.Pianeta;

import java.util.List;

@Dao
public interface PianetaDao {

    @Query("SELECT * FROM pianeta")
    List<Pianeta> findAll();

    @Insert
    void insert(Pianeta pianeta);

    @Insert
    void insert(List<Pianeta> pianeti);

    @Delete
    void delete(Pianeta pianeta);

    @Update
    void update(Pianeta pianeta);

}
