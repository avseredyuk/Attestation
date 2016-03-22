/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package att;

import entities.Bureaucracy.DriverLicense;
import entities.Bureaucracy.DriverLicense.Category;
import entities.Humans.Driver;
import entities.Vehicles.Autopark;
import entities.Vehicles.CargoVehicle;
import entities.Vehicles.Motorcade;
import entities.Vehicles.PassengerVehicle;
import entities.Vehicles.UniversalVehicle;
import entities.Vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author lenfer
 */
public class View {

    static final String[] COMMANDS_ARRAY =
            {"lp", "mm", "ld", "sd", "li", "fd", "e", "h"};
    static final String STRING_COMMAND_NOT_FOUND =
            "Command not found";
    static final String STRING_INCORRECT_COMMAND_FORMAT =
            "Incorrect command format";
    static final String STRING_NO_DRIVERS_FOUND_FILTERED =
            "There are no drivers matching your parameters";
    static final String STRING_FORMAT_MOTORCADE =
            "Motorcade will cost %d";
    static final String STRING_FORMAT_VEHICLE_1 =
            "\t%s\t%s\t%s\t%d\t%s\t%d";
    static final String STRING_FORMAT_VEHICLE_2 =
            "\t%s\t%s\t%s\t%d\t%s\t%d\t%d";
    static final String STRING_FORMAT_DRIVER =
            "\t%s\t%s\t%s\t%s\t%s\t%s";
    static final String STRING_ERROR_PREFIX =
            "Error: ";
    static final String STRING_INTRODUCTION_HELP =
            "Welcome to Autopark v1.0\n\n"
            + "List of commands:\n"
            + " * lp\t\tList our autopark\n"
            + " * mm X Y Z\tMake motorcade to transfer X(kg) of cargo, Y(pcs) people to the distance Z(km)\n"
            + " * ld\t\tList our drivers\n"
            + " * sd\t\tSort our drivers by categories\n"
            + " * li\t\tList our insurance\n"
            + " * fd X Y\tFind driver by X category and Y driving expirience(years)\n"
            + " * e\t\tExit\n"
            + " * h\t\tShow this help\n";
    
