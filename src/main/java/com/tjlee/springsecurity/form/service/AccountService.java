package com.tjlee.springsecurity.form.service;

import com.tjlee.springsecurity.form.domain.Account;
import com.tjlee.springsecurity.form.domain.Role;
import com.tjlee.springsecurity.form.repository.AccountRepository;
import com.tjlee.springsecurity.form.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(accountRepository.findByUsername(username))
                    .map(member ->
                            User.builder()
                                .username(member.getUsername())
                                .password(member.getPassword())
                                .roles(member.getRoles().toArray(new String[0]))
                                .build())
                    .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public Account createNew(Account account, String[] roleNames) {
        account.encodePassword(passwordEncoder);
        accountRepository.save(account);

        for(String tt : roleNames){
            Role role = new Role();
            role.setRoleName(tt);
            role.setAccountId(account.getId());
            role.setAccount(account);
            roleRepository.save(role);

            account.getRoles().add(role);
        }
        return account;
    }

    public Account getAccount(String id) {
        return accountRepository.getByUsername(id);
    }
}
