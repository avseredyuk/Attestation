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
public class Truck extends CargoVehicle {
    private static final int MAX_CARGO_CAPACITY = 7500;
    private static final String ERROR_TOO_BIG_CARGO = 
            "Too big cargo for <Truck>";
    
    public Truck(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM,
            final int cargoCapacity) {
        super(model, nubmer, VIN, category, priceperKM, cargoCapacity);
        checkCargoCapacityWithinCategory(cargoCapacity);
    }
    
    private void checkCargoCapacityWithinCategory(final int cargoCapacity) {
        if (cargoCapacity > Truck.MAX_CARGO_CAPACITY) {
            throw new IllegalArgumentException(ERROR_TOO_BIG_CARGO);
        }
    }

    @Override
    public final void setCargoCapacity(final int cargoCapacity) {
        checkCargoCapacityWithinCategory(cargoCapacity);
        super.setCargoCapacity(cargoCapacity);
    }

    @Override
    public String toString() {
        return "Truck{" + "MAX_CARGO_CAPACITY=" + MAX_CARGO_CAPACITY
                + ", " + super.toString() + '}';
    }
    
}
