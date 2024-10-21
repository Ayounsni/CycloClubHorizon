package com.chh.services.interfaces;

import com.chh.models.entities.Stage;
import com.chh.models.entities.Team;

import java.util.List;

public interface IStageService {
    List<Stage> getAllStages();
    Stage getStageById(Long id);
    void createStage(Stage stage);
    void updateStage(Stage stage);
    void deleteStageById(Long id);
    void deleteStage(Stage stage);
}
