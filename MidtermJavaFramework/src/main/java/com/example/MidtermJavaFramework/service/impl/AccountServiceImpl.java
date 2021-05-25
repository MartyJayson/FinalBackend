package com.example.MidtermJavaFramework.service.impl;

import com.example.MidtermJavaFramework.entity.Account;
import com.example.MidtermJavaFramework.repository.AccountRepository;
import com.example.MidtermJavaFramework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void addAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.saveAndFlush(account);
    }
    
    @Override
    public void updateAccount(Long id, Account student) {
        Account userDb =accountRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(student.getUsername());
            userDb.setPassword(student.getPassword()); // plaintext password

            accountRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("Error! Account: " + username + " not found!");
        }
        return account;
    }
}
