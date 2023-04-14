package utils;

import models.*;

import java.util.Date;

import static utils.Checker.*;

public class CityReader {
    public static String inputName() {
        String name = inputStringNotNull("City name (name can not be null): ");
        return name;
    }

    public static Coordinates inputCoordinates() {
        double x;
        System.out.println("City coordinates");
        do {
            x = inputDouble("Enter coordinate X (X must be more than -25): ");
            if (x > -25){
                break;
            }
            System.out.println("X must be double and more than -25!");
        }while (true);
        float y = inputFloat("Enter coordinate Y: ");
        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }

    public static long inputPopulation() {
        do {
            long population = inputLong("Enter city population (population must be more than 0): ");
            if (population > 0){
                return population;
            }
            System.out.println("Population must be long and more than 0!");
        }while (true);
    }

    public static double inputArea() {
        do {
            double area = inputDouble("Enter city area (area must be more than 0): ");
            if (area > 0){
                return area;
            }
            System.out.println("Area must be double and more than 0!");
        }while (true);
    }

    public static int inputMetersAboveSeaLevel() {
        do {
            int metersAboveSeaLevel = inputInteger("Enter the height of the city above sea level: ");
            if (metersAboveSeaLevel > 8849){
                System.out.println("City cannot be higher than the highest point on Earth!");
            }
            else if (metersAboveSeaLevel < -432){
                System.out.println("City cannot be below the lowest point on land!");
            }
            else {
                return metersAboveSeaLevel;
            }
        }while (true);
    }

    public static Climate inputClimate(){
        String prompt = ("Choose city climate (can not be null)\n1. TROPICAL_SAVANNA\n" +
                "2. HUMIDCONTINENTAL\n" +
                "3. OCEANIC\n" +
                "4. STEPPE\n");
        int climateNumber = inputEnumNumber(prompt, 4, false);
        return Climate.fromInt(climateNumber);
    }
    public static Government inputGovernment(){
        String prompt = ("Choose city government (can be null)\n1. ANARCHY\n" +
                "2. COMMUNISM\n" +
                "3. MERITOCRACY\n" +
                "4. ETHNOCRACY\n");
        int governmentNumber = inputEnumNumber(prompt, 4, true);
        return Government.fromInt(governmentNumber);
    }
    public static StandardOfLiving inputStandardOfLiving(){
        String prompt = ("Choose city standard of living (can be null)\n1. ULTRA HIGH\n" +
                "2. HIGH\n" +
                "3. VERY LOW\n" +
                "4. ULTRA LOW\n" +
                "5. NIGHTMARE\n");
        int standardOfLivingNumber = inputEnumNumber(prompt, 5, true);
        return StandardOfLiving.fromInt(standardOfLivingNumber);
    }
    public static Human inputGovernor(){
        long age;
        System.out.println("City governor");
        do {
            age = inputLong("Enter governor age: ");
            if (age > 0 ){
                break;
            }
            System.out.println("Governor age must be long and more than 0!");
        }while (true);
        Date governorBirthday = inputDate("Governor birthday\nEnter date (dd.MM.yyyy): ");
        Human governor = new Human(age, governorBirthday);
        return governor;
    }
}
