package com.yassin.myapp.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private Double balance = 0.0; // Default value to prevent NullPointer errors
    private String bankName;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    public Account() {
    }
    public Account(Long id, String name, AccountType type, String bankName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bankName = bankName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public AccountType getType() {
        return type;
    }
    public void setType(AccountType type) {
        this.type = type;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
