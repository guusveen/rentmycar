package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return UserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id) {
        return UserService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User User) {
        return UserService.createUser(User);
    }
}
