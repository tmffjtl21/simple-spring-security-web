package com.tjlee.springsecurity.form.controller;

import com.tjlee.springsecurity.form.dto.AccountDTO;
import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{username}/{password}")
    public AccountDTO createAccount(@ModelAttribute AccountDTO accountDTO, @RequestParam String[] roleNames){
        System.out.println(Arrays.toString(roleNames));
        return accountService.createNew(accountDTO, roleNames);
    }

    @GetMapping("/account/username/{id}")
    public AccountDTO getAccount (@PathVariable String id){
        return accountService.getAccount(id);
    }
}
