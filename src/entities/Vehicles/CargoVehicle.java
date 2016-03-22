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
public class CargoVehicle extends Vehicle {
    private int cargoCapacity;

    public CargoVehicle(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM,
            final int cargoCapacity) {
        super(model, nubmer, VIN, category, priceperKM);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(final int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return "CargoVehicle{" + "cargoCapacity=" + cargoCapacity
                + ", Vehicle=" + super.toString() + '}';
    }
    
    
    
}
