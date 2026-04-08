package com.myodesy.backend.model;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "tipo_dificultad")
public class TypeDifficulty {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_dificultad")
    private Long idTypeDifficulty;
 
    @Column(name = "nombre", nullable = false, length = 100)
    private String name;
 
    @Column(name = "activo", nullable = false)
    private Boolean active = true;
 
    public TypeDifficulty() {}
 
    public Long    getIdTypeDifficulty()        { return idTypeDifficulty; }
    public String  getName()                  { return name; }
    public void    setName(String n)          { this.name = n; }
    public Boolean getActive()                  { return active; }
    public void    setActive(Boolean a)         { this.active = a; }
}
 