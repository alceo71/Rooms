package com.example.rooms.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PianetaConSatelliti {
    @Embedded
    public Pianeta pianeta;

    @Relation(
            parentColumn = "id",
            entityColumn = "id_pianeta"
    )
    public List<Satellite> sateliti;

}
