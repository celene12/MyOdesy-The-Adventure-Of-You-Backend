package com.myodesy.backend.repository;

import com.myodesy.backend.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByPersonId(Long personId);
    List<Routine> findByActiveTrue();
}