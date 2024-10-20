package com.chh.services.interfaces;

import com.chh.models.entities.Competition;
import com.chh.models.entities.Cyclist;

import java.time.LocalDate;
import java.util.List;

public interface ICompetitionService {
    List<Competition> getAllCompetitions();
    Competition getCompetitionById(Long id);
    void createCompetition(Competition competition);
    void updateCompetition(Competition competition);
    void deleteCompetitionById(Long id);
    void deleteCompetition(Competition competition);
    List<Competition> getAllCompetitionByName(String name);
    List<Competition> getAllCompetitionByStartDate(LocalDate startDate);

}
