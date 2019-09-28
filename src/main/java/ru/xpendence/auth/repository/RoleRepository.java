package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}
