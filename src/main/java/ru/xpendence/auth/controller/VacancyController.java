package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.xpendence.auth.dto.PersonDto;
import ru.xpendence.auth.dto.Vacancy;
import ru.xpendence.auth.dto.VacancyDto;
import ru.xpendence.auth.entity.Person;
import ru.xpendence.auth.mapper.PersonMapper;
import ru.xpendence.auth.service.PersonService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class VacancyController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/vacancies")
    public List<Vacancy> returnVacancy(@RequestParam Long id) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Person person = personService.getOnePerson(id);
        PersonDto personDto = personMapper.toDto(person);
        VacancyDto result = restTemplate.postForObject("http://localhost:5000/foo", personDto, VacancyDto.class);
        Map<String, Double> map = result.getName();
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String) mapElement.getKey();
            Double percent = (Double) mapElement.getValue();
            Long done = Math.round(percent * 100);
            String keyword = returnKeyWord().get(key);
            vacancyList.add(new Vacancy(id, key, done, keyword));
        }
        System.out.println(result);
        return vacancyList
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public Map<String, String> returnKeyWord() {
        Map<String, String> map = new HashMap<>();
        map.put("JAVA DEVELOPER", "java");
        map.put("ИНЖЕНЕР-ТЕСТИРОВЩИК", "Test Engineer");
        map.put("НАГРУЗОЧНЫЙ ТЕСТИРОВЩИК", "Test Engineer");
        map.put("IT-ИНЖЕНЕР", "IT ENGINEER");
        map.put("СИСТЕМНЫЙ АНАЛИТИК", "SYSTEMS ANALYST");
        map.put("PYTHON РАЗРАБОТЧИК", "python");
        map.put("FRONTEND DEVELOPER", "react");
        map.put("QA-ИНЖЕНЕР", "Test Engineer");
        map.put("БИЗНЕС-АНАЛИТИК", "BUSINESS ANALYST");
        map.put("СИСТЕМНЫЙ ИНЖЕНЕР", "SYSTEM ENGINEER");
        return map;
    }
}
