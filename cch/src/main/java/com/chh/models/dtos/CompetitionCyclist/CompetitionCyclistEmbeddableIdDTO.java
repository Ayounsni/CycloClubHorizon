package com.chh.models.dtos.CompetitionCyclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionCyclistEmbeddableIdDTO {
    private Long competitionId;
    private Long cyclistId;
}
