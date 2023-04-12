package commands;

import common.AppClient;
import models.City;

import static common.AppClient.cities;

public class ShowCommand implements Command{
    @Override
    public void execute() {
        if (cities.isEmpty()) {
            System.out.println("No cities in collection");
        }
        else {
            for (City city : cities) {
                System.out.println("\n" + city.toString());
            }
        }
    }
}
