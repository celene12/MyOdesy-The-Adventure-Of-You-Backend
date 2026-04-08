package com.myodesy.backend.service;

import com.myodesy.backend.dto.GymGoalDto;
import com.myodesy.backend.model.GymGoal;
import com.myodesy.backend.repository.GymGoalRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymGoalService {

    private final GymGoalRepository repository;

    public GymGoalService(GymGoalRepository repository) {
        this.repository = repository;
    }

    public List<GymGoalDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public GymGoalDto findById(Long id) {
        GymGoal g = repository.findById(id).orElseThrow();
        return toDto(g);
    }

    public GymGoalDto create(GymGoalDto dto) {
        GymGoal g = toEntity(dto);
        return toDto(repository.save(g));
    }

    public GymGoalDto update(Long id, GymGoalDto dto) {
        GymGoal g = repository.findById(id).orElseThrow();

        g.setUserId(dto.getUserId());
        g.setCategoryId(dto.getCategoryId());
        g.setWeeklyGymDays(dto.getWeeklyGymDays());
        g.setTargetDaysPerWeek(dto.getTargetDaysPerWeek());
        g.setActiveGoal(dto.getActiveGoal());
        g.setUpdatedAt(LocalDateTime.now());

        return toDto(repository.save(g));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GymGoalDto toDto(GymGoal g) {
        GymGoalDto dto = new GymGoalDto();
        dto.setGymGoalId(g.getGymGoalId());
        dto.setUserId(g.getUserId());
        dto.setCategoryId(g.getCategoryId());
        dto.setWeeklyGymDays(g.getWeeklyGymDays());
        dto.setTargetDaysPerWeek(g.getTargetDaysPerWeek());
        dto.setActiveGoal(g.getActiveGoal());
        return dto;
    }

    private GymGoal toEntity(GymGoalDto dto) {
        GymGoal g = new GymGoal();
        g.setUserId(dto.getUserId());
        g.setCategoryId(dto.getCategoryId());
        g.setWeeklyGymDays(dto.getWeeklyGymDays());
        g.setTargetDaysPerWeek(dto.getTargetDaysPerWeek());
        g.setActiveGoal(dto.getActiveGoal());
        return g;
    }
}