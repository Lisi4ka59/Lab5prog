package commands;

import models.City;
import models.StandardOfLiving;

import java.util.ArrayList;

import static common.Main.cities;

public class PrintUniqueStandardOfLivingCommand implements Command{
    @Override
    public void execute() {
        ArrayList<StandardOfLiving> list = new ArrayList<>();

        for (City city:cities) {
            if (!list.contains(city.getStandardOfLiving()))
                list.add(city.getStandardOfLiving());
        }

        for (StandardOfLiving number:list) {
            System.out.println(number);

        }
    }
}
