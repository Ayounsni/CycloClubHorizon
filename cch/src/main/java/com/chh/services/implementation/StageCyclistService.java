package com.chh.services.implementation;

import com.chh.models.entities.StageCyclist;
import com.chh.repository.StageCyclistRepository;
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

    @Override
    public List<StageCyclist> getAllStageCyclists() {
        return stageCyclistRepository.findAll();
    }

    @Override
    public void createStageCyclist(StageCyclist stageCyclist) {
        stageCyclistRepository.save(stageCyclist);
    }
}
