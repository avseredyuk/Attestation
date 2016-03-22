/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Vehicles;

import entities.Bureaucracy.DriverLicense;

/**
 *
 * @author lenfer
 */
public class Universal extends UniversalVehicle {
    private static final int MAX_CARGO_CAPACITY = 7500;
    private static final int MAX_PASSENGER_CAPACITY = 16;
    private static final String ERROR_TOO_BIG_CARGO = 
            "Too big cargo for <Universal>";
    private static final String ERROR_TOO_MUCH_PASSENGERS = 
            "Too much passengers for <Universal>";
    
    public Universal(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM,
            final int cargoCapacity,
            final int passengerCapacity) {
        super(model, nubmer, VIN, category, priceperKM, cargoCapacity, passengerCapacity);
        checkCargoCapacityWithinCategory(cargoCapacity);
        checkPassengerCapacityWithinCategory(passengerCapacity);
    }
    
    private void checkCargoCapacityWithinCategory(final int cargoCapacity) {
        if (cargoCapacity > Universal.MAX_CARGO_CAPACITY) {
            throw new IllegalArgumentException(ERROR_TOO_BIG_CARGO);
        }
    }
    
    private void checkPassengerCapacityWithinCategory(final int passengerCapacity) {
        if (passengerCapacity > Universal.MAX_PASSENGER_CAPACITY) {
            throw new IllegalArgumentException(ERROR_TOO_MUCH_PASSENGERS);
        }
    }

    @Override
    public final void setCargoCapacity(final int cargoCapacity) {
        checkCargoCapacityWithinCategory(cargoCapacity);
        super.setCargoCapacity(cargoCapacity);
    }

    @Override
    public final void setPassengerCapacity(final int passengerCapacity) {
        checkPassengerCapacityWithinCategory(passengerCapacity);
        super.setPassengerCapacity(passengerCapacity);
    }

    @Override
    public String toString() {
        return "Universal{" + "MAX_CARGO_CAPACITY=" + MAX_CARGO_CAPACITY
                + ", MAX_PASSENGER_CAPACITY=" + MAX_PASSENGER_CAPACITY
                + ", " + super.toString() + '}';
    }
    
    
    
}
