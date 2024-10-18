package com.chh.repository;

import com.chh.models.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
