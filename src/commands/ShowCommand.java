package commands;

import common.Main;
import models.City;

import static common.Main.cities;

public class ShowCommand implements Command{
    @Override
    public void execute() {
        if (cities.isEmpty()) {
            System.out.println("No cities in collection");
        }
        else {
            for (City city : cities) {
                System.out.println(city.toString());
            }
        }
    }
}
