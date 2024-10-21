package com.chh.services.interfaces;

import com.chh.models.entities.Competition;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Stage;

import java.util.List;

public interface ICompetitionCyclistService {
    List<CompetitionCyclist> getAllCompetitionCyclists();
    void createCompetitionCyclist(CompetitionCyclist competitionCyclist);
    List<CompetitionCyclist> findByCyclist(Cyclist cyclist);
    List<CompetitionCyclist> findByCompetition(Competition competition);
    void deleteByCyclistAndCompetition(Cyclist cyclist, Competition competition);
}
