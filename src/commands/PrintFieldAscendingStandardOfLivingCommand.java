package commands;

import models.City;
import utils.StandardOfLivingComparator;

import static common.AppClient.cities;

public class PrintFieldAscendingStandardOfLivingCommand implements Command{
    @Override
    public void execute() {
        for (City city: cities.stream().sorted(new StandardOfLivingComparator()).toList()) {
            System.out.println(city.getStandardOfLiving());
        }
    }
}
