package com.chh.models.mappers;

import com.chh.models.dtos.Cyclist.CreateCyclistDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.UpdateCyclistDTO;
import com.chh.models.dtos.Stage.CreateStageDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.chh.models.dtos.Stage.UpdateStageDTO;
import com.chh.models.dtos.StageCyclist.ListCyclistDTO;
import com.chh.models.dtos.StageCyclist.ListCyclistDTO;
import com.chh.models.entities.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StageMapper {

    @Mapping(target = "competition", source = "competitionId", qualifiedByName = "mapCompetitionIdToCompetition")
    Stage toEntity(CreateStageDTO createStageDTO);

    @Mapping(target = "competition", source = "competitionId", qualifiedByName = "mapCompetitionIdToCompetition")
    void updateStageFromDto(UpdateStageDTO updateStageDTO, @MappingTarget Stage stage);

    @Named("mapCompetitionIdToCompetition")
    default Competition mapCompetitionIdToCompetition(Long competitionId) {
        if (competitionId == null) {
            return null;
        }
        Competition competition = new Competition();
        competition.setId(competitionId);
        return competition;
    }

    @Mapping(target = "competitionName", source = "competition.name")
    @Mapping(target = "stageCyclists", source = "cyclists")
    StageDTO toDTO(Stage stage);

    @Mapping(target = "cyclist.teamName", source = "cyclist.team.name")
    ListCyclistDTO toListStageCyclistDTO(StageCyclist stageCyclist);

    List<StageDTO> toDTOs(List<Stage> stages);
}
