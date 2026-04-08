package com.myodesy.backend.dto;

import jakarta.validation.constraints.*;

public class RoutineDto {

    private Long idRoutine;

    @NotNull(message = "Tiempo de rutina is required")
    @Min(value = 1, message = "Tiempo must be greater than 0")
    private Integer routineTime;

    @NotNull(message = "Persona ID is required")
    private Long personId;

    @NotNull(message = "Tipo de rutina ID is required")
    private Long routineTypeId;

    @NotNull(message = "Tipo de dificultad ID is required")
    private Long difficultyTypeId;

    @NotNull(message = "Active status is required")
    private Boolean active;

    public Long getIdRoutine() { return idRoutine; }
    public void setIdRoutine(Long idRoutine) { this.idRoutine = idRoutine; }

    public Integer getRoutineTime() { return routineTime; }
    public void setRoutineTime(Integer t) { this.routineTime = t; }

    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }

    public Long getRoutineTypeId() { return routineTypeId; }
    public void setRoutineTypeId(Long routineTypeId) { this.routineTypeId = routineTypeId; }

    public Long getDifficultyTypeId() { return difficultyTypeId; }
    public void setDifficultyTypeId(Long difficultyTypeId) { this.difficultyTypeId = difficultyTypeId; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}