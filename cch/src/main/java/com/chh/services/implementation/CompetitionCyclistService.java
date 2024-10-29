package com.chh.services.implementation;

import com.chh.models.dtos.CompetitionCyclist.CompetitionCyclistDTO;
import com.chh.models.dtos.CompetitionCyclist.CreateCompetitionCyclistDTO;
import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.embeddableId.CyclistCompetitionId;
import com.chh.models.embeddableId.StageCyclistId;
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
    public List<CompetitionCyclistDTO> getAllCompetitionCyclists() {
        return competitionCyclistRepository.findAll()
                .stream().map(competitionCyclistMapper::toDTO)
                .toList();
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
    public CompetitionCyclistDTO getCompetitionResultByCompetitionAndCyclist(Long competitionId, Long cyclistId) {
        CyclistCompetitionId cyclistCompetitionId = new CyclistCompetitionId(competitionId, cyclistId);

        CompetitionCyclist competitionCyclist = competitionCyclistRepository.findById(cyclistCompetitionId)
                .orElseThrow(() -> new IllegalArgumentException("CompetitionCyclist with competition ID " + competitionId + " and cyclist ID " + cyclistId + " does not exist."));

        return competitionCyclistMapper.toDTO(competitionCyclist);
    }

    @Override
    public void deleteCompetitionCyclistById(Long competitionId, Long cyclistId) {
        CyclistCompetitionId cyclistCompetitionId = new CyclistCompetitionId(competitionId, cyclistId);
        if (!competitionCyclistRepository.existsById(cyclistCompetitionId)) {
            throw new IllegalArgumentException("StageCyclist with stage ID " + competitionId + " and cyclist ID " + cyclistId + " does not exist.");
        }
        competitionCyclistRepository.deleteById(cyclistCompetitionId);
    }
}
