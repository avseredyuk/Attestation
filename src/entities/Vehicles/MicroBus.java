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
public class MicroBus extends PassengerVehicle {
    private static final int MAX_PASSENGER_CAPACITY = 16;
    private static final String ERROR_TOO_MUCH_PASSENGERS =
            "Too much passengers for <MicroBus>";
    
    public MicroBus(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM,
            final int passengerCapacity) {
        super(model, nubmer, VIN, category, priceperKM, passengerCapacity);
        checkPassengerCapacityWithinCategory(passengerCapacity);
    }
    
    private void checkPassengerCapacityWithinCategory(final int passengerCapacity) {
        if (passengerCapacity > MicroBus.MAX_PASSENGER_CAPACITY) {
            throw new IllegalArgumentException(ERROR_TOO_MUCH_PASSENGERS);
        }
    }

    @Override
    public final void setPassengerCapacity(final int passengerCapacity) {
        checkPassengerCapacityWithinCategory(passengerCapacity);
        super.setPassengerCapacity(passengerCapacity);
    }

    @Override
    public String toString() {
        return "MicroBus{" + "MAX_PASSENGER_CAPACITY="
                + MAX_PASSENGER_CAPACITY + ", " + super.toString() + '}';
    }
    
}