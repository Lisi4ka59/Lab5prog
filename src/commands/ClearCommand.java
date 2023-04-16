package commands;

import java.util.List;

public class ClearCommand implements Command{
    private final List collection;
    public ClearCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        collection.clear();
        System.out.println("Collection cleared");
    }
    @Override
    public void execute(String output) {
        collection.clear();
    }
}
