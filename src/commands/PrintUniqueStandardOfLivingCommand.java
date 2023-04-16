package commands;

import models.City;
import models.StandardOfLiving;

import java.util.ArrayList;
import java.util.List;

public class PrintUniqueStandardOfLivingCommand implements Command{
    private final List<City> collection;
    public PrintUniqueStandardOfLivingCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        ArrayList<StandardOfLiving> list = new ArrayList<>();

        for (City city:collection) {
            if (!list.contains(city.getStandardOfLiving()))
                list.add(city.getStandardOfLiving());
        }

        for (StandardOfLiving number:list) {
            System.out.println(number);

        }
    }
}
