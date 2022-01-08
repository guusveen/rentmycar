package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.ElectricVehicle;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import com.example.rentmycarapi.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public Iterable<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id) {
        return carService.getById(id);
    }

    @PostMapping("/ice")
    public Car createICE(@RequestBody InternalCombustionEngine car) {
        return carService.createICE(car);
    }

    @PostMapping("/ev")
    public Car createEV(@RequestBody ElectricVehicle car) {
        return carService.createEV(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        return carService.deleteById(id);
    }
}
