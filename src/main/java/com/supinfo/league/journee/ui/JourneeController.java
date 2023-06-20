package com.supinfo.league.journee.ui;

import com.supinfo.league.journee.application.CreerJourneeRequest;
import com.supinfo.league.journee.application.CreerJourneeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/saisons/{saisonId}/journees")
@RestController
public class JourneeController {

    private final CreerJourneeUseCase creerJourneeUseCase;

    public JourneeController(CreerJourneeUseCase creerJourneeUseCase) {
        this.creerJourneeUseCase = creerJourneeUseCase;
    }

    @PostMapping
    public ResponseEntity creerJournee(@RequestBody CreerJourneeRequest request, @PathVariable String saisonId){
        this.creerJourneeUseCase.execute(request);
        return ResponseEntity.ok().build();
    }
}
