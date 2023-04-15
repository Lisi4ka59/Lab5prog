package commands;

import models.City;

import java.util.List;

import static common.AppClient.cities;

public class PrintDescendingCommand implements Command{
    private List collection;
    public PrintDescendingCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {

        for (Object city: collection.stream().sorted().toList()) {
            System.out.println(city.toString());
        }
    }
}
