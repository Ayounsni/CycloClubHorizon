package com.chh.models.embeddableId;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyclistCompetitionId implements Serializable {

    private Long competitionId;
    private Long cyclistId;
}
