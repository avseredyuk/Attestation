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
public class HeavyTruck extends CargoVehicle {

    public HeavyTruck(final String model, final String nubmer, final String VIN,
                      final DriverLicense.Category category,
                      final int priceperKM, final int cargoCapacity) {
        super(model, nubmer, VIN, category, priceperKM, cargoCapacity);
    }

    @Override
    public final String toString() {
        return "HeavyTruck{" + super.toString() + '}';
    }
    
}
