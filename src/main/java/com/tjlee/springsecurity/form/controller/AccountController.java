package com.tjlee.springsecurity.form.controller;

import com.tjlee.springsecurity.form.domain.Account;
import com.tjlee.springsecurity.form.domain.Role;
import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{username}/{password}")
    public Account createAccount (@ModelAttribute Account account, @RequestParam String[] roleNames){
        System.out.println(roleNames.toString());
        return accountService.createNew(account, roleNames);
    }

    @GetMapping("/account/username/{id}")
    public Account getAccount (@PathVariable String id){
        return accountService.getAccount(id);
    }
}
