package com.chh.services.implementation;


import com.chh.models.dtos.Stage.CreateStageDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.chh.models.dtos.Stage.UpdateStageDTO;
import com.chh.models.entities.Competition;
import com.chh.models.entities.Stage;
import com.chh.models.mappers.StageMapper;
import com.chh.repository.CompetitionRepository;
import com.chh.repository.StageRepository;
import com.chh.services.interfaces.IStageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StageService implements IStageService {
    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private StageMapper stageMapper;

    @Override
    public List<StageDTO> getAllStages() {
        List<Stage> stages = stageRepository.findAll();
        return stageMapper.toDTOs(stages);
    }

    @Override
    public StageDTO getStageById(Long id) {
        Stage stage = stageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stage avec l'ID " + id + " n'existe pas."));
        return stageMapper.toDTO(stage);
    }

    @Override
    public StageDTO createStage(CreateStageDTO createStageDTO) {
        Stage stage = stageMapper.toEntity(createStageDTO);
        if (createStageDTO.getCompetitionId() != null) {
            Competition competition = competitionRepository.findById(createStageDTO.getCompetitionId())
                    .orElseThrow(() -> new EntityNotFoundException("Competition not found"));
            stage.setCompetition(competition);
        }
        Stage savedStage = stageRepository.save(stage);
        return stageMapper.toDTO(savedStage);
    }

    @Override
    public StageDTO updateStage(Long id, UpdateStageDTO updateStageDTO) {
        Stage stage = stageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + id + " does not exist."));
        stageMapper.updateStageFromDto(updateStageDTO, stage);
        Stage updatedStage = stageRepository.save(stage);
        return stageMapper.toDTO(updatedStage);
    }

    @Override
    public void updateDone(Long id){
        Stage stage = stageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + id + " does not exist."));
        stage.setDone(true);
        stageRepository.save(stage);
    }

    @Override
    public void deleteStageById(Long id) {
        if (!stageRepository.existsById(id)) {
            throw new IllegalArgumentException("Le cycliste avec l'ID " + id + " n'existe pas.");
        }
        stageRepository.deleteById(id);
    }

    @Override
    public void deleteStage(Stage stage) {
        stageRepository.delete(stage);
    }

}
