package com.chh.controllers;


import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.entities.Cyclist;
import com.chh.services.implementation.CyclistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/cyclists")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @GetMapping
    public ResponseEntity<List<CyclistDTO>> getAllCyclists() {
        List<CyclistDTO> cyclists = cyclistService.getAllCyclists();

        return new ResponseEntity<>(cyclists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCyclistById(@PathVariable("id") Long id) {
        try {
            CyclistDTO cyclist = cyclistService.getCyclistById(id);
            return new ResponseEntity<>(cyclist, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération du cycliste : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createCyclist(@Valid @RequestBody CreateCyclistDTO createCyclistDTO) {

        try {
         CyclistDTO cyclist = cyclistService.createCyclist(createCyclistDTO);
            return new ResponseEntity<>("Created succefuly" + cyclist, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating cyclist: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCyclist(@PathVariable("id") Long id) {
        try {
            cyclistService.deleteCyclistById(id);
            return new ResponseEntity<>("Le cyclist est supprimé avec succès", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCyclist(@PathVariable("id") Long id, @Valid @RequestBody UpdateCyclistDTO updateCyclistDTO) {
        try {
            CyclistDTO updatedCyclist = cyclistService.updateCyclist(id, updateCyclistDTO);
            return new ResponseEntity<>(updatedCyclist, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
