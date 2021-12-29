package com.example.demo.entities.account;

import com.example.demo.utility.DatabaseLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDatabaseLoader extends DatabaseLoader<Account, AccountRepository> {

    @Autowired
    public AccountDatabaseLoader(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account newInstance(Integer i) {
        return new Account("Credit Card " + i);
    }

}
