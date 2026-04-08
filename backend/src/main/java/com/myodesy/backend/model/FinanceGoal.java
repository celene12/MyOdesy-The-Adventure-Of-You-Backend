package com.myodesy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_finanzas")
public class FinanceGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_finanza")
    private Long financeGoalId;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "categoria")
    private Long categoryId;

    @Column(name = "meta_de_ahorro_del_mes")
    private Double monthlySavingGoal;

    @Column(name = "ahorro_actual")
    private Double currentSaving;

    @Column(name = "gastos_del_mes")
    private Double monthlyExpenses;

    @Column(name = "meta_anual")
    private Double yearlyGoal;

    @Column(name = "ingresos_del_mes")
    private Double monthlyIncome;

    @Column(name = "categorias_de_finanzas")
    private Long categoryFinanceId;

    @Column(name = "fecha_de_creacion")
    private LocalDateTime createdAt;

    @Column(name = "fecha_de_actualizacion")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getFinanceGoalId() { return financeGoalId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long id) { this.userId = id; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public Double getMonthlySavingGoal() { return monthlySavingGoal; }
    public void setMonthlySavingGoal(Double m) { this.monthlySavingGoal = m; }

    public Double getCurrentSaving() { return currentSaving; }
    public void setCurrentSaving(Double c) { this.currentSaving = c; }

    public Double getMonthlyExpenses() { return monthlyExpenses; }
    public void setMonthlyExpenses(Double g) { this.monthlyExpenses = g; }

    public Double getYearlyGoal() { return yearlyGoal; }
    public void setYearlyGoal(Double y) { this.yearlyGoal = y; }

    public Long getCategoryFinanceId() { return categoryFinanceId; }
    public void setCategoryFinanceId(Long id) { this.categoryFinanceId = id; }

    public Double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(Double i) { this.monthlyIncome = i; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}