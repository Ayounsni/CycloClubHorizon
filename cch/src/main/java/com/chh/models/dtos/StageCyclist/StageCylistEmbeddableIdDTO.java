package com.chh.models.dtos.StageCyclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageCylistEmbeddableIdDTO {
    private Long stageId;
    private Long cyclistId;
}
