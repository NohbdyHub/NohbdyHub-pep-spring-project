package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.UsernameExistsException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account insertAccount(String username, String password) {
        if (repository.existsByUsername(username)) {
            throw new UsernameExistsException();
        }

        return repository.save(new Account(username, password));        
    }

    public Account getAccountByCredentials(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).orElseThrow();
    }
}
