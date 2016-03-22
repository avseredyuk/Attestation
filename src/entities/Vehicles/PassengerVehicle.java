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
public class PassengerVehicle extends Vehicle {
    private int passengerCapacity;

    public PassengerVehicle(final String model,
                            final String nubmer,
                            final String VIN,
                            final DriverLicense.Category category,
                            final int priceperKM,
                            final int passengerCapacity) {
        super(model, nubmer, VIN, category, priceperKM);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(final int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "PassengerVehicle{" + "passengerCapacity=" + passengerCapacity
                + ", " + super.toString() + '}';
    }
    
}
