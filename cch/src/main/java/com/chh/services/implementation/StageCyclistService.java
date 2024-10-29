package com.chh.services.implementation;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.embeddableId.CyclistCompetitionId;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.*;
import com.chh.models.mappers.StageCyclistMapper;
import com.chh.repository.*;
import com.chh.services.interfaces.IStageCyclistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StageCyclistService implements IStageCyclistService {

    private final StageCyclistRepository stageCyclistRepository;
    private final StageCyclistMapper stageCyclistMapper;
    private final CyclistRepository cyclistRepository;
    private final StageRepository stageRepository;
    private final CompetitionCyclistRepository competitionCyclistRepository;
    private final CompetitionRepository competitionRepository;

    @Override
    public List<StageCyclistDTO> getAllStageCyclists() {
        return stageCyclistRepository.findAll()
                .stream().map(stageCyclistMapper::toDTO)
                .toList();
    }


    @Override
    public StageCyclistDTO createStageCyclist(CreateStageCyclistDTO createStageCyclistDTO) {
        Stage stage = stageRepository.findById(createStageCyclistDTO.getId().getStageId())
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + createStageCyclistDTO.getId().getStageId() + " does not exist."));

        CyclistCompetitionId cyclistCompetitionId = new CyclistCompetitionId(stage.getCompetition().getId(), createStageCyclistDTO.getId().getCyclistId());

        competitionCyclistRepository.findById(cyclistCompetitionId)
                .orElseThrow(() -> new IllegalArgumentException("cyclist il n est pas participer dans la competition"));

        Cyclist cyclist = cyclistRepository.findById(createStageCyclistDTO.getId().getCyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist with ID " + createStageCyclistDTO.getId().getCyclistId() + " does not exist."));

        StageCyclist stageCyclist = stageCyclistRepository.save(
                new StageCyclist(stage, cyclist, createStageCyclistDTO.getTime())
        );
        return stageCyclistMapper.toDTO(stageCyclist);
    }


    @Override
    public StageCyclistDTO getStageResultByStageAndCyclist(Long stageId, Long cyclistId) {
        StageCyclistId stageCyclistId = new StageCyclistId(stageId, cyclistId);

        StageCyclist stageCyclist = stageCyclistRepository.findById(stageCyclistId)
                .orElseThrow(() -> new IllegalArgumentException("StageCyclist with stage ID " + stageId + " and cyclist ID " + cyclistId + " does not exist."));

        return stageCyclistMapper.toDTO(stageCyclist);
    }

    @Override
    public void deleteStageCyclistById(Long stageId, Long cyclistId) {
        StageCyclistId stageCyclistId = new StageCyclistId(stageId, cyclistId);
        if (!stageCyclistRepository.existsById(stageCyclistId)) {
            throw new IllegalArgumentException("StageCyclist with stage ID " + stageId + " and cyclist ID " + cyclistId + " does not exist.");
        }
        stageCyclistRepository.deleteById(stageCyclistId);
    }

}
