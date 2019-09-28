package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.auth.dto.CoursesDto;
import ru.xpendence.auth.service.CoursesService;

import java.io.IOException;
import java.util.Set;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses")
    public Set<CoursesDto> getListCourses(@RequestParam String query) throws IOException {
        String url = "https://www.coursera.org/";
        return coursesService.getListUrl(url, query);
    }
}
