package com.chh.models.mappers;

import com.chh.models.dtos.StageCyclist.CreateStageCyclistDTO;
import com.chh.models.dtos.StageCyclist.StageCylistEmbeddableIdDTO;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.StageCyclist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StageCyclistMapper {

    @Mapping(target = "cyclist.id", source = "id.cyclistId")  // Accéder à cyclistId dans l'objet imbriqué
    @Mapping(target = "stage.id", source = "id.stageId")      // Accéder à stageId dans l'objet imbriqué
    StageCyclist toEntity(CreateStageCyclistDTO createStageCyclistDTO);

    CreateStageCyclistDTO toDTO(StageCyclist stageCyclist);
}
