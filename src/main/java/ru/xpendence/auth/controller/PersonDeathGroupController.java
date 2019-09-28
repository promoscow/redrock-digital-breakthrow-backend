package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.entity.PersonDeathGroup;
import ru.xpendence.auth.repository.PersonDeathGroupDao;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PersonDeathGroupController {
    private final PersonDeathGroupDao personDeathGroupDao;

    @GetMapping("/risk")
    public List<PersonDeathGroup> getAll() {
        return personDeathGroupDao.findAll();
    }
}

