package com.myodesy.backend.dto;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 
public class RoutineTypeDto {
 
    private Long idRoutineType;
 
    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;
 
    @Size(max = 255)
    private String description;
 
    private Boolean active;
 
    public RoutineTypeDto() {}
 
    public Long    getIdRoutineType()           { return idRoutineType; }
    public void    setIdRoutineType(Long id)    { this.idRoutineType = id; }
    public String  getName()                 { return name; }
    public void    setName(String n)         { this.name = n; }
    public String  getDescription()            { return description; }
    public void    setDescription(String d)    { this.description = d; }
    public Boolean getActive()                 { return active; }
    public void    setActive(Boolean a)        { this.active = a; }
}