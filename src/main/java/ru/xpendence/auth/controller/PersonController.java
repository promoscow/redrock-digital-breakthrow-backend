package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.dto.PersonDto;
import ru.xpendence.auth.entity.Person;
import ru.xpendence.auth.mapper.PersonMapper;
import ru.xpendence.auth.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/persons")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/person_dto")
    public List<PersonDto> getPersonDtos() {
        return personRepository.findAll().stream().map(p -> personMapper.toDto(p)).collect(Collectors.toList());
    }
}
