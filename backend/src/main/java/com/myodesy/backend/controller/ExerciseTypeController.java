package com.myodesy.backend.controller;

import com.myodesy.backend.dto.ExerciseTypeDto;
import com.myodesy.backend.service.ExerciseTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myodesy/exercises")
public class ExerciseTypeController {

    private final ExerciseTypeService service;

    public ExerciseTypeController(ExerciseTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseTypeDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseTypeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ExerciseTypeDto> create(@Valid @RequestBody ExerciseTypeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseTypeDto> update(@PathVariable Long id,
                                              @Valid @RequestBody ExerciseTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}