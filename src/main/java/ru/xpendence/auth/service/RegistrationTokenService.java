package ru.xpendence.auth.service;

import ru.xpendence.auth.entity.RegistrationToken;


public interface RegistrationTokenService {

    RegistrationToken create(RegistrationToken registrationToken);

    RegistrationToken getByUsernameAndToken(String username, String token);
}
