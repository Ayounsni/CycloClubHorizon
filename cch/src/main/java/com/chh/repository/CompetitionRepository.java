package com.chh.repository;

import com.chh.models.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    List<Competition> findByName(String name);
    List<Competition> findByStartDate(LocalDate startDate);
}
