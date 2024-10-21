package com.chh.services.implementation;

import com.chh.models.entities.Stage;
import com.chh.repository.StageRepository;
import com.chh.services.interfaces.IStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StageService implements IStageService {
    @Autowired
    private StageRepository stageRepository;

    @Override
    public List<Stage> getAllStages(){
        return stageRepository.findAll();
    }

    @Override
    public Stage getStageById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    @Override
    public void createStage(Stage stage) {
        stageRepository.save(stage);
    }

    @Override
    public void updateStage(Stage stage) {
        if(stageRepository.existsById(stage.getId())) {
            stageRepository.save(stage);
        }else {
            throw new IllegalArgumentException("Team with ID " + stage.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteStageById(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public void deleteStage(Stage stage) {
        stageRepository.delete(stage);
    }

}
