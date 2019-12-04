package com.example.rooms.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rooms.model.Pianeta;

import java.util.List;

@Dao
public interface PianetaDao {

    @Query("SELECT * FROM pianeta")
    List<Pianeta> findAll();

    @Insert
    Long insert(Pianeta pianeta);

    @Insert
    void insert(List<Pianeta> pianeti);

    @Delete
    void delete(Pianeta pianeta);

}
