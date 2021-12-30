package com.example.demo.entities.expense.projections;

import java.util.Date;

import com.example.demo.entities.currency.Currency;
import com.example.demo.entities.currency.projections.Code;
import com.example.demo.entities.expense.Expense;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full", types = { Expense.class })
public interface Full {
    public String getAccount();

    public String getCategory();

    public Float getAmount();

    // public Currency getCurrency();
    public Code getCurrency();

    public Date getDate();

    @Value("#{target.currency.getCode()}")
    public String getCurrencyCode();
}
