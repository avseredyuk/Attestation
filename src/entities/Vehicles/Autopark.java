/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Vehicles;

import entities.Bureaucracy.DriverLicense;
import entities.Humans.Driver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lenfer
 */
public class Autopark {
    private ArrayList<Vehicle> park = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private static final String ERROR_IO = 
            "I/O Error";

    public Autopark() {
        loadPark();
        loadDrivers();
//        generateRandomPark(100);
//        savePark();
//        generateRandomDrivers(100);
//        saveDrivers();
        
    }
    
    private void loadDrivers() {
        try {
            FileInputStream fileIn = new FileInputStream("drivers");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            drivers = (ArrayList<Driver>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception ex) {
            System.out.println(ERROR_IO);
        }
    }
    
    private void loadPark() {
        try {
            FileInputStream fileIn = new FileInputStream("autopark");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            park = (ArrayList<Vehicle>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception ex) {
            System.out.println(ERROR_IO);
        }
    }
    
    private void saveDrivers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("drivers");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(drivers);
            out.close();
            fileOut.close();
        } catch (Exception ex) {
            System.out.println(ERROR_IO);
        }
    }
    
    private void savePark() {
        try {
            FileOutputStream fileOut = new FileOutputStream("autopark");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(park);
            out.close();
            fileOut.close();
        } catch (Exception ex) {
            System.out.println(ERROR_IO);
        }
    }
    
    private void generateRandomPark(final int size) {
        for (int i = 0; i < size; i++) {
            switch ((int) (Math.random() * 5)) {
                case 0:
                    park.add(new Truck("gazel", "aa13ae", "SDGGJ87D8F",
                            DriverLicense.Category.C1, 300, 3000)); 
                    break;
                case 1: 
                    park.add(new HeavyTruck("gazel", "aa13ae", "SDGGJ87D8F",
                            DriverLicense.Category.C, 400, 10000));
                    break;
                case 2:
                    park.add(new MicroBus("gazel", "aa13ae", "SDGGJ87D8F",
                            DriverLicense.Category.D1, 150, 10)); 
                    break;
                case 3:
                    park.add(new Bus("gazel", "aa13ae", "SDGGJ87D8F",
                            DriverLicense.Category.D, 250, 20)); 
                    break;
                default:
                    park.add(new Universal("gazel", "aa13ae", "SDGGJ87D8F", 
                            DriverLicense.Category.B, 320, 1000, 8)); 
                    break;
            }
        }
    }
    
    private Date getRandomDate(final int startingYear,
                               final int yearsPositiveRange) {
        String date = Integer.toString(startingYear
                + (int) (Math.random() * yearsPositiveRange))
                + "/" + (int) (Math.random() * 13)
                + "/" + (int) (Math.random() * 28);
        java.util.Date utilDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            utilDate = formatter.parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        return utilDate;
    }
    
    private Driver.Gender getRandomGender() {
        switch ((int) (Math.random() * 2)) {
                case 0:
                    return Driver.Gender.MALE;
                default:
                    return Driver.Gender.FEMALE;
            }
    }
    
    private String getRandomName() {
        switch ((int) (Math.random() * 5)) {
            case 0:
                return "Vasya";
            case 1:
                return "Petya";
            case 2:
                return "Kolya";
            case 3:
                return "Vanya";
            default:
                return "Sasha";
        }
    }
    
    private DriverLicense.Category getRandomCategory() {
        switch ((int) (Math.random() * 9)) {
            case 0:
                return DriverLicense.Category.A;
            case 1:
                return DriverLicense.Category.A1;
            case 2:
                return DriverLicense.Category.B1;
            case 3:
                return DriverLicense.Category.B;
            case 4:
                return DriverLicense.Category.C;
            case 5:
                return DriverLicense.Category.C1;
            case 6:
                return DriverLicense.Category.CD;
            case 7:
                return DriverLicense.Category.D;
            default:
                return DriverLicense.Category.D1;
        }
    }
    
    private void generateRandomDrivers(final int size) {
        for (int i = 0; i < size; i++) {
            DriverLicense driverLicense = 
                    new DriverLicense(getRandomDate(1980, 10),
                            getRandomDate(2050, 30),
                            getRandomCategory());
            Driver d = 
                    new Driver(getRandomName(),
                            getRandomDate(1940, 20),
                            getRandomGender(),
                            driverLicense);
            drivers.add(d);
        }
    }

    public final ArrayList<Driver> getDrivers() {
        return drivers;
    }
    
    public final ArrayList<Vehicle> getPark() {
        return park;
    }
}
