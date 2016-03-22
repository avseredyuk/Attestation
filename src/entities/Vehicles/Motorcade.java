/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Vehicles;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenfer
 */
public class Motorcade {
    private static final String ERROR_NOT_ENOUGH_CARGO_VEHICLES =
            "Not enough cargo vehicles";
    private static final String ERROR_NOT_ENOUGH_PASSENGER_VEHICLES =
            "Not enough passenger vehicles";
    private static final String ERROR_CANT_FIT_INTO_MOTORCADE =
            "Cant fit needed cargo & passengers into your set of vehicles";
    private int neededCargoCapacity;
    private int neededPassengerCapacity;
    private final List<Vehicle> vehicles;
    private final List<Vehicle> motorcade = new ArrayList<>();
    private final int deliveryDistance;
    private int totalCost;

    public Motorcade(final int neededCargoCapacity,
                     final int neededPassengerCapacity,
                     final List<Vehicle> vehicles,
                     final int deliveryDistance) {
        this.neededCargoCapacity = neededCargoCapacity;
        this.neededPassengerCapacity = neededPassengerCapacity;
        this.vehicles = new ArrayList<>(vehicles);
        this.deliveryDistance = deliveryDistance;
        calculateMotorcade();
    }
    
    private void calculateMotorcade() {
        if ((isCargoCanFit()) && (isPassengersCanFit())) {
            while (isCargoLeft() || isPassengersLeft()) {
                if (isCargoLeft()) {
                    Vehicle vehicle = getNextCargo();
                    if (vehicle instanceof CargoVehicle) {
                        CargoVehicle cargoVehicle = (CargoVehicle) vehicle;
                        if (cargoVehicle == null) {
                            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_CARGO_VEHICLES);
                        }
                        totalCost = totalCost + cargoVehicle.getPriceperKM()
                                * deliveryDistance;
                        motorcade.add(cargoVehicle);
                        neededCargoCapacity = neededCargoCapacity
                                - cargoVehicle.getCargoCapacity();
                    } else if (vehicle instanceof UniversalVehicle) {
                        UniversalVehicle universalVehicle = 
                                (UniversalVehicle) vehicle;
                        if (universalVehicle == null) {
                            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_CARGO_VEHICLES);
                        }
                        totalCost = totalCost + universalVehicle.getPriceperKM()
                                * deliveryDistance;
                        motorcade.add(universalVehicle);
                        neededCargoCapacity = neededCargoCapacity
                                - universalVehicle.getCargoCapacity();
                    }
                }
                if (isPassengersLeft()) {
                    Vehicle vehicle = getNextPassenger();
                    if (vehicle instanceof PassengerVehicle) {
                        PassengerVehicle passengerVehicle =
                                (PassengerVehicle) vehicle;
                        if (passengerVehicle == null) {
                            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_PASSENGER_VEHICLES);
                        }
                        totalCost = totalCost + passengerVehicle.getPriceperKM()
                                * deliveryDistance;
                        motorcade.add(passengerVehicle);
                        neededPassengerCapacity = neededPassengerCapacity
                                - passengerVehicle.getPassengerCapacity();
                    } else if (vehicle instanceof UniversalVehicle) {
                        UniversalVehicle universalVehicle = 
                                (UniversalVehicle) vehicle;
                        if (universalVehicle == null) {
                            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_PASSENGER_VEHICLES);
                        }
                        totalCost = totalCost + universalVehicle.getPriceperKM()
                                * deliveryDistance;
                        motorcade.add(universalVehicle);
                        neededPassengerCapacity = neededPassengerCapacity
                                - universalVehicle.getPassengerCapacity();
                    }
                }
                
            }
        } else {
            throw new IllegalArgumentException(ERROR_CANT_FIT_INTO_MOTORCADE);
        }
    }
    
    public final int getTotalCost() {
        return totalCost;
    }
    
    private Vehicle getNextPassenger() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle instanceof PassengerVehicle) {
                vehicles.remove(vehicle);
                return vehicle;
            } else if (vehicle instanceof UniversalVehicle) {
                vehicles.remove(vehicle);
                return vehicle;
            }
        }
        return null;
    }
    
    private Vehicle getNextCargo() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle instanceof CargoVehicle) {
                return vehicle;
            } else if (vehicle instanceof UniversalVehicle) {
                return vehicle;
            }
        }
        return null;
    }
    
    private boolean isCargoCanFit() {
        return neededCargoCapacity <= getInputCargoSize();
    }
    
    private boolean isPassengersCanFit() {
        return neededPassengerCapacity <= getInputPassengerSize();
    }
    
    private int getInputPassengerSize() {
        int result = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof PassengerVehicle) {
                PassengerVehicle passengerVehicle = (PassengerVehicle) vehicle;
                result = result + passengerVehicle.getPassengerCapacity();
            } else if (vehicle instanceof UniversalVehicle) {
                UniversalVehicle universalVehicle = (UniversalVehicle) vehicle;
                result = result + universalVehicle.getPassengerCapacity();
            }
        }
        return result;
    }
    
    private int getInputCargoSize() {
        int result = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof CargoVehicle) {
                CargoVehicle cargoVehicle = (CargoVehicle) vehicle;
                result = result + cargoVehicle.getCargoCapacity();
            } else if (vehicle instanceof UniversalVehicle) {
                UniversalVehicle universalVehicle = (UniversalVehicle) vehicle;
                result = result + universalVehicle.getCargoCapacity();
            }
        }
        return result;
    }
    
    private boolean isCargoLeft() {
        return neededCargoCapacity > 0;
    }
    
    private boolean isPassengersLeft() {
        return neededPassengerCapacity > 0;
    }        
    
}
