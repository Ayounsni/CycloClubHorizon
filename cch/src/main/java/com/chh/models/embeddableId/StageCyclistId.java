package com.chh.models.embeddableId;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageCyclistId implements Serializable {

    private Long stageId;
    private Long cyclistId;
}
