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
 * This class implements the methods of the CarService interface
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
     * Get all Cars in repository
     * @return
     */
    @Override
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    /**
     * Get Car by id in repository
     * @param id
     * @return
     */
    @Override
    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    /**
     * Create InternalCombustionEngine Car in repository
     * @param car
     * @return
     */
    @Override
    public InternalCombustionEngine createICE(InternalCombustionEngine car) {
        return carRepository.save(car);
    }

    /**
     * Create ElectricVehicle Car in repository
     * @param car
     * @return
     */
    @Override
    public ElectricVehicle createEV(ElectricVehicle car) {
        return carRepository.save(car);
    }

    /**
     * Delete Car by id from repository
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
