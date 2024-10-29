package com.chh.controllers;


import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Competition.CreateCompetitionDTO;
import com.chh.models.dtos.Competition.UpdateCompetitionDTO;
import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.StageCyclist;
import com.chh.services.implementation.CompetitionService;
import com.chh.services.implementation.StageCyclistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stage-results")
public class StageCyclistController {

    @Autowired
    private StageCyclistService stageCyclistService;

    @GetMapping
    public ResponseEntity<List<StageCyclistDTO>> getAllCompetitions() {
        List<StageCyclistDTO> stageCyclists = stageCyclistService.getAllStageCyclists();
        return new ResponseEntity<>(stageCyclists, HttpStatus.OK);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getCompetitionById(@PathVariable("id") Long id) {
//        try {
//            CompetitionDTO competition = competitionService.getCompetitionById(id);
//            return new ResponseEntity<>(competition, HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Erreur lors de la récupération de la compétition : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping
    public ResponseEntity<Object> createStageCyclist(@Valid @RequestBody CreateStageCyclistDTO stageCyclistDTO) {
        try {
            StageCyclistDTO savedStageCyclistDTO = stageCyclistService.createStageCyclist(stageCyclistDTO);
            return new ResponseEntity<>(savedStageCyclistDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création de StageCyclist : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{stageId}/{cyclistId}")
    public ResponseEntity<Object> getStageResult(@PathVariable("stageId") Long stageId, @PathVariable("cyclistId") Long cyclistId) {
        try {
            StageCyclistDTO stageResult = stageCyclistService.getStageResultByStageAndCyclist(stageId, cyclistId);
            return new ResponseEntity<>(stageResult, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération du résultat de l'étape : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{stageId}/{cyclistId}")
    public ResponseEntity<String> deleteStageCyclist(@PathVariable("stageId") Long stageId, @PathVariable("cyclistId") Long cyclistId) {
        try {
            stageCyclistService.deleteStageCyclistById(stageId, cyclistId);
            return new ResponseEntity<>("La résultat de l'étape a été supprimée avec succès", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCompetition(@PathVariable("id") Long id, @Valid @RequestBody UpdateCompetitionDTO updateCompetitionDTO) {
//        try {
//            CompetitionDTO updatedCompetition = competitionService.updateCompetition(id, updateCompetitionDTO);
//            return new ResponseEntity<>(updatedCompetition, HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Erreur lors de la mise à jour : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}

