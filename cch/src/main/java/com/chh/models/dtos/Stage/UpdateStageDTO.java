package com.chh.models.dtos.Stage;

import com.chh.models.enums.StageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStageDTO {
    private Integer number;
    private String startLocation;
    private String endLocation;
    private LocalDate date;
    private LocalTime startTime;
    private StageType type;
    private Long competitionId;
}
