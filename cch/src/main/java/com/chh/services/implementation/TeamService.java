package com.chh.services;

import com.chh.models.entities.Team;
import com.chh.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {


    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    public Team getStatusById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}

