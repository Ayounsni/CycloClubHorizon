package com.chh.services.interfaces;

import com.chh.models.dtos.CompetitionCyclist.CompetitionCyclistDTO;
import com.chh.models.dtos.CompetitionCyclist.CreateCompetitionCyclistDTO;
import com.chh.models.entities.Competition;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Stage;

import java.util.List;

public interface ICompetitionCyclistService {
    List<CompetitionCyclistDTO> getAllCompetitionCyclists();
    CompetitionCyclistDTO createCompetitionCyclist(CreateCompetitionCyclistDTO createCompetitionCyclistDTO);
    CompetitionCyclistDTO getCompetitionResultByCompetitionAndCyclist(Long competitionId, Long cyclistId);
    void deleteCompetitionCyclistById(Long competitionId, Long cyclistId);
}
