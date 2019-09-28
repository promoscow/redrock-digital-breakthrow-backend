package ru.xpendence.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<User> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
