package com.chh.models.entities;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer year;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @OneToMany(mappedBy = "competition",cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    @OrderBy("generalRange ASC")
    private List<CompetitionCyclist> cyclists ;

    @OneToMany(mappedBy = "competition",cascade = CascadeType.REMOVE,   fetch = FetchType.EAGER)
    private List<Stage> stages ;
}

