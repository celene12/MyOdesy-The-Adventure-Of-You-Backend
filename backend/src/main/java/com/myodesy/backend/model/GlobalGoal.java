package com.myodesy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_globales")
public class GlobalGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_global")
    private Long globalGoalId;

    @Column(name = "id_metas_de_categorias")
    private Long categoryId;

    @Column(name = "año")
    private Integer year;

    @Column(name = "mes")
    private Integer month;

    @Column(name = "cumplio_la_meta")
    private Boolean completed;

    @Column(name = "dia_del_mes")
    private LocalDate dayOfMonth;

    @Column(name = "tiempo_en_que_lo_completo")
    private Integer completionTime;

    @Column(name = "porcentaje_de_avance")
    private Double progressPercentage;

    @Column(name = "dias_en_que_tardo_completar_tarea")
    private Integer daysToComplete;

    @Column(name = "fecha_de_creacion")
    private LocalDateTime createdAt;

    @Column(name = "fecha_de_actualizacion")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getGlobalGoalId() { return globalGoalId; }
    public void setGlobalGoalId(Long id) { this.globalGoalId = id; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public Integer getYear() { return year; }
    public void setYear(Integer y) { this.year = y; }

    public Integer getMonth() { return month; }
    public void setMonth(Integer m) { this.month = m; }

    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean c) { this.completed = c; }

    public LocalDate getDayOfMonth() { return dayOfMonth; }
    public void setDayOfMonth(LocalDate d) { this.dayOfMonth = d; }

    public Integer getCompletionTime() { return completionTime; }
    public void setCompletionTime(Integer t) { this.completionTime = t; }

    public Double getProgressPercentage() { return progressPercentage; }
    public void setProgressPercentage(Double p) { this.progressPercentage = p; }

    public Integer getDaysToComplete() { return daysToComplete; }
    public void setDaysToComplete(Integer d) { this.daysToComplete = d; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}