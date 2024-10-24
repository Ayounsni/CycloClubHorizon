package com.chh.models.entities;

import com.chh.models.embeddableId.StageCyclistId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageCyclist {

    @EmbeddedId
    private StageCyclistId id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    @JsonIgnore
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("stageId")
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @NotNull
    private Duration time;

    private Integer range;
}
