package commands;

import common.Main;
import models.City;

public class RemoveHeadCommand implements Command{
    @Override
    public void execute() {
        if (!Main.cities.isEmpty()){
            City city = Main.cities.getFirst();
            System.out.println(city.toString());
            Main.cities.removeFirst();
            System.out.println("First element of collection removed");
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
