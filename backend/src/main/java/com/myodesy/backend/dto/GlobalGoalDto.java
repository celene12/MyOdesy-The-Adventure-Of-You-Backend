package com.myodesy.backend.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class GlobalGoalDto {

    private Long globalGoalId;

    @NotNull(message = "Categoria ID is required")
    private Long categoryId;

    @NotNull(message = "Año is required")
    private Integer year;

    @NotNull(message = "Mes is required")
    @Min(value = 1)
    @Max(value = 12)
    private Integer month;

    private Boolean completed;

    @NotNull(message = "Dia del mes is required")
    private LocalDate dayOfMonth;

    private Integer completionTime;

    private Double progressPercentage;

    private Integer daysToComplete;

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
}