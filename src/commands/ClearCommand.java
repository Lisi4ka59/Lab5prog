package commands;

import common.AppClient;
import common.Main;
import models.CityLinkedList;

public class ClearCommand implements Command{
    @Override
    public void execute() {
        AppClient.cities.clear();
        System.out.println("Collection cleared");
    }
}
