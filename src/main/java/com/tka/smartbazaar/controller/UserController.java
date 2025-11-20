package com.tka.smartbazaar.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.tka.smartbazaar.dto.LoginDto;
import com.tka.smartbazaar.entity.User;
import com.tka.smartbazaar.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173/")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> list() { return service.listAll(); }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping("/register")
    public User register(@RequestBody User u) { return service.create(u); }
    
    @PostMapping("/login")
    public User login(@RequestBody LoginDto dto) {
        User u = service.findByEmail(dto.getEmail());

        if (u == null)
            throw new RuntimeException("Email not found");

        if (!u.getPassword().equals(dto.getPassword()))
            throw new RuntimeException("Incorrect password");

        return u; 
    }

}
