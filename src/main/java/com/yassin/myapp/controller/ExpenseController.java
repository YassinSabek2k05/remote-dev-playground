package com.yassin.myapp.controller;

import com.yassin.myapp.model.Account;
import com.yassin.myapp.model.Expense;
import com.yassin.myapp.repository.AccountRepository;
import com.yassin.myapp.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseRepository expenseRepository;
    private final AccountRepository accountRepository;

    public ExpenseController(ExpenseRepository expenseRepository, AccountRepository accountRepository) {
        this.expenseRepository = expenseRepository;
        this.accountRepository = accountRepository;
    }
    @GetMapping
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }
}