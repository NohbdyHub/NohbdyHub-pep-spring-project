package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account insertAccount(String username, String password) {
       return null;
    }

    public Account getAccountByCredentials(String username, String password) {
        return null;
    }
}
