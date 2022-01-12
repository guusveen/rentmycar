package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This is the RestController for accessing UserService methods
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    /**
     * Instance of UserService
     */
    private final UserService UserService;

    /**
     * Constructor
     * @param UserService
     */
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    /**
     * Gets all users
     * @return
     */
    @GetMapping
    public Iterable<User> getAll() {
        return UserService.getAll();
    }

    /**
     * Gets user by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id) {
        return UserService.getById(id);
    }

    /**
     * Creates user
     * @param User
     * @return
     */
    @PostMapping
    public User createUser(@RequestBody User User) {
        return UserService.createUser(User);
    }
}
