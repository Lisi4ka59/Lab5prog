package commands;

import java.util.List;

public class PrintDescendingCommand implements Command{
    private final List collection;
    public PrintDescendingCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {

        for (Object city: collection.stream().sorted().toList()) {
            System.out.println(city.toString());
        }
    }
}
