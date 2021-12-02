package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public boolean addUser(@RequestParam String username){
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
        return true;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userRepository.findUserById(id);
    }
}
