package com.supinfo.league.journee.application;

import com.supinfo.league.journee.domain.Journee;
import com.supinfo.league.journee.domain.JourneeDao;
import com.supinfo.league.saison.domain.Saison;
import com.supinfo.league.saison.domain.SaisonDao;
import org.springframework.stereotype.Service;

@Service
public class CreerJourneeUseCase {

    private final SaisonDao saisonDao;
    private final JourneeDao journeeDao;

    public CreerJourneeUseCase(SaisonDao saisonDao, JourneeDao journeeDao) {
        this.saisonDao = saisonDao;
        this.journeeDao = journeeDao;
    }

    public void execute(CreerJourneeRequest request){
        Saison saison = this.saisonDao.findById(request.saisonId());
        Journee journee = saison.newJournee(journeeDao.nextId(), request.numero(), request.date());
        this.journeeDao.creerJournee(journee);
    }
}
