package com.chh.services.implementation;

import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Competition.CreateCompetitionDTO;
import com.chh.models.dtos.Competition.UpdateCompetitionDTO;
import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.entities.Competition;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;
import com.chh.models.mappers.CompetitionMapper;
import com.chh.repository.CompetitionRepository;
import com.chh.services.interfaces.ICompetitionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CompetitionService implements ICompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private CompetitionMapper competitionMapper;


    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitionMapper.toDTOs(competitions);
    }

    @Override
    public CompetitionDTO getCompetitionById(Long id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La compétition avec l'ID " + id + " n'existe pas."));
        return competitionMapper.toDTO(competition);
    }

    @Override
    public CompetitionDTO createCompetition(CreateCompetitionDTO createCompetitionDTO) {
        Competition competition = competitionMapper.toEntity(createCompetitionDTO);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(savedCompetition);
    }

    @Override
    public CompetitionDTO updateCompetition(Long id, UpdateCompetitionDTO updateCompetitionDTO) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La compétition avec l'ID " + id + " n'existe pas."));
        competitionMapper.updateCompetitionFromDto(updateCompetitionDTO, competition);
        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(updatedCompetition);
    }

    @Override
    public void deleteCompetitionById(Long id) {
        if (!competitionRepository.existsById(id)) {
            throw new IllegalArgumentException("La compétition avec l'ID " + id + " n'existe pas.");
        }
        competitionRepository.deleteById(id);
    }

    @Override
    public void deleteCompetition(Competition competition) {
        competitionRepository.delete(competition);
    }

    @Override
    public List<Competition> getAllCompetitionByName(String name) {
        return competitionRepository.findByName(name);
    }

    @Override
    public List<Competition> getAllCompetitionByStartDate(LocalDate startDate) {
        return competitionRepository.findByStartDate(startDate);
    }

}
