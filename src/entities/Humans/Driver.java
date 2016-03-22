/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Humans;

import entities.Bureaucracy.DriverLicense;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author lenfer
 */
public class Driver extends Human implements Serializable {
    private DriverLicense license;

    public Driver(final String name,
            final Date dateOfBirth,
            final Gender gender,
            final DriverLicense license) {
        super(name, dateOfBirth, gender);
        this.license = license;
    }

    public final DriverLicense getLicense() {
        return license;
    }

    public final void setLicense(final DriverLicense license) {
        this.license = license;
    }

    public static Comparator<Driver> DriverLicenseCategoryComparator = 
            new Comparator<Driver>() {
        @Override
        public int compare(Driver driver1, Driver driver2) {
            int categoryValue1 = 
                    driver1.getLicense().getCategories().get(0).ordinal();
            int categoryValue2 = 
                    driver2.getLicense().getCategories().get(0).ordinal();
            return categoryValue1 - categoryValue2;
    }};
    
    
    @Override
    public String toString() {
        return "Driver{" + license + ", " + super.toString() + '}';
    }
    
    
    
}
