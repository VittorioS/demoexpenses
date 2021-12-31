package com.example.demo.entities.expense;

import java.time.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class ExpenseResume {
    private @Id DayOfWeek day;
    private Double amount;

    /**
     * @param day
     * @param amount
     */
    public ExpenseResume(DayOfWeek day, Double amount) {
        this.day = day;
        this.amount = amount;
    }

    /**
     * @param day
     * @param amount
     */
    public ExpenseResume(int day, Double amount) {
        this.day = DayOfWeek.of(day);
        this.amount = amount;
    }

    /**
     * @return the day
     */
    public DayOfWeek getDay() {
        return day;
    }

    /**
     * @return the day
     */
    public int getDayOfWeekISO() {
        return day.getValue();
    }

    /**
     * @param day the day to set
     */
    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
