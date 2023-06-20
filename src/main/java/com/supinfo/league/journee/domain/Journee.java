package com.supinfo.league.journee.domain;

import com.supinfo.league.saison.domain.Saison;

import java.time.LocalDate;

public class Journee {
    private String id;
    private int numero;
    private LocalDate date;

    private Saison saison;

    public Journee(String id, int numero, LocalDate date, Saison saison) {
        this.id = id;
        this.numero = numero;
        this.date = date;
        this.saison = saison;
    }

    public String getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public Saison getSaison() {
        return saison;
    }
}
