package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.ElectricVehicle;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import com.example.rentmycarapi.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 */
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    /**
     * Constructor
     * @param carRepository
     */
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    /**
     *
     * @param car
     * @return
     */
    @Override
    public Car createICE(InternalCombustionEngine car) {
        return carRepository.save(car);
    }

    /**
     *
     * @param car
     * @return
     */
    @Override
    public Car createEV(ElectricVehicle car) {
        return carRepository.save(car);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
