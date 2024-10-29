package com.chh.repository;

import com.chh.models.embeddableId.CyclistCompetitionId;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.Competition;
import com.chh.models.entities.CompetitionCyclist;
import com.chh.models.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionCyclistRepository extends JpaRepository<CompetitionCyclist, CyclistCompetitionId> {
    List<CompetitionCyclist> findByCyclist(Cyclist cyclist);
    List<CompetitionCyclist> findByCompetition(Competition competition);
    void deleteByCyclistAndCompetition(Cyclist cyclist, Competition competition);
}
