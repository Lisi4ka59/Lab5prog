package commands;


import common.AppClient;
import models.*;



import static utils.CityReader.*;

/**
 * add command, use to make a city
 * @autor Mikhail Nachinkin
 * @version 1.0
 */
public class AddCommand implements Command {
    @Override
    public void execute() {
        City city = getCity();
        AppClient.cities.add(city);
        System.out.println("Congratulations! City added to collection");
    }
    /**
     * add command, use to make a city
     * @autor Mikhail Nachinkin
     * @version 1.0
     */
    public static City getCity() {
        String name = inputName();
        Coordinates coordinates = inputCoordinates();
        double area = inputArea();
        long population = inputPopulation();
        int metersAboveSeaLevel = inputMetersAboveSeaLevel();
        Climate climate = inputClimate();
        Government government = inputGovernment();
        StandardOfLiving standardOfLiving = inputStandardOfLiving();
        Human governor = inputGovernor();
        City city = new City(name, coordinates, population, area, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
        return city;
    }
}