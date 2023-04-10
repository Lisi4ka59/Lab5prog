package commands;


import common.Main;
import models.*;



import static common.CityReader.*;

public class AddCommand implements Command {
    @Override
    public void execute() {
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
        Main.cities.add(city);
        System.out.println("Congratulations! City added to collection");
    }
}