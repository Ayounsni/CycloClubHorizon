package com.chh.models.dtos.StageCyclist;

import com.chh.models.dtos.Cyclist.CyclistDTO;
import com.chh.models.dtos.Cyclist.ListCyclistsDTO;
import com.chh.models.dtos.Stage.StageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCyclistDTO {
    private CyclistDTO cyclist;
    @JsonFormat(pattern = "HH:mm:ss")
    private String time;
    private Integer range;

    public void setTime(Duration duration) {
        this.time = duration != null ? String.format("%02d:%02d:%02d",
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart()) : null;
    }
}
