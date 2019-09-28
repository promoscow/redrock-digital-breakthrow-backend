package ru.xpendence.auth.service;

import org.springframework.stereotype.Service;
import ru.xpendence.auth.entity.RegistrationToken;
import ru.xpendence.auth.repository.RegistrationTokenRepository;

import javax.persistence.EntityNotFoundException;


@Service
public class RegistrationTokenServiceImpl implements RegistrationTokenService {

    private final RegistrationTokenRepository repository;

    public RegistrationTokenServiceImpl(RegistrationTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public RegistrationToken create(RegistrationToken registrationToken) {
        return repository.save(registrationToken);
    }

    @Override
    public RegistrationToken getByUsernameAndToken(String username, String token) {
        return repository.findByUsernameAndToken(username, token)
                .orElseThrow(() -> new EntityNotFoundException("token invalid"));
    }
}
