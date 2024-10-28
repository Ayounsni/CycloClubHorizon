package com.chh.services.interfaces;

import com.chh.models.dtos.Stage.CreateStageDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.chh.models.dtos.Stage.UpdateStageDTO;
import com.chh.models.entities.Stage;
import com.chh.models.entities.Team;

import java.util.List;

public interface IStageService {
    List<StageDTO> getAllStages();
    StageDTO getStageById(Long id);
    StageDTO createStage(CreateStageDTO createStageDTO);
    StageDTO updateStage(Long id, UpdateStageDTO updateStageDTO);
    void deleteStageById(Long id);
    void deleteStage(Stage stage);
}
