package com.chh.models.dtos.Stage;

import com.chh.models.dtos.Cyclist.ListCyclistsDTO;
import com.chh.models.dtos.StageCyclist.ListStageCyclistDTO;
import com.chh.models.enums.StageType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageDTO {
    private Long id;

    private Integer number;

    private String startLocation;

    private String endLocation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;

    private StageType type;

    private String competitionName;

    private List<ListStageCyclistDTO> stageCyclists;
}
