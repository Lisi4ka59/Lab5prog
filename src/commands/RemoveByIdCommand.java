package commands;

import models.City;

import java.util.List;

import static utils.Checker.inputLong;
import static utils.CityLinkedList.isSave;

public class RemoveByIdCommand implements Command {
    private final List<City> collection;

    public RemoveByIdCommand(List<City> collection) {
        this.collection = collection;
    }

    private void remove(long id) {
        boolean removed = false;
        for (City city : collection) {
            if (city.getId() == id) {
                removed = collection.remove(city);
                break;
            }
        }
        if (removed)
            System.out.printf("City %d removed\n", id);
        else
            System.out.printf("City %d doesn't exist\n", id);
    }

    @Override
    public void execute() {
        remove(inputLong("Enter city id: "));
        isSave = false;
    }

    @Override
    public void execute(String stringId) {
        long id;
        try {
            id = Long.parseLong(stringId);
        } catch (NumberFormatException e) {
            System.out.println("Entered value can not be city id!");
            id = inputLong("Enter correct city id: ");
        }
        remove(id);
        isSave = false;
    }
}