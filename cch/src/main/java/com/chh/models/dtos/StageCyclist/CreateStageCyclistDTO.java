package com.chh.models.dtos.StageCyclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStageCyclistDTO {
    private StageCylistEmbeddableIdDTO id;
    private Duration time;
}
