package com.chh.services.interfaces;

import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Competition.CreateCompetitionDTO;
import com.chh.models.dtos.Competition.UpdateCompetitionDTO;
import com.chh.models.entities.Competition;
import com.chh.models.entities.Cyclist;

import java.time.LocalDate;
import java.util.List;

public interface ICompetitionService {
    List<CompetitionDTO> getAllCompetitions();
    CompetitionDTO getCompetitionById(Long id);
    CompetitionDTO createCompetition(CreateCompetitionDTO createCompetitionDTO);
    CompetitionDTO updateCompetition(Long id, UpdateCompetitionDTO updateCompetitionDTO);
    void deleteCompetitionById(Long id);
    void deleteCompetition(Competition competition);
    List<Competition> getAllCompetitionByName(String name);
    List<Competition> getAllCompetitionByStartDate(LocalDate startDate);

}
