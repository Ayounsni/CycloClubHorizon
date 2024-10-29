package com.chh.models.mappers;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCyclistDTO;
import com.chh.models.entities.StageCyclist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StageCyclistMapper {

    @Mapping(target = "cyclist.id", source = "id.cyclistId")
    @Mapping(target = "stage.id", source = "id.stageId")
    StageCyclist toEntity(CreateStageCyclistDTO createStageCyclistDTO);


    @Mapping(target = "cyclist.teamName", source = "cyclist.team.name")
    @Mapping(target = "stage.competitionName", source = "stage.competition.name")
    StageCyclistDTO toDTO(StageCyclist stageCyclist);
}
