package com.chh.models.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Cyclist> cyclists = new ArrayList<>();
}

