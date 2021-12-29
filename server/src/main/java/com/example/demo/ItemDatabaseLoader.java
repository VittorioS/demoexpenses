package com.example.demo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemDatabaseLoader implements CommandLineRunner {

    private final ItemRepository repository;

    @Autowired
    public ItemDatabaseLoader(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {
            items.add(new Item("Home " + i, i * 200.00f, "EUR", Date.from(Instant.now())));
        }
        this.repository.saveAll(items);
    }

}
