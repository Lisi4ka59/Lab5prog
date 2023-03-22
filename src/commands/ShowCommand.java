package commands;

import common.Main;
import models.City;

public class ShowCommand implements Command{
    @Override
    public void execute() {
        for (City city : Main.cities){
            System.out.println(city.toString());
        }
    }
}
