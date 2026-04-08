package com.myodesy.backend.dto;

import jakarta.validation.constraints.*;

public class ExerciseTypeDto {

    private Long idExercise;

    @NotBlank(message = "Nombre is required")
    @Size(max = 100, message = "Nombre must not exceed 100 characters")
    private String name;

    @Size(max = 255, message = "Descripcion must not exceed 255 characters")
    private String description;

    @NotNull(message = "Repeticiones mínimas is required")
    @Min(value = 1, message = "Minimum repetitions must be at least 1")
    private Integer repMin;

    @NotNull(message = "Repeticiones máximas is required")
    @Min(value = 1, message = "Maximum repetitions must be at least 1")
    private Integer repMax;

    @NotNull(message = "Series is required")
    @Min(value = 1, message = "Series must be at least 1")
    private Integer series;

    @NotNull(message = "Active status is required")
    private Boolean active;

    public Long getIdExercise() { return idExercise; }
    public void setIdExercise(Long id) { this.idExercise = id; }

    public String getName() { return name; }
    public void setName(String n) { this.name = n; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public Integer getRepMin() { return repMin; }
    public void setRepMin(Integer r) { this.repMin = r; }

    public Integer getRepMax() { return repMax; }
    public void setRepMax(Integer r) { this.repMax = r; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer s) { this.series = s; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}