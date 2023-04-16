package commands;

import models.*;
import java.util.List;
import static utils.CityReader.*;

/**
 * add command, use to make a city
 * @autor Mikhail Nachinkin
 * @version 1.0
 */
public class AddCommand implements Command {
    private final List collection;
    public AddCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        City city = getCity();
        collection.add(city);
        System.out.println("Congratulations! City added to collection");
    }
    /**
     * add command, use to make a city
     * @autor Mikhail Nachinkin
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
        return new City(name, coordinates, population, area, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
    }
}