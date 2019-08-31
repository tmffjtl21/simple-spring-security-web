package com.tjlee.springsecurity;

import com.tjlee.springsecurity.form.dto.AccountDTO;
import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

@Component
@Transactional
@Order(1)
public class DataInsertRunner implements ApplicationRunner {

    final AccountService accountService;

    @PersistenceContext
    EntityManager entityManager;

    public DataInsertRunner(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(1, 15).forEach(value -> accountService.createNew(new AccountDTO("tjlee" + value,"1111", Arrays.asList("USER", "ADMIN")),
                Collections.singletonList("USER")));
    }
}

