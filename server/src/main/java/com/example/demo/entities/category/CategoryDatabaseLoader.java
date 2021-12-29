package com.example.demo.entities.category;

import com.example.demo.utility.DatabaseLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDatabaseLoader extends DatabaseLoader<Category, CategoryRepository> {

    @Autowired
    public CategoryDatabaseLoader(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Category newInstance(Integer i) {
        return new Category("Category " + i);
    }

}
