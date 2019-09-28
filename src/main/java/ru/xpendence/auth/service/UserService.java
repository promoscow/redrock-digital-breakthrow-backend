package ru.xpendence.auth.service;

import ru.xpendence.auth.dto.UserDto;
import ru.xpendence.auth.entity.User;


public interface UserService {

    User create(UserDto dto);

    User save(User user);

    User getByUsername(String username);

    User get(Long id);

    User confirm(User user);
}
