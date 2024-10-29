package com.chh.models.mappers;

import com.chh.models.dtos.CompetitionCyclist.CompetitionCyclistDTO;
import com.chh.models.dtos.CompetitionCyclist.CreateCompetitionCyclistDTO;
import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.StageCyclist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetitionCyclistMapper {

    @Mapping(target = "cyclist.id", source = "id.cyclistId")
    @Mapping(target = "competition.id", source = "id.competitionId")
    CompetitionCyclist toEntity(CreateCompetitionCyclistDTO createCompetitionCyclistDTO);


    @Mapping(target = "cyclist.teamName", source = "cyclist.team.name")
//    @Mapping(target = "stage.competitionName", source = "stage.competition.name")
    CompetitionCyclistDTO toDTO(CompetitionCyclist competitionCyclist);
}
