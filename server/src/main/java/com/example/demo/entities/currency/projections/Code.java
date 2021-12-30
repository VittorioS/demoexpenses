package com.example.demo.entities.currency.projections;

import com.example.demo.entities.currency.Currency;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "code", types = { Currency.class })
public interface Code {
    public String getCode();
}
