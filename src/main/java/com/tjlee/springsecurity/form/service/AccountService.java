package com.tjlee.springsecurity.form.service;

import com.tjlee.springsecurity.form.domain.Account;
import com.tjlee.springsecurity.form.domain.Role;
import com.tjlee.springsecurity.form.dto.AccountDTO;
import com.tjlee.springsecurity.form.mapper.AccountMapper;
import com.tjlee.springsecurity.form.repository.AccountRepository;
import com.tjlee.springsecurity.form.repository.RoleRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;

    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, RoleRepository roleRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.accountMapper = accountMapper;
    }

    @SuppressWarnings("SuspiciousToArrayCall")
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

    public AccountDTO createNew(final AccountDTO accountDTO, final List<String> roleNames) {
        Account account = Optional.ofNullable(accountRepository.findByUsername(accountDTO.getUsername()))
                .map(returnAccount -> {         // update
                    returnAccount.setUsername(accountDTO.getUsername());
                    setRoles(returnAccount, roleNames);
                    return returnAccount;
                })
                .orElseGet(() -> {          // insert
                    Account returnAccount = accountMapper.toEntity(accountDTO);
                    setRoles(returnAccount, roleNames);
                    return returnAccount;
                });
        accountRepository.save(account);
        return accountMapper.toDTO(account);
    }

    public AccountDTO getAccount(String id) {
        return accountMapper.toDTO(accountRepository.findByUsername(id));
    }

    private void setRoles(Account account, final List<String> roleNames){

        // TODO 좀더 봐야함
        final List<String> roleList = account.getRoles()
                .stream().map(Role::getRoleName).collect(Collectors.toList());

        roleNames.forEach(roleName -> {
            if(!roleList.contains(roleName)){
                Role role = new Role();
                role.setRoleName(roleName);
                role.setAccountId(account.getId());
                role.setAccount(account);
                roleRepository.save(role);
                account.getRoles().add(role);
            }
        });
    }
}
