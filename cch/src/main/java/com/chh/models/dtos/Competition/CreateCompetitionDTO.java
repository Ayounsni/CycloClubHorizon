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
public class CreateCompetitionDTO {
    @NotBlank
    private String name;
    @NotNull
    private Integer year;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
}
