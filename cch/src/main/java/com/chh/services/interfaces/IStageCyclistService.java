package com.chh.services.interfaces;

import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.StageCyclist;

import java.util.List;

public interface IStageCyclistService {
    List<StageCyclist> getAllStageCyclists();
    void createStageCyclist(StageCyclist stageCyclist);
}
