package com.supinfo.league.saison.ui;

import com.supinfo.league.saison.application.CreerSaisonRequest;
import com.supinfo.league.saison.application.CreerSaisonUseCase;
import com.supinfo.league.saison.domain.SaisonAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/saisons")
@RestController
public class SaisonController {

    private final CreerSaisonUseCase creerSaisonUseCase;

    public SaisonController(CreerSaisonUseCase creerSaisonUseCase) {
        this.creerSaisonUseCase = creerSaisonUseCase;
    }

    @PostMapping
    public ResponseEntity creerSaison(@RequestBody CreerSaisonRequest request) {
        try {
            this.creerSaisonUseCase.execute(request);
            return ResponseEntity.ok().build();
        } catch (SaisonAlreadyExistsException sae) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sae.getMessage());
        }
    }
}
