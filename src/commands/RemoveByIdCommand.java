package commands;

import models.City;

import java.util.Scanner;

import static common.Main.cities;

public class RemoveByIdCommand implements Command{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        boolean removed = false;
        for (City city:cities) {
            if (city.getId()==id){
                removed = cities.remove(city);
                break;
            }
        }
        if (removed)
            System.out.printf("City %d removed\n", id);
        else
            System.out.printf("City %d doesn't exist\n", id);
    }
}
