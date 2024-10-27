package com.chh.services.implementation;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.dtos.Team.CreateTeamDTO;
import com.chh.models.dtos.Team.TeamDTO;
import com.chh.models.dtos.Team.UpdateTeamDTO;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;
import com.chh.models.mappers.CyclistMapper;
import com.chh.models.mappers.TeamMapper;
import com.chh.repository.TeamRepository;
import com.chh.services.interfaces.ITeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService implements ITeamService {
    @Autowired
    private  TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<TeamDTO> getAllTeam() {
        List<Team> teams = teamRepository.findAll();
        return teamMapper.toDTOs(teams) ;
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le team avec l'ID " + id + " n'existe pas."));;
        return teamMapper.toDTO(team);
    }

    @Override
    public TeamDTO createTeam(CreateTeamDTO createTeamDTO) {
        Team team = teamMapper.toEntity(createTeamDTO);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDTO(savedTeam);
    }
    @Override
    public TeamDTO updateTeam(Long id, UpdateTeamDTO updateTeamDTO) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team with ID " + id + " does not exist."));
        teamMapper.updateTeamFromDto(updateTeamDTO, team);
        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDTO(updatedTeam);
    }

    @Override
    public void deleteTeamById(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new IllegalArgumentException("Le team avec l'ID " + id + " n'existe pas.");
        }
        teamRepository.deleteById(id);
    }

}

