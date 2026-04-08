package com.myodesy.backend.service;

import com.myodesy.backend.dto.GlobalGoalDto;
import com.myodesy.backend.model.GlobalGoal;
import com.myodesy.backend.repository.GlobalGoalRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime; 

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GlobalGoalService {

    private final GlobalGoalRepository repository;

    public GlobalGoalService(GlobalGoalRepository repository) {
        this.repository = repository;
    }

    public GlobalGoalDto findById(Long id) {
        GlobalGoal g = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));

        return toDto(g);
    }

    public GlobalGoalDto create(GlobalGoalDto dto) {
        GlobalGoal g = toEntity(dto); 
        return toDto(repository.save(g)); 
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<GlobalGoalDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public GlobalGoalDto save(GlobalGoalDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    public GlobalGoalDto update(Long id, GlobalGoalDto dto) {
        GlobalGoal g = repository.findById(id).orElseThrow();

        g.setCategoryId(dto.getCategoryId());
        g.setYear(dto.getYear());
        g.setMonth(dto.getMonth());
        g.setCompleted(dto.getCompleted());
        g.setDayOfMonth(dto.getDayOfMonth());
        g.setCompletionTime(dto.getCompletionTime());
        g.setProgressPercentage(dto.getProgressPercentage());
        g.setDaysToComplete(dto.getDaysToComplete());
        g.setUpdatedAt(LocalDateTime.now());

        return toDto(repository.save(g));
    }

    private GlobalGoalDto toDto(GlobalGoal g) {
        GlobalGoalDto dto = new GlobalGoalDto();

        dto.setGlobalGoalId(g.getGlobalGoalId());
        dto.setCategoryId(g.getCategoryId());
        dto.setYear(g.getYear());
        dto.setMonth(g.getMonth());
        dto.setCompleted(g.getCompleted());
        dto.setDayOfMonth(g.getDayOfMonth());
        dto.setCompletionTime(g.getCompletionTime());
        dto.setProgressPercentage(g.getProgressPercentage());
        dto.setDaysToComplete(g.getDaysToComplete());

        return dto;
    }

    private GlobalGoal toEntity(GlobalGoalDto dto) {
        GlobalGoal g = new GlobalGoal();

        g.setCategoryId(dto.getCategoryId());
        g.setYear(dto.getYear());
        g.setMonth(dto.getMonth());
        g.setCompleted(dto.getCompleted());
        g.setDayOfMonth(dto.getDayOfMonth());
        g.setCompletionTime(dto.getCompletionTime());
        g.setProgressPercentage(dto.getProgressPercentage());
        g.setDaysToComplete(dto.getDaysToComplete());

        return g;
    }

}