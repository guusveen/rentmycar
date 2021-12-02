package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Integer id);
}
