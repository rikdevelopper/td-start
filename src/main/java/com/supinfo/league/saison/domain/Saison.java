package com.supinfo.league.saison.domain;

public class Saison {
    private final String id;
    private final String libelle;

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
}
