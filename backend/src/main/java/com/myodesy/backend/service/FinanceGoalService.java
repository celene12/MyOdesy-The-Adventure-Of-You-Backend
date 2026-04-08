package com.myodesy.backend.service;

import com.myodesy.backend.dto.FinanceGoalDto;
import com.myodesy.backend.model.FinanceGoal;
import com.myodesy.backend.repository.FinanceGoalRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime; 

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceGoalService {

    private final FinanceGoalRepository repository;

    public FinanceGoalService(FinanceGoalRepository repository) {
        this.repository = repository;
    }

    public List<FinanceGoalDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public FinanceGoalDto findById(Long id) {
        FinanceGoal f = repository.findById(id).orElseThrow();
        return toDto(f);
    }

    public FinanceGoalDto create(FinanceGoalDto dto) {
        FinanceGoal f = toEntity(dto);
        return toDto(repository.save(f));
    }

    public FinanceGoalDto update(Long id, FinanceGoalDto dto) {
        FinanceGoal f = repository.findById(id).orElseThrow();

        f.setUserId(dto.getUserId());
        f.setCategoryId(dto.getCategoryId());
        f.setMonthlySavingGoal(dto.getMonthlySavingGoal());
        f.setCurrentSaving(dto.getCurrentSaving());
        f.setMonthlyExpenses(dto.getMonthlyExpenses());
        f.setCategoryFinanceId(dto.getCategoryFinanceId());
        f.setYearlyGoal(dto.getYearlyGoal());
        f.setMonthlyIncome(dto.getMonthlyIncome());
        f.setUpdatedAt(LocalDateTime.now());

        return toDto(repository.save(f));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FinanceGoalDto toDto(FinanceGoal f) {
        FinanceGoalDto dto = new FinanceGoalDto();
        dto.setFinanceGoalId(f.getFinanceGoalId());
        dto.setUserId(f.getUserId());
        dto.setCategoryId(f.getCategoryId());
        dto.setMonthlySavingGoal(f.getMonthlySavingGoal());
        dto.setCurrentSaving(f.getCurrentSaving());
        dto.setMonthlyExpenses(f.getMonthlyExpenses());
        dto.setCategoryFinanceId(f.getCategoryFinanceId());
        dto.setYearlyGoal(f.getYearlyGoal());
        dto.setMonthlyIncome(f.getMonthlyIncome());
        return dto;
    }

    private FinanceGoal toEntity(FinanceGoalDto dto) {
        FinanceGoal f = new FinanceGoal();
        f.setUserId(dto.getUserId());
        f.setCategoryId(dto.getCategoryId());
        f.setMonthlySavingGoal(dto.getMonthlySavingGoal());
        f.setCurrentSaving(dto.getCurrentSaving());
        f.setMonthlyExpenses(dto.getMonthlyExpenses());
        f.setCategoryFinanceId(dto.getCategoryFinanceId());
        f.setYearlyGoal(dto.getYearlyGoal());
        f.setMonthlyIncome(dto.getMonthlyIncome());
        return f;
    }
}