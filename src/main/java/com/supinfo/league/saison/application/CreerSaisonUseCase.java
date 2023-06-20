package com.supinfo.league.saison.application;

import com.supinfo.league.saison.domain.Saison;
import com.supinfo.league.saison.domain.SaisonAlreadyExistsException;
import com.supinfo.league.saison.domain.SaisonDao;
import org.springframework.stereotype.Service;

@Service
public class CreerSaisonUseCase {

    private final SaisonDao saisonDao;

    public CreerSaisonUseCase(SaisonDao saisonDao) {
        this.saisonDao = saisonDao;
    }

    public void execute(CreerSaisonRequest request) throws SaisonAlreadyExistsException {
        if (this.saisonDao.exists(request.libelle)) {
            throw new SaisonAlreadyExistsException(String.format("La saison %s existe déjà", request.libelle));
        }
        Saison newSaison = new Saison(this.saisonDao.nextId(), request.libelle);
        this.saisonDao.creerSaison(newSaison);
    }
}
