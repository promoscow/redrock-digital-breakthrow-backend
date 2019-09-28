package ru.xpendence.auth.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.auth.dto.PersonDto;
import ru.xpendence.auth.dto.SkillDto;
import ru.xpendence.auth.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    @Autowired
    private SkillMapper skillMapper;


    public PersonDto toDto(Person person) {
        List<String> skillDtos =
                person.getSkills().stream()
                        .map(a -> skillMapper.toDto(a))
                        .map(SkillDto::getName)
                        .collect(Collectors.toList());
        return new PersonDto(person.getAge(), person.getGender(), skillDtos, person.getEducation(), person.getFromProfession());
    }

}
