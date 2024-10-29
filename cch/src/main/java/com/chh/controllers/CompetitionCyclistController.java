package com.chh.controllers;


import com.chh.models.dtos.CompetitionCyclist.CompetitionCyclistDTO;
import com.chh.models.dtos.CompetitionCyclist.CreateCompetitionCyclistDTO;
import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.entities.Competition;
import com.chh.services.implementation.CompetitionCyclistService;
import com.chh.services.implementation.StageCyclistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/general-results")
public class CompetitionCyclistController {

    @Autowired
    private CompetitionCyclistService competitionCyclistService;

    @GetMapping
    public ResponseEntity<List<CompetitionCyclistDTO>> getAllCompetitionCyclist() {
        List<CompetitionCyclistDTO> competitionCyclists = competitionCyclistService.getAllCompetitionCyclists();
        return new ResponseEntity<>(competitionCyclists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCompetitionCyclist(@Valid @RequestBody CreateCompetitionCyclistDTO createCompetitionCyclistDTO) {
        try {
            CompetitionCyclistDTO savedCompetitionCyclistDTO = competitionCyclistService.createCompetitionCyclist(createCompetitionCyclistDTO);
            return new ResponseEntity<>(savedCompetitionCyclistDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création de CompetitionCyclist : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<Object> getStageResult(@PathVariable("competitionId") Long competitionId, @PathVariable("cyclistId") Long cyclistId) {
        try {
            CompetitionCyclistDTO generalResult = competitionCyclistService.getCompetitionResultByCompetitionAndCyclist(competitionId, cyclistId);
            return new ResponseEntity<>(generalResult, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération du résultat génerale : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<String> deleteCompetitionCyclist(@PathVariable("competitionId") Long competitionId, @PathVariable("cyclistId") Long cyclistId) {
        try {
            competitionCyclistService.deleteCompetitionCyclistById(competitionId, cyclistId);
            return new ResponseEntity<>("La résultat general a été supprimée avec succès", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

