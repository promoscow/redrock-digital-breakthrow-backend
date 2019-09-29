package ru.xpendence.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.xpendence.auth.dto.PersonDto;
import ru.xpendence.auth.dto.Vacancy;
import ru.xpendence.auth.dto.VacancyDto;
import ru.xpendence.auth.entity.Person;
import ru.xpendence.auth.mapper.PersonMapper;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VacancyService {
    private static final String URL = "http://smth:5000/foo";
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final RestTemplate restTemplate;

    public List<Vacancy> vacancies(Long id) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Person person = personService.getOnePerson(id);
        PersonDto personDto = personMapper.toDto(person);
        log.info("Send to url {} ", URL);
        VacancyDto result = getVacancyDto(personDto);
        log.info("Get dto {} ", result);
        Map<String, Double> map = result.getName();
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String) mapElement.getKey();
            Double percent = (Double) mapElement.getValue();
            Long done = Math.round(percent);
            String keyword = returnKeyWord().get(key);
            vacancyList.add(new Vacancy(id, key, done, keyword));
        }
        return vacancyList
                .stream()
                .sorted(Comparator.comparingLong(Vacancy::getPercentage).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public VacancyDto getVacancyDto(PersonDto personDto) {
        return restTemplate.postForObject(URL, personDto, VacancyDto.class);
    }

    public VacancyDto getVacancyDtoMock() {
        VacancyDto result = new VacancyDto();
        result.setName(returnMock());
        return result;
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

    public Map<String, Double> returnMock() {
        Map<String, Double> map = new HashMap<>();
        map.put("JAVA DEVELOPER", 0.43785254937332088);
        map.put("FRONTEND DEVELOPER", 0.31431410164191545);
        map.put("IT-ИНЖЕНЕР", 0.5381351135565087);
        map.put("PYTHON РАЗРАБОТЧИК", 0.77548899927149625);
        map.put("QA-ИНЖЕНЕР", 0.80143894703954274);
        map.put("БИЗНЕС-АНАЛИТИК", 0.66482843991856275);
        map.put("ИНЖЕНЕР-ТЕСТИРОВЩИК", 0.70995102071853255);
        map.put("НАГРУЗОЧНЫЙ ТЕСТИРОВЩИК", 0.548725766608213664);
        map.put("СИСТЕМНЫЙ АНАЛИТИК", 0.8092650618719052);
        return map;
    }

}
