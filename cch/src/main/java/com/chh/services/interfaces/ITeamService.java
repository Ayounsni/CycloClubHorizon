package com.chh.services.interfaces;

import com.chh.models.entities.Team;

import java.util.List;

public interface ITeamService {
    List<Team> getAllTeam();
    Team getStatusById(Long id);
    void createTeam(Team team);
}
