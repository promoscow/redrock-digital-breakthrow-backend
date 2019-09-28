package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.entity.Person;
import ru.xpendence.auth.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}