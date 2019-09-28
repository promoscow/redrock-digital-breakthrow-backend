package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VacancyController {
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final RestTemplate restTemplate;


    @GetMapping("/vacancies")
    public List<Vacancy> returnVacancy(@RequestParam Long id) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Person person = personService.getOnePerson(id);
        PersonDto personDto = personMapper.toDto(person);
//        VacancyDto result = restTemplate.postForObject("http://smth:5000/foo", personDto, VacancyDto.class);
        VacancyDto result = new VacancyDto();
        result.setName(returnMock());
        Map<String, Double> map = result.getName();
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String) mapElement.getKey();
            Double percent = (Double) mapElement.getValue();
            Long done = Math.round(percent * 100);
            String keyword = returnKeyWord().get(key);
            vacancyList.add(new Vacancy(id, key, done, keyword));
        }
        return vacancyList
                .stream()
                .sorted(Comparator.comparingLong(Vacancy::getPercentage))
                .limit(5)
                .collect(Collectors.toList());
    }

    public Map<String, String> returnKeyWord() {
        Map<String, String> map = new HashMap<>();
        map.put("JAVA DEVELOPER", "java");
        map.put("ИНЖЕНЕР-ТЕСТИРОВЩИК", "tdd");
        map.put("НАГРУЗОЧНЫЙ ТЕСТИРОВЩИК", "tdd");
        map.put("IT-ИНЖЕНЕР", "IT");
        map.put("СИСТЕМНЫЙ АНАЛИТИК", "analytics");
        map.put("PYTHON РАЗРАБОТЧИК", "python");
        map.put("FRONTEND DEVELOPER", "react");
        map.put("QA-ИНЖЕНЕР", "tdd");
        map.put("БИЗНЕС-АНАЛИТИК", "analytics");
        map.put("СИСТЕМНЫЙ ИНЖЕНЕР", "analytics");
        return map;
    }

    public Map<String, Double> returnMock(){
        Map<String, Double> map = new HashMap<>();
        map.put("JAVA DEVELOPER", 0.03785254937332088);
        map.put("FRONTEND DEVELOPER", 0.11431410164191545);
        map.put("IT-ИНЖЕНЕР", 0.0381351135565087);
        map.put("PYTHON РАЗРАБОТЧИК", 0.17548899927149625);
        map.put("QA-ИНЖЕНЕР", 0.20143894703954274);
        map.put("БИЗНЕС-АНАЛИТИК", 0.26482843991856275);
        map.put("ИНЖЕНЕР-ТЕСТИРОВЩИК", 0.00995102071853255);
        map.put("НАГРУЗОЧНЫЙ ТЕСТИРОВЩИК", 0.048725766608213664);
        map.put("СИСТЕМНЫЙ АНАЛИТИК", 0.1092650618719052);
        return map;
    }
}