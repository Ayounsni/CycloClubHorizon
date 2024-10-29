package com.chh.models.dtos.CompetitionCyclist;

import com.chh.models.dtos.Competition.CompetitionDTO;
import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.chh.models.dtos.StageCyclist.StageCylistEmbeddableIdDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionCyclistDTO {
    private CompetitionDTO competition;
    private CyclistDTO cyclist;
    @JsonFormat(pattern = "HH:mm:ss")
    private String generalTime;
    private Integer generalRange;

    public void setTime(Duration duration) {
        this.generalTime = duration != null ? String.format("%02d:%02d:%02d",
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart()) : null;
    }

}
