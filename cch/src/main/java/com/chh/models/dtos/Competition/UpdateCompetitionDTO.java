package com.chh.models.dtos.Competition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompetitionDTO {
    private String name;
    private Integer year;
    private LocalDate startDate;
    private LocalDate endDate;
}
