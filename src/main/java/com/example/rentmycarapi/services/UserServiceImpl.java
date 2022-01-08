package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public Iterable<User> getAll() {
        return UserRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return UserRepository.findById(id);
    }

    @Override
    public User createUser(User User) {
        return UserRepository.save(User);
    }
}
