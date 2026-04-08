package com.myodesy.backend.service;
 
import com.myodesy.backend.dto.TypeDifficultyDto;
import com.myodesy.backend.model.TypeDifficulty;
import com.myodesy.backend.repository.TypeDifficultyRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class TypeDifficultyService {
 
    private final TypeDifficultyRepository repository;
 
    public TypeDifficultyService(TypeDifficultyRepository repository) {
        this.repository = repository;
    }
 
    public List<TypeDifficultyDto> findAll() {
        return repository.findByActiveTrue().stream()
                .map(this::toDTO).collect(Collectors.toList());
    }
 
    public TypeDifficultyDto findById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("TypeDifficulty not found with id: " + id));
    }
 
    public TypeDifficultyDto create(TypeDifficultyDto dto) {
        TypeDifficulty entity = new TypeDifficulty();
        entity.setName(dto.getName());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        return toDTO(repository.save(entity));
    }
 
    public TypeDifficultyDto update(Long id, TypeDifficultyDto dto) {
        TypeDifficulty existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeDifficulty not found with id: " + id));
        existing.setName(dto.getName());
        if (dto.getActive() != null) existing.setActive(dto.getActive());
        return toDTO(repository.save(existing));
    }
 
    public void delete(Long id) {
        TypeDifficulty existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeDifficulty not found with id: " + id));
        existing.setActive(false);
        repository.save(existing);
    }
 
    private TypeDifficultyDto toDTO(TypeDifficulty e) {
        TypeDifficultyDto dto = new TypeDifficultyDto();
        dto.setIdTypeDifficulty(e.getIdTypeDifficulty());
        dto.setName(e.getName());
        dto.setActive(e.getActive());
        return dto;
    }
}