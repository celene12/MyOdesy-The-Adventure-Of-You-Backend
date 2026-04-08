package com.myodesy.backend.controller;

import com.myodesy.backend.dto.GlobalGoalDto;
import com.myodesy.backend.service.GlobalGoalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myodesy/globalGoals")
public class GlobalGoalController {

    private final GlobalGoalService service;

    public GlobalGoalController(GlobalGoalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GlobalGoalDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalGoalDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<GlobalGoalDto> create(@Valid @RequestBody GlobalGoalDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalGoalDto> update(@PathVariable Long id,
                                                @Valid @RequestBody GlobalGoalDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}