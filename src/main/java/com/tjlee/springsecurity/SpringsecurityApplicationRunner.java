package com.tjlee.springsecurity;

import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringsecurityApplicationRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        accountService.createNew(new Account("admin", "1111", Arrays.asList("ADMIN", "USER", "SUPERADMIN")));
//        accountService.createNew(new Account("tjlee1", "1111", Arrays.asList("USER")));
//        accountService.createNew(new Account("tjlee2", "1111", Arrays.asList("USER")));
//        accountService.createNew(new Account("tjlee3", "1111", Arrays.asList("USER")));
//        accountService.createNew(new Account("tjlee4", "1111", Arrays.asList("USER")));
//        accountService.createNew(new Account("tjlee5", "1111", Arrays.asList("USER")));
    }
}
