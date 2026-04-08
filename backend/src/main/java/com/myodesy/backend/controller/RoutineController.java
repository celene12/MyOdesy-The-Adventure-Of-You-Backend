package com.myodesy.backend.controller;

import com.myodesy.backend.dto.RoutineDto;
import com.myodesy.backend.service.RoutineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myodesy/routines")
public class RoutineController {

    private final RoutineService service;

    public RoutineController(RoutineService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoutineDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoutineDto> create(@Valid @RequestBody RoutineDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineDto> update(@PathVariable Long id,
                                             @Valid @RequestBody RoutineDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}