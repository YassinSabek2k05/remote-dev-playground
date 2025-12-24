package com.yassin.myapp.repository;

import com.yassin.myapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // The first parameter <Expense> is the Entity type
    // The second parameter <Long> is the type of the @Id field
}