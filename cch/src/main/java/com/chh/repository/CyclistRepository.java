package com.chh.repository;

import com.chh.models.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
}
