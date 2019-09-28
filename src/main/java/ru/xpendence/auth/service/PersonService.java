package ru.xpendence.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.entity.Person;
import ru.xpendence.auth.repository.PersonRepository;

import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person getOnePerson(Long id) {
        return personRepository.findById(id).get();
    }
}
