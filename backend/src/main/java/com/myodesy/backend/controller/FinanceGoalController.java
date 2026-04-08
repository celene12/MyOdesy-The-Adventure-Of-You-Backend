package com.myodesy.backend.controller;

import com.myodesy.backend.dto.FinanceGoalDto;
import com.myodesy.backend.service.FinanceGoalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myodesy/financeGoals")
public class FinanceGoalController {

    private final FinanceGoalService service;

    public FinanceGoalController(FinanceGoalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FinanceGoalDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinanceGoalDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<FinanceGoalDto> create(@Valid @RequestBody FinanceGoalDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinanceGoalDto> update(@PathVariable Long id,
                                                 @Valid @RequestBody FinanceGoalDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}