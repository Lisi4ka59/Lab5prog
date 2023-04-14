package commands;

import common.AppClient;

public class ClearCommand implements Command{
    @Override
    public void execute() {
        AppClient.cities.clear();
        System.out.println("Collection cleared");
    }
}
