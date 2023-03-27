package commands;

import common.Main;

public class RemoveFirstCommand implements Command{
    @Override
    public void execute() {
        if (!Main.cities.isEmpty()) {
            Main.cities.removeFirst();
            System.out.println("First element of collection removed");
        }
        else {
            System.out.println("Collection is empty");
        }
    }
}
