package com.chh.services.interfaces;

import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;

import java.util.List;

public interface ICyclistService {
    List<Cyclist> getAllCyclists();
    Cyclist getCyclistById(Long id);
    void createCyclist(Cyclist cyclist);
}
