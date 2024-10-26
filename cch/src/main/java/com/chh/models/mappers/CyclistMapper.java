package com.chh.models.mappers;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CyclistMapper {

    @Mapping(target = "team", source = "teamId", qualifiedByName = "mapTeamIdToTeam")
    Cyclist toEntity(CreateCyclistDTO createCyclistDTO);

    @Mapping(target = "team", source = "teamId", qualifiedByName = "mapTeamIdToTeam")
    void updateCyclistFromDto(UpdateCyclistDTO updateCyclistDTO, @MappingTarget Cyclist cyclist);

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

    List<CyclistDTO> toDTOs(List<Cyclist> cyclists);
}
