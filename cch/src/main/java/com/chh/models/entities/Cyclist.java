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
@Setter
@Getter
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
    private Team team;


    @OneToMany(mappedBy = "cyclist", cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    private List<CompetitionCyclist> competitions ;


    @OneToMany(mappedBy = "cyclist" ,  fetch = FetchType.EAGER)
    private List<StageCyclist> stages ;


}

