package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.dto.SkillDto;
import ru.xpendence.auth.mapper.SkillMapper;
import ru.xpendence.auth.repository.SkillsRepository;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SkillsController {
    private final SkillsRepository skillsRepository;
    private final SkillMapper skillMapper;

    @GetMapping("/skills")
    public List<SkillDto> getAllSkills() {
        return skillsRepository
                .findAll()
                .stream()
                .map(a -> skillMapper.toDto(a))
                .collect(Collectors.toList());
    }
}

