package commands;

import models.City;

import static common.AppClient.cities;

public class PrintDescendingCommand implements Command{
    @Override
    public void execute() {

        for (City city: cities.stream().sorted().toList()) {
            System.out.println(city.toString());
        }
    }
}
