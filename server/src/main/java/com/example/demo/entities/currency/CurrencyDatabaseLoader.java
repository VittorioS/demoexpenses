package com.example.demo.entities.currency;

import com.example.demo.utility.DatabaseLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDatabaseLoader extends DatabaseLoader<Currency, CurrencyRepository> {

    @Autowired
    public CurrencyDatabaseLoader(CurrencyRepository repository) {
        super(repository);
    }

    @Override
    public Currency newInstance(Integer i) {
        return new Currency("€", "EUR" + i, i.toString(), 2);
    }

}
