package com.example.rentmycarapi.interfaces;

/**
 * The methods in this interface have a different implementation for ElectricVehicle cars and InternalCombustionEngine cars
 */
public interface Costs {
    public int getCostsPerKM();
    public int getTCO();
}
