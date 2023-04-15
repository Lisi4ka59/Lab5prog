package commands;
import common.AppClient;
import models.City;

import java.util.List;

public class InfoCommand implements Command{
    private List<City> collection;
    public InfoCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        System.out.printf(collection.toString());
    }
}
