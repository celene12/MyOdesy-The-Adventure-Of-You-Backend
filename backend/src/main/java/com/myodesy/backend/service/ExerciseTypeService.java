package com.myodesy.backend.service;

import com.myodesy.backend.dto.ExerciseTypeDto;
import com.myodesy.backend.model.ExerciseType;
import com.myodesy.backend.repository.ExerciseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseTypeService {

    private final ExerciseTypeRepository repository;

    public ExerciseTypeService(ExerciseTypeRepository repository) {
        this.repository = repository;
    }

    public List<ExerciseTypeDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ExerciseTypeDto findById(Long id) {
        ExerciseType e = repository.findById(id).orElseThrow();
        return toDto(e);
    }

    public ExerciseTypeDto create(ExerciseTypeDto dto) {
        ExerciseType e = toEntity(dto);
        return toDto(repository.save(e));
    }

    public ExerciseTypeDto update(Long id, ExerciseTypeDto dto) {
        ExerciseType e = repository.findById(id).orElseThrow();

        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setRepMin(dto.getRepMin());
        e.setRepMax(dto.getRepMax());
        e.setSeries(dto.getSeries());
        e.setActive(dto.getActive());

        return toDto(repository.save(e));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ExerciseTypeDto toDto(ExerciseType e) {
        ExerciseTypeDto dto = new ExerciseTypeDto();
        dto.setIdExercise(e.getExerciseId()); // ✅ CORRECTO
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setRepMin(e.getRepMin());
        dto.setRepMax(e.getRepMax());
        dto.setSeries(e.getSeries());
        dto.setActive(e.getActive());
        return dto;
    }

    private ExerciseType toEntity(ExerciseTypeDto dto) {
        ExerciseType e = new ExerciseType();
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setRepMin(dto.getRepMin());
        e.setRepMax(dto.getRepMax());
        e.setSeries(dto.getSeries());
        e.setActive(dto.getActive());
        return e;
    }
}