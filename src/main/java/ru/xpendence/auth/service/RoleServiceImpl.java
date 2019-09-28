package ru.xpendence.auth.service;

import org.springframework.stereotype.Service;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;
import ru.xpendence.auth.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role getByType(RoleType roleType) {
        return repository.findByRoleType(roleType)
                .orElseThrow(() -> new EntityNotFoundException("role not found by type: " + roleType.name()));
    }
}
