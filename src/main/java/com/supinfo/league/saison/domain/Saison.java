package com.supinfo.league.saison.domain;

import com.supinfo.league.journee.domain.Journee;

import java.time.LocalDate;
import java.util.List;

public class Saison {
    private final String id;
    private final String libelle;
    private List<Journee> journees;

    public Saison(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getId() {
        return id;
    }

    public Journee newJournee(String id, int numero, LocalDate date){
        return new Journee(id, numero, date, this);
    }
}
