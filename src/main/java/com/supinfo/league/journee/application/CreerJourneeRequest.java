package com.supinfo.league.journee.application;

import java.time.LocalDate;

public record CreerJourneeRequest(String saisonId, int numero, LocalDate date) {
}