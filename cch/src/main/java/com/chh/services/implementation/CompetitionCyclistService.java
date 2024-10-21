package com.chh.services.implementation;

import com.chh.models.entities.Competition;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.Cyclist;
import com.chh.repository.CompetitionCyclistRepository;
import com.chh.services.interfaces.ICompetitionCyclistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class CompetitionCyclistService implements ICompetitionCyclistService {
    @Autowired
    private CompetitionCyclistRepository competitionCyclistRepository;

    @Override
    public List<CompetitionCyclist> getAllCompetitionCyclists() {
        return competitionCyclistRepository.findAll();
    }

    @Override
    public void createCompetitionCyclist(CompetitionCyclist competitionCyclist) {
        competitionCyclistRepository.save(competitionCyclist);
    }

    @Override
    public List<CompetitionCyclist> findByCyclist(Cyclist cyclist) {
        return competitionCyclistRepository.findByCyclist(cyclist);
    }

    @Override
    public List<CompetitionCyclist> findByCompetition(Competition competition) {
        return competitionCyclistRepository.findByCompetition(competition);
    }

    @Override
    public void deleteByCyclistAndCompetition(Cyclist cyclist, Competition competition) {
        competitionCyclistRepository.deleteByCyclistAndCompetition(cyclist, competition);
    }
}
