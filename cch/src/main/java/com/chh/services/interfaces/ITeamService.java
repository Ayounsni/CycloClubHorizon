package com.chh.services.interfaces;

import com.chh.models.dtos.Team.CreateTeamDTO;
import com.chh.models.dtos.Team.TeamDTO;
import com.chh.models.dtos.Team.UpdateTeamDTO;
import com.chh.models.entities.Team;

import java.util.List;

public interface ITeamService {
    List<TeamDTO> getAllTeam();
    TeamDTO getTeamById(Long id);
    TeamDTO createTeam(CreateTeamDTO createTeamDTO);
    TeamDTO updateTeam(Long id, UpdateTeamDTO updateTeamDTO);
    void deleteTeamById(Long id);
}
