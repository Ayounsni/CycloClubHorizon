package com.chh.models.entities;

import com.chh.models.embeddableId.StageCyclistId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import java.time.Duration;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StageCyclist {

    @EmbeddedId
    private StageCyclistId id;

    @ManyToOne
    @MapsId("cyclistId")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("stageId")
    private Stage stage;

    @NotNull
    private Duration time;

    private Integer range;

    public StageCyclist(Long cyclistId, Long stageId, Duration time) {
        this.id = new StageCyclistId(stageId, cyclistId);
        this.time = time;
    }
}
