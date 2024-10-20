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
    @Autowired
    private  TeamRepository teamRepository;

//    public void setTeamRepository(TeamRepository teamRepository) {
//        this.teamRepository = teamRepository;
//    }

//    public TeamService(TeamRepository teamRepository) {
//        this.teamRepository = teamRepository;
//    }

    @Override
    public List<Team> getAllTeam() {

        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {

        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }
    @Override
    public void updateTeam(Team team) {
        if (teamRepository.existsById(team.getId())) {
            teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team with ID " + team.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }

}

