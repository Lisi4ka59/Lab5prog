package common;

import models.*;

import static common.Checker.*;

public class CityReader {
    public static String inputName() {
        String name = inputStringNotNull("City name (name can not be null): ");
        return name;
    }

    public static Coordinates inputCoordinates() {
        double x = inputDouble("City coordinates\nEnter coordinate X (X must be more than -25): ");
        float y = inputFloat("Enter coordinate Y: ");
        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }

    public static long inputPopulation() {
        long population = inputLong("Enter city population (population must be more than 0): ");
        return population;
    }

    public static double inputArea() {
        double area = inputDouble("Enter city area (area must be more than 0): ");
        return area;
    }

    public static int inputMetersAboveSeaLevel() {
        int metersAboveSeaLevel = inputInteger("Enter the height of the city above sea level: ");
        return metersAboveSeaLevel;
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
}


/*
        System.out.print("City governor\nEnter governor age: ");
        long age = Long.valueOf(scanner.nextLine());
        System.out.print("Governor birthday\nEnter year: ");
        int year = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter month: ");
        int month = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter day: ");
        int day = Integer.valueOf(scanner.nextLine());
        Date birthday = new Date(year, month, day);
        Human governor = new Human(age, birthday);


        System.out.println("Congratulations! City added to collection");
        City city = new City(name, coordinates, population, area, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
        Main.cities.add(city);
    }
}
*/

