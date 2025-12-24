package com.yassin.myapp.repository;

import com.yassin.myapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // The first parameter <Account> is the Entity type
    // The second parameter <Long> is the type of the @Id field
}