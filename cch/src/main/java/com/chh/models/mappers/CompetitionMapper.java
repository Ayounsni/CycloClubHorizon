package com.chh.models.mappers;


import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Competition.CreateCompetitionDTO;
import com.chh.models.dtos.Competition.UpdateCompetitionDTO;
import com.chh.models.dtos.Team.CreateTeamDTO;
import com.chh.models.dtos.Team.TeamDTO;
import com.chh.models.dtos.Team.UpdateTeamDTO;
import com.chh.models.entities.Competition;
import com.chh.models.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CompetitionMapper {

    Competition toEntity(CreateCompetitionDTO createCompetitionDTO);

    void updateCompetitionFromDto(UpdateCompetitionDTO updateCompetitionDTO, @MappingTarget Competition competition);

//    @Mapping(target = "cyclists", source = "cyclists")
    CompetitionDTO toDTO(Competition competition);

    List<CompetitionDTO> toDTOs(List<Competition> competitions);
}
