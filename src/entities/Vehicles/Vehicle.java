/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Vehicles;

import entities.Bureaucracy.DriverLicense;
import java.io.Serializable;

/**
 *
 * @author lenfer
 */
public class Vehicle implements Serializable {
    private String model;
    private String nubmer;
    private String VIN;
    private DriverLicense.Category category;
    private int priceperKM;

    public Vehicle() {
    }

    public Vehicle(final String model,
            final String nubmer,
            final String VIN,
            final DriverLicense.Category category,
            final int priceperKM) {
        this.model = model;
        this.nubmer = nubmer;
        this.VIN = VIN;
        this.category = category;
        this.priceperKM = priceperKM;
    }

    public final String getModel() {
        return model;
    }

    public final void setModel(final String model) {
        this.model = model;
    }

    public final String getNubmer() {
        return nubmer;
    }

    public final void setNubmer(final String nubmer) {
        this.nubmer = nubmer;
    }

    public final String getVIN() {
        return VIN;
    }

    public final void setVIN(final String VIN) {
        this.VIN = VIN;
    }

    public final DriverLicense.Category getCategory() {
        return category;
    }

    public final void setCategory(final DriverLicense.Category category) {
        this.category = category;
    }

    public final int getPriceperKM() {
        return priceperKM;
    }

    public final void setPriceperKM(final int priceperKM) {
        this.priceperKM = priceperKM;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model=" + model + ", nubmer=" + nubmer 
                + ", VIN=" + VIN + ", category=" + category 
                + ", priceperKM=" + priceperKM + '}';
    }
    
    
}
