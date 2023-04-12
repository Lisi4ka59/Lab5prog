package commands;

import common.AppClient;
import common.Main;

public class RemoveFirstCommand implements Command{
    @Override
    public void execute() {
        if (!AppClient.cities.isEmpty()) {
            AppClient.cities.removeFirst();
            System.out.println("First element of collection removed");
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
