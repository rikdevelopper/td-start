package com.supinfo.league.saison.domain;

public interface SaisonDao {

    void creerSaison(Saison saison);

    boolean exists(String libelle);

    String nextId();

    Saison findById(String id);
}
