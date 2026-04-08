package com.myodesy.backend.dto;

import jakarta.validation.constraints.*;

public class FinanceGoalDto {

    private Long financeGoalId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Categoria is required")
    private Long categoryId;

    @Min(0)
    private Double monthlySavingGoal;

    @Min(0)
    private Double currentSaving;

    @Min(0)
    private Double monthlyExpenses;

    @NotNull(message = "Categoria de finanzas is required")
    private Long categoryFinanceId;

    @Min(0)
    private Double yearlyGoal;

    @Min(0)
    private Double monthlyIncome;

    public Long getFinanceGoalId() { return financeGoalId; }
    public void setFinanceGoalId(Long id) { this.financeGoalId = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long id) { this.userId = id; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public Double getMonthlySavingGoal() { return monthlySavingGoal; }
    public void setMonthlySavingGoal(Double m) { this.monthlySavingGoal = m; }

    public Double getCurrentSaving() { return currentSaving; }
    public void setCurrentSaving(Double a) { this.currentSaving = a; }

    public Double getMonthlyExpenses() { return monthlyExpenses; }
    public void setMonthlyExpenses(Double g) { this.monthlyExpenses = g; }

    public Long getCategoryFinanceId() { return categoryFinanceId; }
    public void setCategoryFinanceId(Long id) { this.categoryFinanceId = id; }

    public Double getYearlyGoal() { return yearlyGoal; }
    public void setYearlyGoal(Double y) { this.yearlyGoal = y; }

    public Double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(Double i) { this.monthlyIncome = i; }
}