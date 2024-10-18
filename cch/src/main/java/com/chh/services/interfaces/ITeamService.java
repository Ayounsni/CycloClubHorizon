package com.chh.services.interfaces;

import com.chh.models.entities.Team;

import java.util.List;

public interface ITeamService {
    List<Team> getAllTeam();
    Team getTeamById(Long id);
    void createTeam(Team team);
    void updateTeam(Team team);
    void deleteTeamById(Long id);
    void deleteTeam(Team team);

}
