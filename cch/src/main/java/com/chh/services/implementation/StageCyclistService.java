package com.chh.services.implementation;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Stage;
import com.chh.models.entities.StageCyclist;
import com.chh.models.mappers.StageCyclistMapper;
import com.chh.repository.CyclistRepository;
import com.chh.repository.StageCyclistRepository;
import com.chh.repository.StageRepository;
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

    @Override
    public List<StageCyclistDTO> getAllStageCyclists() {
        return stageCyclistRepository.findAll()
                .stream().map(stageCyclistMapper::toDTO)
                .toList();
    }


    @Override
    public StageCyclistDTO createStageCyclist(CreateStageCyclistDTO createStageCyclistDTO) {

        Cyclist cyclist = cyclistRepository.findById(createStageCyclistDTO.getId().getCyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist with ID " + createStageCyclistDTO.getId().getCyclistId() + " does not exist."));

        Stage stage = stageRepository.findById(createStageCyclistDTO.getId().getStageId())
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + createStageCyclistDTO.getId().getStageId() + " does not exist."));

        StageCyclist stageCyclist = stageCyclistRepository.save(
                new StageCyclist(stage, cyclist, createStageCyclistDTO.getTime())
        );

        return stageCyclistMapper.toDTO(stageCyclist);
    }

    @Override
    public StageCyclistDTO getStageResultByStageAndCyclist(Long stageId, Long cyclistId) {
        StageCyclistId stageCyclistId = new StageCyclistId(stageId, cyclistId);

        StageCyclist stageCyclist = stageCyclistRepository.findById(stageCyclist)
                .orElseThrow(() -> new IllegalArgumentException("StageCyclist with stage ID " + stageId + " and cyclist ID " + cyclistId + " does not exist."));

        return stageCyclistMapper.toDTO(stageCyclist);
    }

}
