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
import java.util.Collections;

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
        accountService.createNew(new AccountDTO("tjlee1", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee2", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee3", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee4", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee5", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee6", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee7", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee8", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee9", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee10", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee11", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee12", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee13", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
        accountService.createNew(new AccountDTO("tjlee14", "1111", new ArrayList<String>()), Collections.singletonList("USER"));
    }
}

