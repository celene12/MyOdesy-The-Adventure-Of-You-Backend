package com.myodesy.backend.repository;

import com.myodesy.backend.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {
    List<ExerciseType> findByActiveTrue();
}