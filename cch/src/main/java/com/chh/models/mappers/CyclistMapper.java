package com.chh.models.mappers;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CyclistMapper {

    @Mapping(target = "team", source = "teamId", qualifiedByName = "mapTeamIdToTeam")
    Cyclist toEntity(CreateCyclistDTO createCyclistDTO);

    @Named("mapTeamIdToTeam")
    default Team mapTeamIdToTeam(Long teamId) {
        if (teamId == null) {
            return null;
        }
        Team team = new Team();
        team.setId(teamId);
        return team;
    }

    @Mapping(target = "teamName", source = "team.name")
    CyclistDTO toDTO(Cyclist cyclist);
}
