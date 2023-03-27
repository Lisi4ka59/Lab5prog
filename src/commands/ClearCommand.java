package commands;

import common.Main;
import models.CityLinkedList;

public class ClearCommand implements Command{
    @Override
    public void execute() {
        Main.cities.clear();
        System.out.println("Collection cleared");
    }
}
