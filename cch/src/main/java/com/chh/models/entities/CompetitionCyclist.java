package com.chh.models.entities;

import com.chh.models.embeddableId.CyclistCompetitionId;
import com.chh.models.embeddableId.StageCyclistId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionCyclist {

    @EmbeddedId
    private CyclistCompetitionId id;

    @ManyToOne
    @MapsId("cyclistId")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("competitionId")
    private Competition competition;

    private Duration generalTime;
    private Integer generalRange;

    public CompetitionCyclist(Competition competition, Cyclist cyclist) {
        this.id = new CyclistCompetitionId(competition.getId(), cyclist.getId());
        this.cyclist = cyclist;
        this.competition = competition;
    }
}

