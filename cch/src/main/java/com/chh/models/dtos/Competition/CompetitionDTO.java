package com.chh.models.dtos.Competition;

import com.chh.models.dtos.CompetitionCyclist.ListCyclistDTO;
import com.chh.models.dtos.Stage.ListStageDTO;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.Stage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDTO {
    private Long id;
    private String name;
    private Integer year;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private List<ListStageDTO> stages;
    private List<ListCyclistDTO> cyclists;
}
