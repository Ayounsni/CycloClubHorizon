package com.chh.models.dtos.CompetitionCyclist;

import com.chh.models.dtos.StageCyclist.StageCylistEmbeddableIdDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetitionCyclistDTO {
    private CompetitionCyclistEmbeddableIdDTO id;
}
