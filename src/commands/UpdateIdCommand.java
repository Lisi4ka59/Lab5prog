package commands;

import models.City;

import java.util.Scanner;

import static common.Main.cities;

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
                System.out.print("City name: ");
                String name = scanner.nextLine();
                city.setName(name);
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
