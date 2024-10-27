package com.chh.models.dtos.Cyclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCyclistsDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String nationality;
    private Integer age;
}
