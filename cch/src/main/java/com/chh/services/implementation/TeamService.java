package com.chh.services.implementation;

import com.chh.models.entities.Team;
import com.chh.repository.TeamRepository;
import com.chh.services.interfaces.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService implements ITeamService {


    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team getStatusById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

}

