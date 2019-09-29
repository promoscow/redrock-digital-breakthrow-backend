package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.dto.Vacancy;
import ru.xpendence.auth.service.VacancyService;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping("/vacancies")
    public List<Vacancy> returnVacancy(@RequestParam Long id) {
        return vacancyService.vacancies(id);
    }
}