    private int getYearByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    public View() {
        // load autopark
        Autopark ourPark = new Autopark();
        ArrayList<Vehicle> ourCarList = ourPark.getPark();
        ArrayList<Driver> ourDriversList = ourPark.getDrivers();
        
        // console stuff
        System.out.println(STRING_INTRODUCTION_HELP);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String params[] = scanner.nextLine().split(" ");
            if (params.length > 0) {
                if (params[0].equals(COMMANDS_ARRAY[0])) {
                    // list park
                    for (Vehicle vehicle : ourCarList) {
                        if (vehicle instanceof UniversalVehicle) {
                            int tmpCapacity1;
                            int tmpCapacity2;
                            UniversalVehicle universalVehicle =
                                    (UniversalVehicle) vehicle;
                            tmpCapacity1 =
                                    universalVehicle.getCargoCapacity();
                            tmpCapacity2 =
                                    universalVehicle.getPassengerCapacity();
                            System.out.println(String.format(
                                    STRING_FORMAT_VEHICLE_2,
                                    vehicle.getModel(),
                                    vehicle.getNubmer(),
                                    vehicle.getVIN(),
                                    vehicle.getPriceperKM(),
                                    vehicle.getCategory(),
                                    tmpCapacity1,
                                    tmpCapacity2));
                        } else {
                            int tmpCapacity = 0;
                            if (vehicle instanceof CargoVehicle) {
                                CargoVehicle cargoVehicle =
                                        (CargoVehicle) vehicle;
                                tmpCapacity =
                                        cargoVehicle.getCargoCapacity();
                            } else if (vehicle instanceof PassengerVehicle) {
                                PassengerVehicle passengerVehicle =
                                        (PassengerVehicle) vehicle;
                                tmpCapacity =
                                        passengerVehicle.getPassengerCapacity();
                            }
                            System.out.println(String.format(
                                    STRING_FORMAT_VEHICLE_1,
                                    vehicle.getModel(),
                                    vehicle.getNubmer(),
                                    vehicle.getVIN(),
                                    vehicle.getPriceperKM(),
                                    vehicle.getCategory(),
                                    tmpCapacity));
                        }
                    }

                } else if (params[0].equals(COMMANDS_ARRAY[1])) {
                    // make motorcade
                    if (params.length == 4) {
                        try {
                            int cargoSize = Integer.parseInt(params[1]);
                            int passengerSize = Integer.parseInt(params[2]);
                            int travelDistance = Integer.parseInt(params[3]);
                            
                            Motorcade motorcade = 
                                    new Motorcade(cargoSize,
                                            passengerSize,
                                            ourCarList,
                                            travelDistance);
                            System.out.println(String.format(
                                    STRING_FORMAT_MOTORCADE,
                                    motorcade.getTotalCost()));
                            
                        } catch (NumberFormatException ex) {
                            System.out.println(STRING_ERROR_PREFIX 
                                    + STRING_INCORRECT_COMMAND_FORMAT);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(STRING_ERROR_PREFIX 
                                    + ex.getMessage());
                        }
                    } else {
                        System.out.println(STRING_ERROR_PREFIX 
                                + STRING_INCORRECT_COMMAND_FORMAT);
                    }
                    
                } else if (params[0].equals(COMMANDS_ARRAY[2])) {
                    // list drivers
                    for (Driver driver : ourDriversList) {
                        DriverLicense driverLicense = driver.getLicense();
                        System.out.println(String.format(
                                STRING_FORMAT_DRIVER,
                                driver.getName(),
                                driver.getGender(),
                                driver.getDateOfBirth(),
                                driverLicense.getCategories(),
                                driverLicense.getIssued(),
                                driverLicense.getExpires()));
                    }
                    
                } else if (params[0].equals(COMMANDS_ARRAY[3])) {
                    // list sorted drivers by category
                    ArrayList<Driver> sortedDrivers = 
                            new ArrayList<>(ourDriversList);
                    Collections.sort(sortedDrivers, 
                            Driver.DriverLicenseCategoryComparator);
                    for (Driver driver : sortedDrivers) {
                        DriverLicense driverLicense = driver.getLicense();
                        System.out.println(
                                String.format(STRING_FORMAT_DRIVER,
                                        driver.getName(),
                                        driver.getGender(),
                                        driver.getDateOfBirth(),
                                        driverLicense.getCategories(),
                                        driverLicense.getIssued(),
                                        driverLicense.getExpires()));
                    }
                    
                } else if (params[0].equals(COMMANDS_ARRAY[4])) {
                    // list insurances
                    
                } else if (params[0].equals(COMMANDS_ARRAY[5])) {
                    // find driver by X category and Y driving expirience(years)
                    if (params.length == 3) {
                        try {
                            String categoryName = params[1].toUpperCase();
                            int findYearsOfExpirience =
                                    Integer.parseInt(params[2]);
                            Category findCategory =
                                    Category.valueOf(categoryName);
                            
                            int filteredDrivers = 0;
                            for (Driver driver : ourDriversList) {
                                int yearsOfExpirience = getYearByDate(new Date())
                                        - getYearByDate(driver.getLicense().getIssued());
                                if ((driver.getLicense().getCategories().contains(findCategory))
                                        && (yearsOfExpirience > findYearsOfExpirience)) {
                                    DriverLicense driverLicense =
                                            driver.getLicense();
                                    System.out.println(
                                            String.format(STRING_FORMAT_DRIVER,
                                                       driver.getName(),
                                                       driver.getGender(),
                                                       driver.getDateOfBirth(),
                                                       driverLicense.getCategories(),
                                                       driverLicense.getIssued(),
                                                       driverLicense.getExpires()));
                                    filteredDrivers++;
                                }
                            }
                            if (filteredDrivers == 0) {
                                System.out.println(STRING_NO_DRIVERS_FOUND_FILTERED);
                            }
                            
                        } catch (NumberFormatException ex) {
                            System.out.println(STRING_ERROR_PREFIX 
                                    + STRING_INCORRECT_COMMAND_FORMAT);
                            
                        } catch (IllegalArgumentException ex) {
                            System.out.println(STRING_ERROR_PREFIX 
                                    + ex.getMessage());
                            
                        }
                    } else {
                        System.out.println(STRING_ERROR_PREFIX 
                                + STRING_INCORRECT_COMMAND_FORMAT);
                    }
                    
                } else if (params[0].equals(COMMANDS_ARRAY[6])) {
                    System.exit(0);
                    
                } else if (params[0].equals(COMMANDS_ARRAY[7])) {
                    System.out.println(STRING_INTRODUCTION_HELP);
                    
                } else {
                    System.out.println(STRING_ERROR_PREFIX 
                            + STRING_COMMAND_NOT_FOUND);
                }
            }
        }
    }
    
}
