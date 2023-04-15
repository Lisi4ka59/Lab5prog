package commands;

import models.City;

import java.util.List;
import java.util.Scanner;

import static common.AppClient.cities;

public class RemoveByIdCommand implements Command{
    private List<City> collection;
    public RemoveByIdCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        boolean removed = false;
        for (City city:collection) {
            if (city.getId()==id){
                removed = collection.remove(city);
                break;
            }
        }
        if (removed)
            System.out.printf("City %d removed\n", id);
        else
            System.out.printf("City %d doesn't exist\n", id);
    }
}
