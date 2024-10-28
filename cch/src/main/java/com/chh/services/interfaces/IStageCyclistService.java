package com.chh.services.interfaces;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.entities.StageCyclist;

import java.util.List;

public interface IStageCyclistService {
    List<StageCyclistDTO> getAllStageCyclists();
    StageCyclistDTO createStageCyclist(CreateStageCyclistDTO createStageCyclistDTO);
}
