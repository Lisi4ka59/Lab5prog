package commands;

import models.City;
import java.util.List;

public class RemoveHeadCommand implements Command{
    private final List<City> collection;
    public RemoveHeadCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        if (!collection.isEmpty()){
            City city = collection.get(0);
            System.out.println(city.toString());
            collection.remove(0);
            System.out.println("First element of collection removed");
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
