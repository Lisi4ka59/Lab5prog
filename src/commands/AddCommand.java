package commands;

import common.Main;
import models.City;

import java.util.Scanner;

public class AddCommand implements Command{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("City name: ");
        String name = scanner.nextLine();
        City city = new City(name, null,null,10,null,null,null, null);
        Main.cities.add(city);
    }
}
