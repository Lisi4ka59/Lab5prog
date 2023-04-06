package commands;

import models.City;

import static common.Main.cities;

public class AddIfMinCommand implements Command{
    @Override
    public void execute() {
        City city = null; // получить город с консоли

        cities.addIfMin(city);
    }
}
