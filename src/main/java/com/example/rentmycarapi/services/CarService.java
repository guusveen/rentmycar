package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.ElectricVehicle;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CarService {
    Iterable<Car> getAll();
    Optional<Car> getById(Long id);

    Car createICE(InternalCombustionEngine car);
    Car createEV(ElectricVehicle car);

    ResponseEntity<HttpStatus> deleteById(Long id);
}
