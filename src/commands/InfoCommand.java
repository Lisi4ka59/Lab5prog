package commands;
import common.AppClient;

public class InfoCommand implements Command{
    @Override
    public void execute() {
        System.out.printf("Type: %s\nCreation date: %s\nCount of elements: %d\n", AppClient.cities.getClass(), AppClient.cities.getCreationCollectionDate().toString(), AppClient.cities.size());
    }
}
