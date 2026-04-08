package com.myodesy.backend.controller;
 
import com.myodesy.backend.dto.TypeDifficultyDto;
import com.myodesy.backend.service.TypeDifficultyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/myodesy/typeDifficulty")
public class TypeDifficultyController {
 
    private final TypeDifficultyService service;
 
    public TypeDifficultyController(TypeDifficultyService service) {
        this.service = service;
    }
 
    @GetMapping
    public ResponseEntity<List<TypeDifficultyDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<TypeDifficultyDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
 
    @PostMapping
    public ResponseEntity<TypeDifficultyDto> create(@Valid @RequestBody TypeDifficultyDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<TypeDifficultyDto> update(@PathVariable Long id,
                                                     @Valid @RequestBody TypeDifficultyDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
 