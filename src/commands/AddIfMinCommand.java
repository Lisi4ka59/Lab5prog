package commands;

import models.City;

import static common.Main.cities;

public class AddIfMinCommand implements Command{
    @Override
    public void execute() {
        City city = AddCommand.getCity(); // получить город с консоли
        if (cities.addIfMin(city)){
            System.out.println("City was successfully added to collection");
        }
        else{
            System.out.println("City is not added to collection");
        }
    }
}
