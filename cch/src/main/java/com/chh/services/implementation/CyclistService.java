package com.chh.services.implementation;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.entities.Cyclist;
//import com.chh.models.mappers.CyclistMapper;
import com.chh.models.entities.Team;
import com.chh.models.mappers.CyclistMapper;
import com.chh.repository.CyclistRepository;
import com.chh.repository.TeamRepository;
import com.chh.services.interfaces.ICyclistService;
import jakarta.persistence.EntityNotFoundException;
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
    @Autowired
    private CyclistMapper cyclistMapper;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<CyclistDTO> getAllCyclists() {
        List<Cyclist> cyclists = cyclistRepository.findAll();
        return cyclistMapper.toDTOs(cyclists);
    }

    @Override
    public void updateCyclist(Cyclist cyclist) {
        if (cyclistRepository.existsById(cyclist.getId())) {
            cyclistRepository.save(cyclist);
        } else {
            throw new IllegalArgumentException("Team with ID " + cyclist.getId() + " does not exist.");
        }
    }

    public void deleteCyclistById(Long id) {
        if (!cyclistRepository.existsById(id)) {
            throw new EntityNotFoundException("Cycliste non trouvé avec l'id : " + id);
        }
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
    public CyclistDTO getCyclistById(Long id) {
       Cyclist cyclist =cyclistRepository.findById(id).orElse(null);
        return cyclistMapper.toDTO(cyclist) ;
    }

    @Override
    public CyclistDTO createCyclist(CreateCyclistDTO createCyclistDTO) {
        Cyclist cyclist = cyclistMapper.toEntity(createCyclistDTO);

        if (createCyclistDTO.getTeamId() != null) {
            Team team = teamRepository.findById(createCyclistDTO.getTeamId())
                    .orElseThrow(() -> new EntityNotFoundException("Team not found"));
            cyclist.setTeam(team);
        }

        Cyclist savedCyclist = cyclistRepository.save(cyclist);
        return cyclistMapper.toDTO(savedCyclist);
    }
}
