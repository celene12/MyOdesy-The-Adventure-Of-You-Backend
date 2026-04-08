package com.myodesy.backend.model;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "tipo_rutina")
public class RoutineType {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_rutina")
    private Long idRoutineType;
 
    @Column(name = "nombre", nullable = false, length = 100)
    private String name;
 
    @Column(name = "descripcion", length = 255)
    private String description;
 
    @Column(name = "activo", nullable = false)
    private Boolean active = true;
 
    public RoutineType() {}
 
    public Long    getIdRoutineType()           { return idRoutineType; }
    public void    setIdRoutineType(Long id)   { this.idRoutineType = id; }
    public String  getName()                 { return name; }
    public void    setName(String n)         { this.name = n; }
    public String  getDescription()            { return description; }
    public void    setDescription(String d)    { this.description = d; }
    public Boolean getActive()                 { return active; }
    public void    setActive(Boolean a)        { this.active = a; }
}