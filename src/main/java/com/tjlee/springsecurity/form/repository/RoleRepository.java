package com.tjlee.springsecurity.form.repository;

import com.tjlee.springsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByAccountId(Long id);
}
