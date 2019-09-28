package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.service.CoursesService;

import java.io.IOException;
import java.util.Set;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @PostMapping("/courses")
    public Set<String> getListCourses(@RequestBody String query) throws IOException {
        String url = "https://www.coursera.org/";
        return coursesService.getListUrl(url, query);
    }
}
