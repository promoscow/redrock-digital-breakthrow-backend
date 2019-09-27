package ru.xpendence.auth.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.service.UserService;


@Service
public class JwtDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return JwtUser.create(userService.getByUsername(username));
    }
}
