package com.example.rooms.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public int getIdPianeta() {
        return idPianeta;
    }

    public void setIdPianeta(int idPianeta) {
        this.idPianeta = idPianeta;
    }
}
