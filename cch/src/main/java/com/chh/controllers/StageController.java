package com.chh.controllers;


import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.dtos.Stage.CreateStageDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.chh.models.dtos.Stage.UpdateStageDTO;
import com.chh.services.implementation.CyclistService;
import com.chh.services.implementation.StageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<StageDTO>> getAllStages() {
        List<StageDTO> stages = stageService.getAllStages();

        return new ResponseEntity<>(stages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStageById(@PathVariable("id") Long id) {
        try {
            StageDTO stage= stageService.getStageById(id);
            return new ResponseEntity<>(stage, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération du stage : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createStage(@Valid @RequestBody CreateStageDTO createStageDTO) {

        try {
            StageDTO stage = stageService.createStage(createStageDTO);
            return new ResponseEntity<>("Created succefuly" + stage, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating stage: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStage(@PathVariable("id") Long id) {
        try {
            stageService.deleteStageById(id);
            return new ResponseEntity<>("Le stage est supprimé avec succès", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStage(@PathVariable("id") Long id, @Valid @RequestBody UpdateStageDTO updateStageDTO) {
        try {
            StageDTO updatedStage = stageService.updateStage(id, updateStageDTO);
            return new ResponseEntity<>(updatedStage, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
