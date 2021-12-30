package com.example.demo.entities.expense;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import com.example.demo.entities.currency.Currency;
import com.example.demo.entities.currency.CurrencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExpenseDatabaseLoader implements CommandLineRunner {

    final private ExpenseRepository repository;
    final private CurrencyRepository currencyRepository;

    /**
     * 
     */
    @Autowired
    public ExpenseDatabaseLoader(ExpenseRepository repository, CurrencyRepository currencyRepository) {
        this.repository = repository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Currency c = this.currencyRepository.save(new Currency("€", "EUR", "0", 2));
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        for (Integer i = 0; i < 10; i++) {
            expenses.add(new Expense("Credit Card", "Category " + i, i * 200.00f, c, Date.from(Instant.now())));
        }
        this.repository.saveAll(expenses);
    }

}
