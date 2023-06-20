package com.supinfo.league.saison.domain;

public class SaisonAlreadyExistsException extends Exception{
    public SaisonAlreadyExistsException(String message) {
        super(message);
    }
}
