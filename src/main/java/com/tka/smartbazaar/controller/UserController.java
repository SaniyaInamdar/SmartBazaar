package com.tka.smartbazaar.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.tka.smartbazaar.entity.User;
import com.tka.smartbazaar.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> list() { return service.listAll(); }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping("/register")
    public User register(@RequestBody User u) { return service.create(u); }
}
