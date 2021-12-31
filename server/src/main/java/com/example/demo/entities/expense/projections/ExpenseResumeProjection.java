package com.example.demo.entities.expense.projections;

import java.time.DayOfWeek;

import com.example.demo.entities.expense.ExpenseResume;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "expenseResumeProjection", types = ExpenseResume.class)
public interface ExpenseResumeProjection {
    public DayOfWeek getDay();

    public int getDayOfWeekISO();

    public Double getAmount();
}
