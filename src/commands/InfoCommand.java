package commands;
import common.Main;
import java.util.Collection;

public class InfoCommand implements Command{
    @Override
    public void execute() {
        System.out.printf("Type: %s\nCreation date: %s\nCount of elements: %d\n", Main.cities.getClass(), Main.cities.getCreationDate().toString(), Main.cities.size());
    }
}
