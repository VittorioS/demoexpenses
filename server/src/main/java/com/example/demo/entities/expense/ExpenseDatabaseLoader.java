package com.example.demo.entities.expense;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExpenseDatabaseLoader implements CommandLineRunner {

    final private ExpenseRepository repository;

    /**
     * 
     */
    @Autowired
    public ExpenseDatabaseLoader(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        for (int i = 0; i < 10; i++) {
            expenses.add(new Expense("Credit Card", "Category " + i, i * 200.00f, "EUR", Date.from(Instant.now())));
        }
        this.repository.saveAll(expenses);
    }
    
}
