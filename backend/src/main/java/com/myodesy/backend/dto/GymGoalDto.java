package com.myodesy.backend.dto;
 
import jakarta.validation.constraints.*;

public class GymGoalDto {
    private Long gymGoalId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Categoria ID is required")
    private Long categoryId;

    @NotNull(message = "Cantidad de días is required")
    @Min(value = 1, message = "Debe ser mayor a 0")
    private Integer weeklyGymDays;

    @NotNull(message = "Dias para ir is required")
    @Min(value = 1, message = "Debe ser mayor a 0")
    private Integer targetDaysPerWeek;

    @NotNull(message = "Meta activa is required")
    private Boolean activeGoal;

    public Long getGymGoalId() { return gymGoalId; }
    public void setGymGoalId(Long id) { this.gymGoalId   = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long id) { this.userId     = id; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public Integer getWeeklyGymDays() { return weeklyGymDays; }
    public void setWeeklyGymDays(Integer d) { this.weeklyGymDays = d; }

    public Integer getTargetDaysPerWeek() { return targetDaysPerWeek; }
    public void setTargetDaysPerWeek(Integer d) { this.targetDaysPerWeek = d; }

    public Boolean getActiveGoal() { return activeGoal; }
    public void setActiveGoal(Boolean a) { this.activeGoal = a; }
}