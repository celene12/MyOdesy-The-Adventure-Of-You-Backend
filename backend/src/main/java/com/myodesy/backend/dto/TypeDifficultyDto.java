package com.myodesy.backend.dto;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 
public class TypeDifficultyDto {
 
    private Long idTypeDifficulty;
 
    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;
 
    private Boolean active;
 
    public TypeDifficultyDto() {}
 
    public Long    getIdTypeDifficulty()        { return idTypeDifficulty; }
    public void    setIdTypeDifficulty(Long id) { this.idTypeDifficulty = id; }
    public String  getName()                  { return name; }
    public void    setName(String n)          { this.name = n; }
    public Boolean getActive()                  { return active; }
    public void    setActive(Boolean a)         { this.active = a; }
}