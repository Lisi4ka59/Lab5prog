package commands;

import models.City;
import utils.StandardOfLivingComparator;

import java.util.List;

public class PrintFieldAscendingStandardOfLivingCommand implements Command{
    private final List<City> collection;
    public PrintFieldAscendingStandardOfLivingCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        for (City city: collection.stream().sorted(new StandardOfLivingComparator()).toList()) {
            System.out.println(city.getStandardOfLiving());
        }
    }
}
