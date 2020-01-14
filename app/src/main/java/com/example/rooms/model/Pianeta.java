package com.example.rooms.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Pianeta {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    // Nome del pianeta
    private String nome;

    // Distanza dal sole in UA
    @ColumnInfo(name = "distanza_ua")
    private double distanzaUA;

    // Periodo rivoluzione in giorni
    @ColumnInfo(name = "rivoluzione_giorni")
    private int rivoluzioneGiorni;

    // Periodo di rotaazione in ore
    @ColumnInfo(name = "rotazione_ore")
    private int rotazioneOre;

    // Massa in rapporto alla terra
    private double massa;

    // Diametro in rapporto alla terra
    private double diametro;

    // Numero di satelliti
    @ColumnInfo(name = "numero_satelliti")
    private int numeroSatelliti;

    @Ignore
    private boolean selezionato;

    public Pianeta(String nome, double distanzaUA, int rivoluzioneGiorni, int rotazioneOre, double massa, double diametro, int numeroSatelliti) {
        this.nome = nome;
        this.distanzaUA = distanzaUA;
        this.rivoluzioneGiorni = rivoluzioneGiorni;
        this.rotazioneOre = rotazioneOre;
        this.massa = massa;
        this.diametro = diametro;
        this.numeroSatelliti = numeroSatelliti;
    }

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

    public double getDistanzaUA() {
        return distanzaUA;
    }

    public void setDistanzaUA(double distanzaUA) {
        this.distanzaUA = distanzaUA;
    }

    public int getRivoluzioneGiorni() {
        return rivoluzioneGiorni;
    }

    public void setRivoluzioneGiorni(int rivoluzioneGiorni) {
        this.rivoluzioneGiorni = rivoluzioneGiorni;
    }

    public int getRotazioneOre() {
        return rotazioneOre;
    }

    public void setRotazioneOre(int rotazioneOre) {
        this.rotazioneOre = rotazioneOre;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public int getNumeroSatelliti() {
        return numeroSatelliti;
    }

    public void setNumeroSatelliti(int numeroSatelliti) {
        this.numeroSatelliti = numeroSatelliti;
    }

    public boolean isSelezionato() {
        return selezionato;
    }

    public void setSelezionato(boolean selezionato) {
        this.selezionato = selezionato;
    }
}
