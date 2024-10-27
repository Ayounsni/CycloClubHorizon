package com.chh.controllers;


import com.chh.models.dtos.Competition.CreateCompetitionDTO;
import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Competition.UpdateCompetitionDTO;
import com.chh.services.implementation.CompetitionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.getAllCompetitions();
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompetitionById(@PathVariable("id") Long id) {
        try {
            CompetitionDTO competition = competitionService.getCompetitionById(id);
            return new ResponseEntity<>(competition, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération de la compétition : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createCompetition(@Valid @RequestBody CreateCompetitionDTO createCompetitionDTO) {
        try {
            CompetitionDTO competition = competitionService.createCompetition(createCompetitionDTO);
            return new ResponseEntity<>("Créé avec succès : " + competition, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création de la compétition : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompetition(@PathVariable("id") Long id) {
        try {
            competitionService.deleteCompetitionById(id);
            return new ResponseEntity<>("La compétition a été supprimée avec succès", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCompetition(@PathVariable("id") Long id, @Valid @RequestBody UpdateCompetitionDTO updateCompetitionDTO) {
        try {
            CompetitionDTO updatedCompetition = competitionService.updateCompetition(id, updateCompetitionDTO);
            return new ResponseEntity<>(updatedCompetition, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la mise à jour : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

