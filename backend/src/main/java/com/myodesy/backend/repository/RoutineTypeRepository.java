package com.myodesy.backend.repository;

import com.myodesy.backend.model.RoutineType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoutineTypeRepository extends JpaRepository<RoutineType, Long> {
    List<RoutineType> findByActiveTrue();
}