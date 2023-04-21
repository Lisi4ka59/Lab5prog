package commands;
import models.City;
import java.util.List;

import static utils.CityLinkedList.isSave;

public class RemoveFirstCommand implements Command{
    private final List<City> collection;
    public RemoveFirstCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        if (!collection.isEmpty()) {
            collection.remove(0);
            System.out.println("First element of collection removed");
            isSave = false;
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
