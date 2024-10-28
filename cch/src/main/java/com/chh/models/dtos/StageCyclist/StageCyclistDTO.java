package com.chh.models.dtos.StageCyclist;

import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Stage.StageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageCyclistDTO {
    private StageDTO stage;
    private CyclistDTO cyclist;
    private Duration time;
    private Integer range;
}
