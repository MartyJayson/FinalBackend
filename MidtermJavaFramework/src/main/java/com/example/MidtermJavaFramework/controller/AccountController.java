package com.example.MidtermJavaFramework.controller;

import com.example.MidtermJavaFramework.entity.Account;
import com.example.MidtermJavaFramework.repository.AccountRepository;
import com.example.MidtermJavaFramework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello everyone!";
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<?> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
/*
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }*/

    @GetMapping("/create")
    public void createAccountByUsernamePassword(String username,
                                                String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        accountService.createAccount(account);
    }
    @PostMapping
    public void createAccount(@RequestBody Account account) {
        System.out.println("AccountController.createAccount");
        System.out.println("account = " + account);

        accountService.createAccount(account);
    }
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id,
                              @RequestBody Account account) {

        System.out.println("AccountController.updateAccount");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        accountService.updateAccount(id, account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountRepository.findById(id).get();
    }

/*
    // /users/find/?name=asdadas&age=20
  @GetMapping("/find/")
    public List<Account> getByNameContainingAndAge(@RequestParam String name,
                                                   @RequestParam("age") Integer age) {
        return accountRepository.findAllByNameContainsAndAge(name, age);
    }
*/


    @PatchMapping("/{id}")
    public Account updateAccountAge(@PathVariable Long id,
                                 @RequestParam Integer age) {
        Account account = accountRepository.findById(id).get();
        account.setAge(age);
        return accountRepository.saveAndFlush(account);
    }
    @DeleteMapping("/{id}")
    void deleteCart(@PathVariable Long id){
        accountRepository.deleteById(id);
    }
}
