package com.chh.services.implementation;

import com.chh.models.dtos.CompetitionCyclist.CompetitionCyclistDTO;
import com.chh.models.dtos.CompetitionCyclist.CreateCompetitionCyclistDTO;
import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.entities.*;
import com.chh.models.mappers.CompetitionCyclistMapper;
import com.chh.repository.CompetitionCyclistRepository;
import com.chh.repository.CompetitionRepository;
import com.chh.repository.CyclistRepository;
import com.chh.services.interfaces.ICompetitionCyclistService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CompetitionCyclistService implements ICompetitionCyclistService {

    private final CompetitionCyclistRepository competitionCyclistRepository;
    private final CompetitionRepository competitionRepository;
    private final CyclistRepository cyclistRepository;
    private final CompetitionCyclistMapper competitionCyclistMapper;

    @Override
    public List<CompetitionCyclist> getAllCompetitionCyclists() {
        return competitionCyclistRepository.findAll();
    }



    @Override
    public CompetitionCyclistDTO createCompetitionCyclist(CreateCompetitionCyclistDTO createCompetitionCyclistDTO) {

        Cyclist cyclist = cyclistRepository.findById(createCompetitionCyclistDTO.getId().getCyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist with ID " + createCompetitionCyclistDTO.getId().getCyclistId() + " does not exist."));

        Competition competition = competitionRepository.findById(createCompetitionCyclistDTO.getId().getCompetitionId())
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + createCompetitionCyclistDTO.getId().getCompetitionId() + " does not exist."));

        CompetitionCyclist competitionCyclist = competitionCyclistRepository.save(
                new CompetitionCyclist(competition, cyclist)
        );

        return competitionCyclistMapper.toDTO(competitionCyclist);
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
