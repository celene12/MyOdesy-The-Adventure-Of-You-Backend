package com.myodesy.backend.repository;

import com.myodesy.backend.model.TypeDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TypeDifficultyRepository extends JpaRepository<TypeDifficulty, Long> {
    List<TypeDifficulty> findByActiveTrue();
}