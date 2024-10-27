package com.chh.models.mappers;


import com.chh.models.dtos.Team.CreateTeamDTO;
import com.chh.models.dtos.Team.TeamDTO;
import com.chh.models.dtos.Team.UpdateTeamDTO;
import com.chh.models.entities.Team;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeamMapper {

    Team toEntity(CreateTeamDTO createTeamDTO);

    void updateTeamFromDto(UpdateTeamDTO updateTeamDTO, @MappingTarget Team team);

    @Mapping(target = "cyclists", source = "cyclists")
    TeamDTO toDTO(Team team);

    List<TeamDTO> toDTOs(List<Team> teams);
}
