package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.dto.CoursesDto;
import ru.xpendence.auth.service.CoursesService;

import java.io.IOException;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CoursesController {
    private final CoursesService coursesService;

    @GetMapping("/courses")
    public Set<CoursesDto> getListCourses(@RequestParam String query) throws IOException {
        String url = "https://www.coursera.org/";
        return coursesService.getListUrl(url, query);
    }
}
