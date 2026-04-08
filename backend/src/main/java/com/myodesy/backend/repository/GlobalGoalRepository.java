package com.myodesy.backend.repository;

import com.myodesy.backend.model.GlobalGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GlobalGoalRepository extends JpaRepository<GlobalGoal, Long> {
    List<GlobalGoal> findByCategoryId(Long categoryId);
}