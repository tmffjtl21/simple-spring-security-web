package com.tjlee.springsecurity.form.repository;

import com.tjlee.springsecurity.form.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    Account getByUsername(String id);
}
