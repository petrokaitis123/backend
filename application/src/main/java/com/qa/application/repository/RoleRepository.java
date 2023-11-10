package com.qa.application.repository;

import com.qa.application.enums.ERole;
import com.qa.application.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
    Role findRoleByName(ERole name);
}
