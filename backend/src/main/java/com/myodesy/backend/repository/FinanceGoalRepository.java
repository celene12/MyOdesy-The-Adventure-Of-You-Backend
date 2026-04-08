package com.myodesy.backend.repository;

import com.myodesy.backend.model.FinanceGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FinanceGoalRepository extends JpaRepository<FinanceGoal, Long> {
    List<FinanceGoal> findByUserId(Long userId);
}