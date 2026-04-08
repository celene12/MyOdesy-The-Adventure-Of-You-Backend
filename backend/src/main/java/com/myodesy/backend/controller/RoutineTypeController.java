package com.myodesy.backend.controller;
 
import com.myodesy.backend.dto.RoutineTypeDto;
import com.myodesy.backend.service.RoutineTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/myodesy/RoutineType")
public class RoutineTypeController {
 
    private final RoutineTypeService service;
 
    public RoutineTypeController(RoutineTypeService service) {
        this.service = service;
    }
 
    @GetMapping
    public ResponseEntity<List<RoutineTypeDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<RoutineTypeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
 
    @PostMapping
    public ResponseEntity<RoutineTypeDto> create(@Valid @RequestBody RoutineTypeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<RoutineTypeDto> update(@PathVariable Long id,
                                                 @Valid @RequestBody RoutineTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
 