package com.chh.services.implementation;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Stage;
import com.chh.models.entities.StageCyclist;
import com.chh.models.mappers.StageCyclistMapper;
import com.chh.repository.CyclistRepository;
import com.chh.repository.StageCyclistRepository;
import com.chh.repository.StageRepository;
import com.chh.services.interfaces.IStageCyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StageCyclistService implements IStageCyclistService {

    @Autowired
    private StageCyclistRepository stageCyclistRepository;

    @Autowired
    private StageCyclistMapper stageCyclistMapper;

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private StageRepository stageRepository;




    @Override
    public List<StageCyclist> getAllStageCyclists() {
        return stageCyclistRepository.findAll();
    }

//    @Override
//    public void createStageCyclist(StageCyclist stageCyclist) {
//        stageCyclistRepository.save(stageCyclist);
//    }
    @Override
    public StageCyclist createStageCyclist(CreateStageCyclistDTO createStageCyclistDTO) {

        // Vérifiez que le cycliste et l'étape existent
        Cyclist cyclist = cyclistRepository.findById(createStageCyclistDTO.getId().getCyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist with ID " + createStageCyclistDTO.getId().getCyclistId() + " does not exist."));

        Stage stage = stageRepository.findById(createStageCyclistDTO.getId().getStageId())
                .orElseThrow(() -> new IllegalArgumentException("Stage with ID " + createStageCyclistDTO.getId().getStageId() + " does not exist."));

        // Créez l'instance StageCyclist
        StageCyclist stageCyclist = new StageCyclist();
        stageCyclist.setId(new StageCyclistId(stage.getId(), cyclist.getId())); // Assurez-vous que vous avez accès à l'ID de l'étape et du cycliste.
        stageCyclist.setCyclist(cyclist);
        stageCyclist.setStage(stage);
        stageCyclist.setTime(createStageCyclistDTO.getTime());

        return stageCyclistRepository.save(stageCyclist);
    }

}
