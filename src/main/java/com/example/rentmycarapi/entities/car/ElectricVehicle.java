package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.User;

import javax.persistence.Entity;

@Entity
public class ElectricVehicle extends Car {
    public ElectricVehicle() {
    }

    public ElectricVehicle(
            User owner,
            String model,
            String picture
    ) {
        super(owner, model, picture);
    }

    @Override
    public int getCostsPerKM() {
        return 0;
    }

    @Override
    public int getTCO() {
        return 0;
    }
}
