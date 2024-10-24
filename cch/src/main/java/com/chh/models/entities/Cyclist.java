package com.chh.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String nationality;

    @NotNull
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    @ToString.Exclude
    @OneToMany(mappedBy = "cyclist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CompetitionCyclist> competitions = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "cyclist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StageCyclist> stages = new ArrayList<>();


}

