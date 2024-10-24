package com.chh.models.dtos.Cyclist;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCyclistDTO {
    @NotBlank
    @Size(min = 5)
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String nationality;
    @NotNull
    private Integer age;
    @NotNull
    private Long teamId;
}
