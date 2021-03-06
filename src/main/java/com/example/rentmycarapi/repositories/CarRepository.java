package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The JPA repository for Car Entity
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByOwner(User owner);
}
