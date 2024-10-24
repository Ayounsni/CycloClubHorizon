package com.chh.controllers;


import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
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
    public ResponseEntity<CyclistDTO> getCyclistById(@PathVariable("id") Long id) {
        CyclistDTO cyclist = cyclistService.getCyclistById(id);
        return new ResponseEntity<>(cyclist, HttpStatus.OK);
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
    public ResponseEntity<String> deleteTeam(@PathVariable("id") Long id) {
        cyclistService.deleteCyclistById(id);
        return new ResponseEntity<>("Le cycliste a été supprimé avec succès",HttpStatus.OK);
    }



}
