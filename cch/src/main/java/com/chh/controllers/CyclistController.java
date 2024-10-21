package com.chh.controllers;


import com.chh.models.entities.Cyclist;
import com.chh.services.implementation.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Cyclist>> getAllCyclists() {
        List<Cyclist> cyclists = cyclistService.getAllCyclists();
        return new ResponseEntity<>(cyclists, HttpStatus.OK);
    }


}
