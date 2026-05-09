package com.myodesy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_ejercicio")
public class ExerciseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Long exerciseId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String name;

    @Column(name = "descripcion_ejercicio", length = 255)
    private String description;

    @Column(name = "repeticiones_minimas")
    private Integer repMin;

    @Column(name = "repeticiones_maximas")
    private Integer repMax;

    @Column(name = "series")
    private Integer series;

    @Column(name = "activo", nullable = false)
    private Boolean active = true;

    public ExerciseType() {}

    public ExerciseType(String name, String description, Integer minRepetitions, Integer maxRepetitions, Integer series) {
        this.name = name;
        this.description = description;
        this.repMin = minRepetitions;
        this.repMax = maxRepetitions;
        this.series = series;
    }

    public Long getExerciseId() { return exerciseId; }

    public String getName() { return name; }
    public void setName(String n) { this.name = n; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public Integer getRepMin() { return repMin; }
    public void setRepMin(Integer m) { this.repMin = m; }

    public Integer getRepMax() { return repMax; }
    public void setRepMax(Integer m) { this.repMax = m; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer s) { this.series = s; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}