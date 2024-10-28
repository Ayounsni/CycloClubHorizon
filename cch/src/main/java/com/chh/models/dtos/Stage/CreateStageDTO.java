package com.chh.models.dtos.Stage;

import com.chh.models.entities.Competition;
import com.chh.models.enums.StageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
public class CreateStageDTO {
    @NotNull
    private Integer number;

    @NotBlank
    private String startLocation;

    @NotBlank
    private String endLocation;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime startTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StageType type;

    @NotNull
    private Long competitionId;
}
