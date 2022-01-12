package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.ElectricVehicle;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import com.example.rentmycarapi.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This is the RestController for accessing CarService methods
 */
@RestController
@RequestMapping("/v1/cars")
public class CarController {
    /**
     * Instance of CarService
     */
    private final CarService carService;

    /**
     * Constructor
     * @param carService
     */
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Gets all cars
     * @return
     */
    @GetMapping()
    public Iterable<Car> getAll() {
        return carService.getAll();
    }

    /**
     * Get car by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id) {
        return carService.getById(id);
    }

    /**
     * Create an InternalCombustionEngine car in CarRepository
     * @param car
     * @return
     */
    @PostMapping("/ice")
    public Car createICE(@RequestBody InternalCombustionEngine car) {
        return carService.createICE(car);
    }

    /**
     * Create an ElectricVehicle car in CarRepository
     * @param car
     * @return
     */
    @PostMapping("/ev")
    public Car createEV(@RequestBody ElectricVehicle car) {
        return carService.createEV(car);
    }

    /**
     * Delete a car by id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        return carService.deleteById(id);
    }
}
