package com.chh.models.entities;

import com.chh.models.enums.StageType;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Enumerated(EnumType.STRING)
    private StageType type;

    @ManyToOne
    private Competition competition;

    private boolean done = false;

    @OneToMany(mappedBy = "stage",cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    @OrderBy("range ASC")
    private List<StageCyclist> cyclists ;
}

