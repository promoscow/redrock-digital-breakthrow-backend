package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.entity.Skills;
import ru.xpendence.auth.repository.SkillsRepository;

import java.util.List;

@RestController
public class SkillsController {
    @Autowired
    private SkillsRepository skillsRepository;

    @GetMapping("/skills")
    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }
}

