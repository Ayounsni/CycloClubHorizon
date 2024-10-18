package com.chh.services.implementation;

import com.chh.models.entities.Cyclist;
import com.chh.repository.CyclistRepository;
import com.chh.services.interfaces.ICyclistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public void updateCyclist(Cyclist cyclist) {
        if (cyclistRepository.existsById(cyclist.getId())) {
            cyclistRepository.save(cyclist);
        } else {
            throw new IllegalArgumentException("Team with ID " + cyclist.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteCyclistById(Long id) {
        cyclistRepository.deleteById(id);
    }

    @Override
    public void deleteCyclist(Cyclist cyclist) {
        cyclistRepository.delete(cyclist);
    }



    @Override
    public List<Cyclist> getAllCyclistTriByName() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getFirstname))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cyclist> getAllCyclistTriByNationality() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getNationality))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cyclist> getAllCyclistTriByTeam() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(cyclist -> cyclist.getTeam().getName()))
                .collect(Collectors.toList());
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
