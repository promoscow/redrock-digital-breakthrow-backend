package ru.xpendence.auth.service;

import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.dto.PythonTestDto;
import ru.xpendence.auth.dto.UserDto;


public interface AuthService {

    String login(LoginDto dto);

    boolean register(UserDto dto);

    String confirmEmail(String username, String token);
}
