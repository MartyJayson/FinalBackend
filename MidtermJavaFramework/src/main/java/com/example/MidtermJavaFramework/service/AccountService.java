package com.example.MidtermJavaFramework.service;

import com.example.MidtermJavaFramework.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccount();
    void createAccount(Account account);
    void updateAccount(Long id, Account account);

}
