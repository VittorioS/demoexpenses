package com.example.demo.utility;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class DatabaseLoader<T, R extends CrudRepository> implements CommandLineRunner {

    final private R repository;

    /**
     * 
     */
    @Autowired
    public DatabaseLoader(R repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<T> expenses = new ArrayList<T>();
        for (Integer i = 0; i < 10; i++) {
            expenses.add(newInstance(i));
        }
        this.repository.deleteAll();
        this.repository.saveAll(expenses);
    }

    public abstract T newInstance(Integer i);
}
