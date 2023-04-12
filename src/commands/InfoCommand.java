package commands;
import common.AppClient;
import common.Main;
import java.util.Collection;

public class InfoCommand implements Command{
    @Override
    public void execute() {
        System.out.printf("Type: %s\nCreation date: %s\nCount of elements: %d\n", AppClient.cities.getClass(), AppClient.cities.getCreationDate().toString(), AppClient.cities.size());
    }
}
