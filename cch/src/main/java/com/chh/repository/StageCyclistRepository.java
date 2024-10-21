package com.chh.repository;

import com.chh.models.entities.StageCyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageCyclistRepository extends JpaRepository<StageCyclist, Long> {
}
