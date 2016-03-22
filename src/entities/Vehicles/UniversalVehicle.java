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
public class UniversalVehicle extends Vehicle {
    private int cargoCapacity;
    private int passengerCapacity;

    public UniversalVehicle(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM,
            final int cargoCapacity,
            final int passengerCapacity) {
        super(model, nubmer, VIN, category, priceperKM);
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(final int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(final int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "UniversalVehicle{" + "cargoCapacity=" + cargoCapacity
                + ", passengerCapacity=" + passengerCapacity
                + ", Vehicle=" + super.toString() + '}';
    }
    
}
