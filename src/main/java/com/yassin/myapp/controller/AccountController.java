package com.yassin.myapp.controller; // Matches your package structure

import com.yassin.myapp.model.Account;
import com.yassin.myapp.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}