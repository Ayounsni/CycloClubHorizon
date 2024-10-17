package com.chh.models.entities;

import com.chh.models.embeddableId.StageCyclistId;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StageCyclist {

    @EmbeddedId
    private StageCyclistId id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("stageId")
    @JoinColumn(name = "stage_id")
    private Stage stage;

    private Duration time;
    private Integer range;
}
