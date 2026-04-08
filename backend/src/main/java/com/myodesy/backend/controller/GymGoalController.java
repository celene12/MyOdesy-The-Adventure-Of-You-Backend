package com.myodesy.backend.controller;

import com.myodesy.backend.dto.GymGoalDto;
import com.myodesy.backend.service.GymGoalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myodesy/gymGoals")
public class GymGoalController {

    private final GymGoalService service;

    public GymGoalController(GymGoalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GymGoalDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymGoalDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<GymGoalDto> create(@Valid @RequestBody GymGoalDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymGoalDto> update(@PathVariable Long id,
                                             @Valid @RequestBody GymGoalDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}