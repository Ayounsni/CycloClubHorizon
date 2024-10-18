package com.chh.repository;

import com.chh.models.entities.CompetitionCyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompetitionCyclistRepository extends JpaRepository<CompetitionCyclist, Long> {
}
