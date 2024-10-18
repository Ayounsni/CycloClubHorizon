package com.chh.services.implementation;

import com.chh.models.entities.Cyclist;
import com.chh.repository.CyclistRepository;
import com.chh.services.interfaces.ICyclistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class CyclistService implements ICyclistService {
    @Autowired
    public CyclistRepository cyclistRepository;


    @Override
    public List<Cyclist> getAllCyclists() {
        return cyclistRepository.findAll();
    }

    @Override
    public Cyclist getCyclistById(Long id) {
        return cyclistRepository.findById(id).orElse(null);
    }

    @Override
    public void createCyclist(Cyclist cyclist) {
        cyclistRepository.save(cyclist);
    }
}
