package com.tjlee.springsecurity;

import com.tjlee.springsecurity.form.dto.AccountDTO;
import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

@Component
@Transactional
@Order(1)
public class DataInsertRunner implements ApplicationRunner {

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    public DataInsertRunner(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(1, 15).forEach(value -> accountService.createNew(new AccountDTO("tjlee" + value, passwordEncoder.encode("1111"), Arrays.asList("USER", "ADMIN")),
                Collections.singletonList("USER")));

        accountService.createNew(new AccountDTO("admin", passwordEncoder.encode("admin"), null), Arrays.asList("USER", "ADMIN"));
    }
}

