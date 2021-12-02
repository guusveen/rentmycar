package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Car;
import com.example.rentmycarapi.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cars")
public class CarController {
    private final CarRepository carRepository;


    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        carRepository.save(car);
        return car;
    }

    @GetMapping()
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }


}
