package com.chh.services.interfaces;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;

import java.util.List;

public interface ICyclistService {
    List<CyclistDTO> getAllCyclists();
    CyclistDTO getCyclistById(Long id);
    CyclistDTO createCyclist(CreateCyclistDTO createCyclistDTO);
    CyclistDTO updateCyclist(Long id, UpdateCyclistDTO updateCyclistDTO);
    void deleteCyclistById(Long id);
    void deleteCyclist(Cyclist cyclist);
    List<Cyclist> getAllCyclistTriByName();
    List<Cyclist> getAllCyclistTriByNationality();
    List<Cyclist> getAllCyclistTriByTeam();


}
