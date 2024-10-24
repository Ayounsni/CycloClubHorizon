package com.chh.models.entities;

import com.chh.models.embeddableId.CyclistCompetitionId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionCyclist {

    @EmbeddedId
    private CyclistCompetitionId id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    @JsonIgnore
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    @JsonIgnore
    private Competition competition;

    private Duration generalTime;
    private Integer generalRange;
}

