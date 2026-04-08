package com.myodesy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_gym")
public class GymGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_gym")
    private Long gymGoalId;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Column(name = "categoria", nullable = false)
    private Long categoryId;

    @Column(name = "cantidad_dias_gym_semana")
    private Integer weeklyGymDays;

    @Column(name = "dias_para_ir_gym_semana")
    private Integer targetDaysPerWeek;

    @Column(name = "meta_activa_del_gym")
    private Boolean activeGoal;

    @Column(name = "fecha_de_creacion")
    private LocalDateTime createdAt;

    @Column(name = "fecha_de_actualizacion")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getGymGoalId() { return gymGoalId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long id) { this.userId = id; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public Integer getWeeklyGymDays() { return weeklyGymDays; }
    public void setWeeklyGymDays(Integer d) { this.weeklyGymDays = d; }

    public Integer getTargetDaysPerWeek() { return targetDaysPerWeek; }
    public void setTargetDaysPerWeek(Integer d) { this.targetDaysPerWeek = d; }

    public Boolean getActiveGoal() { return activeGoal; }
    public void setActiveGoal(Boolean a) { this.activeGoal = a; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}