package com.tjlee.springsecurity.form.mapper;

import com.tjlee.springsecurity.domain.Account;
import com.tjlee.springsecurity.domain.Role;
import com.tjlee.springsecurity.form.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "roles", source = "roles", defaultExpression = "java(getRoleList)")
    AccountDTO toDTO(Account entity);

    @Mapping(target = "roles", ignore = true)
    Account toEntity(AccountDTO dto);

    default List<String> getRoleList(List<Role> roles) {
        return roles.stream().map(Role::getRoleName).collect(Collectors.toList());
    }
}
