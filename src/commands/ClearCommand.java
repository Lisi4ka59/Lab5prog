package commands;

import java.util.List;

import static utils.CityLinkedList.isSave;

public class ClearCommand implements Command{
    private final List collection;
    public ClearCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        collection.clear();
        System.out.println("Collection cleared");
        isSave = false;
    }
    @Override
    public void execute(String output) {
        collection.clear();
        isSave = false;
    }
}
