package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> getAll();
    Optional<User> getById(Long id);

    User createUser(User user);
}
