package com.chh.models.entities;

import com.chh.models.embeddableId.CyclistCompetitionId;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionCyclist {

    @EmbeddedId
    private CyclistCompetitionId id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    private Competition competition;

    private Duration generalTime;
    private Integer generalRange;
}

