package commands;

import common.AppClient;
import common.Main;
import models.City;

public class RemoveHeadCommand implements Command{
    @Override
    public void execute() {
        if (!AppClient.cities.isEmpty()){
            City city = AppClient.cities.getFirst();
            System.out.println(city.toString());
            AppClient.cities.removeFirst();
            System.out.println("First element of collection removed");
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
