package com.chh.services.implementation;

import com.chh.models.entities.Competition;
import com.chh.models.entities.Cyclist;
import com.chh.repository.CompetitionRepository;
import com.chh.services.interfaces.ICompetitionService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public class CompetitionService implements ICompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompetition(Competition competition) {
        competitionRepository.save(competition);
    }

    @Override
    public void updateCompetition(Competition competition) {
        if (competitionRepository.existsById(competition.getId())) {
            competitionRepository.save(competition);
        } else {
            throw new IllegalArgumentException("Team with ID " + competition.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteCompetitionById(Long id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public void deleteCompetition(Competition competition) {
        competitionRepository.delete(competition);
    }

    @Override
    public List<Competition> getAllCompetitionByName(String name) {
        return competitionRepository.findByName(name);
    }

    @Override
    public List<Competition> getAllCompetitionByStartDate(LocalDate startDate) {
        return competitionRepository.findByStartDate(startDate);
    }


}
