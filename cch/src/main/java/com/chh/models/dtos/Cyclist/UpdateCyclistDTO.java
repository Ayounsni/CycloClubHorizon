package com.chh.models.dtos.Cyclist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCyclistDTO {
    private String firstname;
    private String lastname;
    private String nationality;
    private Integer age;
    private Long teamId;
}
