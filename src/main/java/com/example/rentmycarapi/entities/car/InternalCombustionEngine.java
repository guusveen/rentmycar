package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.enums.FuelType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class InternalCombustionEngine extends Car {

    @Getter
    @Setter
    private FuelType fuelType;

    public InternalCombustionEngine() {
    }

    public InternalCombustionEngine(
            User owner,
            String model,
            String picture,
            FuelType fuelType
    ) {
        super(owner, model, picture);
        this.fuelType = fuelType;
    }

    @Override
    public int getCostsPerKM() {
        return 1;
    }

    @Override
    public int getTCO() {
        return 800;
    }
}
