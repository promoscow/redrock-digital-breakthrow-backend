package ru.xpendence.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.service.UserService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 24.09.19
 * Time: 20:59
 * e-mail: v.chernyshov@pflb.ru
 */
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
