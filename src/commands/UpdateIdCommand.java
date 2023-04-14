package commands;

import models.City;

import java.util.Scanner;

import static utils.CityReader.*;
import static common.AppClient.cities;

public class UpdateIdCommand implements Command{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        boolean update = false;
        for (City city:cities) {
            if (city.getId()==id){
                city.setName(inputName());
                city.setCoordinates(inputCoordinates());
                city.setArea(inputArea());
                city.setPopulation(inputPopulation());
                city.setMetersAboveSeaLevel(inputMetersAboveSeaLevel());
                city.setClimate(inputClimate());
                city.setGovernment(inputGovernment());
                city.setStandardOfLiving(inputStandardOfLiving());
                city.setGovernor(inputGovernor());
                update = true;
                break;
            }
        }
        if (update)
            System.out.printf("City %d updated\n", id);
        else
            System.out.printf("City %d doesn't exist\n", id);
    }
}
