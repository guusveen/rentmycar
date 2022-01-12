package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.User;

import javax.persistence.Entity;

/**
 * Child of Car class with own implementation of methods
 */
@Entity
public class ElectricVehicle extends Car {
    /**
     * Empty constructor
     */
    public ElectricVehicle() {
    }

    /**
     * Constructor
     * @param owner
     * @param model
     * @param picture
     */
    public ElectricVehicle(User owner, String model, String picture) {
        super(owner, model, picture);
    }

    /**
     * Get Costs per KM
     * @return
     */
    @Override
    public int getCostsPerKM() {
        return 0;
    }

    /**
     * Get Total cost of ownership
     * @return
     */
    @Override
    public int getTCO() {
        return 0;
    }
}
