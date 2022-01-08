package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import com.example.rentmycarapi.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cars")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping()
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody InternalCombustionEngine car) {
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
