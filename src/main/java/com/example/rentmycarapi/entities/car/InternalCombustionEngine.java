package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.enums.FuelType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Child of Car class with own implementation of methods
 */
@Entity
public class InternalCombustionEngine extends Car {

    @Getter
    @Setter
    private FuelType fuelType;

    /**
     * Empty constructor
     */
    public InternalCombustionEngine() {
    }

    /**
     * Constructor
     * @param owner
     * @param model
     * @param picture
     * @param fuelType
     */
    public InternalCombustionEngine(User owner, String model, String picture, FuelType fuelType) {
        super(owner, model, picture);
        this.fuelType = fuelType;
    }

    /**
     * Get costs per KM
     * @return
     */
    @Override
    public int getCostsPerKM() {
        return 1;
    }

    /**
     * Get total cost of ownership
     * @return
     */
    @Override
    public int getTCO() {
        return 800;
    }
}
