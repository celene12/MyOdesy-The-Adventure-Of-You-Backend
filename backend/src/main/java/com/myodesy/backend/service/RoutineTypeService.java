package com.myodesy.backend.service;
 
import com.myodesy.backend.dto.RoutineTypeDto;
import com.myodesy.backend.model.RoutineType;
import com.myodesy.backend.repository.RoutineTypeRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class RoutineTypeService {
 
    private final RoutineTypeRepository repository;
 
    public RoutineTypeService(RoutineTypeRepository repository) {
        this.repository = repository;
    }
 
    public List<RoutineTypeDto> findAll() {
        return repository.findByActiveTrue().stream()
                .map(this::toDTO).collect(Collectors.toList());
    }
 
    public RoutineTypeDto findById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("TipoRutina not found with id: " + id));
    }
 
    public RoutineTypeDto create(RoutineTypeDto dto) {
        RoutineType entity = new RoutineType();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        return toDTO(repository.save(entity));
    }
 
    public RoutineTypeDto update(Long id, RoutineTypeDto dto) {
        RoutineType existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoutineType not found with id: " + id));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        if (dto.getActive() != null) existing.setActive(dto.getActive());
        return toDTO(repository.save(existing));
    }
 
    public void delete(Long id) {
        RoutineType existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoutineType not found with id: " + id));
        existing.setActive(false);
        repository.save(existing);
    }
 
    private RoutineTypeDto toDTO(RoutineType e) {
        RoutineTypeDto dto = new RoutineTypeDto();
        dto.setIdRoutineType(e.getIdRoutineType());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }
}
 