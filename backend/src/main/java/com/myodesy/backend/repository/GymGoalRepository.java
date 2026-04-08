package com.myodesy.backend.repository;

import com.myodesy.backend.model.GymGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GymGoalRepository extends JpaRepository<GymGoal, Long> {
    List<GymGoal> findByUserId(Long userId);
}