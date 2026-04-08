package com.myodesy.backend.service;

import com.myodesy.backend.dto.RoutineDto;
import com.myodesy.backend.model.Routine;
import com.myodesy.backend.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    private final RoutineRepository repository;

    public RoutineService(RoutineRepository repository) {
        this.repository = repository;
    }

    public List<RoutineDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public RoutineDto findById(Long id) {
        Routine r = repository.findById(id).orElseThrow();
        return toDto(r);
    }

    public RoutineDto create(RoutineDto dto) {
        Routine r = toEntity(dto);
        return toDto(repository.save(r));
    }

    public RoutineDto update(Long id, RoutineDto dto) {
        Routine r = repository.findById(id).orElseThrow();

        r.setRoutineTime(dto.getRoutineTime());
        r.setPersonId(dto.getPersonId());
        r.setRoutineTypeId(dto.getRoutineTypeId());
        r.setDifficultyTypeId(dto.getDifficultyTypeId());
        r.setActive(dto.getActive());

        return toDto(repository.save(r));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private RoutineDto toDto(Routine r) {
        RoutineDto dto = new RoutineDto();
        dto.setIdRoutine(r.getRoutineId());
        dto.setRoutineTime(r.getRoutineTime());
        dto.setPersonId(r.getPersonId());
        dto.setRoutineTypeId(r.getRoutineTypeId());
        dto.setDifficultyTypeId(r.getDifficultyTypeId());
        dto.setActive(r.getActive());
        return dto;
    }

    private Routine toEntity(RoutineDto dto) {
        Routine r = new Routine();
        r.setRoutineTime(dto.getRoutineTime());
        r.setPersonId(dto.getPersonId());
        r.setRoutineTypeId(dto.getRoutineTypeId());
        r.setDifficultyTypeId(dto.getDifficultyTypeId());
        r.setActive(dto.getActive());
        return r;
    }
}