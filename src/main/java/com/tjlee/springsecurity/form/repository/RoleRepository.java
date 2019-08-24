package com.tjlee.springsecurity.form.repository;

import com.tjlee.springsecurity.form.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
