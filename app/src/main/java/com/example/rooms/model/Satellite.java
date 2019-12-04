package com.example.rooms.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Satellite {


    @PrimaryKey(autoGenerate = true)
    private int id;

    // Nome del pianeta
    @ColumnInfo(name = "nome")
    private String nome;

    // Massa in rapporto alla terra
    @ColumnInfo(name = "massa")
    private double massa;


    @ColumnInfo(name = "id_pianeta")
    private int idPianeta;
}
