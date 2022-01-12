package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The JPA repository of User class
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Integer id);
}
