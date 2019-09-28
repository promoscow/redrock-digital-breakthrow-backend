package ru.xpendence.auth.service;

import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;


public interface RoleService {

    Role getByType(RoleType roleType);
}
