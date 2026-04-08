package com.myodesy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Long routineId;

    @Column(name = "tiempo_rutina")
    private Integer routineTime;

    @Column(name = "id_persona")
    private Long personId;

    @Column(name = "id_tipo_rutina")
    private Long routineTypeId;

    @Column(name = "id_tipo_dificultad")
    private Long difficultyTypeId;

    @Column(name = "activo", nullable = false)
    private Boolean active = true;

    public Routine() {}

    public Routine(Integer routineTime, Long personId, Long routineTypeId, Long difficultyTypeId) {
        this.routineTime = routineTime;
        this.personId = personId;
        this.routineTypeId = routineTypeId;
        this.difficultyTypeId = difficultyTypeId;
    }


    public Long getRoutineId() { return routineId; }
    public void setRoutineId(Long id) { this.routineId = id; }

    public Integer getRoutineTime() { return routineTime; }
    public void setRoutineTime(Integer t) { this.routineTime = t; }

    public Long getPersonId() { return personId; }
    public void setPersonId(Long p) { this.personId = p; }

    public Long getRoutineTypeId() { return routineTypeId; }
    public void setRoutineTypeId(Long r) { this.routineTypeId = r; }

    public Long getDifficultyTypeId() { return difficultyTypeId; }
    public void setDifficultyTypeId(Long d) { this.difficultyTypeId = d; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}